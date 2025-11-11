package singleton;

public class ConfiguracionGlobal {
    private static volatile ConfiguracionGlobal instancia;
    private boolean modoDebug;
    private String entorno;
    private String idioma;

    private ConfiguracionGlobal() {
        this.modoDebug = false;
        this.entorno = "Produccion";
        this.idioma = "Español";
    }

    public static ConfiguracionGlobal getInstancia() {
        if (instancia == null) { // Sin sincronización (performance)
            synchronized (ConfiguracionGlobal.class) {
                if (instancia == null) { // Segundo check dentro del bloque sincronizado
                    instancia = new ConfiguracionGlobal();
                }
            }
        }
        return instancia;
    }

    public boolean isModoDebug() {
        return modoDebug;
    }

    public void setModoDebug(boolean modoDebug) {
        this.modoDebug = modoDebug;
    }

    public String getEntorno() {
        return entorno;
    }

    public void setEntorno(String entorno) {
       if (!entorno.equalsIgnoreCase("Produccion") &&
                !entorno.equalsIgnoreCase("Desarrollo") &&
                !entorno.equalsIgnoreCase("Pruebas")) {
            System.out.println(
                    "Error: El entorno solo puede ser 'Produccion', 'Desarrollo' o 'Pruebas'. Intente de nuevo.");
            return; // No cambia el valor actual
        }
        this.entorno = capitalizar(entorno);
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
         if (!idioma.equalsIgnoreCase("Español") &&
                !idioma.equalsIgnoreCase("Ingles")) {
            System.out.println("Error: El idioma solo puede ser 'Español' o 'Ingles'. Intente de nuevo.");
            return; // No cambia el valor actual
        }
        this.idioma = capitalizar(idioma);
    }

    public void mostrarConfiguracion() {
         System.out.println();
        System.out.println("=== Configuración Global ===");
        System.out.println("Modo debug: " + modoDebug);
        System.out.println("Entorno: " + entorno);
        System.out.println("Idioma: " + idioma);
    }
    // Método auxiliar para formatear el texto
    private String capitalizar(String texto) {
        if (texto == null || texto.isEmpty())
            return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }
}