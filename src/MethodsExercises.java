import java.util.Scanner;
import java.lang.Math;
public class MethodsExercises {

    public static double addition(double num1, double num2){
        return num1 + num2;
    }

    public static double subtraction(double num1, double num2){
        return num1 - num2;
    }

    public static double multiplication(double num1, double num2){
        return num1 * num2;
    }

    public static double division(double num1, double num2){
        return num1 / num2;
    }

    public static double modulus(double num1, double num2){
        return num1%num2;
    }

    //        Basic Arithmetic
//        Create four separate methods. Each will perform an
// arithmetic operation:
//
//        Addition
//        Subtraction
//        Multiplication
//        Division
//        Each function needs to take two parameters/arguments
// so that the operation can be performed.
//   Test your functions and verify the output.
//        Add a modulus function that finds the modulus of two numbers.
// Food for thought: What happens if we try to divide by zero?
// What should happen?
//Bonus Create your multiplication method without the * operator (Hdouble: a loop might be helpful).
//        Do the above with recursion.
    //Create a method that validates that user input is in a certain range
//        The method signature should look like this:
          public static int getInteger(int min, int max){
              Scanner scanner = new Scanner(System.in);
              int input = scanner.nextInt();
              if (input > max || input < min){
                  System.out.printf("Invalid number! Enter a number between %s to %s:", min, max);
                  return getInteger(min, max);
              }
              System.out.printf("You entered %s!", input);
              return input;
    }
//        public static int getInteger(int min, int max);
//        and is used like this:
    //        System.out.print("Enter a number between 1 and 10: ");
//        int userInput = getInteger(1, 10);
//        If the input is invalid, prompt the user again. Hint: recursion might be helpful here!

//    Calculate the factorial of a number.
//    Prompt the user to enter an integer from 1 to 10.
//    Display the factorial of the number entered by the user.
//    Ask if the user wants to continue.
//    Use a for loop to calculate the factorial.
//    Assume that the user will enter an integer, but verify it’s between 1 and 10.
//    Use the long type to store the factorial.
//    Continue only if the user agrees to.
//    A factorial is a number multiplied by each of the numbers before it.
//    Factorials are denoted by the exclamation point (n!). Ex:

//    public static long factorial (){
//        int num = getInteger(1,10);
////        boolean run = true;
//        while(true){
//            long total = 1;
//            for (int i = 1; i <= num; i++){
//                total *= i;
//            }
//            return total;
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Would you like to continue? Enter Y or N:");
//            String confirm = scanner.nextLine();
//            if(confirm.equalsIgnoreCase("Y")){
//                continue;
//            }else{
//                break;
//            }
//        }
//
//
////        if (num <1) return 1;
////        return num*factorial(num-1);
//    }

//    Create an application that simulates dice rolling.
//
//    Ask the user to enter the number of sides for a pair of dice.
//    Prompt the user to roll the dice.
//"Roll" two n-sided dice, display the results of each, and then ask the user if
// he/she wants to roll the dice again.
//            Use static methods to implement the method(s) that generate the random numbers.
//    Use the .random method of the java.lang.Math class to generate random numbers.
    public static int rollDice (int sides){
        int die1 = (int)((Math.random() * sides) + 1);
        int die2 = (int)((Math.random() * sides) + 1);
        int total = die1 + die2;
        System.out.printf("First is %s and Second is %s. The total is %s.", die1, die2, total);
//        System.out.println();
        return total;
    }

    public static void main(String[] args) {
//        System.out.println(addition(1,2));
//        System.out.println(subtraction(1,2));
//        System.out.println(multiplication(1,2));
//        System.out.println(division(1,0));
//        System.out.println(modulus(2,1));

//
//        System.out.print("Enter a number between 1 and 10: ");
//        int userInput = getInteger(1, 10);
//
        System.out.println();
//        System.out.println(factorial());

        rollDice(6);


    }
}
