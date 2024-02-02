import java.util.Scanner;

public class UserInterface {
	private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("Choose an option:");
        System.out.println("1. Register a new user");
        System.out.println("2. Log in");
        System.out.println("3. Display available stocks");
        System.out.println("4. Buy stocks");
        System.out.println("5. Sell stocks");
        System.out.println("6. Display portfolio");
        System.out.println("7. Display transaction history");
        System.out.println("8. Log out");
        System.out.println("0. Exit");
    }

    public int getOption() {
        System.out.print("Enter your choice: ");
        int option = scanner.nextInt();
        scanner.nextLine();  
        return option;
    }

    public String getUsername() {
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.print("Enter password: ");
        return scanner.nextLine();
    }

    public int getQuantity() {
        System.out.print("Enter quantity: ");
        return scanner.nextInt();
    }

}
