package de.bht.pr2.lab02.part1;

import de.bht.pr2.lab02.part2.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyTest {

    int[] randomArray;
    int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


    @BeforeEach
    void randomize() {
        randomArray = new int[]{6, 9, 2, 3, 8, 1, 0, 10, 7, 4, 5};
    }

    @Test
    void testBubbleSort() {
        int[] bubbleArray = BubbleSort.sort(randomArray);
        assertArrayEquals(bubbleArray,sortedArray);
    }
    @Test
    void testInsertionSort() {
        int[] insertionArray = InsertionSort.sort(randomArray);
        assertArrayEquals(insertionArray,sortedArray);
    }
    @Test
    void testQuickSort() {
        int[] quickArray = QuickSort.sort(randomArray);
        assertArrayEquals(quickArray,sortedArray);
    }
}
