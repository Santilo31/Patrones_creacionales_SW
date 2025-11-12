package adapter;

/**
 * Adaptador que convierte el stock del sistema externo (en lotes de 10)
 * a unidades individuales, que es lo que usa nuestra app interna.
 */
public class StockAdapter implements StockProvider {

    private final ExternalStockSystem externalSystem;
    private static final int UNITS_PER_BATCH = 10;

    public StockAdapter(ExternalStockSystem externalSystem) {
        this.externalSystem = externalSystem;
    }

    @Override
    public int getStockUnits(String productName) {
        int stockBatches = externalSystem.getStockInBatches(productName);
        int stockUnits = stockBatches * UNITS_PER_BATCH;
        System.out.println("(Adapter) Stock externo en lotes: " + stockBatches);
        System.out.println("(Adapter) Convertido a unidades: " + stockUnits);
        return stockUnits;
    }

    // Método adicional: convertir un número de lotes ingresado manualmente
    public int convertirDesdeUsuario(int lotes) {
        System.out.println("(Adapter) Convirtiendo lotes ingresados a unidades...");
        return lotes * UNITS_PER_BATCH;
    }
}
