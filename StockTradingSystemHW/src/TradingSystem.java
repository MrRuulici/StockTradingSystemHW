
public class TradingSystem {
	private TradingStrategy strategy;

    public void setStrategy(TradingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeTrade(User user, Stock stock, int quantity) {
        strategy.executeTrade(user, stock, quantity);
    }

}
