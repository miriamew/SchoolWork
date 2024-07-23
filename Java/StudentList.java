//Miriam Wetstein
package test;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentList implements Serializable
{
  /**
	 *  
	 */
	private static final long serialVersionUID = 1L;
ArrayList<String> students = new ArrayList<String>();

  //***************************************************

  public StudentList(String[] names)
  {
    for (int i=0; i<names.length; i++)
    {
      students.add(names[i]);
    }
  } // end constructor

  
  public void display()
  {
    for (int i=0; i<students.size(); i++)
    {
      System.out.print(students.get(i) + " ");
    }
    System.out.println();
  } // end display



  public void removeStudent(int index)
  {
    if (index >= 0 && index < students.size())
    {
      students.remove(index);
    }
    else
    {
      System.out.println("Can't remove student because " +
        index + " is an invalid index position.");
    }
  } // end removeStudent
} // end StudentList