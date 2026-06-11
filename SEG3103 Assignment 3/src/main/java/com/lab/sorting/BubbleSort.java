package com.lab.sorting;

/**
 * BubbleSort with an early-exit optimisation.
 *
 * Branches:
 *  1. null / empty array  → throw IllegalArgumentException
 *  2. Inner swap condition (arr[j] > arr[j+1])
 *  3. Early-exit when no swaps occurred in a pass (already sorted)
 */
public class BubbleSort {

    /**
     * Sorts {@code arr} in ascending order in-place.
     *
     * @param arr the integer array to sort
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {          // Branch A
                    int temp  = arr[j];
                    arr[j]    = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped   = true;
                }
            }

            if (!swapped) {                          // Branch B
                break;
            }
        }
    }
}
