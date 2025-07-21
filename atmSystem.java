import java.util.Scanner;

public class atmSystem {
    static double balance = 1000;
    public static void main(String[] args) throws InterruptedException{

        Scanner scanner = new Scanner(System.in);

        double numResponse;
        String response;
        double amount;
        char choice;
        int defaultPin = 0000;
        int pin;

        String menu = "---------------ATM---------------\n\n-1. Check Balance \n-2. Deposit \n-3. Withdraw \n-4. Exit";
        System.out.println(menu);

        System.out.print("\nEnter a valid option: ");
        choice = scanner.next().charAt(0);

        while (choice != '4'){
            if (choice=='1'){
                System.out.print("\nEnter pin: ");
                pin = scanner.nextInt();
                int attempts = 1;
                System.out.println("\nLoading....");
                Thread.sleep(2500);
                while (pin != defaultPin){
                    System.out.println("Invalid pin!");
                    attempts++;
                    if (attempts==5){
                        System.out.println("\nYou have reached limit of 5 attempts,your account has been flagged for suspicious activity!\nOPERATION CANCELLED!");
                        //break;
                        System.exit(0);
                    }
                    System.out.print("\nEnter pin: ");
                    pin = scanner.nextInt();
                    System.out.println("\nLoading....");
                    Thread.sleep(2000);
                }
                numResponse = checkBalance();
                System.out.printf("\nBalance: $%.2f", numResponse);
            } else if (choice=='2'){
                System.out.print("Enter deposit amount: ");
                amount = scanner.nextDouble();
                System.out.print("\nEnter pin: ");
                pin = scanner.nextInt();
                int attempts = 1;
                System.out.println("\nLoading....");
                Thread.sleep(2500);
                while (pin != defaultPin){
                    System.out.println("Invalid pin!");
                    attempts++;
                    if (attempts==5){
                        System.out.println("\nYou have reached limit of 5 attempts,your account has been flagged for suspicious activity!\nOPERATION CANCELLED!");
                        //break;
                        System.exit(0);
                    }
                    System.out.print("\nEnter pin: ");
                    pin = scanner.nextInt();
                    System.out.println("\nLoading....");
                    Thread.sleep(2000);
                }
                response = deposit(amount);
                System.out.println(response);
            } else if (choice=='3'){
                System.out.print("Enter withdrawal amount: ");
                amount = scanner.nextDouble();
                System.out.print("\nEnter pin: ");
                pin = scanner.nextInt();
                int attempts = 1;
                System.out.println("\nLoading....");
                Thread.sleep(2500);
                while (pin != defaultPin){
                    System.out.println("Invalid pin!");
                    attempts++;
                    if (attempts==5){
                        System.out.println("\nYou have reached limit of 5 attempts,your account has been flagged for suspicious activity!\nOPERATION CANCELLED!");
                        //break;
                        System.exit(0);
                    }
                    System.out.print("\nEnter pin: ");
                    pin = scanner.nextInt();
                    System.out.println("\nLoading....");
                    Thread.sleep(2000);
                }
                response = withdraw(amount);
                System.out.println(response);
            }
            refresh();
            clear();
            System.out.println(menu);
            System.out.print("\nEnter a valid option: ");
            choice = scanner.next().charAt(0);
        }

        System.out.println("Operation cancelled!");
        System.exit(0);
    }
    static double checkBalance(){
        return balance;
    }
    static String deposit(double amount){
        balance += amount;
        return "\n$" + amount + " deposited successfully";
    }
    static String withdraw(double amount){
        if (amount > balance){
            return "\nInsufficient funds!";
        }
        else {
            balance -= amount;
            return "\n$" + amount + " withdrawal successful";
        }
    }
    static void refresh() throws InterruptedException{
        Thread.sleep(3000);
        System.out.println("\n\nRefreshing...");
        System.out.print("5.. ");
        Thread.sleep(1000);
        System.out.print("4.. ");
        Thread.sleep(1000);
        System.out.print("3.. ");
        Thread.sleep(1000);
        System.out.print("2.. ");
        Thread.sleep(1000);
        System.out.print("1.. ");
        Thread.sleep(1000);
    }
    static void clear(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}