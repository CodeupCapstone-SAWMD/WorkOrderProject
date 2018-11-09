import java.util.Scanner;
import java.lang.Math;
public class HighLow {

//    Game Development 101
//
//    Welcome to the world of game development!
//
//    You are going to build a high-low guessing game.
// Create a class named HighLow inside of src.
//
//    The specs for the game are:
//
//    Game picks a random number between 1 and 100.
//    Prompts user to guess the number
//    All user inputs are validated
//    If user's guess is less than the number, it outputs "HIGHER"
//    If user's guess is more than the number, it outputs "LOWER"
//    If a user guesses the number, the game should declare "GOOD GUESS!"
    public static int randomNumber (){
        return (int)(Math.random()*100)+1;
    }

    public static int confirmGuess(){
        int min = 1;
        int max = 100;
        System.out.println("Guess a number between 1 to 100:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input > max || input < min){
            System.out.printf("Invalid number! Enter a number between %s to %s:", min, max);
            System.out.println();
            return confirmGuess();
        }
        System.out.printf("You entered %s!", input);
        return input;
    }

    public static int numberGuess (int randomNum){
        System.out.println(randomNum);
        int number = 0;
        System.out.println();
        while(number != randomNum){
                number = confirmGuess();
                System.out.println();
                if(number > randomNum){
                    System.out.println("LOWER");
//                    numberGuess(randomNum);
                }
                else if(number < randomNum){
                    System.out.println("HIGHER");
//                    numberGuess(randomNum);
                }
            }
            if (number == randomNum){
        System.out.println("Good Guess!");
        }
        return number;
    }



    public static void main(String[] args) {
//        System.out.println(randomNumber());
        numberGuess(randomNumber());


    }


}
