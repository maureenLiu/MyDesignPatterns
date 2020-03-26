package com.maureen.dp.strategy;

import org.springframework.core.io.AbstractFileResolvingResource;

public class Sorter<T> {
    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                //minPos = arr[j].compareTo(arr[minPos]) == -1? j : minPos;
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //选择排序
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = -1;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
