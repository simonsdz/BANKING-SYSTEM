package Banking;

import java.util.Scanner;

public class Account
{
    int balance;
    int prevTransaction;

    void deposit(int amount)
    {
        if(amount!=0 && amount>0)
        {
            balance+=amount;
            prevTransaction=amount;
            System.out.println("================================");
            System.out.println("Deposited: "+ amount+".0");
            System.out.println("Your current balance: "+balance+".0");
            System.out.println("================================");
        }
        else
            System.out.println("Amount to be deposited should be greater than 0");
    }
    void withdrawal(int amount)
    {
        if(amount!=0 && amount>0 && amount<=balance)
        {
            balance-=amount;
            prevTransaction= -amount;
            System.out.println("================================");
            System.out.println(amount+".0 has been withdrawn");
            System.out.println("Your current balance: "+balance+".0");
            System.out.println("================================");
        }
        else if(amount==0) {
            System.out.println();
            System.out.println("Amount to be withdrawn should be greater than 0");
        }
        else if(amount>balance) {
            System.out.println();
            System.out.println("You don't have sufficient amount to withdraw");
        }

    }
    void checkBalance()
    {
        System.out.println("================================");
        System.out.println("Your current balance: "+balance+".0");
        System.out.println("================================");
    }
    void getPreviousTransaction()
    {
        if(prevTransaction>0)
        {
            System.out.println("================================");
            System.out.println("Deposited: "+prevTransaction+".0");
            System.out.println("================================");
        }
        else if(prevTransaction<0)
        {
            System.out.println("================================");
            System.out.println("Withdrawn: "+Math.abs(prevTransaction)+".0");
            System.out.println("================================");
        }
        else
        {
            System.out.println("================================");
            System.out.println("There was no transaction");
            System.out.println("================================");
        }

    }

    void start()
    {
        System.out.println("What would do like to do?");
        System.out.println();

        int userOption=0;
        do {
            System.out.println("1. Check your balance");
            System.out.println("2. Make a deposit");
            System.out.println("3. Make a withdrawal");
            System.out.println("4. View previous transaction");
            System.out.println("5. Exit");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter an option");
            try
            {
                userOption=sc.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("================================");
                System.out.println("Choose from the given options");
                System.out.println("================================");
                continue;
            }
            switch (userOption)
            {
                case 1:
                    System.out.println();
                    checkBalance();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter an amount to deposit: ");
                    int amountToDeposit=sc.nextInt();
                    deposit(amountToDeposit);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter an amount to withdraw");
                    int amountToWithdraw=sc.nextInt();
                    withdrawal(amountToWithdraw);
                    System.out.println();
                    break;
                case 4:
                    getPreviousTransaction();
                    break;
                case 5:
                    System.out.println();
                    break;
                default:
                    System.out.println("================================");
                    System.out.println("Choose from the given options");
                    System.out.println("================================");
                    break;
            }
        }while(userOption!=5);
        System.out.println("Thank you for banking with us! Do visit us again!!");
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String userName="";
        String accountNumber="";
        System.out.println("Enter your Name : ");
        userName=sc.nextLine();
        if(checkUserName(userName)==false)
        {
            System.out.println("Entered User Name is incorrect");
            return;
        }
        System.out.println("Enter your Account Number : ");
        accountNumber=sc.nextLine();
        if(checkAccountNumber(accountNumber)==false)
        {
            System.out.println("Entered account Number is incorrect");
            return;
        }
        Account user=new Account();
        System.out.println("Welcome, "+ userName+"!");
        System.out.println();
        user.start();
    }
    static boolean checkUserName(String userName)
    {
        /*
        To check whether the entered input name is valid.
        Conditions are: The input should only consists of aplhabets and space.
         */
        boolean wrongUserName=false;
        for(int i=0;i<userName.length();i++)
        {
            char c=userName.charAt(i);
            if(c>=33 && c<=64)
            {
                wrongUserName=true;
                break;
            }
            if(c>=123 && c<=126)
            {
                wrongUserName=true;
                break;
            }
        }
        if(wrongUserName==true)
            return false;
        return true;
    }
    static boolean checkAccountNumber(String accNumber)
    {
        /*
        To check whether the input account number is valid.
        Conditions are: It should contain "ID" in the beginning followed by 4 integers.
         */
        if(accNumber.length()!=6)
            return false;
        char charA10=Character.toUpperCase(accNumber.charAt(0));
        char charAt1=Character.toUpperCase(accNumber.charAt(1));
        if(charA10!='I' || charAt1!='D')
            return false;
        for(int i=2;i<accNumber.length();i++)
        {
            char c=accNumber.charAt(i);
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }
}
