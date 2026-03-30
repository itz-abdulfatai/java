package others;
// public class Tests {

//     public static void main(String[] args) {
//         // Declare a 4x4 two-dimensional array
//         int[][] myArray = new int[4][4];

//         // Initialize the array using nested loops
//         for (int row = 0; row < 4; row++) {
//             for (int col = 0; col < 4; col++) {
//                 // Each cell is the sum of its column index and row index
//                 myArray[row][col] = row + col;
//             }
//         }

//         // Print the array to verify the initialization
//         System.out.println("The initialized array:");
//         for (int row = 0; row < 4; row++) {
//             for (int col = 0; col < 4; col++) {
//                 System.out.print(myArray[row][col] + "\t");
//             }
//             System.out.println();
//         }
//     }
// }

public class Tests {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6 };
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1)
                array[i] = array[i] * 2;
            for (int j = 0; j < array.length; j++)
                System.out.print(array[j]);
        }
    }
}