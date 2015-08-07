package printPyramid;

public class DisplayHalfPattern {
	public static void main(String args[])
	  {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("enter n");
		int n=sc.nextInt();
		String FullPattern=new String();
		DisplayHalfPattern obj=new DisplayHalfPattern();
		FullPattern=obj.WholePyramid(n);
		System.out.print(FullPattern);
		sc.close();
	  }
	/*
	 This function is calling spaces function and numbers function, then combining both space and
	  number string and returning combined string.
	  
	  Input: Number of rows in pattern
	 */
	
	String WholePyramid(int n){
		String CombinedString=new String();               //to combine spaces string and numbers string
		String SpaceString=new String();
		String NumberString=new String();
		for(int row=1;row<=n;row++)
		{
			SpaceString=Spaces(row, n);
			NumberString=Numbers(row, n);
			CombinedString+=SpaceString+NumberString;
			CombinedString+="\n";
			//System.out.print(CombinedString=SpaceString+NumberString);
			
			
		}
		return CombinedString;
	}
	
	/*
	 Description: this function is adding spaces in each string
	 */
	
	String Spaces(int row, int n){
		String SpaceString=new String();                  //str1 is a string of spaces
		for(int i=1;i<=row-1;i++)
		{
			SpaceString+=" ";                   //adding spaces to string
		}
		return SpaceString;
	}
	
	/*
	 Description: This function is inserting numbers in each string
	 */
	
	String Numbers(int row, int n){
		String NumberString=new String(); 
		for(int i=1;i<=n+1-row;i++)
		{
			NumberString+=i;               //adding numbers to string
		}
		
		return NumberString;
	}
}

