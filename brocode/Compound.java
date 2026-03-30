import java.util.Scanner;
public class Compound {


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double principal;
        double rate;
        int timesCompounded;
        int years;
        double amount;

        System.out.print("Enter the principal amount: ");
        principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in percentage): ");   
        rate = scanner.nextDouble()/ 100; // Convert percentage to decimal

        System.out.print("Enter the number of times interest is compounded per year: ");
        timesCompounded = scanner.nextInt();

        System.out.print("Enter the number of years: ");
        years = scanner.nextInt();

        // Calculate the compound interest
        amount = principal * Math.pow((1 + rate / timesCompounded), timesCompounded * years);

        System.out.printf("The amount after %d years is: %.2f\n", years, amount);
        System.out.printf("The compound interest earned is: %.2f\n", amount - principal);
        
        
        
        
        scanner.close();
    }
        
     
    }
