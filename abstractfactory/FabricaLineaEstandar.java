package abstractfactory;

import productos.*;
import java.util.HashMap;
import java.util.Map;

public class FabricaLineaEstandar implements FabricaLinea {

    @Override
    public Computadora crearComputadora() {
        Map<String, String> specs = new HashMap<>();
        specs.put("CPU", "Intel i7");
        specs.put("RAM", "16GB");
        specs.put("Almacenamiento", "1TB HDD");
        return new Computadora("HP", "Estandar", "Comp-Mid", 1200.0, specs);
    }

    @Override
    public Telefono crearTelefono() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "6.4\" OLED");
        specs.put("Batería", "4000mAh");
        specs.put("Cámara", "48MP");
        return new Telefono("Xiaomi", "Estandar", "Redmi Note", 800.0, specs);
    }

    @Override
    public Tableta crearTableta() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "10.5\" LCD");
        specs.put("RAM", "8GB");
        specs.put("Almacenamiento", "256GB");
        return new Tableta("Lenovo", "Estandar", "Tab-M10", 700.0, specs);
    }
}