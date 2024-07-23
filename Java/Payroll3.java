//Miriam Wetstein
package test;

import java.util.Calendar;

public class Payroll3
{
  public static void main(String[] args)
  {
    Employee2[] employees = new Employee2[100];
    Hourly2 hourly;
    employees[0] = new Hourly2("Anna", 25.0); 
    employees[1] = new Salaried2("Simon", 48000);
    employees[2] = new Hourly2("Donovan", 20.0);
    employees[3] = new Commissioned("Glen");
    employees[4] = new SalariedAndCommissioned("Carol", 24000);

    ((Commission) employees[3]).addSales(15000);
    ((Commission) employees[4]).addSales(15000);
    
    Calendar rightNow = Calendar.getInstance();
    int currentMonth = rightNow.get(Calendar.MONTH);
    
    
    for (rightNow.get(Calendar.DATE), rightNow.get(Calendar.DAY_OF_WEEK); rightNow.get(Calendar.MONTH)<=(currentMonth+1); rightNow.add(Calendar.DATE,1))
    {
      for (int i=0; i<employees.length && employees[i] != null; i++)
      {
        if (rightNow.get(Calendar.DAY_OF_WEEK) > 1 && rightNow.get(Calendar.DAY_OF_WEEK) < 7
          && employees[i] instanceof Hourly2)
        {
          hourly = (Hourly2) employees[i];
          hourly.addHours(8);
        }
        if ((rightNow.get(Calendar.DAY_OF_WEEK) == 6 && employees[i] instanceof Hourly2) ||
          ((rightNow.get(Calendar.DATE)==15 || rightNow.get(Calendar.DATE)==rightNow.getActualMaximum(Calendar.DAY_OF_MONTH) ) &&
            (employees[i] instanceof Salaried2 || employees[i] instanceof Commissioned)))
        {
         
          employees[i].printPay(rightNow.get(Calendar.DATE));
        }
      } 
    } 
    
  } // end main
} // end class Payroll3