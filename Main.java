import singleton.ConfiguracionGlobal;
import factorymethod.*;
import productos.Producto;
import java.util.*;

/**
 * Menú principal con: - Configuración global (Singleton) - Creación de productos (Factory Method)
 */

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== Sistema de Gestión de Productos (Factory Method + Singleton) ===");
            System.out.println("1. Crear producto (Factory Method)");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Configuración global (Singleton)");
            System.out.println("0. Salir");
            opcion = leerOpcionMenu();
            System.out.println();


            switch (opcion) {
                case 1 -> crearConFactoryMethod();
                case 2 -> listarInventario();
                case 3 -> probarSingleton();
                case 0 -> System.out.println("Saliendo...");
                default -> {
                    if (opcion != -1) { 
                        System.out.println("Opción inválida.");
                    }
                }
            }   
        }
        while (opcion != 0);
         sc.close();
    }
     // MÉTODO DEL FACTORY METHOD
    private static void crearConFactoryMethod() {
        System.out.println("\n--- Crear producto (Factory Method) ---");
        System.out.println("Seleccione el tipo de producto:");
        System.out.println("1) Computadora");
        System.out.println("2) Teléfono");
        System.out.println("3) Tableta");

        int op = leerOpcionMenu();
        FabricaProducto fabricante;

        switch (op) {
            case 1 -> fabricante = new FabricaComputadora();
            case 2 -> fabricante = new FabricaTelefono();
            case 3 -> fabricante = new FabricaTableta();
            default -> {
                System.out.println("Opción inválida.");
                return;
            }
        }
        // Solicitar datos del producto
        System.out.print("Marca (Enter para usar valor por defecto 'Genérica'): ");
        String marca = sc.nextLine().trim();

        System.out.print("Modelo (Enter para usar valor por defecto): ");
        String modelo = sc.nextLine().trim();

        System.out.print("Precio (Enter para usar valor por defecto): ");
        String precioTexto = sc.nextLine().trim();
        Double precio = null;
        if (!precioTexto.isEmpty()) {
            try {
                precio = Double.parseDouble(precioTexto);
            } catch (NumberFormatException e) {
                System.out.println(" **Entrada inválida. Se usará el precio por defecto.**");
            }
        }
         // Preguntar si desea personalizar especificaciones
        System.out.print("¿Desea personalizar especificaciones técnicas? (s/n): ");
        String respuesta = sc.nextLine().trim().toLowerCase();

        Map<String, String> especificaciones = null;
        if (respuesta.equals("s") || respuesta.equals("si")) {
            especificaciones = solicitarEspecificaciones();
        }

        // Crear el producto usando Factory Method
        Producto producto = fabricante.crearProducto(
                marca.isEmpty() ? null : marca,
                modelo.isEmpty() ? null : modelo,
                precio,
                especificaciones);

        inventario.add(producto);
        System.out.println("\n Producto creado exitosamente:");
        producto.mostrarInfo();
    }

    /**
     * Solicita especificaciones personalizadas al usuario
     */
    private static Map<String, String> solicitarEspecificaciones() {
        Map<String, String> specs = new HashMap<>();
        System.out.println("\nIngrese especificaciones (Enter en 'Especificación' para terminar):");

        while (true) {
            System.out.print("  Especificación (RAM, CPU, Pantalla, Almacenamiento): ");
            String clave = sc.nextLine().trim();
            if (clave.isEmpty()) {
                break;
            }

            System.out.print("  Valor: ");
            String valor = sc.nextLine().trim();

            if (!valor.isEmpty()) {
                specs.put(clave, valor);
                System.out.println("  Añadido: " + clave + " = " + valor);
            }
        }

        return specs.isEmpty() ? null : specs;
    }

   
    // INVENTARIO
    
    
    private static void listarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("Inventario vacío.");
            return;
        }

        System.out.println("\n=== Inventario de Productos ===");
        int i = 1;
        for (Producto p : inventario) {

            System.out.println("Producto #" + i++);
            p.mostrarInfo();
            System.out.println();
        }
   
        System.out.println("Total de productos: " + inventario.size());
    }
    // SINGLETON
       private static void probarSingleton() {
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        int opcion;

        do {
            config.mostrarConfiguracion();
            System.out.println("1. Activar/desactivar modo debug");
            System.out.println("2. Cambiar entorno");
            System.out.println("3. Cambiar idioma");
            System.out.println("0. Volver al menú principal");
            opcion = leerOpcionMenu();

            switch (opcion) {
                case 1 -> configurarModoDebug(config);
                case 2 -> {
                    System.out.print("Ingrese el entorno sin tildes (Produccion/Desarrollo/Pruebas): ");
                    config.setEntorno(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Ingrese idioma sin tildes (Español/Ingles): ");
                    config.setIdioma(sc.nextLine());
                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> {
                    if (opcion != -1) {
                        System.out.println("Opción inválida.");
                    }
                }
            }
        } while (opcion != 0);
    }
     // LECTURA ROBUSTA DE OPCIONES

    private static int leerOpcionMenu() {
        int opcion = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println(" **Error**: Debe ingresar un número para seleccionar la opción.");
                sc.next();
            } finally {
                sc.nextLine();
            }
        }
        return opcion;
    }

    
    // CONFIGURAR MODO DEBUG (VALIDACIÓN ROBUSTA)
    private static void configurarModoDebug(ConfiguracionGlobal config) {
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Ingrese true para activar o false para desactivar: ");
            try {
                boolean nuevoModo = sc.nextBoolean();

                config.setModoDebug(nuevoModo);
                entradaValida = true;

            } catch (InputMismatchException e) {

                System.out.println("\n **ALERTA**: Entrada no válida. Debe ingresar 'true' o 'false'.");
                System.out.println("Por favor, intente de nuevo.");

                sc.next();
            } finally {
                sc.nextLine(); 
            }
        }
        System.out.println(" Modo Debug actualizado a: " + config.isModoDebug());
    }
}