import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by maggie on 6/20/16.
 */
public class JunitTest_heapSort {

    @Test
    public void heapSortTest(){
        int[] arr = new int[]{2,3,1,3,8,4};
        int[] arrExpected = new int[]{8,4,3,3,2,1};
        Sort_HeapSort h = new Sort_HeapSort();

        assertArrayEquals(arrExpected,h.heapSort(arr));

    }

}
