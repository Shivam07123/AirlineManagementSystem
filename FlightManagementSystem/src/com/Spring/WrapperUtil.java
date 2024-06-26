package com.Spring;

import java.util.Arrays;

public class WrapperUtil {
    // Finds the maximum value in an array of integers
	public static Integer findMax(Integer[] numbers) {
	    if (numbers == null || numbers.length == 0) {
	        return null;
	    }
	    
	    Integer max = numbers[0];  // Assume the first element is the max initially
	    for (int i = 1; i < numbers.length; i++) {
	        if (numbers[i] > max) {
	            max = numbers[i];  // Update max if the current element is greater
	        }
	    }
	    
	    return max;
	}


    // Calculates the average of an array of doubles
    public static Double calculateAverage(Double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        Double average = 0.0;
       
        for(int i = 0; i < numbers.length; i++) {
        	average += numbers[i];
        }
        average = average/numbers.length;
        return average;
    }

    // Converts a binary string ("1101") to a Boolean array
    public static Boolean[] convertToBooleanArray(String binaryString) {
        Boolean[] booleanArray = new Boolean[binaryString.length()];
        for (int i = 0; i < binaryString.length(); i++) {
            booleanArray[i] = binaryString.charAt(i) == '1';
        }
        return booleanArray;
    }

    // Converts a Boolean array to a binary string
    public static String convertToBinaryString(Boolean[] booleanArray) {
        StringBuilder sb = new StringBuilder();
        for (Boolean bool : booleanArray) {
            sb.append(bool ? '1' : '0');
        }
        return sb.toString();
    }
}
