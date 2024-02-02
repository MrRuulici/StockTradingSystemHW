import java.util.Date;

public class DayTradingStrategy implements TradingStrategy {
    @Override
    public void executeTrade(User user, Stock stock, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity for day trading.");
            return;
        }

        double totalValue = stock.getCurrentPrice() * quantity;

        if (user.getPortfolio().addStock(stock, quantity)) {
            user.getPortfolio().addTransaction(new Transaction(stock.getName(), quantity, totalValue, new Date()));
            System.out.println("Day trading successful. You bought" + stock.getName());
        } else {
            System.out.println("Failed to complete day trading.");
        }
    }
}

