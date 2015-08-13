package assignment_4;

/**
author: Nidhi Sharma
Description: This program contains a function to check whether there is a solution for queen problem
             of n dimensional matrix, if solution persist then function will return true and program will print
             "Solution is possible", else if solution does not persist function will return false and
             program will print "Solution is not possible".
     
Input:  Enter Matrix Dimension for square matrix

Output: It will give whether there is a solution possible for that dimension.

For Example: I/P:Enter Matrix Dimension 4
O/P:
solution is possible

*/

public class NQueenProblem {

	public static void main(String args[])
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("Enter Matrix Dimension for square matrix");
		int dimension = sc.nextInt();                        // Enter Matrix Dimension
		if(dimension>=1 && dimension <=25)
		{
			int[][] board=new int[dimension][dimension];	
			int startRow=0;
			NQueenProblem obj=new NQueenProblem();
		    Boolean result=obj.nQueen(board, startRow, dimension);       
		    //Call Function and storing possibility  in result
		    if(result==true)
		    	System.out.println("Solution is possible");
		    else
		    	System.out.println("Solution is not possible");
		}
		else
			System.out.println("Not valid for this size\nplease enter dimension between 1 to 25");
		sc.close();
	}
	
	/*********************************************
	N Queen problem: Here board is nxn matrix, 
	startRow is initially 0 and dimension of matrix is n, 
	which will be entered by user
	 *********************************************/
	
	Boolean  nQueen(int[][] board, int startRow, int dimensionOfMatrix)
	{ 
		   if ( solveNQUtil(board, 0, dimensionOfMatrix) == false )
				      return false;
		   else
	                  return true;
	}
	/* A recursive function to solve N Queen problem */
	Boolean solveNQUtil(int[][] board, int col, int N)
	{
	   
	    if (col >= N)
	        return true;
	 
	    /* Consider this column and try placing this queen in all rows
	       one by one */
	    for (int i = 0; i < N; i++)
	    {
	        /* Check if queen can be placed on board[i][col] */
	        if ( isSafe(board, i, col, N) )
	        {
	            /* Place this queen in board[i][col] */
	            board[i][col] = 1;
	 
	            /* recursion to place rest of the queens */
	            if ( solveNQUtil(board, col + 1, N) == true )
	                return true;
	 
	            /* If placing queen in board[i][col] doesn't lead to a solution
	               then remove queen from board[i][col] */
	            board[i][col] = 0; // BACKTRACK
	        }
	    }
	 
	     /* If queen can not be place in any row in this colum col
	        then return false */
	    return false;
	}

	
	Boolean isSafe(int[][] board, int row, int col, int N)
	{
	    int i, j;
	 
	    /* Check this row on left side */
	    for (i = 0; i < col; i++)
	    {
	        if (board[row][i]!=0)
	            return false;
	    }
	 
	    /* Check upper diagonal on left side */
	    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
	    {
	        if (board[i][j]!=0)
	            return false;
	    }
	 
	    /* Check lower diagonal on left side */
	    for (i = row, j = col; j >= 0 && i < N; i++, j--)
	    {
	        if (board[i][j]!=0)
	            return false;
	    }
	 
	    return true;
	}
	 
}
