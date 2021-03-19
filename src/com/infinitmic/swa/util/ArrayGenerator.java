package com.infinitmic.swa.util;

import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;

public class ArrayGenerator {

    public static Map<Integer, Comparable[]> generateAllArrays(int numberOfExperiments, int initialArraySize, int multiplier) {
        Map<Integer, Comparable[]> allArrays = new HashMap<>();
        int arraySize = initialArraySize;

        for(int i = 0; i < numberOfExperiments; i++) {
            Comparable[] array = generateRandomArray(arraySize);
            allArrays.put(i, array);
            arraySize *= multiplier;
        }
        return allArrays;
    }

    public static Comparable[] generateRandomArray(int length) {
        Comparable[] array = new Comparable[length];

        for(int i = 0; i < length; i++) {
            array[i] = StdRandom.uniform();
        }
        return array;
    }
}
