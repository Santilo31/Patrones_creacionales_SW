package factorymethod;

import productos.Producto;
import java.util.Map;

public interface FabricaProducto {
    Producto crearProducto(String marca, String modelo, Double precio, Map<String, String> especificaciones);
}
