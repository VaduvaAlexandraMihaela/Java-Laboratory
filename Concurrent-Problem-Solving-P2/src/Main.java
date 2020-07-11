
public class Main {

	public static void main(String[] args) {
		int n = 3;
		Matrix a = new Matrix(n); 
		Matrix b = new Matrix(n);
		Matrix c = new Matrix(n); 
		
		for(int i =0; i< n; i++)
		{
			for(int j = 0; j< n;j++)
			{
				a.set(i, j, 1);
				b.set(i, j, 1);
				c.set(i, j, 0);
			}
		}
		
		AddTask task = new AddTask(a, b, c);
		
		task.run();

	}

}
