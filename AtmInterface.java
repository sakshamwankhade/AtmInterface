import java.util.Scanner;

// Bank Account class
class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
	{
        this.balance = initialBalance;
    }

    public double getBalance() 
	{
        return balance;
    }

    public void deposit(double amount) 
	{
        balance += amount;
    }

    public void withdraw(double amount) 
	{
        if (amount <= balance) 
            balance -= amount;
		else 
            System.out.println("Insufficient balance!");
    }
}

// ATM class
class ATM 
{
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) 
	{
        this.bankAccount = bankAccount;
    }

    public void displayMenu() 
	{
        
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) 
	{
        Scanner scanner = new Scanner(System.in);

        switch (option) 
		{
            case 1:
                System.out.println("Current Balance: Rs. " + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: Rs. ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful!");
                break;
            case 3:
                System.out.print("Enter withdrawal amount: Rs. ");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Thanks for using the ATM");
                System.out.println("Have a great day ahead !!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option ! Please try again !");
                break;
        }
    }
}


// Main class
public class ATMInterface 
{
    public static void main(String[] args) 
	{
        BankAccount bankAccount = new BankAccount(1000000.0);
        ATM atm = new ATM(bankAccount);

        System.out.println("!! Welcome to the ATM !!");
        Scanner scanner = new Scanner(System.in);

        while (true) 
		{
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();

            atm.processOption(option);
        }
    }
}