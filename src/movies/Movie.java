package movies;

public class Movie {

//    Movie List
//
//    We are going to build an application that keeps track of Movie.Movie and displays them by category.
//
//Inside of src, create a directory named movies. Create all of the classes described below in this directory.
//    Create a class named Movie. It should have private fields for name and category,
// and a constructor that sets both of these.
//
// Create methods to access these properties and change them (getters and setters).

//    Download the MoviesArray file and save it as MoviesArray.java inside of movies.
// This class has a static method named findAll that will return an array of Movie objects.
//    Create a class named MoviesApplication that has a main method.
//    Give the user a list of options for viewing all the movies or viewing movies by category.
//    Use your Input class to get input from the user, and display information based on their choice.
// (Remember to import your Input class)
//    If a category is selected, only movies from that category should be displayed.
//    Your application should continue to run until the user chooses to exit.
//    Sample Output
//What would you like to do?
//
//            0 - exit
//1 - view all Movie.Movie
//2 - view Movie.Movie in the animated category
//3 - view Movie.Movie in the drama category
//4 - view Movie.Movie in the horror category
//5 - view Movie.Movie in the scifi category
//
//    Enter your choice: 1
//
//    Frankenstein -- horror
//    Goodfellas -- drama
//    Pulp Fiction -- drama
//...
    private String name;
    private String category;

    public void setName(String name){
        this.name = name;
    };

    public void setCategory(String category){
        this.category = category;
    }

    public String getName(){
        return this.name;
    };

    public String getCategory(){
         return this.category;
    }

    public Movie (String name, String category){
        setName(name);
        setCategory(category);
    }



}
