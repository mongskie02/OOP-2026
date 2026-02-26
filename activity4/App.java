
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class App {

    static int c;

    public static void main(String[] args) {
        //load accounts
        //BankAccount[] accounts;
        ArrayList<BankAccount> accounts = new ArrayList<>();
        loadAccounts(accounts);

        //login
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO JAVA ATM");
        System.out.println("Enter account number to proceed:");
        String acctNo = sc.nextLine();
        System.out.println("Enter PIN:");
        int pin = sc.nextInt();

        Optional<BankAccount> newSessionUser = accounts.stream().filter(account -> account.getAcctNo().equals(acctNo)).findFirst();

        if (newSessionUser.isPresent()) {
            if (newSessionUser.get().isValidPin(pin)) {
                System.out.println("Welcome...");
                //begin transaction
                beginTransaction(newSessionUser.get(), accounts);
            } else {
                System.out.println("Invalid credentials...");
            }
        }

    }

    public static void beginTransaction(BankAccount account, ArrayList<BankAccount> accounts) {
        do {
            System.out.println("""
            Menu
            1. Balance Inquiry
            2. Deposit
            3. Withdraw
            0. Exit
        
        """);

            System.out.println("Choice: ");
            Scanner sc = new Scanner(System.in);
            c = sc.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Deposit Amount: ");
                    int amount = sc.nextInt();
                    account.deposit(amount);
                    System.out.println("Deposit successful");
                    saveData(accounts);
                    break;
                case 3:
                    System.out.println("Withdraw Amount: ");
                    int withdraw = sc.nextInt();
                    account.withdraw(withdraw);
                    System.out.println("Withdrawal successful");
                    saveData(accounts);
                    break;
                case 0:
                    System.out.println("Thank you for using Java ATM");
                    break;
                default:
                    System.out.println("Invalid choice...");
            }
        } while (c != 0);

    }

    public static void saveData(ArrayList<BankAccount> accounts) {
        StringBuilder data = new StringBuilder("Account Number,Full Name,Balance,PIN");
        for (BankAccount acc : accounts) {
            data.append("\n")
                    .append(acc.getAcctNo()).append(",")
                    .append(acc.getFullName()).append(",")
                    .append(acc.getBalance()).append(",")
                    .append(acc.getPin());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.csv"))) {
            bw.write(data.toString());
            bw.close();
            System.out.println("File saved...");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void loadAccounts(ArrayList<BankAccount> accounts) {
        try (Scanner reader = new Scanner(new File("accounts.csv"))) {
            reader.nextLine(); //skip the header
            while (reader.hasNextLine()) {
                String[] cols = reader.nextLine().split(",");
                String acctNo = cols[0];
                String fullName = cols[1];
                float balance = Float.parseFloat(cols[2]);
                int pin = Integer.parseInt(cols[3]);

                BankAccount acc = new BankAccount(acctNo, pin, balance, fullName);
                accounts.add(acc);
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();

        }
    }
}
