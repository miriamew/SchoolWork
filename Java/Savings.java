package test;

public class Savings extends BankAccount{
	  
	  private double balance;
	  private double interest;
	 
	  

	  public Savings(double balance, double interest)
	  {
	    
	    this.balance = balance;
	    this.interest = interest;
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
		  System.out.print("Savings account balance = " + this.balance+"\n");
	  }

	  
	  public double addInterest()
	  {
	    this.balance += (this.balance*this.interest);
	    return(this.balance);
	  } 

}
