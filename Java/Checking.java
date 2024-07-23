package test;

public class Checking extends BankAccount {
	
	
	  private double balance;
	 
	  

	  public Checking (double balance)
	  {
	    
	    this.balance = balance;
	  } 

	  
	  public double writeACheck(double amount)
	  {
		  this.balance = (this.balance - amount - 1);
		  return(this.balance);
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
		  System.out.print("Checking account balance = " + this.balance+"\n");
	  }
}
