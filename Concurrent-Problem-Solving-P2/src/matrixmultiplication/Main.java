package matrixmultiplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static int size = 1024; //the size of the three A,B,C
	
	private static int[] getCol(int[][] matrix, int rowId) //function for creating the results matrix 
	{
		int[] result = new int[size]; 
		
		for(int i =0; i != size; i++) {
			result[i] = matrix[rowId][i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		//new executor that has as many threads as the available virtual CPUs 
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); 
		
		int[][] A = new int[size][size]; //matrix A
		int[][] B = new int[size][size]; //matrix B
		
		int[][] C = new int[size][size]; //the results matrix C
		
		Multiply[][] values = new Multiply[size][size]; //object in which we memorise the results of type Multiply
		
		for(int i = 0; i != size; ++i) { // divide-et-impera implementation 
			for(int j = 0; j != size; ++j) {
				var Bcol = getCol(B,j); 
				values[i][j] = new Multiply(A[i],Bcol); 
				executor.execute(values[i][j]);
			}
		}
		
		try {
			executor.awaitTermination(60, TimeUnit.SECONDS); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		for(int i = 0; i != size; ++i) { //the results are memorised into the result matrix
			for(int j =0; j != size; j++) {
				C[i][j] = values[i][j].getResult();
				System.out.printf("%d ", C[i][j]);
			}
		}

	}

}
