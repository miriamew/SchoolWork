//Miriam Wetstein


import java.util.Scanner;
public class ParkingLot
{
	public static double calculateCharge(double hours)
	{
		double charge = 0;
		if (hours<=3)
	    {
	    	charge = 2.00;
	    }
	    else
	    {
	    	charge = (hours-3)*.50 + 2;     
	    	if (charge>10.0)
	    	{
	    		charge=10.0;
	    	}
	    }
		return charge;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Enter hours for car 1:");
		Scanner input=new Scanner(System.in);
		double hours1 = input.nextDouble();
		double charge1 = calculateCharge(hours1);
		
		System.out.println("Enter hours for car 2:");
		double hours2 =  input.nextDouble();
		double charge2 = calculateCharge(hours2);
		
		System.out.println("Enter hours for car 3:");
		double hours3 = input.nextDouble();
		double charge3 = calculateCharge(hours3);
		
		final String HEADING = "%-6s%6s%9s\n";
	    final String DATA = "%-6s%,6.1f%,9.2f\n";
	    double totalHours, totalCharge; 
	  
	    System.out.printf(HEADING, "Car", "Hours", "Charge");
	    System.out.printf(DATA, "1", hours1, charge1);
	  
	    System.out.printf(DATA, "2", hours2, charge2);
	    
	    System.out.printf(DATA, "3", hours3, charge3);
	    
	    totalHours = hours1+hours2+hours3;
	    totalCharge = charge1+charge2+charge3;
	    System.out.printf("\n%-6s%6.1f%9.2f", "TOTAL:", totalHours, totalCharge);

	}
}