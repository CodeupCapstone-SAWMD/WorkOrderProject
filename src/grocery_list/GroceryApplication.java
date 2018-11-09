package grocery_list;
import util.Input;

public class GroceryApplication {

    public static void main(String[] args) {
        Input input = new Input();

        System.out.println("Would you like to create a grocery list?");
        String confirm = input.getString();
        if (confirm.contains("y")){
            boolean run = true;
            while (run){

                System.out.println("Would you like to enter a new item?");
                String confirmItem = input.getString();
                if (confirmItem.contains("y")){
                    System.out.println("Select a category:");
                }else{
                    System.out.println("Thank you for using the grocery list app! Good Bye!");
                    break;
                }
            }


        }else{
            System.out.println("Thank you for using the grocery list app! Good Bye!");

        }

//        A user should be prompted if they would like to create a grocery list.
//
//        If they pick yes, they will be prompted if they would like to enter a new item.
//
//                If the users picks yes, they should be given the following three prompts:
//
//        Given an ordered list of grocery categories to choose from, select the category
//        Enter name of the item
//        Enter how many
//        The user will then be given the choice to finalize the list or add an additional item.
//
//                Once the user finalizes the list, they will be presented with a
//        complete list organized alphabetically and grouped by category, and including quantity.
    }
}
