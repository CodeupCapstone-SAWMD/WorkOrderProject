package movies;
import util.Input;

import java.util.Arrays;

public class MoviesApplication {

//    Create a class named MoviesApplication that has a main method.
//    Give the user a list of options for viewing all the movies or viewing movies by category.
//    Use your Input class to get input from the user, and display information based on their choice.
// (Remember to import your Input class)
//    If a category is selected, only movies from that category should be displayed.
//    Your application should continue to run until the user chooses to exit.
//What would you like to do?
//
//            0 - exit
//1 - view all movies
//2 - view movies in the animated category
//3 - view movies in the drama category
//4 - view movies in the horror category
//5 - view movies in the scifi category
//
//    Enter your choice: 1
//
//    Frankenstein -- horror
//    Goodfellas -- drama
//    Pulp Fiction -- drama
//...


    public static Movie[] addMovie(Movie[] movieList, Movie newMovie){
        Movie[] updatedMovie = new Movie[movieList.length +1];
        for(int i = 0; i <updatedMovie.length-1; i++){
            updatedMovie[i] = movieList[i];
        }
        updatedMovie[updatedMovie.length-1] = newMovie;
        return updatedMovie;
    }

    public static void main(String[] args) {
        Boolean run = true;
        while (run = true) {
            System.out.println("What would you like to do?");
            System.out.println("0 - Exit");
            System.out.println("1 - View All Movies");
            System.out.println("2 - View Movies in the Animated Category");
            System.out.println("3 - View Movies in the Drama Category");
            System.out.println("4 - View Movies in the Horror Category");
            System.out.println("5 - View Movies in the SciFi Category");
            System.out.println("6 - Add a Movie to the List:");

//            System.out.println("Enter your choice: ");
            Input input = new Input();
            long selection = input.getInt(0, 6);
            MoviesArray list = new MoviesArray();
//            String[] listArray = list.findAll();
//            System.out.println(list.findAll());
            Movie[] movieList = list.findAll();

            if (selection == 1) {
                for (int i = 0; i <= movieList.length - 1; i++) {
                    System.out.println(movieList[i].getName() + " -- " + movieList[i].getCategory());
                }
            } else if (selection == 2) {
                for (int i = 0; i <= movieList.length - 1; i++) {
                    if (movieList[i].getCategory() == "animated") {
                        System.out.println(movieList[i].getName() + " -- " + movieList[i].getCategory());
                    }
                }
            } else if (selection == 3) {
                for (int i = 0; i <= movieList.length - 1; i++) {
                    if (movieList[i].getCategory() == "drama") {
                        System.out.println(movieList[i].getName() + " -- " + movieList[i].getCategory());
                    }
                }
            } else if (selection == 4) {
                for (int i = 0; i <= movieList.length - 1; i++) {
                    if (movieList[i].getCategory() == "horror") {
                        System.out.println(movieList[i].getName() + " -- " + movieList[i].getCategory());
                    }
                }
            } else if (selection == 5) {
                for (int i = 0; i <= movieList.length - 1; i++) {
                    if (movieList[i].getCategory() == "scifi") {
                        System.out.println(movieList[i].getName() + " -- " + movieList[i].getCategory());
                    }
                }
            } else if (selection == 0) {
                System.out.println("Thank you for using the MovieApplication. Good Bye!");
                break;
            } else if (selection == 6) {
                System.out.println("Enter the movie name:");
                String movieName = input.getString();
                System.out.println("Enter the movie category (i.e. horror, scifi, comedy):");
                String movieCategory = input.getString();
                Movie newMovie = new Movie(movieName, movieCategory);
                addMovie(movieList, newMovie);

            }
        }
    }
}
