import java.math.BigDecimal;
import java.math.RoundingMode;

public class Interest {
    private double principal;
    private double rate;
    private double time;

    // Constructor with simple validation
    public Interest(double principal, double rate, double time) {
        if (principal <= 0 || rate <= 0 || time <= 0) {
            System.out.println("Values must be greater than 0.");
        } else if (principal % 1 == 0) {
            System.out.println("Principal should be decimal, not integer.");
        } else if (rate % 1 == 0) {
            System.out.println("Rate should be decimal, not integer.");
        } else {
            this.principal = principal;
            this.rate = rate;
            this.time = time;
        }
    }

    // Simple Interest (double)
    public double calcSimpleInterest() {
        return (principal * rate * time) / 100;
    }

    // Compound Interest (double)
    public double calcCompoundInterest() {
        return principal * Math.pow(1 + rate / 100, time) - principal;
    }

    // Simple Interest (BigDecimal overload)
    public BigDecimal calcSimpleInterest(BigDecimal p, BigDecimal r, BigDecimal t) {
        return p.multiply(r).multiply(t).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
    }

    // Compound Interest (BigDecimal overload)
    public BigDecimal calcCompoundInterest(BigDecimal p, BigDecimal r, BigDecimal t) {
        BigDecimal rateFraction = r.divide(new BigDecimal(100), 10, RoundingMode.HALF_UP);
        BigDecimal base = BigDecimal.ONE.add(rateFraction);
        BigDecimal power = base.pow(t.intValue());
        return p.multiply(power).subtract(p).setScale(2, RoundingMode.HALF_UP);
    }
}
