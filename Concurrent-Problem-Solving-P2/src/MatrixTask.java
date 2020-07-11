import java.util.concurrent.*; 


public class MatrixTask {
	static ExecutorService exec = Executors.newCachedThreadPool(); 
	
	static Matrix add(Matrix a, Matrix b) {
		int n = a.getDim(); 
		Matrix c = new Matrix(n); 
		Future<?> future = exec.submit(new AddTask(a,b,c)); 
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return c; 
	}

}
