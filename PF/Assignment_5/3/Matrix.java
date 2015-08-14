package Matrix;

public class Matrix {

	int noRows;
	int noCols;
	int data[][];
	public Matrix(int row, int col){
		this.noRows=row;
		this.noCols=col;
		data=new int[row][col];
	}
	
	public void addElements(int row, int col, int val){
		
		this.data[row][col]=val;
	}
	
	public Matrix transpose(){
		
		Matrix transMatrix= new Matrix(this.noCols,this.noRows);
		for(int i=0;i<transMatrix.noRows;i++)
			{
				for(int j=0;j<transMatrix.noCols;j++)
				transMatrix.data[i][j]=this.data[j][i];	
				
			}
		return transMatrix;
	}
	
	public void show(){
		
		for(int i=0;i<this.noRows;i++)
		{
			for(int j=0;j<this.noCols;j++)
			System.out.print(this.data[i][j]+ " ");
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		
		java.util.Scanner sc= new java.util.Scanner(System.in);
		
		System.out.println("Enter No. of rows and columns of matrix respectively");
		int row=sc.nextInt();
		int col=sc.nextInt();
		Matrix obj = new Matrix(row,col);
		System.out.println("Enter elements of matrix row wise");
		for(int i=0; i< row; i++)
		{
			for(int j=0;j<col;j++)
				{
				    int val=sc.nextInt();
					obj.addElements(i,j,val);
				}
		}
		
		Matrix m2= obj.transpose();
		m2.show();
		sc.close();
	}
}


