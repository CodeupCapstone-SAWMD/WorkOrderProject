package Contacts;

import util.Input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactManagerApplication {

    public static void main(String[] args) throws IOException {
        Input input = new Input();
        List<Contact> contacts = new ArrayList<>();
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        System.out.println("------------------------------------");
        System.out.println("| WELCOME TO THE CONTACTS MANAGER! |");
        System.out.println("------------------------------------");

        while(true){


            try{

                if (Files.notExists(dataDirectory)) {
                    Files.createDirectories(dataDirectory);
                }

                if (! Files.exists(dataFile)) {
                    Files.createFile(dataFile);
                }
                Path contactsPath = Paths.get("./data/", "contacts.txt");
                List<String> contactList = Files.readAllLines(contactsPath);
                for (int i = 0; i < contactList.size(); i += 1) {
                    System.out.println((i + 1) + ": " + contactList.get(i));
                }

            }
            catch (Exception e){
                System.out.println(e);
//                Path file = Files.createFile(contactRoster);

            }

            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4 or 5):\n");
            int option = input.getInt();
            if(option == 1){
                System.out.println("View contacts.\n");
                System.out.println("Name       | Phone number |\n"+"---------------------------\n");
                Path contactsList = Paths.get("./data/", "contacts.txt");

                System.out.println(Files.readAllLines(contactsList));
//                System.out.println(contactRoster);
//
//                for (int i = 0; i < contactsList.size(); i += 1) {
//                    System.out.println((i + 1) + ": " + contactsList.get(i));
//                }
//                Files.write(contactRoster, contacts);
            }
            else if(option == 2){

                System.out.println("\nYou have chosen to enter a new contact to your roster!\n");
                System.out.println("Enter the name of your contact:\n");
                String newName = input.getString();
                System.out.println("\nEnter the phone number of your contact\n");
                long newphoneNum = input.getInt();
                Contact newContact = new Contact(newName, newphoneNum);
                System.out.printf("\nYour new contact name is %s with a phone number of %s\n\n", newName, newphoneNum);
                contacts.add(newContact);
                for(Contact contact :contacts){
                    System.out.println("Name: " + contact.getName() + " Phone Number: " + contact.getPhoneNum());
                }
//                System.out.println();
//                Path contactRoster = Paths.get("./data/", "contacts.txt");
//                Path file = Files.createFile(contactRoster);
//                Path contactRoster = Paths.get("./data/", "contacts.txt");

//                System.out.println(Files.readAllLines(contactRoster));
//                Files.write(Paths.get("./data/", "contacts.txt"), Arrays.listOf(newContact), StandardOpenOption.APPEND);


            }
            else if(option == 3){
                System.out.println("Search a contact by name.\n");

            }
            else if(option == 4){
                System.out.println("Delete an existing contact.\n");

            }
            else if(option == 5){
//                Path contactRoster = Paths.get(".", "contacts.txt");
//                Path file = Files.createFile(contactRoster);
//                Files.write(file, contacts);

                System.out.println("Thank you for using the Contacts Manager App! Good Bye!");
                break;
            }else{
                System.out.println("Invalid Input!\n");
            }

        }

    }
}
