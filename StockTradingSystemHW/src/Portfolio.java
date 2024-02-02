import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Portfolio {
	private List<Transaction> transactionHistory;
	private List<Stock> ownedStocks;
	 private StockManagement stockManagement;

	public Portfolio(StockManagement stockManagement) {
		transactionHistory = new ArrayList<>();
		ownedStocks = new ArrayList<>();
		this.stockManagement = stockManagement;
		
	}

	public boolean addTransaction(Transaction transaction) {
		return transactionHistory.add(transaction);
	}

	public List<Transaction> getTransactionHistory() {
		return new ArrayList<>(transactionHistory);
	}

	public void displayTransactionHistory() {
		if (transactionHistory.isEmpty()) {
			System.out.println("Transaction history is empty.");
		} else {
			System.out.println("Transaction History:");
			for (Transaction transaction : transactionHistory) {
				System.out.println("Date: " + transaction.getDate() + ", Stock: " + transaction.getStockName()
						+ ", Quantity: " + transaction.getQuantity() + ", Price: $" + transaction.getPrice());
			}
		}
	}

	public boolean addStock(Stock stock, int quantity) {
	    StockManagement stockManagement = StockManagement.getInstance();
	    Stock availableStock = stockManagement.getStockBySymbol(stock.getTickerSymbol());

	    if (availableStock == null) {
	        System.out.println("Stock not available for purchase.");
	        return false;
	    }

	    if (availableStock.getQuantity() < quantity) {
	        System.out.println("Not enough stocks available for purchase.");
	        return false;
	    }

	    double totalValue = availableStock.getCurrentPrice() * quantity;

	    if (stockManagement.removeStock(availableStock, quantity)) {
	        Transaction transaction = new Transaction(stock.getName(), quantity, totalValue, new Date());
	        addTransaction(transaction);
	        ownedStocks.add(stock); // Add to owned stocks
	        System.out.println("Stock purchase successful.");
	        return true;
	    } else {
	        System.out.println("Failed to complete stock purchase.");
	        return false;
	    }
	}


    public boolean removeStock(Stock stock, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity for removing stock.");
            return false;
        }

        double totalValue = stock.getCurrentPrice() * quantity;

        if (stockManagement.addStock(stock)) {
            addTransaction(new Transaction(stock.getName(), quantity, totalValue, new Date()));
            System.out.println("Stock removal successful.");
            return true;
        } else {
            System.out.println("Failed to complete stock removal.");
            return false;
        }
    }

	public long getHoldingDays(String stockName) {
		long holdingDays = 0;

		for (Transaction transaction : transactionHistory) {
			if (transaction.getStockName().equals(stockName)) {
				long days = calculateDaysBetween(transaction.getDate(), new Date());
				holdingDays += days;
			}
		}

		return holdingDays;
	}

	private long calculateDaysBetween(Date startDate, Date endDate) {
		long diff = endDate.getTime() - startDate.getTime();
		return diff / (24 * 60 * 60 * 1000); // Convert milliseconds to days
	}

	public List<Stock> getOwnedStocks() {
		return new ArrayList<>(ownedStocks);
	}

	public void displayPortfolio() {
		if (ownedStocks.isEmpty()) {
			System.out.println("Portfolio is empty.");
		} else {
			System.out.println("Portfolio:");
			for (Stock stock : ownedStocks) {
				System.out.println("Stock: " + stock.getName() + ", Ticker Symbol: " + stock.getTickerSymbol()
						+ ", Quantity: " + stock.getQuantity() + ", Current Price: $" + stock.getCurrentPrice());
			}
		}
	}
}

