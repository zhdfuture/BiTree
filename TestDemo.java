package Heap;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9};
        HeapTest testHeap=new HeapTest();
        testHeap.initHeap(array);
//        testHeap.show();
        testHeap.pushHeap(10);
       testHeap.show();
        System.out.println();
        testHeap.popHeap();
        testHeap.show();
        System.out.println();
        testHeap.HeapSort();
        testHeap.show();

    }
}
