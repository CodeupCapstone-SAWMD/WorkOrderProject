import java.lang.Math;

public class ServerNameGenerator {

//    Server Name Generator
//
//    We are going to build a server name generator. Create a class inside of
//        src named ServerNameGenerator, and follow the specs below.
//
//    Create two arrays whose elements are strings, one with at least 10 adjectives, another with at least 10 nouns.
//    Create a method that will return a random element from an array of strings.
//    Add a main method, and inside of your main method select and random noun and adjective and hyphenate the combination
// and display the generated name to the user.
//            Example Output
//    Here is your server name:
//    dedicated-photon

    static String getRandom (String[] array){
        int randomNum = (int) (Math.floor(Math.random() * (array.length-1)));
//        System.out.println(randomNum);
       return array[randomNum];
    }

    public static void main(String[] args) {
        String[] adjectives = {"aggressive", "agreeable", "ambitious", "brave", "calm", "delightful", "eager", "faithful", "good", "young"};
        String[] nouns = {"Texas", "dog", "cat", "horse", "car", "bike", "man", "woman", "child", "house"};
        System.out.println("Here is your server name: \n"+ getRandom(adjectives) + "-" + getRandom(nouns));
//        System.out.println(getRandom(nouns));

    }
}
