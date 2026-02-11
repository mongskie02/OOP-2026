
public class BankAccount {

    private String acctNo;
    private int pin;
    private float balance = 0;
    private String fullName;

    public BankAccount(String acctNo, int pin, float balance, String fullName) {
        this.acctNo = acctNo;
        this.pin = pin;
        this.fullName = fullName;
        if (balance > 0) {
            this.balance = balance;
        }
    }

    //getters
    public String getAcctNo() {
        return acctNo;
    }

    public int getPin() {
        return pin;
    }

    public boolean isValidPin(int pin) {
        return this.pin == pin;
    }

    public float getBalance() {
        return balance;
    }

    public String getFullName() {
        return fullName;
    }

    // Setters
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public boolean setPin(int pin) {
        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
            return true;
        } else {
            System.out.println("Error: Invalid pin");
            return false;
        }
    }

    public boolean deposit(float balance) {
        if (balance > 0) {
            this.balance += balance;
            return true;
        } else {
            System.out.println("Error: You cannot deposit less than 1 peso.");
            return false;
        }

    }

    public void withdraw(float amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withraw success...");
        } else {
            System.out.println("Error: Insufficient balance");
        }
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
