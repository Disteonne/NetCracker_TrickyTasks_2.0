package TaskOne;

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
}
