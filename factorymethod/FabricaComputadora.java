package factorymethod;

import productos.Computadora;
import productos.Producto;
import java.util.HashMap;
import java.util.Map;

public class FabricaComputadora implements FabricaProducto {

    @Override
 public Producto crearProducto(String marca, String modelo, Double precio, Map<String, String> especificaciones) {
        Map<String, String> specs = new HashMap<>();
        specs.put("CPU", "Intel i5");
        specs.put("RAM", "8GB");
        specs.put("Almacenamiento", "512GB SSD");
        if (especificaciones != null && !especificaciones.isEmpty()) {
            specs.putAll(especificaciones); // ← ESTO DEBE SOBRESCRIBIR
        }

        String marcaFinal = (marca == null || marca.isEmpty()) ? "Genérica" : marca;
        String modeloFinal = (modelo == null || modelo.isEmpty()) ? "Comp-Base" : modelo;
        double precioFinal = (precio == null || precio <= 0) ? 800.0 : precio;

        return new Computadora(marcaFinal, null, modeloFinal, precioFinal, specs);
    }
}