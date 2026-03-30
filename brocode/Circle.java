import java.util.Scanner;
public class Circle {
    public static void main(String[] args) {
        int radius;
        double area;
        double circumference;
        double volume;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        radius = scanner.nextInt();

        area = Math.PI * Math.pow(radius, 2); // Area of the circle
        circumference = 2 * Math.PI * radius; // Circumference of the circle
        volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3); // Volume of the sphere

        System.out.printf("Area of the circle: %.2fcm\n", area);
        System.out.printf("Circumference of the circle: %.2fcm\n", circumference);
        System.out.printf("Volume of the sphere: %.2fcm\n", volume);
        scanner.close();
    }
}
