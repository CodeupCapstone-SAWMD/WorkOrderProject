package grades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Student {
    private String name;
    private ArrayList<Integer> grades;
    private HashMap<String, String> attendance;

//    Create a Student class
//
//    Create a class named Student. It should have private properties for the
//    student's name, and grades. The grades property should be an list of integers.
//    The student class should have a constructor that sets name property, and initializes
//        the grades property as an empty list. The Student class should have the following
//        methods:
//
//    Copied to clipboard
//    // returns the student's name
//    public String getName();
//    // adds the given grade to the grades property
//    public void addGrade(int grade);
//    // returns the average of the students grades
//    public double getGradeAverage();


//    Test your Student class by adding a main method and creating Student objects.
//    Verify that you can add grades to each object, and that your getGradeAverage method
//    correctly returns the average of the student's grades.


    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
        this.attendance = new HashMap<>();
    }

    // returns the student's name
    public String getName(){
        return this.name;
    };

    // adds the given grade to the grades property
    public void addGrade(int grade){
        grades.add(grade);
    };
    // returns the average of the students grades
    public double getGradeAverage(){
        double total = 0;
        for(double grade: grades){
            total += grade;
        }
        return total / grades.size();
    };

    public String recordAttendance(String date, String value){
//        this.attendance.keySet(date);
        if(value.equals("A") || value.equals("P")){
            return this.attendance.put(date, value);
        }else {
            System.out.println("Invalid Entry. Check your attendance input...");
            return "Invalid";
        }
    };

    public HashMap<String, String> getAttendance() {
        return attendance;
    };

    public String absentDays(){
        attendance.forEach((k,v) -> {
            if( v.equals("A")){
                System.out.println("Date: " + k);
        };
    });
        return "Absent";
    };

//    public double getAttendanceAverage(){
//        AtomicReference<Double> num = new AtomicReference<>((double) 0);
//        attendance.entrySet().forEach(entry -> {
//            if( entry.equals("A")){
//                num.updateAndGet(v -> new Double((double) (v + 1)));
//            };
//        });
//        return num.get();
//    };

        public double getAttendanceAverage(){
            final double[] count = {0};
        attendance.forEach((k,v) -> {
            if(v.contains("A")){
                count[0] += 1;
            }
        });
//        attendance.compute(date, (k,v) -> (v.contains("A") ? (count+=1):(count+=0));
//        map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))

        return (attendance.size() - count[0])/attendance.size() *100;
    };

//    Add an attendance property to your Student objects. It should be a HashMap.
// The keys should be strings representing the date, in the format "2017-10-02",
// and the values should be Strings that are one of:
//
//            "A": Absent
//"P": Present
//
//    Add a method named recordAttendance(String date, String value)
// that adds records to the HashMap this method should make sure value is
// an an acceptable string
//
//    Create an instance method on your Student class to calculate a student's
// attendance percentage -- (Total Days - Absences) / Total Days
//    Add the attendance information to the output of your command line
// interface, this should require only a small change
//    Create an instance method on Student that finds the specific days a
// student was absent. This method should return a List of Strings, where each
// string is the date of the absence

}
