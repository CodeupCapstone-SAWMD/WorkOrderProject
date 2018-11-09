import java.util.Scanner;
public class ControlFlowExercises {
    public static void main(String[] args) {


//        /////Loop Basics/////
//
//        While
//
//        Create an integer variable i with a value of 5.
//        Create a while loop that runs so long as i is less than or equal to 15
//        Each loop iteration, output the current value of i, then increment i by one.
//        Your output should look like this:
//
//        5 6 7 8 9 10 11 12 13 14 15
//        int i = 5;
//        while (i <= 15){
//            System.out.print(i + " ");
//            i++;
//        }
//
//    }
//        //////Do While/////
//
//        Create a do-while loop that will count by 2's starting with 0 and ending at 100.
//        Follow each number with a new line.
//        Alter your loop to count backwards by 5's from 100 to -10.
//        Create a do-while loop that starts at 2, and displays the number squared on each
//        line while the number is less than 1,000,000. Output should equal:
//        2
//        4
//        16
//        256
//        65536
//        long num = 2L;
//        do {
//            System.out.println(num);
//            num *= num;
//        }while (num < 1000000);
//    }

//        /////For/////
//
//        refactor the previous two exercises to use a for loop instead

//        for(int i = 5;i <= 15;i++){
//            System.out.print(i + " ");
//        }
//
//        for(long num = 2; num < 1000000000; num*=num){
//            System.out.println(num);
//    }

//        /////Fizzbuzz/////
//
//        One of the most common interview questions for entry-level programmers is
// the FizzBuzz test. Developed by Imran Ghory,
// the test is designed to test basic looping and conditional logic skills.
//
//                Write a program that prints the numbers from 1 to 100.
//        For multiples of three print “Fizz” instead of the number
//        For the multiples of five print “Buzz”.
//        For numbers which are multiples of both three and five print “FizzBuzz”.


//        for(int i = 1; i <=100; i++){
//            if(i%3 == 0 & i%5 == 0){
//                System.out.println("FizzBuzz");
//            }else if(i%3 == 0){
//                System.out.println("Fizz");
//            }else if(i%5 == 0){
//                System.out.println("Buzz");
//            }else{
//                System.out.println(i);
//            }
//        }

//        /////Display a table of powers./////
//
//                Prompt the user to enter an integer.
//        Display a table of squares and cubes from 1 to the value entered.
//        Ask if the user wants to continue.
//        Assume that the user will enter valid data.
//        Only continue if the user agrees to.
//        Example Output
//
//        What number would you like to go up to? 5
//
//        Here is your table!
//
//                number | squared | cubed
//                ------ | ------- | -----
//                1      | 1       | 1
//        2      | 4       | 8
//        3      | 9       | 27
//        4      | 16      | 64
//        5      | 25      | 125
//
        Scanner scanner = new Scanner(System.in);
        int test = 0;
        while (test < 1){

            System.out.println("Enter an integer: ");
            int input = scanner.nextInt();
            System.out.println("number | squared | cubed");
            System.out.println("------ | ------- | -----");

            for(long i = 1; i <= input; i++){
                double squared = i * i;
                double cubed = i * i * i;
                System.out.printf( "%-6d |%-9.2f|1000%-7.2f%n", i, squared, cubed);
            }

            scanner.nextLine();

            System.out.println("Would you like to continue? Enter Y or N:");
            String confirm = scanner.nextLine();
            if(confirm.equalsIgnoreCase("Y")){
                continue;
            }else{
                break;
            }
        }


//        //////Convert given number grades into letter grades.///////
//
//                Prompt the user for a numerical grade from 0 to 100.
//        Display the corresponding letter grade.
//                Prompt the user to continue.
//        Assume that the user will enter valid integers for the grades.
//        The application should only continue if the user agrees to.
//        Grade Ranges:
//
//        A : 100 - 88
//        B : 87 - 80
//        C : 79 - 67
//        D : 66 - 60
//        F : 59 - 0
//        Scanner scanner = new Scanner(System.in);
//        int test = 0;
//        while (test < 1){
//
//                System.out.println("Enter a numerical grade: ");
//                int grade = scanner.nextInt();
//                String letterGrade = "";
//                if (grade >= 0 && grade <= 59){
//                    letterGrade = "F";
//                }else if(grade >=60 && grade <=66){
//                    letterGrade = "D";
//                }else if(grade >= 67 && grade <= 79){
//                    letterGrade = "C";
//                }else if(grade >= 80 && grade <= 87){
//                    letterGrade = "B";
//                }else if(grade >=88){
//                    letterGrade = "A";
//                }
//                System.out.format("You entered a numerical grade of %d. The letter grade is %s. ", grade, letterGrade);
//                scanner.nextLine();
//                System.out.println("Would you like to continue? Enter Y or N:");
//                String confirm = scanner.nextLine();
//            if(confirm.equalsIgnoreCase("Y")){
//                continue;
//            }else{
//                break;
//            }
//        }
    }
}
