package com.jk.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class SortApplicationTests {

    @Test
    void contextLoads() {
        int[] array = {4, 67, 10, 5, 8, 3, 7};
        int[] selectSort = selectSort(array);
        int[] insertSort = insertSort(array);
        int[] bubbleSort = bubbleSort(array);
        int[] mergeSort = array.clone();
        mergeSort(mergeSort);

        System.out.println("선택");
        for (int i : selectSort) {
            System.out.println(i);
        }

        System.out.println("삽입");
        for (int i : insertSort) {
            System.out.println(i);
        }

        System.out.println("버블");
        for (int i : bubbleSort) {
            System.out.println(i);
        }

        System.out.println("합병");
        for (int i : mergeSort) {
            System.out.println(i);
        }
    }


    private int[] selectSort(int[] array) {
        int[] result = new int[array.length];
        List<Integer> temp = Arrays.stream(array).boxed().collect(Collectors.toList());

        for (int i = 0; i < array.length; i++) {
            int delemeter = 999;
            int index = 0;

            for (int j = 0; j < temp.size(); j++) {
                int tempInt = temp.get(j);
                if (tempInt < delemeter) {
                    delemeter = tempInt;
                    index = j;
                }
            }

            temp.remove(index);
            result[i] = delemeter;
        }

        return result;
    }

    private int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            while(j >= 0 && temp < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }

        return array;
    }

    private int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-1; j++) {
                if (array[j-1] > array[j]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    private void mergeSort(int[] array) {
        int median = array.length/2;

        if (median != 0) {
            int[] temp1 = new int[median], temp2 = new int[array.length-median];

            System.arraycopy(array, 0, temp1, 0, median);
            System.arraycopy(array, median, temp2, median - median, array.length - median);

            mergeSort(temp1);
            mergeSort(temp2);
            merge(temp1, temp2, array);
        }
    }

    private void merge(int[] a, int[] b, int[] result) {
        int delemeter = 0;

        for (int i : a) {
            for (int j : b) {
                if (i < j) {
                    result[delemeter] = i;
                    delemeter++;
                    break;
                } else {
                    result[delemeter] = j;
                    delemeter++;
                }
            }
        }
    }
}
