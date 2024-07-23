//Miriam Wetstein


import java.util.Scanner;
public class ShapeCreator
{
public static void main(String[] args)
{
System.out.println("Enter a character, a size, and either the word checkerboard or square. Please put a space between them.");
Scanner input=new Scanner(System.in);
String symbol = input.next();
int size = input.nextInt();
int rows = size;
int totalRows = size;
String pattern = input.next();

if (pattern.equals("checkerboard"))
{
	while (rows!=0)
	{
		while (size!=0)
		{
			if (rows%2 == 0)
			{
			System.out.print(" " + symbol);
			}
			else
			{
				System.out.print(symbol + " ");
			}
			size--;
		}
		size = totalRows;
		System.out.println("  ");
		rows--;
	}
}

else if  (pattern.equals("square"))
{
	int gaps = size - 2;
	while (rows!=0)
	{
		if (rows == totalRows || rows == 1)
		{
		while (size!=0)
		{
			System.out.print (symbol);
			size--;
		}
		}
		else
		{
			while (size!=0)
			{
				System.out.print(symbol);
				size--;
				while (gaps!=0)
				{
					System.out.print(" ");
					gaps--;
					size--;
				}
			}
		}
		size = totalRows;
		gaps = totalRows-2;
		System.out.println(" ");
		rows--;
	}	
}

else
{
	System.out.print("That is not a valid pattern");
}
}
}