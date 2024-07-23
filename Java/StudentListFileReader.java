//Miriam Wetstein
package test;
import java.util.Scanner;
// for ObjectInputStream, FileInputStream, and EOFException
import java.io.*;

public class StudentListFileReader

{
  

public static void main(String[] args)
  {
    Scanner stdIn = new Scanner(System.in);
    StudentList studentList;

    System.out.print("Enter filename: ");
    try (ObjectInputStream fileIn = new ObjectInputStream(
      new FileInputStream(stdIn.nextLine())))
    {
      while (true)
      {
    	  studentList = (StudentList) fileIn.readObject();
    	  studentList.display();
      }
    } // end try and close fileIn automatically
    catch (EOFException e)
    {} // end-of-file exception terminates infinite while loop
    catch (Exception e)
    {
      System.out.println(e.getClass());
      System.out.println(e.getMessage());
    }
    stdIn.close();
  } // end main
} // end ReadObject class