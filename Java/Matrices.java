//Miriam Wetstein



public class Matrices
{
	public static int matrixA[][];
	public static int matrixB[][];
	
	
	
	

	

	public static void createMatrices(int[][] matrixA, int[][] matrixB) 
	{
		int num = 1;
		
		for (int i=0; i<matrixA.length; i++)
		{
		  for (int j=0; j<matrixA[0].length; j++)
		  {
		    
		    matrixA[i][j] = num;
		    
		    num++;
		  } 
		}
		num = 9;
		for (int i=0; i<matrixB.length; i++)
		{
		  for (int j=0; j<matrixB[0].length; j++)
		  {
		    
		    matrixB[i][j] = num;
		    num--;
		  } 
		} 


	}
	
	
	public static void printMatrix(int[][]matrix)
	{
		
		
		
		for (int i=0; i<matrix.length; i++)
		{
		  for (int j=0; j<matrix[0].length; j++)
		  {
		    
		    System.out.print(matrix[i][j] + " ");
		   
		  } 
		  System.out.print("\n");
		}
		
		

	}	
	public static void addMatrix(int[][]matrixSum, int[][]matrix1, int[][]matrix2) 
	{
		for (int i=0; i<matrix1.length; i++)
		{
		  for (int j=0; j<matrix1[0].length; j++)
		  {
		    
		   matrixSum[i][j] =  matrix1[i][j] + matrix2[i][j];
		    
		    
		  } 
		}
		
	}
	public static void subMatrix(int[][]matrixDifference, int[][]matrix1, int[][]matrix2) 
	{
		for (int i=0; i<matrix1.length; i++)
		{
		  for (int j=0; j<matrix1[0].length; j++)
		  {
		    
			  matrixDifference[i][j] =  matrix1[i][j] - matrix2[i][j];
		    
		    
		  } 
		}
		
	}
	public static void mulMatrix(int[][]matrixProduct, int[][]matrix1, int[][]matrix2) 
	{
		for (int i=0; i<matrix1.length; i++)
		{
		  for (int j=0; j<matrix1[0].length; j++)
		  {
		    for (int k=0; k<matrix1[0].length; k++)
			  matrixProduct[i][j] +=  matrix1[i][k] * matrix2[k][j];
		    
		    
		  } 
		}
		
	}
	
	 
		
	
	
	public static final int SIZE = 3;
	public static void main(String[] args) 
	{ // variables for inputs
		
		int matrixA[][] = new int[SIZE][SIZE];
		int matrixB[][] = new int[SIZE][SIZE];
		
		// variables to store the results
		int matrixSum[][] = new int[SIZE][SIZE];
		int matrixDifference[][] = new int[SIZE][SIZE];
		int matrixProduct[][] = new int[SIZE][SIZE];
		
		System.out.println("Initializing matrices...");
		createMatrices(matrixA, matrixB);
		
		System.out.println("\nMatrix A:");
		printMatrix(matrixA);
		System.out.println("\nMatrix B:");
		printMatrix(matrixB);
		
		addMatrix(matrixSum, matrixA, matrixB);
		System.out.println("\n\nMatrix Sum:");
		
		printMatrix(matrixSum);
		
		subMatrix(matrixDifference, matrixA, matrixB);
		System.out.println("\nMatrix Difference:");
		
		printMatrix(matrixDifference);
		
		mulMatrix(matrixProduct, matrixA, matrixB);
		System.out.println("\nMatrix Product:");
		printMatrix(matrixProduct);
		
	}
}