package productos;

import java.util.HashMap;
import java.util.Map;

public abstract class Producto {
    protected String tipo; // Computadora, Telefono, Tableta
    protected String linea; // Premium, Estandar, Economica
    protected String modelo; // nombre del modelo
    protected double precio;
    protected String marca;
    protected Map<String, String> especificaciones = new HashMap<>();

    public Producto() {
    }

    public Producto(String tipo, String linea, String marca, String modelo, double precio) {
        this.tipo = tipo;
        this.linea = linea;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public abstract Producto clonar(); // Prototype

    public String getTipo() {
        return tipo;
    }

    public String getLinea() {
        return linea;
    }

    public String getModelo() {
        return modelo;
    }
     public String getMarca() {
        return marca;
    }
    public double getPrecio() {
        return precio;
    }

    public Map<String, String> getEspecificaciones() {
        return especificaciones;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void mostrarInfo() {
        System.out.println("----- Producto -----");
        System.out.println("Tipo: " + tipo);
        System.out.println("Línea: " + linea);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio: $" + precio);
        System.out.println("Especificaciones:");
        for (Map.Entry<String, String> e : especificaciones.entrySet()) {
            System.out.println("  - " + e.getKey() + ": " + e.getValue());
        }
    }
}