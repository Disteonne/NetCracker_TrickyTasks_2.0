package TaskOne;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IMatrixWorkerIplTest {
    private double[][] matrix_one={{1,2,3},{4,5,6},{7,8,9}};
    private double[][] matrix_two={{2,7,7},{4,5,1},{9,6,2}};

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
        double[][] res={{37,35,15},{82,89,45},{127,143,75}};
        assertArrayEquals(res,iMatrixWorker.multiply(matrix_one,matrix_two));
    }
}