package com.lab.sorting;

/**
 * Linear Search — scans every element sequentially.
 *
 * Branches:
 *  1. null / empty array  → throw IllegalArgumentException
 *  2. Element matches     → return index immediately (early return)
 *  3. Loop exhausted      → return -1 (not found)
 */
public class LinearSearch {

    /**
     * Searches for {@code target} in {@code arr} from left to right.
     *
     * @param arr    the integer array to search (need not be sorted)
     * @param target the value to search for
     * @return the first index where {@code target} is found, or -1
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {   // Branch A: 
                return i;
            }
        }

        return -1;                    // Branch B: 
    }
}
