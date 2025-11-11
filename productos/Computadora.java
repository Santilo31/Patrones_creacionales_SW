package productos;

import java.util.HashMap;
import java.util.Map;

public class Computadora extends Producto {

    public Computadora() {
        this.tipo = "Computadora";
    }

 public Computadora(String marca, String linea, String modelo, double precio, Map<String, String> specs) {
        super("Computadora", linea, marca, modelo, precio);
        if (specs != null)
            this.especificaciones.putAll(specs);
    }

    // Constructor copia para clonar (deep copy)
    private Computadora(Computadora otra) {
        this.tipo = otra.tipo;
        this.linea = otra.linea;
        this.modelo = otra.modelo;
        this.precio = otra.precio;
        this.especificaciones = new HashMap<>(otra.especificaciones);
    }

    @Override
    public Producto clonar() {
        return new Computadora(this);
    }
}
