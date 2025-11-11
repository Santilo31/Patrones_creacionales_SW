package prototype;

import productos.Producto;
import java.util.Map;

/**
 * Gestor de prototipos con operaciones de alto nivel.
 * Facilita la creación de variantes a partir de prototipos base.
 */
public class GestorPrototipos {
    private final RegistroPrototipos registro;

    public GestorPrototipos() {
        this.registro = RegistroPrototipos.getInstancia();
    }

    /**
     * Crea una variante de un prototipo con modificaciones personalizadas.
     * Valida que el prototipo pueda clonarse antes de proceder.
     */
    public Producto crearVariante(String idPrototipo, String nuevaMarca,
            String nuevoModelo, Double nuevoPrecio) {
        // Validar y clonar el prototipo
        Producto variante = registro.clonarPrototipo(idPrototipo);

        if (!variante.puedeClonarse()) {
            throw new IllegalStateException(
                    "El prototipo '" + idPrototipo + "' no puede clonarse: datos incompletos");
        }

        // Aplicar modificaciones si se proporcionan
        if (nuevaMarca != null && !nuevaMarca.isEmpty()) {
            variante.setMarca(nuevaMarca);
        }
        if (nuevoModelo != null && !nuevoModelo.isEmpty()) {
            variante.setModelo(nuevoModelo);
        }
        if (nuevoPrecio != null && nuevoPrecio > 0) {
            variante.setPrecio(nuevoPrecio);
        }

        return variante;
    }

    /**
     * Crea una variante con especificaciones personalizadas adicionales
     */
    public Producto crearVarianteConEspecificaciones(String idPrototipo,
            String nuevaMarca,
            String nuevoModelo,
            Double nuevoPrecio,
            Map<String, String> nuevasEspecificaciones) {
        Producto variante = crearVariante(idPrototipo, nuevaMarca, nuevoModelo, nuevoPrecio);

        // Agregar o sobrescribir especificaciones
        if (nuevasEspecificaciones != null && !nuevasEspecificaciones.isEmpty()) {
            variante.getEspecificaciones().putAll(nuevasEspecificaciones);
        }

        return variante;
    }

    /**
     * Crea una copia exacta del prototipo sin modificaciones
     */
    public Producto clonarExacto(String idPrototipo) {
        return registro.clonarPrototipo(idPrototipo);
    }

    /**
     * Crea múltiples variantes con precios escalonados
     */
    public Producto[] crearVariantesPorPrecio(String idPrototipo,
            double[] precios,
            String[] sufijosModelo) {
        if (precios.length != sufijosModelo.length) {
            throw new IllegalArgumentException("Los arrays de precios y sufijos deben tener el mismo tamaño");
        }

        Producto[] variantes = new Producto[precios.length];
        Producto base = registro.clonarPrototipo(idPrototipo);

        for (int i = 0; i < precios.length; i++) {
            variantes[i] = base.clonar();
            variantes[i].setModelo(base.getModelo() + " " + sufijosModelo[i]);
            variantes[i].setPrecio(precios[i]);
        }

        return variantes;
    }

    /**
     * Registra un nuevo prototipo en el sistema
     */
    public void registrarPrototipo(String id, Producto prototipo) {
        registro.registrarPrototipo(id, prototipo);
    }

    /**
     * Lista todos los prototipos disponibles
     */
    public void listarPrototipos() {
        registro.listarPrototipos();
    }

    /**
     * Verifica si existe un prototipo
     */
    public boolean existePrototipo(String id) {
        return registro.existePrototipo(id);
    }
}