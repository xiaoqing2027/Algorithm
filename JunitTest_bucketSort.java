import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by maggie on 6/20/16.
 */
public class JunitTest_bucketSort {

    @Test
    public void bucketSort(){
        int[] arr = new int[]{2,3,1,3,8,4,5,6,6,7};
        int[] arrExpected = new int[]{1,2,3,3,4,5,6,6,7,8};
        Sort_BucketSort_ForJunitTest b = new Sort_BucketSort_ForJunitTest();
        assertArrayEquals(arrExpected,b.bucketSort(arr,2));

        int max =0;
        int min = 0;
        b.maxAndMin(arr, max, min);
        assertEquals(8,max);
        assertEquals(1,min);


    }
}
