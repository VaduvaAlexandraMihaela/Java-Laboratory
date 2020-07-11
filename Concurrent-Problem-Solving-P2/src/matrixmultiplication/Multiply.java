package matrixmultiplication;

public class Multiply implements Runnable{
	
	private int[] aRow; //the row of the matrix A
	private int[] bCol;  //the column of the matrix B
	
	private int result = 0; //the result of the multiplication 
	
	Multiply(int[] aRow, int[] bCol) // the constructor 
	{
		this.aRow = aRow; 
		this.bCol = bCol;
	}
	
	public void run() {
		for(int elementA : aRow)
			for(int elementB : bCol)
			{
				result += elementA * elementB; //multiplying the elements from the row of the matrix A
				//with the element from the matrix B and adding the results
			}
	}
	
	public int getResult() //method for returning the final result
	{
		return result;
	}

}
