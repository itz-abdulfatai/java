import java.util.Scanner;

public class WeightConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter unit (kg or lbs): ");
        String unit = scanner.nextLine().trim().toLowerCase();

        if (!unit.equals("kg") && !unit.equals("lbs")) {
            System.out.println("Invalid unit. Please enter 'kg' or 'lbs'.");
            scanner.close();
            return;
        }

        System.out.print("Enter weight: ");
        double weight;

        // Handle invalid numeric input
        if (scanner.hasNextDouble()) {
            weight = scanner.nextDouble();
        } else {
            System.out.println("Invalid weight input.");
            scanner.close();
            return;
        }

        double convertedWeight = convertWeight(weight, unit);
        String convertedUnit = unit.equals("kg") ? "lbs" : "kg";

        System.out.printf("Weight in %s: %.2f%s\n", convertedUnit, convertedWeight, convertedUnit);

        scanner.close();
    }

    private static double convertWeight(double weight, String unit) {
        final double CONVERSION_FACTOR = 0.45359237;

        if (unit.equals("lbs")) {
            return weight * CONVERSION_FACTOR;
        } else {
            return weight / CONVERSION_FACTOR;
        }
    }
}
