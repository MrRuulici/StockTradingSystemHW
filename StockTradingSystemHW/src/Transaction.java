import java.util.Date;

public class Transaction {
	private String stockName;
    private int quantity;
    private double price;
    private Date date;
    
	public Transaction(String stockName, int quantity, double price, Date date) {
		super();
		this.stockName = stockName;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    
}
