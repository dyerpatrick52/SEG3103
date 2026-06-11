package com.lab.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for BubbleSort, BinarySearch, and LinearSearch.
 *
 * Test case design follows branch/condition coverage:
 *   - Every conditional branch (true + false) is exercised at least once.
 *   - Edge cases (null, empty, single element, duplicates) are included.
 */
class SortingSearchingTest {

    // =========================================================
    //  BubbleSort Tests
    // =========================================================

    @Test
    @DisplayName("TC1 - BubbleSort: sorts a typical unsorted array")
    void bubbleSort_typicalUnsortedArray() {
       
        int[] input    = {5, 3, 8, 1, 9, 2};
        int[] expected = {1, 2, 3, 5, 8, 9};
        BubbleSort.sort(input);
        assertArrayEquals(expected, input,
            "BubbleSort should correctly sort an unsorted array in ascending order");
    }

    @Test
    @DisplayName("TC2 - BubbleSort: already-sorted array triggers early exit")
    void bubbleSort_alreadySortedArray() {
        
        int[] input    = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.sort(input);
        assertArrayEquals(expected, input,
            "BubbleSort should leave an already-sorted array unchanged and exit early");
    }

    @Test
    @DisplayName("TC3 - BubbleSort: single-element array is trivially sorted")
    void bubbleSort_singleElement() {
       
        int[] input = {42};
        BubbleSort.sort(input);
        assertArrayEquals(new int[]{42}, input,
            "A single-element array should remain unchanged");
    }

    @Test
    @DisplayName("TC4 - BubbleSort: array with duplicate values")
    void bubbleSort_duplicateValues() {
        
        int[] input    = {4, 2, 4, 1, 2};
        int[] expected = {1, 2, 2, 4, 4};
        BubbleSort.sort(input);
        assertArrayEquals(expected, input,
            "BubbleSort should handle duplicates correctly");
    }

    @Test
    @DisplayName("TC5 - BubbleSort: null array throws IllegalArgumentException")
    void bubbleSort_nullArray_throwsException() {
        
        assertThrows(IllegalArgumentException.class,
            () -> BubbleSort.sort(null),
            "Passing null should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("TC6 - BubbleSort: empty array throws IllegalArgumentException")
    void bubbleSort_emptyArray_throwsException() {
        
        assertThrows(IllegalArgumentException.class,
            () -> BubbleSort.sort(new int[]{}),
            "Passing an empty array should throw IllegalArgumentException");
    }

    // =========================================================
    //  BinarySearch Tests
    // =========================================================

    @Test
    @DisplayName("TC7 - BinarySearch: finds target in the middle of the array")
    void binarySearch_targetInMiddle() {
       
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.search(arr, 5),
            "BinarySearch should return index 2 for target 5");
    }

    @Test
    @DisplayName("TC8 - BinarySearch: target in right half ")
    void binarySearch_targetInRightHalf() {
       
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(4, BinarySearch.search(arr, 9),
            "BinarySearch should find 9 at index 4 via right-half navigation");
    }

    @Test
    @DisplayName("TC9 - BinarySearch: target in left half ")
    void binarySearch_targetInLeftHalf() {
       
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(0, BinarySearch.search(arr, 1),
            "BinarySearch should find 1 at index 0 ");
    }

    @Test
    @DisplayName("TC10 - BinarySearch: target not present returns -1")
    void binarySearch_targetNotFound() {
        
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.search(arr, 4),
            "BinarySearch should return -1 when target is not in the array");
    }

    @Test
    @DisplayName("TC11 - BinarySearch: null array throws IllegalArgumentException")
    void binarySearch_nullArray_throwsException() {
        assertThrows(IllegalArgumentException.class,
            () -> BinarySearch.search(null, 1),
            "Passing null should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("TC12 - BinarySearch: empty array throws IllegalArgumentException")
    void binarySearch_emptyArray_throwsException() {
        assertThrows(IllegalArgumentException.class,
            () -> BinarySearch.search(new int[]{}, 1),
            "Passing an empty array should throw IllegalArgumentException");
    }

    // =========================================================
    //  LinearSearch Tests
    // =========================================================

    @Test
    @DisplayName("TC13 - LinearSearch: finds target at the first position")
    void linearSearch_targetAtFirstIndex() {
        
        int[] arr = {7, 2, 9, 4};
        assertEquals(0, LinearSearch.search(arr, 7),
            "LinearSearch should return 0 when target is the first element");
    }

    @Test
    @DisplayName("TC14 - LinearSearch: finds target at the last position")
    void linearSearch_targetAtLastIndex() {
       
        int[] arr = {7, 2, 9, 4};
        assertEquals(3, LinearSearch.search(arr, 4),
            "LinearSearch should return 3 when target is the last element");
    }

    @Test
    @DisplayName("TC15 - LinearSearch: target not present returns -1")
    void linearSearch_targetNotFound() {
        
        int[] arr = {7, 2, 9, 4};
        assertEquals(-1, LinearSearch.search(arr, 99),
            "LinearSearch should return -1 when target is not in the array");
    }

    @Test
    @DisplayName("TC16 - LinearSearch: null array throws IllegalArgumentException")
    void linearSearch_nullArray_throwsException() {
        assertThrows(IllegalArgumentException.class,
            () -> LinearSearch.search(null, 1),
            "Passing null should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("TC17 - LinearSearch: empty array throws IllegalArgumentException")
    void linearSearch_emptyArray_throwsException() {
        assertThrows(IllegalArgumentException.class,
            () -> LinearSearch.search(new int[]{}, 1),
            "Passing an empty array should throw IllegalArgumentException");
    }
}
