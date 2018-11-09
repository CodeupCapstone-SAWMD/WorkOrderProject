import java.util.Scanner;
public class ConsoleExercises {
    public static void main(String[] args) {
        double pi = 3.14159;
//        The value of pi is approximately 3.14.
        System.out.format("The value of pi is approximately %.2f \n", pi);
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter an integer: ");
//        int userInput = scanner.nextInt();
//
//        System.out.println("You entered: --> " + userInput + " <--");
//
//        Scanner words = new Scanner(System.in);
//        System.out.println("Enter 3 words:");
//        String word1 = words.next();
//        String word2 = words.next();
//        String word3 = words.next();
//        System.out.println(word1);
//        System.out.println(word2);
//        System.out.println(word3);

//        Scanner sentence = new Scanner(System.in);
//        System.out.println("Enter a sentence:");
//        String sentence1 = sentence.nextLine();
//        System.out.println(sentence1);

        Scanner lengthInput = new Scanner(System.in);
        System.out.println("Enter the width of the classroom in ft:");
        double length = Double.parseDouble(lengthInput.nextLine());
//        int lengthNum = length;

        Scanner widthInput = new Scanner(System.in);
        System.out.println("Enter the length of the classroom in ft:");
        double width = Double.parseDouble(widthInput.nextLine());

        Scanner heightInput = new Scanner(System.in);
        System.out.println("Enter the length of the classroom in ft:");
        double height = Double.parseDouble(heightInput.nextLine());

        System.out.println("The perimeter is: " + (width * 2 + length*2) + " ft");
        System.out.println("The area is: " + (length * width) + " sq ft");
        System.out.println("The volume is: " + (width * length * height) + " cubic ft");
    }
}
