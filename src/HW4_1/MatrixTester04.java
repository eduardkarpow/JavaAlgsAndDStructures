package HW4_1;

public class MatrixTester04 {
    public static void main(String[] args) {
        Matrix mx = new Matrix(3,3);
        System.out.println(mx);
        mx.multipleOnDigit(2.0);
        System.out.println(mx);
        Matrix mx2 = mx.sumMatrix(new Matrix(3,3));
        System.out.println(mx2);
    }
}
class Matrix{
    private int rows, cols;
    private double[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                this.matrix[i][j] = Math.random()*10;
            }
        }
    }
    public void multipleOnDigit(double n){
        for (int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                this.matrix[i][j]*=n;
            }
        }
    }
    public Matrix sumMatrix(Matrix mx){
        Matrix mx2 = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                mx2.matrix[i][j]=this.matrix[i][j]+mx.matrix[i][j];
            }
        }
        return mx2;
    }
    public String toString(){
        String str = "";
        for(int i =0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                str+=Double.toString(this.matrix[i][j])+" ";
            }
            str+="\n";
        }
        return str;
    }
}
