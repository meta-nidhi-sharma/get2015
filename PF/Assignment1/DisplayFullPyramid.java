package printPyramid;
/**
author: Nidhi Sharma
Description: This program is to display a full pyramid
Input: Number of rows in pyramid
Output: Display pyramid where pyramid is group of individual strings
 */

public class DisplayFullPyramid {
			
			public static void main(String args[])
			  {
				
				java.util.Scanner sc=new java.util.Scanner(System.in);
				System.out.println("enter n");
				int n=sc.nextInt();
				String Pyramid=new String();
				DisplayFullPyramid obj=new DisplayFullPyramid();
				Pyramid=obj.WholePyramid(n);
				System.out.print(Pyramid);
				sc.close();
			  }
			
			
			/*
			 the function is returning whole pyramid in group of strings
			 */
			
			String WholePyramid(int n){
				String CombinedString=new String();               //to combine spaces string and numbers string
				String SpaceString=new String();
				String NumberString=new String();
				for(int row=1;row<=n;row++)
				{
					SpaceString=Spaces(row, n);
					NumberString=Numbers(row, n);
					CombinedString+=SpaceString+NumberString+"\n";                   //combining space string and number string with next line
				}
				for(int row=n-1;row>=1;row--)
				{
					SpaceString=Spaces(row, n);
					NumberString=Numbers(row, n);
					CombinedString+=SpaceString+NumberString+"\n";
					
				}
				return CombinedString;
			}
			
			/*
			 Description: this function is adding spaces in each string
			 */
			
			String Spaces(int row, int n){
				String SpaceString=new String();                  //str1 is a string of spaces
				for(int i=1;i<=n-row;i++)
					SpaceString+=" ";                   //adding spaces to string
				
				return SpaceString;
			}
			
			/*
			 Description: This function is inserting numbers in each string
			 */
			
			String Numbers(int row, int n){
				String NumberString=new String();                    //str2 is a string of numbers
				int count=0;                        //to print value of count as numbers 
				for(int i=1;i<=2*row-1;i++)
				{
					if(i<=row)
					{
						NumberString+=++count;               //adding numbers to string
					}
					else
					{
						NumberString+=--count;	
					}
				}
				//System.out.println(str2);
				
				return NumberString;
			}
	}
