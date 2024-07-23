//Miriam Wetstein
package test;


import java.util.Scanner;
import java.io.*; // ObjectOutputStream, FileOutputStream

public class StudentListFileWriter 

{
  

public static void main(String[] args)
  {
    Scanner stdIn = new Scanner(System.in);
    

    System.out.print("Enter filename: ");
    try (ObjectOutputStream fileOut = new ObjectOutputStream(
      new FileOutputStream(stdIn.nextLine())))
    {
    	String[] names1 = {"Caleb", "Izumi", "Mary", "Usha"};
        StudentList studentList1 = new StudentList(names1);
        fileOut.writeObject(studentList1);
        String[] names2 = {"Caleb", "Izumi", "Mary", "Usha", "Miriam"};
        StudentList studentList2 = new StudentList(names2);
        fileOut.writeObject(studentList2);
        fileOut.reset();
        studentList2.removeStudent(1);
        fileOut.writeObject(studentList2);

    } // end try and close fileOut automatically
    catch (Exception e)
    {
      System.out.println(e.getClass());
      System.out.println(e.getMessage());
    } // end catch
    stdIn.close();
  } // end main
} // end WriteObject class