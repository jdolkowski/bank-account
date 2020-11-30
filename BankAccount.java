import java.util.ArrayList;
import java.util.Date;

public class BankAccount {
    private final String name;
    private final String accountNumber;
    private float accountBalance;
    private final ArrayList<Payment> transferHistory;

    public BankAccount(String name, String accountNumber, float accountBalance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.transferHistory = new ArrayList<>();
    }
    public BankAccount(){
        this("untitled", "00000000000000000000000000",  0.0f);
    }
    public BankAccount(String name){
        this(name, "00000000000000000000000000",  0.0f);
    }
    public void addMoney(float money){
        accountBalance += money;
    }
    public void takeMoney(float money){
        accountBalance -= money;
    }
    public String getName(){
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }
    public void transferToAccount(BankAccount otherAccount, float money, String title){
       if(this.getAccountBalance() >= money) {
           this.takeMoney(money);
           otherAccount.addMoney(money);
           Date date = new Date();
           Payment payment = new Payment(title, date, money, this.getAccountNumber() + this.getName(), otherAccount.getAccountNumber() + otherAccount.getName());
           transferHistory.add(payment);
       } else{
           System.out.println("transakcja odrzucona");
       }
    }
    public void transferToAccount(BankAccount otherAccount, float money, String title, Date date){
        if(this.getAccountBalance() >= money) {
            this.takeMoney(money);
            otherAccount.addMoney(money);

            Payment payment = new Payment(title, date, money, this.getAccountNumber() + this.getName(), otherAccount.getAccountNumber() + otherAccount.getName());
            transferHistory.add(payment);
            otherAccount.transferHistory.add(payment);
        } else{
            System.out.println("transakcja odrzucona");
        }
    }
    public void seeHistory(Date dateStart, Date dateEnd){
        for(Payment i : transferHistory){
            if( !dateStart.after(i.getDate()) && !dateEnd.before(i.getDate()) ){
                i.printPayment();
            }
        }
    }
}
