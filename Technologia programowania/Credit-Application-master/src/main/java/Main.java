import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = scanner.next();

        System.out.println("Enter your last name");
        String lastName = scanner.next();

        System.out.println("Enter your total monthly income in PLN");
        int totalMonthlyIncomeInPLN = scanner.nextInt();

        System.out.println("Enter number of family dependants");
        int numberOfFamilyDependants = scanner.nextInt();

        IncomeCalculator incomeCalculator = new IncomeCalculator(totalMonthlyIncomeInPLN,numberOfFamilyDependants);

        System.out.println(name + lastName + " Decision is " + incomeCalculator.incomePerFamilyMember());

    }
}
