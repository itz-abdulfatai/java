package exams;

import java.util.Comparator;

public class Compare {

    public static void main(String[] args) {
        double[] array = { -0.51, 0.80, 6.11, 7.01, 11.67, 14.11, 23.02, 23.29, 26.65, 31.91 };
        // use Integer instead of int because we need Objects

        // int index = linearSearch(array, 10);
        // System.out.println("Found at index: " + index);
    }

    // linearSearch method should be OUTSIDE main
    public static int linearSearch(Object[] array, Object key) {
        for (int k = 0; k < array.length; k++) {
            if (array[k].equals(key)) {
                return k;
            }
        }
        return -1; // move return -1 outside loop
    }

}
