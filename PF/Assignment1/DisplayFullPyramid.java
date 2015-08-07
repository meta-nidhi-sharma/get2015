package printPyramid;
/**
author: Nidhi Sharma
Description: This program is to display a full pyramid
Input: Number of rows in pyramid(for ex. 3)
Output: Display pyramid where pyramid is group of individual strings

o/p:         1
            121  
           12321
            121
             1
         
         */

public class DisplayFullPyramid {
			
			public static void main(String args[])
			  {
				
				java.util.Scanner sc=new java.util.Scanner(System.in);
				System.out.println("enter n");
				int n=sc.nextInt();
				String pyramid=new String();
				DisplayFullPyramid obj=new DisplayFullPyramid();
				pyramid=obj.wholePyramid(n);
				System.out.print(pyramid);
				sc.close();
			  }
			
			
			/*
			 the function is returning whole pyramid in group of strings
			 */
			
			String wholePyramid(int n){
				String combinedString=new String();               //to combine spaces string and numbers string
				String spaceString=new String();
				String numberString=new String();
				for(int row=1;row<=n;row++)
				{
					spaceString=spaces(row, n);
					numberString=numbers(row, n);
					combinedString+=spaceString+numberString+"\n";                   //combining space string and number string with next line
				}
				for(int row=n-1;row>=1;row--)
				{
					spaceString=spaces(row, n);
					numberString=numbers(row, n);
					combinedString+=spaceString+numberString+"\n";
					
				}
				return combinedString;
			}
		
		/*
			 Description: this function is adding spaces in each string
			 */
			
			String spaces(int row, int n){
				String spaceString=new String();                  //str1 is a string of spaces
				for(int i=1;i<=n-row;i++)
					spaceString+=" ";                   //adding spaces to string
				
				return spaceString;
			}
			
			/*
			 Description: This function is inserting numbers in each string
			 */
			
			String numbers(int row, int n){
				String numberString=new String();                    //str2 is a string of numbers
				int count=0;                        //to print value of count as numbers 
				for(int i=1;i<=2*row-1;i++)
				{
					if(i<=row)
					{
						numberString+=++count;               //adding numbers to string
					}
					else
					{
						numberString+=--count;	
					}
				}
				//System.out.println(str2);
				
				return numberString;
			}
	}
