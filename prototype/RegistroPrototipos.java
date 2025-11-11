package prototype;

import productos.Producto;
import java.util.HashMap;
import java.util.Map;

/**
 * Registro de prototipos (Prototype Pattern).
 * Almacena productos base que pueden ser clonados para crear variantes.
 */
public class RegistroPrototipos {
    private static RegistroPrototipos instancia;
    private final Map<String, Producto> prototipos;

    private RegistroPrototipos() {
        this.prototipos = new HashMap<>();
    }

    public static RegistroPrototipos getInstancia() {
        if (instancia == null) {
            instancia = new RegistroPrototipos();
        }
        return instancia;
    }

    /**
     * Registra un producto como prototipo con un identificador único
     */
    public void registrarPrototipo(String id, Producto prototipo) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("El ID del prototipo no puede estar vacío");
        }
        if (prototipo == null) {
            throw new IllegalArgumentException("El prototipo no puede ser null");
        }
        prototipos.put(id, prototipo);
        System.out.println("Prototipo registrado: " + id);
    }

    /**
     * Clona un prototipo registrado por su ID
     */
    public Producto clonarPrototipo(String id) {
        Producto prototipo = prototipos.get(id);
        if (prototipo == null) {
            throw new IllegalArgumentException("No existe prototipo con ID: " + id);
        }
        return prototipo.clonar();
    }

    /**
     * Verifica si existe un prototipo con el ID dado
     */
    public boolean existePrototipo(String id) {
        return prototipos.containsKey(id);
    }

    /**
     * Elimina un prototipo del registro
     */
    public void eliminarPrototipo(String id) {
        if (prototipos.remove(id) != null) {
            System.out.println(" Prototipo eliminado: " + id);
        } else {
            System.out.println("No existe prototipo con ID: " + id);
        }
    }

    /**
     * Lista todos los prototipos registrados
     */
    public void listarPrototipos() {
        if (prototipos.isEmpty()) {
            System.out.println("No hay prototipos registrados.");
            return;
        }

        System.out.println("\n=== Prototipos Registrados ===");
        for (Map.Entry<String, Producto> entry : prototipos.entrySet()) {
            Producto p = entry.getValue();
            System.out.println("\nID: " + entry.getKey());
            System.out.println("  Tipo: " + p.getTipo());
            System.out.println("  Marca: " + p.getMarca());
            System.out.println("  Modelo: " + p.getModelo());
            System.out.println("  Línea: " + p.getLinea());
            System.out.println("  Precio: $" + p.getPrecio());
        }
        System.out.println("========================================");
    }

    /**
     * Obtiene la cantidad de prototipos registrados
     */
    public int cantidadPrototipos() {
        return prototipos.size();
    }

    /**
     * Limpia todos los prototipos del registro
     */
    public void limpiarRegistro() {
        prototipos.clear();
        System.out.println("Registro de prototipos limpiado");
    }
}