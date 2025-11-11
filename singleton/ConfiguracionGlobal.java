package singleton;

public class ConfiguracionGlobal {
    private static ConfiguracionGlobal instancia;
    private boolean modoDebug;
    private String entorno;
    private String idioma;

    private ConfiguracionGlobal() {
        this.modoDebug = false;
        this.entorno = "Producción";
        this.idioma = "Español";
    }

    public static ConfiguracionGlobal getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionGlobal();
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
        this.entorno = entorno;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void mostrarConfiguracion() {
        System.out.println("=== Configuración Global ===");
        System.out.println("Modo debug: " + modoDebug);
        System.out.println("Entorno: " + entorno);
        System.out.println("Idioma: " + idioma);
    }
}