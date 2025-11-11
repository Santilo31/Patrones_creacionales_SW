package factorymethod;

import productos.Producto;
import productos.Telefono;
import java.util.HashMap;
import java.util.Map;

public class FabricaTelefono implements FabricaProducto {

    @Override
     public Producto crearProducto(String marca, String modelo, Double precio, Map<String, String> especificaciones) {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "6.1\"");
        specs.put("Batería", "3500mAh");
        specs.put("Cámara", "12MP");
        if (especificaciones != null && !especificaciones.isEmpty()) {
            specs.putAll(especificaciones); // ← ESTO DEBE SOBRESCRIBIR
        }

        String marcaFinal = (marca == null || marca.isEmpty()) ? "Genérica" : marca;
        String modeloFinal = (modelo == null || modelo.isEmpty()) ? "Tel-Base" : modelo;
        double precioFinal = (precio == null || precio <= 0) ? 500.0 : precio;

        return new Telefono(marcaFinal, null, modeloFinal, precioFinal, specs);
    }
}