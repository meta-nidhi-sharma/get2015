package assignment1;

public class checkSorting {
	int checkSortedArray(int a[], int asize)
	{
		int i,r=0;
		int min=a[0];
		for(i=1;i<asize;i++)
		{
		  if((a[i]>min) && (r!=2))	
		  {
			  r=1;
			  min=a[i];
		  }
		  else if((a[i]<min) && (r!=1))
				  {
			       r=2;
			        min=a[i];
				  }
		  else 
		  {
			  r=0;
		      break;
		  }
		}	
			return r;
	}
	
	
	public static void main(String args[])
	{
		int a[]=new int[] {7,8,6,10};
		int asize=a.length;
		int x;
		checkSorting obj=new checkSorting();
		x=obj.checkSortedArray(a, asize);
		System.out.println(x);
	}
}
