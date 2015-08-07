package printPyramid;
/**
author: Nidhi Sharma
Description: This program is to display a pattern 
Input: Number of rows in pyramid(for Ex. 4)
Output: Display pyramid where pyramid is group of individual strings
o/p:    1234
         123
          12
           1
 */
public class DisplayHalfPattern {
	public static void main(String args[])
	  {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("enter n");
		int n=sc.nextInt();
		String fullPattern=new String();
		DisplayHalfPattern obj=new DisplayHalfPattern();
		fullPattern=obj.wholePyramid(n);
		System.out.print(fullPattern);
		sc.close();
	  }
	/*
	 This function is calling spaces function and numbers function, then combining both space and
	  number string and returning combined string.
	  
	  Input: Number of rows in pattern
	 */
	
	String wholePyramid(int n){
		String combinedString=new String();               //to combine spaces string and numbers string
		String spaceString=new String();
		String numberString=new String();
		for(int row=1;row<=n;row++)
		{
			spaceString=spaces(row, n);
			numberString=numbers(row, n);
			combinedString+=spaceString+numberString;
			combinedString+="\n";
			//System.out.print(CombinedString=SpaceString+NumberString);
			
			
		}
		return combinedString;
	}
	
	/*
	 Description: this function is adding spaces in each string
	 */
	
	String spaces(int row, int n){
		String spaceString=new String();                  //str1 is a string of spaces
		for(int i=1;i<=row-1;i++)
		{
			spaceString+=" ";                   //adding spaces to string
		}
		return spaceString;
	}
	
	/*
	 Description: This function is inserting numbers in each string
	 */
	
	String numbers(int row, int n){
		String numberString=new String(); 
		for(int i=1;i<=n+1-row;i++)
		{
			numberString+=i;               //adding numbers to string
		}
		
		return numberString;
	}
}

