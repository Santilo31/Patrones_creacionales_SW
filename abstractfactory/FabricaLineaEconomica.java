package abstractfactory;

import productos.*;
import java.util.HashMap;
import java.util.Map;

public class FabricaLineaEconomica implements FabricaLinea {

    @Override
    public Computadora crearComputadora() {
        Map<String, String> specs = new HashMap<>();
        specs.put("CPU", "Intel i3");
        specs.put("RAM", "8GB");
        specs.put("Almacenamiento", "256GB SSD");
        return new Computadora("Acer", "Economica", "Comp-Lite", 600.0, specs);
    }

    @Override
    public Telefono crearTelefono() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "6.1\" LCD");
        specs.put("Batería", "3000mAh");
        specs.put("Cámara", "8MP");
        return new Telefono("Motorola", "Economica", "Moto E", 300.0, specs);
    }

    @Override
    public Tableta crearTableta() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "9.7\" LCD");
        specs.put("RAM", "4GB");
        specs.put("Almacenamiento", "64GB");
        return new Tableta("Huawei", "Economica", "Tab-Lite", 400.0, specs);
    }
}