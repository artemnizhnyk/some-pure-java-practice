package com.artemnizhnyk.somepurejavapractice.two;

public class Sorting {
    private static int[] getInitialArray() {
        return new int[]{64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};
    }

    public static void main(String[] args) {
        int[] array = getInitialArray();
        printArray(array);
        bubbleSort(array);
        printArray(array);
        System.out.println("-----------------");

        array = getInitialArray();
        printArray(array);
        quickSort(array, 0, array.length - 1);
        printArray(array);

    }

    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (arr.length == 0 || leftIndex >= rightIndex) return;

        int pivot = arr[(leftIndex + rightIndex) / 2];
        int leftMarker = leftIndex;
        int rightMarker = rightIndex;

        while (leftMarker <= rightMarker) {
            while (arr[leftMarker] < pivot) leftMarker++;
            while (arr[rightMarker] > pivot) rightMarker--;
            if (leftMarker <= rightMarker) {
                int swap = arr[leftMarker];
                arr[leftMarker] = arr[rightMarker];
                arr[rightMarker] = swap;
                leftMarker++;
                rightMarker--;
            }
        }
        if (leftIndex < rightMarker) quickSort(arr, leftIndex, rightMarker);
        if (rightIndex > leftMarker) quickSort(arr, leftMarker, rightIndex);
    }

    private static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }
}