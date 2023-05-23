import java.text.NumberFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        final byte PERCENTAGE = 100;
        final byte MONTHS_YEAR = 12;

        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principalValue = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = annualInterestRate / PERCENTAGE / MONTHS_YEAR;

        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();
        int payments = period * MONTHS_YEAR;

        System.out.println("principalValue: " + principalValue);
        System.out.println("annualInterestRate: " + annualInterestRate);
        System.out.println("monthlyInterestRate: " + monthlyInterestRate);
        System.out.println("period: " + period);
        System.out.println("payments: " + payments);

        double mortgage = principalValue
                * ( (monthlyInterestRate * Math.pow(1+monthlyInterestRate,payments))
                / (Math.pow(1+monthlyInterestRate,payments) -1) );

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage*10);

        System.out.println("Mortgage: " + mortgageFormatted);

    }
}