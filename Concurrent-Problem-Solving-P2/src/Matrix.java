
public class Matrix {
	public int dim;
	public int rowDisplace, colDisplace; 
	public double data[][]; 
	
	Matrix(int dimension){
		this.dim = dimension; 
		rowDisplace = colDisplace = 0; 
		data = new double[dimension][dimension];
	}
	
	Matrix(double[][] matrix, int x, int y, int dimension) {
		data = matrix; 
		rowDisplace = x; 
		colDisplace = y; 
		dim = dimension;
	}
	
	double get(int row, int col) {
		return data[row + rowDisplace][col+colDisplace];
	}
	
	void set(int row, int col, double value) {
		data[row+rowDisplace][col+colDisplace] = value;
	}
	
	int getDim() 
	{
		return dim; 
	}
	
	Matrix[][] split(){
		Matrix[][] result = new Matrix[2][2]; 
		int newDim = dim / 2; 
		result[0][0] = new Matrix(data, rowDisplace, colDisplace, newDim); 
		result[0][1] = new Matrix(data, rowDisplace, colDisplace, newDim);
		result[1][0] = new Matrix(data, rowDisplace, colDisplace, newDim);
		result[1][1] = new Matrix(data, rowDisplace, colDisplace, newDim);
		
		return result;
	}
}
