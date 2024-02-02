import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	
    	UserInterface userInterface = new UserInterface();
        StockManagement stockManagement = StockManagement.getInstance();
        stockManagement.addStock(new Stock("Company A", "CMA", 100.0, 50));
        stockManagement.addStock(new Stock("Company B", "CMB", 75.0, 30));
        UserAccountManagement userAccountManagement = new UserAccountManagement(new ArrayList<>());

        int option;
        do {
            userInterface.displayOptions();
            option = userInterface.getOption();

            switch (option) {
                case 1:
                    String username = userInterface.getUsername();
                    String password = userInterface.getPassword();
                    userAccountManagement.registerUser(username, password);
                    break;
                case 2:
                    username = userInterface.getUsername();
                    password = userInterface.getPassword();
                    userAccountManagement.loginUser(username, password);
                    break;
                case 3:
                    stockManagement.displayAvailableStocks();
                    break;
                case 4:
                	TradingStrategy DayTradingStrategy = new DayTradingStrategy();

                	DayTradingStrategy.executeTrade(userAccountManagement.getLoggedInUser(), stockManagement.getStockBySymbol("CMA"), 10);
                    userAccountManagement.getPortfolio().displayPortfolio();
                    break;
                case 5:
                    User loggedInUser = userAccountManagement.getLoggedInUser();

                    if (loggedInUser != null) {
                        Portfolio userPortfolio = loggedInUser.getPortfolio();
                        List<Stock> ownedStocks = userPortfolio.getOwnedStocks();

                        if (!ownedStocks.isEmpty()) {
                            Stock stockToRemove = ownedStocks.get(0);
                            userAccountManagement.getPortfolio().removeStock(stockToRemove, 10);
                        } else {
                            System.out.println("User's portfolio is empty. No stocks to remove.");
                        }
                    } else {
                        System.out.println("No user logged in. Please log in to perform this action.");
                    }
                    break;
                case 6:
                	userAccountManagement.getPortfolio().displayPortfolio();
                
                    break;
                case 7:
                	userAccountManagement.getPortfolio().displayTransactionHistory();
                    break;
                case 8:
                    userAccountManagement.logout();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        } while (option != 0);
    }

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//        // Initialize stock management
//        StockManagement stockManagement = StockManagement.getInstance();
//        stockManagement.addStock(new Stock("Company A", "CMA", 100.0, 50));
//        stockManagement.addStock(new Stock("Company B", "CMB", 75.0, 30));
//
//        // Initialize user account management
//        List<User> registeredUsers = new ArrayList<>();
//        UserAccountManagement userAccountManagement = new UserAccountManagement(registeredUsers);
//
//        // Register a new user
//        userAccountManagement.registerUser("user1", "password123");
//
//        // Log in the user
//        userAccountManagement.loginUser("user1", "password123");
//
//        // Display available stocks
//        stockManagement.displayAvailableStocks();
//
//        // Execute a trade using a trading strategy
//        TradingSystem tradingSystem = new TradingSystem();
//        tradingSystem.setStrategy(new DayTradingStrategy());
//        tradingSystem.executeTrade(userAccountManagement.getLoggedInUser(), stockManagement.getStockBySymbol("CMA"), 10);
//
//        // Display user's portfolio
//        userAccountManagement.getPortfolio();
//
//        // Display transaction history
//        //userAccountManagement.displayTransactionHistory();
//
//        // Log out the user
//        userAccountManagement.logout();
    }

