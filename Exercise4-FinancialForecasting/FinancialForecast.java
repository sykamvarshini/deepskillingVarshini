import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValue(double presentValue, double growthRate, int years) {

        if (years == 0) {
            return presentValue;
        }

        return futureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Present Value: ");
            double presentValue = sc.nextDouble();
            
            System.out.print("Enter Annual Growth Rate (in %): ");
            double growth = sc.nextDouble();
            
            System.out.print("Enter Number of Years: ");
            int years = sc.nextInt();
            
            double result = futureValue(presentValue, growth / 100, years);
            
            System.out.printf("Future Value after %d years = %.2f", years, result);
        }
    }
}