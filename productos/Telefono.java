package productos;

import java.util.Map;

public class Telefono extends Producto {
    public Telefono() {
        this.tipo = "Teléfono";
    }

public Telefono(String marca, String linea, String modelo, double precio, Map<String, String> specs) {
        super("Teléfono", linea, marca, modelo, precio);
        if (specs != null)
            this.especificaciones.putAll(specs);
    }

    private Telefono(Telefono otro) {
        this.tipo = otro.tipo;
        this.linea = otro.linea;
        this.modelo = otro.modelo;
        this.precio = otro.precio;
        this.especificaciones = new java.util.HashMap<>(otro.especificaciones);
    }

    @Override
    public Producto clonar() {
        return new Telefono(this);
    }
    
}
