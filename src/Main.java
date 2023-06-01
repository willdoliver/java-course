import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte PERCENTAGE = 100;
        final byte MONTHS_YEAR = 12;

        Scanner scanner = new Scanner(System.in);
        int principalValue;
        float annualInterestRate;
        byte period;

        while(true) {
            System.out.print("Principal ($1K - $1M): ");
            principalValue = scanner.nextInt();
            if (principalValue >= 1000 && principalValue < 1000000) {
                break;
            } else {
                System.out.println("Enter a number between 1,000 and 1,000,000");
            }
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate > 0 && annualInterestRate <= 30) {
                break;
            } else {
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
            }
        }
        float monthlyInterestRate = annualInterestRate / PERCENTAGE / MONTHS_YEAR;

        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextByte();
            if (period > 0 && period <= 30) {
                break;
            } else {
                System.out.println("Enter a value between 1 and 30.");
            }
        }
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