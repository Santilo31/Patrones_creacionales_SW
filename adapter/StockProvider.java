package adapter;
/**
 * Interfaz esperada por el sistema interno.
 * La aplicación trabaja con unidades individuales.
 */
public interface StockProvider {
    int getStockUnits(String productName);
}
