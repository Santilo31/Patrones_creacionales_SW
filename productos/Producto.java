package productos;

import java.util.HashMap;
import java.util.Map;
import prototype.Prototype;


public abstract class Producto implements Prototype<Producto> {
    protected String tipo; // Computadora, Telefono, Tableta
    protected String linea; // Premium, Estandar, Economica
    protected String modelo; // nombre del modelo
    protected double precio;
    protected String marca;
    protected Map<String, String> especificaciones = new HashMap<>();
    protected boolean esClon = false;
    protected String prototipoOrigen;
    protected int stock = 0; // cantidad disponible, por defecto 0


    public Producto() {
    }

    public Producto(String tipo, String linea, String marca, String modelo, double precio) {
        this.tipo = tipo;
        this.linea = linea;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }
    @Override
    public abstract Producto clonar();

    @Override
    public boolean puedeClonarse() {
        return tipo != null && !tipo.isEmpty()
                && marca != null && !marca.isEmpty()
                && modelo != null && !modelo.isEmpty()
                && precio > 0;
    }
    public void marcarComoClon(String idPrototipoOrigen) {
        this.esClon = true;
        this.prototipoOrigen = idPrototipoOrigen;
    }

    public boolean esClon() {
        return esClon;
    }

    public String getPrototipoOrigen() {
        return prototipoOrigen;
    }

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
    
    public void setStock(int nuevoStock) {
        this.stock = nuevoStock;
    }

    public int getStock() {
        return stock;
    }

    public void mostrarInfo() {
        System.out.println("----- Producto -----");
        System.out.println("Tipo: " + tipo);
        System.out.println("Línea: " + linea);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + stock + " unidades");
        if (esClon) {
            System.out.println("(Derivado del prototipo: " + prototipoOrigen + ")");
        }
        System.out.println("Especificaciones:");
        for (Map.Entry<String, String> e : especificaciones.entrySet()) {
            System.out.println("  - " + e.getKey() + ": " + e.getValue());
        }
    }
}