package grades;
import java.util.ArrayList;
import java.util.HashMap;
import util.Input;


public class GradesApplication {

//    Create a map for students and Github usernames
//
//    Create a class named GradesApplication with a main method. Inside the main
//    method, create a HashMap named students. It should have keys that are strings
//    that represent github usernames, and values that are Student objects.
//    Create at least 4 student objects with at least 3 grades each, and add them to the map.
//
//    Be creative! Make up github usernames and grades for your student objects.
        public static void main(String[] args) {

            HashMap<String, Student> students = new HashMap<>();
            Input input = new Input();

            Student louie = new Student("louie");
            louie.addGrade(90);
            louie.addGrade(90);
            louie.addGrade(90);
            louie.recordAttendance("2018-07-23", "P");
            louie.recordAttendance("2018-07-24", "A");
            louie.recordAttendance("2018-07-25", "P");
            louie.recordAttendance("2018-07-26", "P");
            louie.recordAttendance("2018-07-27", "P");

            Student isa = new Student("isa");
            isa.addGrade(95);
            isa.addGrade(90);
            isa.addGrade(100);
            isa.recordAttendance("2018-07-23", "P");
            isa.recordAttendance("2018-07-24", "P");
            isa.recordAttendance("2018-07-25", "P");
            isa.recordAttendance("2018-07-26", "P");
            isa.recordAttendance("2018-07-27", "P");

            Student isiah = new Student("isiah");
            isiah.addGrade(65);
            isiah.addGrade(75);
            isiah.addGrade(70);
            isiah.recordAttendance("2018-07-23", "A");
            isiah.recordAttendance("2018-07-24", "A");
            isiah.recordAttendance("2018-07-25", "A");
            isiah.recordAttendance("2018-07-26", "P");
            isiah.recordAttendance("2018-07-27", "A");


            Student alois = new Student ("alois");
            alois.addGrade(80);
            alois.addGrade(70);
            alois.addGrade(60);
            alois.recordAttendance("2018-07-23", "A");
            alois.recordAttendance("2018-07-24", "A");
            alois.recordAttendance("2018-07-25", "A");
            alois.recordAttendance("2018-07-26", "A");
            alois.recordAttendance("2018-07-27", "A");

//            System.out.println(isiah.getGradeAverage());

            students.put("alois@github.com", alois);
            students.put("louie@github.com", louie);
            students.put("isa@github.com", isa);
            students.put("isiah@github.com", isiah);
//            System.out.println(students);

            System.out.println("Welcome!\n" +
                    "\n" +
                    "Here are the github usernames of our students:\n");
//            ArrayList<String> usernames = new ArrayList<>();
//            usernames = students.keySet();
            for (String username: students.keySet()){
                System.out.print("|" + username + "| ");
            }
            System.out.println();

                System.out.println("\nWhat student would you like to see more information on?\n");
            boolean run = true;
            while(run) {
                String username = input.getString();
                if (students.containsKey(username)) {
//                    System.out.println("Name: " + students.get(username));

                    students.forEach((k,v) -> {
//                        System.out.println(k);
                        if(k.contains(username)) {
                            System.out.println(
                            "\nName: " + v.getName()
                            + "\nGitHub Username " + k
                            + "\nGrade Average: " + v.getGradeAverage()
                                    + "\nAttendance Average: " +v.getAttendanceAverage()
                            + "\nAbsent Days: "
                            );
                            v.absentDays();
                        }

                    });

                    System.out.println("\nWould you like to see another student?\n");

                }
                else if(username.equalsIgnoreCase("no")){
                    System.out.println("Thank you and GoodBye!");
                    break;
                }
                else{
                    System.out.printf("\nSorry, no student found with the gihub username of %s.\n" +
                            "\n" +
                            "Would you like to see another student?\n", username);
                }
//            System.out.println(students.keySet());



            }

        }

}
