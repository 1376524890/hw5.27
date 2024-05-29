import java.util.InputMismatchException;
import java.util.Scanner;

class ExceptionHandler {
    void handler(double number1, double  number2, char operator){
            double result = 0;
            switch (operator) {
                case '+':
                    result = number1 + number2;
                    System.out.println("The result is: " + result);
                    break;
                case '-':
                    result = number1 - number2;
                    System.out.println("The result is: " + result);
                    break;
                case '*':
                    result = number1 * number2;
                    System.out.println("The result is: " + result);
                    break;
                case '/':
                    try {
                        if (number2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = number1 / number2;
                        System.out.println("The result is: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                default:
                    System.out.println("Error: Invalid operator");
            }


    }

    void withoutHandler(String number1, String number2, char operator){

    }
}


public class Calculator {
    static double firstInput;
    static double secondInput;
    static char operator;

    public static void input(){
        Scanner scanner = new Scanner(System.in);
        try{
            firstInput = scanner.nextDouble();
            operator = scanner.next().charAt(0);
            secondInput = scanner.nextDouble();
        }catch (InputMismatchException mm){
            System.out.println("Error: One or both of the inputs are not valid numbers");
        }

    }
    public static void main(String[] args) {
        input();
        ExceptionHandler eh = new ExceptionHandler();
        System.out.println("-----Use exception handler-----");
        eh.handler(firstInput,secondInput,operator);
    }
}
