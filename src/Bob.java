import java.util.Scanner;
public class Bob {
    public static void main(String[] args) {
//        Bob is a lackadaisical teenager. In conversation,
// his responses are very limited.
//
//        Bob answers 'Sure.' if you ask him a question.
// (the input ends with a question mark)
//        He answers 'Whoa, chill out!' if you yell at him.
// (the input ends with an exclamation mark)
//        He says 'Fine. Be that way!' if you address him
// without actually saying anything. (empty input)
//        He answers 'Whatever.' to anything else.
//        Write the Java code necessary so that a user of
// your command line application can have a conversation with Bob
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while(run){
            String input = scanner.nextLine();
            if (input.trim().endsWith("!")){
                System.out.println("Whoa, chill out!");
            }else if(input.trim().endsWith("?")){
                System.out.println("Sure.");
            }else if(input.length() == 0){
                System.out.println("Fine. Be that way!");
            }else{
                System.out.println("Whatever.");
            }
//            int lastCharInt = input.length();
//            char lastChar =  input.charAt(lastCharInt);
//            switch (lastChar){
//                case "!":
//                    System.out.println("Whoa, chill out!");
//                    break;
//                case "!":
//                    System.out.println("Whoa, chill out!");
//                    break;
//                case "?":
//                    System.out.println("Whoa, chill out!");
//                    break;
//                case 0:
//                    System.out.println("Whoa, chill out!");
//                    break;
//                 default:
//                     System.out.println("Whatever.");
//                     break;
////
//            }
        }
    }
}
