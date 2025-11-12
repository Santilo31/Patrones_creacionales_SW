package adapter;

/**
 * Simula un sistema externo que reporta el stock en LOTES de 10 unidades.
 * No se puede modificar esta clase.
 */
public class ExternalStockSystem {

    public int getStockInBatches(String productName) {
        return switch (productName.toLowerCase()) {
            case "computadora" -> 5;  // 5 lotes = 50 unidades
            case "telefono" -> 8;     // 8 lotes = 80 unidades
            case "tableta" -> 4;      // 4 lotes = 40 unidades
            default -> 2;             // 2 lotes = 20 unidades
        };
    }
}