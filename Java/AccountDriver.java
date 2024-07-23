package test;
import java.util.ArrayList;

//Miriam Wetstein
public class AccountDriver {

	public static void main(String[] args) {
		BankAccount[] accounts = new BankAccount[3];
		accounts[0] = new Savings(1100, .05);
		accounts[0].deposit(100);
		accounts[0].withdraw(200);
		((Savings) accounts[0]).addInterest();
		accounts[1] = new Checking(100);
		accounts[1].deposit(50);
		accounts[2] = new Checking(200);
		accounts[2].withdraw(100);
		accounts[2].deposit(75);
		
		((Checking) accounts[2]).writeACheck(50);
		
		for(int i = 0; i < accounts.length && accounts[i] != null; i++) 
		{
			accounts[i].display();
		}
		System.out.println("ArrayList Results:");
		ArrayList<BankAccount> accounts1 = new ArrayList<>(2);
		accounts1.add(new Savings(1100, .05));
		accounts1.get(0).deposit(100);
		accounts1.get(0).withdraw(200);
		((Savings) accounts1.get(0)).addInterest();
		
		accounts1.add(new Checking(100));
		accounts1.get(1).deposit(50);
		accounts1.add( new Checking(200));
		accounts1.get(2).withdraw(100);
		accounts1.get(2).deposit(75);
		((Checking) accounts1.get(2)).writeACheck(50);
		
		for(int i = 0; i < accounts1.size(); i++) 
		{
			accounts1.get(i).display();
		}
		}
}
