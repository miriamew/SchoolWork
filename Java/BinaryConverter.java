//Miriam Wetstein


import java.util.Scanner;
public class BinaryConverter
{
	public static void main(String[] args)
	{
		int places = 0;
		Boolean binary = true;
		int placeValue = 1;
		int finalNum = 0;
		System.out.println("Enter a number in binary.");
		Scanner input=new Scanner(System.in);
		int number = input.nextInt();
		int newNumber = number;
		while (newNumber>0)
		{
			newNumber = newNumber/10;
			places++;
		}
	
		while(places > 0 )
		{
			if (binary)
			{
				newNumber = number%10;
				if (newNumber == 1 || newNumber == 0)
				{
					number = number/10; 
					finalNum += newNumber * placeValue;
					placeValue = placeValue * 2;
					places--;
				}
				else
					{			
					System.out.println("Sorry, that number isn't binary.");
					binary = false;
					}		
			}
		}
		System.out.println(finalNum);
	}
}