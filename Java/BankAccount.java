package test;



//Miriam Wetstein
public class BankAccount {

	  private double balance;
	  
	  public BankAccount()
	  {
	    
	  }

	  public double deposit(double amount)
	  {
		  this.balance += amount;
		  return (this.balance);
	  } 
	  public double withdraw(double amount)
	  {
		 this.balance = (this.balance-amount);
		 return (this.balance);
	  } 

	  public void display()
	  {
		  System.out.print("dummy");
	  }

}

