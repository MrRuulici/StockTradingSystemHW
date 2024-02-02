import java.util.Date;

public class LongTermInvestingStrategy implements TradingStrategy {
    private static final int LONG_TERM_HOLDING_DAYS = 0; // Example: Holding for at least 1 day

    @Override
    public void executeTrade(User user, Stock stock, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity for long-term investing.");
            return;
        }

        if (stock.getQuantity() < quantity) {
            System.out.println("Not enough stocks available for long-term investing.");
            return;
        }

        // Calculate the holding period in days
        long holdingDays = calculateHoldingDays(user, stock);

        if (holdingDays >= LONG_TERM_HOLDING_DAYS) {
            double totalValue = stock.getCurrentPrice() * quantity;
            
            
            if (user.getPortfolio().removeStock(stock, quantity)) {
                user.getPortfolio().addTransaction(new Transaction(stock.getName(), quantity, totalValue, new Date()));
                System.out.println("Long-term investing successful.");
            } else {
                System.out.println("Failed to complete long-term investing.");
            }
        } else {
            System.out.println("Stock must be held for at least " + LONG_TERM_HOLDING_DAYS + " days for long-term investing.");
        }
    }

    private long calculateHoldingDays(User user, Stock stock) {
        return user.getPortfolio().getHoldingDays(stock.getName());
    }
}
