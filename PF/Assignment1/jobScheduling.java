package assignment1;

public class jobScheduling {
	
	public int[][] FCFS(int arrival_time[], int job_size[])
	{
		int temp;
		int[] job=new int[arrival_time.length];
		int[] waiting_time=new int[arrival_time.length];
		int[] job_finished_time=new int[arrival_time.length];
		int[] job_start_time=new int[arrival_time.length];
		for(int i=0;i<arrival_time.length;i++)
		{
			job[i]=i+1;
		}
		for(int i=0;i<arrival_time.length;i++)
		{
			for(int j=i;j<arrival_time.length;j++)
			{
				if(arrival_time[i]>arrival_time[j])
				{
					temp=arrival_time[i];
					arrival_time[i]=arrival_time[j];
					arrival_time[j]=temp;
				}
			}
		}
		
		waiting_time[0]=0;
		int size=job_size[0];
		for(int i=1;i<arrival_time.length;i++)
		{
			waiting_time[i]=size-arrival_time[i]+1;
			if(waiting_time[i]<0)
			{
				waiting_time[i]=0;
			}
			size=size+job_size[i];
		}
		job_finished_time[0]=waiting_time[0]+job_size[0];
		for(int i=1;i<arrival_time.length;i++)
		{
			job_finished_time[i]=((job_finished_time[i-1]>arrival_time[i])?job_finished_time[i-1]:arrival_time[i]-1)+job_size[i];
		}
		job_start_time[0]=(arrival_time[0]>1)?arrival_time[0]:1;
		for(int i=1;i<arrival_time.length;i++)
		{
			job_start_time[i]=job_start_time[i-1]+job_size[i-1];
			job_start_time[i]=(job_start_time[i]>=arrival_time[i])?job_start_time[i]:arrival_time[i];
		}
		int[][] result=new int[arrival_time.length][5];;
		for(int i=0;i<arrival_time.length;i++)
		{
			result[i][0]=job[i];
			result[i][1]=arrival_time[i];
			result[i][2]=waiting_time[i];
			result[i][3]=job_start_time[i];
			result[i][4]=job_finished_time[i];
			
		}
		return result;
	}
	public static void main(String[] args) {
		jobScheduling obj=new jobScheduling();
		java.util.Scanner sc=new java.util.Scanner(System.in);
		int noOfJobs;
		System.out.println("Enter No of Jobs: ");
		noOfJobs=sc.nextInt();
		int[] arrival_time=new int[noOfJobs];
		int[] job_size=new int[noOfJobs];
		System.out.println("Enter Arrival Times: ");
		for(int i=0;i<arrival_time.length;i++)
		{
			arrival_time[i]=sc.nextInt();
		}
		System.out.println("Enter Job Size: ");
		for(int i=0;i<job_size.length;i++)
		{
			job_size[i]=sc.nextInt();
		}
		int[][] c;
		c=obj.FCFS(arrival_time,job_size);
		System.out.print("job\t"+"job arrived time\t"+"job wait time\t"+"job start at\t"+"job finished at\n");
		for(int i=0;i<arrival_time.length;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(c[i][j]+"\t\t");
			}
			System.out.println();
		}
		sc.close();
	}

}
