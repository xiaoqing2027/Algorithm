import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by maggie on 6/26/16.
 */
public class JunitTest_quickSort {
    Sort_quickSort q = new Sort_quickSort();

    @org.junit.Test
    public void partition_normalCase_shouldSuccess(){

        int[] arr1 = new int[]{2,2,3,6,5,4};
        //int[] arr1Expect = new int[]{2,2,3,4,5,6};
        int pivot= q.partition(arr1, 0, arr1.length-1);
        assertEquals(3,pivot);

    }

    @org.junit.Test
    public void swap_normalCase_shouldSuccess(){
        int[] arr2 = new int[]{2,3};
        int[] arr2Expect = new int[]{3,2};
        q.swap(arr2,0,1);
        assertArrayEquals(arr2Expect, arr2);
    }
    @org.junit.Test
    public void quickSort_function_normalCase_shouldSuccess(){
        int[] arr = new int[]{2,2,3,1,6,7,5,6,7,4,8};
        int[] arrExpect = new int[]{1,2,2,3,4,5,6,6,7,7,8};

        assertArrayEquals(arrExpect, q.quickSort(arr));
    }
}
