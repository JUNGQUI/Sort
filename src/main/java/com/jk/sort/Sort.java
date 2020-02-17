package com.jk.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {
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
}
