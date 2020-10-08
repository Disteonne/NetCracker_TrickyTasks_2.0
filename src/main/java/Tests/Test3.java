package Tests;

import java.util.ArrayList;

public class Test3 {
    //double sum=0;
    ArrayList<Double> list=new ArrayList<>();

    public  double DetRec(double[][] m){
        double sum=0;
        if(m.length==1){
            return  m[0][0];
        }
        for (int i = 0; i < m[0].length; i++) {
            double[][] minor=getMinor(m,i);
            sum+=Math.pow(-1,i)*m[0][i]*DetRec(minor);
            //list.add(sum);
            //sum
            //sign=-sign;
        }
        return sum;
    }

    public  double[][] getMinor(double[][] m, int n) {
        double[][] res = new double[m.length - 1][m.length - 1];
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < n; j++)
                res[i - 1][j] = m[i][j];
            for (int j = n + 1; j < m.length; j++)
                res[i - 1][j - 1] = m[i][j];
        }
        return res;
    /*
        for (int i = 1; i < m.length; i++)
        {
            for (int j = 0, col = 0; j < m[1].length; j++)
            {
                if (j == n)
                    continue;
                res[i - 1][col] = m[i][j];
                col++;
            }
        }
        return res;
    }

     */
    }
}
