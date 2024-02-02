
public class Stock {
	 private String name;
	 private String tickerSymbol; //prescurtarea
	 private double currentPrice;
	 private int quantity;
	 
	public Stock(String name, String tickerSymbol, double currentPrice, int quantity) {
		super();
		this.name = name;
		this.tickerSymbol = tickerSymbol;
		this.currentPrice = currentPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	 
	 
	
}
