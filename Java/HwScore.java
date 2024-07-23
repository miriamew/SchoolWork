//Miriam Wetstein


import java.util.Scanner;
public class HwScore
{
	
	public static final double LETTER_A = .9;
	public static final double LETTER_B= .8;
	public static final double LETTER_C = .7;
	public static final double LETTER_D = .6;
	private static double totalEarnedPoints;
	private static double totalPossiblePoints;
	
	private double earnedPoints;
	private double possiblePoints;
	

	public HwScore(double earnedPoints, double possiblePoints) 
	{
		this.earnedPoints = earnedPoints;
		this.possiblePoints = possiblePoints;
		HwScore.totalPossiblePoints += this.possiblePoints;
		HwScore.totalEarnedPoints+=this.earnedPoints;
	}

	public void printGrade() 
	{
		
		System.out.print("On this homework, you earned "+this.earnedPoints+" out of "+ this.possiblePoints + " possible points: ");
		if (this.earnedPoints/this.possiblePoints>=LETTER_A) 
		{
			System.out.print("A\n");
		}
		else if (this.earnedPoints/this.possiblePoints>LETTER_B) 
		{
			System.out.print("B\n");
		}
		else if (this.earnedPoints/this.possiblePoints>LETTER_C) 
		{
			System.out.print("C\n");
		}
		else if (this.earnedPoints/this.possiblePoints>LETTER_D) 
		{
			System.out.print("D\n");
		}
		else
		{
			System.out.print("F\n");
		}
	}
		

	static void printOverallGrade()
	{
		
		System.out.print("On all homework, you earned "+HwScore.totalEarnedPoints+" out of " +HwScore.totalPossiblePoints+" possible points: ");
		if (HwScore.totalEarnedPoints/HwScore.totalPossiblePoints>=LETTER_A) 
		{
			System.out.print("A");
		}
		else if (HwScore.totalEarnedPoints/HwScore.totalPossiblePoints>LETTER_B) 
		{
			System.out.print("B");
		}
		else if (HwScore.totalEarnedPoints/HwScore.totalPossiblePoints>LETTER_C) 
		{
			System.out.print("C");
		}
		else if (HwScore.totalEarnedPoints/HwScore.totalPossiblePoints>LETTER_D) 
		{
			System.out.print("D");
		}
		else
		{
			System.out.print("F");
		}
	}
		
	public static void main(String[] args)
	{
		HwScore hw1 = new HwScore(26.5,30);
		HwScore hw2 = new HwScore(29,27.5);
		HwScore hw3 = new HwScore(0,20);
		HwScore hw4 = new HwScore(16,20);
		
		hw1.printGrade();
		hw2.printGrade();
		hw3.printGrade();
		HwScore.printOverallGrade();
		
	}
}