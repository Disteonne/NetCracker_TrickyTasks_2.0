package Tests;

public class Test1 {
    public static void main(String[] args) {
        double [][] m = {{2,3},{3,1,2}};
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
