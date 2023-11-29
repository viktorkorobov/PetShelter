package org.example;
import java.util.Scanner;

public class Calculator {
    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("a: ");
        double a = scanner.nextDouble();
        System.out.println("operations: ");
        String operations = scanner.next();
        System.out.println("b: ");
        double b = scanner.nextDouble();
        double result = performOperation(a, operations, b);
        System.out.println("Result: "+ result);
    }
    private double performOperation( double a, String operations,double b) {
        double result = 0;

        switch (operations) {
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            case "/":
                result = a/b;
                break;
            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }
        return result;
    }
}
