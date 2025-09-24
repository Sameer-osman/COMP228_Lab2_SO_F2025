import java.util.Scanner;
import java.math.BigDecimal;

public class MainDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create 5 objects using user input
        for (int i = 1; i <= 5; i++) {
            System.out.println("=== Object " + i + " ===");

            System.out.print("Enter principal: ");
            double p = sc.nextDouble();

            System.out.print("Enter rate: ");
            double r = sc.nextDouble();

            System.out.print("Enter time: ");
            double t = sc.nextDouble();

            Interest obj = new Interest(p, r, t);

            System.out.println("Simple Interest (double): " + obj.calcSimpleInterest());
            System.out.println("Compound Interest (double): " + obj.calcCompoundInterest());
            System.out.println();
        }

        // One BigDecimal example to show overloading
        BigDecimal p2 = new BigDecimal("1000.75");
        BigDecimal r2 = new BigDecimal("4.9");
        BigDecimal t2 = new BigDecimal("4");

        Interest obj2 = new Interest(1000.75, 4.9, 4);
        System.out.println("=== BigDecimal Example ===");
        System.out.println("Simple Interest (BigDecimal): " + obj2.calcSimpleInterest(p2, r2, t2));
        System.out.println("Compound Interest (BigDecimal): " + obj2.calcCompoundInterest(p2, r2, t2));

        sc.close();
    }
}
