package assignment1;

public class assignment {
	public int convertBinaryToOctal(int n)
	{
		 int i,octalNum=0,count=0;
		for(i=0;i<3;i++)
		 {
			 octalNum=(int)(octalNum+((n%10)*Math.pow(2, i))*Math.pow(10, count));
			 n=n/10;
			 if(i==2 && n!=0)
			 {
				 i=-1;
				 count++;
				 continue;
			 }
		 }
		return octalNum;
	}
	public static void main(String args[])
	{
		assignment obj=new assignment();
		int octal=obj.convertBinaryToOctal(110101);
		System.out.println(octal);
	}

}



