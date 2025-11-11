package productos;

import java.util.Map;

public class Tableta extends Producto {
    public Tableta() {
        this.tipo = "Tableta";
    }

public Tableta(String marca, String linea, String modelo, double precio, Map<String, String> specs) {
        super("Tableta", linea, marca, modelo, precio);
        if (specs != null)
            this.especificaciones.putAll(specs);
    }

    private Tableta(Tableta otra) {
        this.tipo = otra.tipo;
        this.linea = otra.linea;
        this.modelo = otra.modelo;
        this.precio = otra.precio;
        this.especificaciones = new java.util.HashMap<>(otra.especificaciones);
    }

    @Override
    public Producto clonar() {
        return new Tableta(this);
    }
}
