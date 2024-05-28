import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String firstInput = scanner.next();
        System.out.print("Enter the second number: ");
        String secondInput = scanner.next();
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);


    }
}
