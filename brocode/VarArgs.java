public class VarArgs {
    public static void main(String[] args) {

        double average = getAverage( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 200, 300, 400, 500, 600, 700, 800, 900, 1000);
        System.out.println("The average is: " + average);
    }

    static double getAverage(double... numbers) {
        double sum = 0;

        if (numbers.length == 0) {
            return 0; // Avoid division by zero
        }

        for(double num:numbers) {
            sum+=num;
        }

        return sum / numbers.length;

    }
}
