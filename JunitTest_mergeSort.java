
import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class JunitTest_mergeSort {


    @Test
    public void mergeSortTest(){
        int[] arr = new int[]{3,2,5,3,8,4};
        int[] arrExpected = new int[]{2,3,3,4,5,8};

        Sort_MergeSort t = new Sort_MergeSort();
        t.mergeSortHelper(arr,0,arr.length-1);
        assertArrayEquals(arrExpected,arr);

        int[] arrMerger = new int[]{2,3,1,3,8,4};
        int[] mergeExpected = new int[]{1,2,3,3,8,4};
        t.merge(arrMerger,0,1,3);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        assertArrayEquals(mergeExpected,arrMerger);

        int[] arrCase0 = new int[]{};
        int[] arrCase1 = new int[]{1};
        t.mergeSort(arrCase0);
        t.mergeSort(arrCase1);

        assertArrayEquals(arrCase0,arrCase0);
        assertArrayEquals(arrCase1,arrCase1);


    }

    @Before
    public void setUp() throws Exception {

    }




    @After
    public void tearDown() throws Exception {

    }


}