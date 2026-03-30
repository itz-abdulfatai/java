package others;

public class Loop {
    public static void main(String[] a) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int sum = 0;
        double average;
        int max = arr[0];
        int min = arr[0];

        System.out.println("Array length: " + arr.length);
        System.out.println("Original array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Process array elements
        for (int i = 0; i < arr.length; i++) {
            // Update min and max
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];

            // Transform odd numbers
            if (arr[i] % 2 == 1) {
                arr[i] = arr[i] * 2;
                System.out.println("Doubled odd number at index " + i + ": " + arr[i]);
            }

            // Calculate running sum
            sum += arr[i];
        }

        // Calculate average
        average = (double) sum / arr.length;

        System.out.println("\nProcessed array:");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

        System.out.println("\nStatistics:");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + String.format("%.2f", average));
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
