import java.util.Scanner;
class User{
    String acNo;
    double balance;
    int atmPin;
    User(String acNO,double balance,int atmPin){
        this.acNo = acNO;
        this.balance = balance;
        this.atmPin = atmPin;
    }
}
class ATM{
    User suchi;
    ATM(String acNO,double balance,int atmPin){
        Scanner sc = new Scanner(System.in);
        suchi = new User(acNO,balance,atmPin);
        System.out.println("****Welcome to CodSoft ATM****");
        System.out.println("Enter your PIN : ");
        int enteredPin = sc.nextInt();
        if(enteredPin == suchi.atmPin){
            menu();
        }else{
            System.out.println("Wrong Pin Entered!!!");
            System.out.println("Transaction Cancelled");
        }
    }
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Withdrawal");
            System.out.println("2. Deposit");
            System.out.println("3. Balance Check");
            System.out.println("4. Cancel");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    withdrawal(sc);
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Transaction Canceled");
                    break;
                default:
                    System.out.println("Invalid...Transaction Canceled!!");
                    break;
            }
        }while(choice!=4);
    }
    public void withdrawal(Scanner sc){
        System.out.println("Enter Amount : ");
        double enteredAmt = sc.nextInt();
        if (suchi.balance>=enteredAmt) {
            suchi.balance = suchi.balance-enteredAmt;
            System.out.println("Transaction Successful...");
        }else{
            System.out.println("Insufficient Balance !");
            System.out.println("Transaction Canceled....");
        }
    }
    public void deposit(Scanner sc){
        System.out.println("Enter Amount to deposit : ");
        double depoAmt = sc.nextInt();
        suchi.balance = suchi.balance+depoAmt;
        System.out.println("Transaction Successful....");
    }
    public void checkBalance(){
        System.out.println("Your Balance is : "+suchi.balance);
    }
}
class AtmInterface{
    public static void main(String a[]){
        new ATM("1230044",5000,7809);
    }
}