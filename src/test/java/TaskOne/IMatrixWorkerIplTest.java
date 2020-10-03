package TaskOne;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IMatrixWorkerIplTest {
    private double[][] matrix_one={{1,2,3},{4,5,6},{7,8,9}};
    private double[][] matrix_two={{2,7,1},{4,5,1},{9,6,1}};
    private double[][] matrix_three={{1,2},{3,4}}; // 2 2
    private double[][] matrix_four={{1,2,3,4,5},{6,7,8,9,10}};// 2 5

    @Test
    public void haveSameDimension() {
        IMatrixWorker iMatrixWorker=new IMatrixWorkerIpl();
        boolean b=iMatrixWorker.haveSameDimension(matrix_one,matrix_two);
        assertEquals(true,iMatrixWorker.haveSameDimension(matrix_one,matrix_two));
    }
    @Test
    public void testAddMatrix(){
        IMatrixWorker iMatrixWorker=new IMatrixWorkerIpl();
        double[][] res={{3,9,10},{8,10,7},{16,14,11}};
        assertArrayEquals(res,iMatrixWorker.add(matrix_one,matrix_two));
    }
    @Test
    public void testSubtract(){
        IMatrixWorker iMatrixWorker=new IMatrixWorkerIpl();
        double[][] res={{-1,-5,-4},{0,0,5},{-2,2,7}};
        assertArrayEquals(res,iMatrixWorker.subtract(matrix_one,matrix_two));
    }
    @Test
    public void testMulti(){
        IMatrixWorker iMatrixWorker=new IMatrixWorkerIpl();
        //double[][] res={{37,35},{82,89},{127,143}};
        //double[][] res1=iMatrixWorker.multiply(matrix_one,matrix_two);
        //double[][] res={{37,35,6},{82,89,15},{127,143,24}};
        double[][] res={{13,16,19,22,25},{27,34,41,48,55}};
        assertArrayEquals(res,iMatrixWorker.multiply(matrix_three,matrix_four));
    }
    @Test(expected = IllegalStateException.class)
    public void testMulti1(){
        IMatrixWorker iMatrixWorker=new IMatrixWorkerIpl();
        double[][] m_1={{1,2,3},{4,5,6}};
        double[][] m_2={{1,2},{3,4,5}};
        double[][] res=iMatrixWorker.multiply(m_1,m_2);
    }
}