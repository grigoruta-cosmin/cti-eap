import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bank {
    private String name;
    ArrayList<Account> accounts = new ArrayList<>();

    public Bank() {
        name = "";
    }

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount() {
        boolean flag = true;
        int option;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("--Bank Account Menu--");
            System.out.println("1. Account");
            System.out.println("2. WithdrawAccount");
            System.out.println("3. BalanceAccount");
            System.out.println("4. Exit");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("--Account--");
                    System.out.println("Set Balance:");
                    accounts.add(new Account(scanner.nextDouble()));
                    break;
                case 2:
                    System.out.println("--Withdraw Account--");
                    System.out.println("Set Balance and WithdrawLimit:");
                    accounts.add(new WithdrawAccount(scanner.nextDouble(), scanner.nextDouble()));
                    break;
                case 3:
                    System.out.println("--Balance Account--");
                    System.out.println("Set Balance and MinBalance:");
                    accounts.add(new BalanceAccount(scanner.nextDouble(), scanner.nextDouble()));
                    break;
                case 4:
                default:
                    flag = false;
            }
        }
    }

    private void selectAccount(int index, int option, String type){
        Scanner scanner = new Scanner(System.in);
        if(!type.equals("Account")){
            System.out.println("!! Specialised Account Type !!");
        }
        System.out.println("Select Quantity:");
        if(option == 1){
            accounts.get(index).deposit(scanner.nextDouble());
        }else if(option == 2){
            accounts.get(index).withdraw(scanner.nextDouble());
        }else{
            System.out.println("!! Invalid Option !!");
        }
    }

    public void makeTransaction() {
        Scanner scanner = new Scanner(System.in);
        int option, index;
        boolean flag = true;
        while (flag) {
            System.out.println("--Transaction Menu--");
            System.out.println("Accounts IDs:");
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println(accounts.get(i).getId());
            }
            System.out.println("Select Account:");
            index = scanner.nextInt();
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            option = scanner.nextInt();
            selectAccount(index, option, accounts.get(index).getClass().getName());
            System.out.println("1.Continue");
            System.out.println("2.Exit");
            if(scanner.nextInt() == 2){
                flag = false;
            }
        }
    }

    @Override
    public String toString() {
        return "--Bank--\nName: " + this.name + "\n" + accounts;
    }

    public static void main(String[] args) {
        Bank bank = new Bank("BCR");
        bank.addAccount();
        bank.makeTransaction();
        System.out.println(bank);
    }
}
