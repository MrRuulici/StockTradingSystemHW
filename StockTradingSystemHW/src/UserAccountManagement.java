import java.util.List;

public class UserAccountManagement {
    private List<User> registeredUsers;
    private User loggedInUser;
    StockManagement stockManagement = StockManagement.getInstance();

    public UserAccountManagement(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public boolean registerUser(String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("Username is already taken. Please choose another one.");
            return false;
        }

        User newUser = new User(username, password, new Portfolio(StockManagement.getInstance()));
        registeredUsers.add(newUser);

        System.out.println("Registration successful. Welcome, " + username + "!");
        return true;
    }

    public boolean loginUser(String username, String password) {
        User user = getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Login successful. Welcome back, " + username + "!");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("Logout successful. Goodbye!");
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    private boolean isUsernameTaken(String username) {
        for (User user : registeredUsers) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private User getUserByUsername(String username) {
        for (User user : registeredUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    public Portfolio getPortfolio() {
        if (loggedInUser != null) {
            return loggedInUser.getPortfolio();
        } else {
            System.out.println("No user logged in. Cannot retrieve portfolio.");
            return null;
        }
    }

}
