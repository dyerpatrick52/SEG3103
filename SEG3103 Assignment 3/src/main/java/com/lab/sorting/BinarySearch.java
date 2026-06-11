package com.lab.sorting;

/**
 * Iterative Binary Search on a sorted integer array.
 *
 * Branches:
 *  1. null / empty array  → throw IllegalArgumentException
 *  2. target == mid value → return index (found)
 *  3. target > mid value  → search right half
 *  4. target < mid value  → search left half
 *  5. Loop exhausted      → return -1 (not found)
 */
public class BinarySearch {

    /**
     * Searches for {@code target} in the sorted array {@code arr}.
     *
     * @param arr    a sorted integer array
     * @param target the value to search for
     * @return the index of {@code target}, or -1 if not found
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int low  = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {        // Branch A:
                return mid;
            } else if (arr[mid] < target) {  // Branch B:
                low = mid + 1;
            } else {                         // Branch C:
                high = mid - 1;
            }
        }

        return -1;                           // Branch D:
    }
}
