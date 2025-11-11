import singleton.ConfiguracionGlobal;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== Sistema de Configuración Global (Singleton) ===");
            System.out.println("1. Mostrar y modificar configuración");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> probarSingleton();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void probarSingleton() {
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        config.mostrarConfiguracion();
        System.out.print("¿Activar modo debug? (true/false): ");
        config.setModoDebug(sc.nextBoolean());
        sc.nextLine();
        config.mostrarConfiguracion();
    }
}