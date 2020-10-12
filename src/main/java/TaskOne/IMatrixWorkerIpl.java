package TaskOne;

/**
 * @author Disteonne
 * Comment:В случае несоответсвия использования матрицы (пример: умножение матриц разного размера 2х3 и 7х5)
 * создавался IllegalStateException.
 */
public class IMatrixWorkerIpl implements IMatrixWorker {
    public IMatrixWorkerIpl() {
        super();
    }

    public void print(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public boolean haveSameDimension(double[][] m1, double[][] m2) {
        return (m1.length == m2.length && m1[0].length == m2[0].length) ? true : false;
    }

    public double[][] add(double[][] m1, double[][] m2) {
        double[][] tmp_matrix=new double[m1.length][m1[0].length];
        if(haveSameDimension(m1,m2)==true) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                tmp_matrix[i][j]=m1[i][j]+m2[i][j];
                }
            }
            return tmp_matrix;
        }
        else
            throw new IllegalStateException();
    }

    public double[][] subtract(double[][] m1, double[][] m2) {
        double[][] tmp_matrix=new double[m1.length][m1[0].length];
        if(haveSameDimension(m1,m2)==true) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    tmp_matrix[i][j]=m1[i][j]-m2[i][j];
                }
            }
            return tmp_matrix;
        }
        else
            throw new IllegalStateException();
    }

    public double[][] multiply(double[][] m1, double[][] m2) {
        double[][] tmp_matrix=new double[m1.length][m2[0].length];
        if(m1[0].length==m2.length) {

            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    tmp_matrix[i][j]=0;
                    for (int k = 0; k < m1[0].length; k++) {
                        tmp_matrix[i][j]+=m1[i][k]*m2[k][j];
                    }
                }
            }
            return tmp_matrix;
        }
        else
            throw new IllegalStateException();
    }

    public  double determinant(double[][] m){
        if(m.length==m[0].length) {
            double sum = 0;
            if (m.length == 1) {
                return m[0][0];
            }
            for (int i = 0; i < m[0].length; i++) {
                double[][] minor = getMinor(m, i);
                sum += Math.pow(-1, i) * m[0][i] * determinant(minor);
            }
            return sum;
        }
        else
            throw new IllegalStateException();
    }

    private  double[][] getMinor(double[][] m, int n) {
        double[][] res = new double[m.length - 1][m.length - 1];
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < n; j++)
                res[i - 1][j] = m[i][j];
            for (int j = n + 1; j < m.length; j++)
                res[i - 1][j - 1] = m[i][j];
        }
        return res;
    }
}
