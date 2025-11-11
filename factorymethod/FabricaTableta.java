package factorymethod;

import productos.Producto;
import productos.Tableta;
import java.util.HashMap;
import java.util.Map;

public class FabricaTableta implements FabricaProducto {

    @Override
public Producto crearProducto(String marca, String modelo, Double precio, Map<String, String> especificaciones) {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "10.1\"");
        specs.put("RAM", "4GB");
        specs.put("Almacenamiento", "128GB");
        if (especificaciones != null && !especificaciones.isEmpty()) {
            specs.putAll(especificaciones); // ← ESTO DEBE SOBRESCRIBIR
        }
        String marcaFinal = (marca == null || marca.isEmpty()) ? "Genérica" : marca;
        String modeloFinal = (modelo == null || modelo.isEmpty()) ? "Tab-Base" : modelo;
        double precioFinal = (precio == null || precio <= 0) ? 300.0 : precio;

        return new Tableta(marcaFinal, null, modeloFinal, precioFinal, specs);
    }
}