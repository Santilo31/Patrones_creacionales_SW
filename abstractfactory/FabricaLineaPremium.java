package abstractfactory;

import productos.*;
import java.util.HashMap;
import java.util.Map;

public class FabricaLineaPremium implements FabricaLinea {

    @Override
    public Computadora crearComputadora() {
        Map<String, String> specs = new HashMap<>();
        specs.put("CPU", "Intel i9");
        specs.put("RAM", "32GB");
        specs.put("Almacenamiento", "2TB SSD");
        return new Computadora("Alienware", "Premium", "Comp-PRO", 2500.0, specs);
    }

    @Override
    public Telefono crearTelefono() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "6.8\" AMOLED 120Hz");
        specs.put("Batería", "5000mAh");
        specs.put("Cámara", "108MP");
        return new Telefono("Samsung", "Premium", "Galaxy Ultra", 1800.0, specs);
    }

    @Override
    public Tableta crearTableta() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "12.9\" Retina");
        specs.put("RAM", "16GB");
        specs.put("Almacenamiento", "1TB");
        return new Tableta("Apple", "Premium", "iPad Pro", 1500.0, specs);
    }
}