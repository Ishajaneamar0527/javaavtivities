import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class BankApp {
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public int getPinCode() {
        return pinCode;
    }
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
    private int userid,pinCode;
    public static void main(String[] args) {
        UserAccount[] ua = new UserAccount[]{
                new UserAccount(412435,7452,"Chris Sandoval", 32000),
                new UserAccount(264863,1349,"Marc Yim", 1000),
                new UserAccount(001,5455,"JCash", 1)};
        List<Logs> logger = new ArrayList<>();
        System.out.println(Arrays.toString(ua));
        BankApp ba = new BankApp();
        Scanner input1 = new Scanner(System.in);
        System.out.println("Welcome to Jcash\n Enter Id:\n");
        ba.setUserid(input1.nextInt());
        System.out.println("Enter Pin Code: ");
        ba.setPinCode(input1.nextInt());
        UserAccount user = ba.checkUser(ua,ba.getUserid(),ba.getPinCode());
        if(user == null){
            System.out.println("Wrong User ID or Pin Code");
            logger.add(new Logs("Login failed",0,0,0,0,LocalDateTime.now()));
            System.exit(0);
        }
        else
            System.out.println("You are Logged in");
        logger.add(new Logs("Login success",0,0,0,0,LocalDateTime.now()));
        boolean menu = true;
MENU:   while(menu) {
        System.out.println("Your account balance is : P"+user.getBalance());
        System.out.println("1. Deposit(Cash  in)\n2. Money Transfer\n3.previous transactions\n 4. Logout");
        int choice = input1.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to Cash in");
                    user.deposit(input1.nextInt(),logger);
                    System.out.println(user.toString());
                    continue MENU;
                case 2:
                    System.out.println("Enter accountID");
                    int accid = input1.nextInt();
                    System.out.println("Enter amount to transfer + %1 charge:");
                    double money = input1.nextInt();
                    double fee = money * 0.01;
                    if ((money + fee) <= user.getBalance()) {
                        user.moneyTransfer(ua, user, accid, money, fee);
                        System.out.println(Arrays.toString(ua));
                    } else {
                        System.out.println("insufficient funds");
                        System.exit(0);
                    }
                    continue MENU;
                case 3:
                    for(Logs log:logger){
                        System.out.println(log);
                    }
                    continue MENU;
                case 4:
                default:
                    menu = false;
                    System.exit(0);
            }
        }
    }
    private UserAccount checkUser(UserAccount[] ua, int userid, int pinCode) {
        UserAccount userFound = null;
        for (UserAccount user: ua){
            if(user.getId()==userid && user.getPin()==pinCode)
                userFound = user;
        }
        return userFound;
    }
}
class UserAccount{
    private int id;
    private int pin;
    private String name;
    private double balance;
    public UserAccount() {
    }
    public UserAccount(int id, int pin, String name, double balance) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", pin=" + pin +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
    public void deposit(int i,List<Logs> logger) {
        logger.add(new Logs("Deposit",i,0,0,0,LocalDateTime.now()));
        this.balance+=i;
    }
    public void moneyTransfer(UserAccount[] receiver,UserAccount sender, int accid, double money,double fee) {
        UserAccount userFound = null;
        for (UserAccount user: receiver){
            if(user.getId()==accid)
                userFound = user;
            if(user.getId()==001)
                user.setBalance(user.getBalance()+fee);
        }
        if(userFound!=null){
            sender.setBalance(sender.getBalance()-(money+fee));
            userFound.setBalance(userFound.getBalance() + money);
        }
        else
            System.out.println("No account found with "+accid+" number\nTry again");
    }
}
class Logs{
    public Logs(String trans_type, double amount, int sender, int receiver, double fee, LocalDateTime transtime) {
        this.trans_type = trans_type;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.fee = fee;
        this.transtime = transtime;
    }
    public String getLog() {
        return "BankApp{" +
                "trans_type='" + trans_type + '\'' +
                ", amount=" + amount +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", fee=" + fee +
                ", transaction date and time=" + transtime +

                '}';
    }
    public void setLogs(String trans_type,double amount,int sender,int receiver,double fee) {
        this.trans_type = trans_type;
        this.amount = amount;
        this.fee = fee;
        this.receiver = receiver;
        this.sender = sender;
        this.transtime = LocalDateTime.now();
    }
    private String trans_type;
    private double amount;
    private int sender;
    private int receiver;
    private double fee;
    private LocalDateTime transtime;
    @Override
    public String toString() {
        return "Logs{" +
                "trans_type='" + trans_type + '\'' +
                ", amount=" + amount +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", fee=" + fee +
                ", transaction date & time=" + transtime +
                '}';
    }
}
