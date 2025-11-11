import singleton.ConfiguracionGlobal;
import java.util.InputMismatchException; // Importar la clase de excepción
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== Sistema de Configuración Global (Singleton) ===");
            System.out.println("1. Mostrar y modificar configuración");
            System.out.println("0. Salir");
            opcion = leerOpcionMenu();
            System.out.println();


            switch (opcion) {
                case 1 -> probarSingleton();
                case 0 -> System.out.println("Saliendo...");
                default -> {
                    if (opcion != -1) { // -1 significa que ya se mostró el error de InputMismatch
                        System.out.println("Opción inválida.");
                    }
                }
            }   
        }
        while (opcion != 0);
         sc.close();
    }

    private static int leerOpcionMenu() {
        int opcion = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                entradaValida = true; // Si llegamos aquí, es un entero válido
            } catch (InputMismatchException e) {
                System.out.println(" **Error**: Debe ingresar un número para seleccionar la opción.");
                sc.next(); // Limpiar el buffer de la entrada no válida
            } finally {
                sc.nextLine(); // Limpiar el buffer de la nueva línea después de nextInt o el error
            }
        }
        return opcion;
    }
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
/**
     * Manejo de la entrada de usuario para el modo Debug con validación robusta.
     */
    private static void configurarModoDebug(ConfiguracionGlobal config) {
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Ingrese true para activar o false para desactivar: ");
            try {
                // Intentamos leer el booleano
                boolean nuevoModo = sc.nextBoolean();

                // Si la lectura tiene éxito, asignamos y salimos del bucle
                config.setModoDebug(nuevoModo);
                entradaValida = true;

            } catch (InputMismatchException e) {
                // Capturamos la excepción si la entrada no fue un booleano válido
                System.out.println("\n **ALERTA**: Entrada no válida. Debe ingresar 'true' o 'false'.");
                System.out.println("Por favor, intente de nuevo.");

                sc.next();
            } finally {
                sc.nextLine(); // Limpiar el buffer después de la operación (éxito o error)
            }
        }
        System.out.println(" Modo Debug actualizado a: " + config.isModoDebug());
    }
}