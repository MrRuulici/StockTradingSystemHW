import java.util.ArrayList;
import java.util.List;

public class StockManagement {
    private static StockManagement instance;
    private List<Stock> availableStocks;

    private StockManagement() {
        availableStocks = new ArrayList<>();
    }

    public static StockManagement getInstance() {
        if (instance == null) {
            instance = new StockManagement();
        }
        return instance;
    }

    public boolean addStock(Stock stock) {
        return availableStocks.add(stock);
    }

    public List<Stock> getAvailableStocks() {
        return new ArrayList<>(availableStocks);
    }

    public Stock getStockBySymbol(String symbol) {
        for (Stock stock : availableStocks) {
            if (stock.getTickerSymbol().equals(symbol)) {
                return stock;
            }
        }
        return null;
    }
    
    public boolean removeStock(Stock stock, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity for removing stock.");
            return false;
        }

        if (!availableStocks.contains(stock)) {
            System.out.println("Stock not found in available stocks.");
            return false;
        }

        int existingQuantity = stock.getQuantity();

        if (existingQuantity < quantity) {
            System.out.println("Not enough stocks available for removal.");
            return false;
        }

        if (existingQuantity == quantity) {
            availableStocks.remove(stock);
        } else {
            // Decrease the quantity of the existing stock
            stock.setQuantity(existingQuantity - quantity);
        }

        return true;
    }


    public void displayAvailableStocks() {
        System.out.println("Available Stocks:");
        for (Stock stock : availableStocks) {
            System.out.println("Symbol: " + stock.getTickerSymbol() +
                    ", Name: " + stock.getName() +
                    ", Price: $" + stock.getCurrentPrice() +
                    ", Quantity: " + stock.getQuantity());
        }
    }

}

