import java.util.Arrays;

public class ArraysExercises {


//    Create an array that holds 3 Person objects. Assign a new instance of the
//    Person class to each element. Iterate through the array and print out the name of each person in the array.
//
//    Create a static method named addPerson. It should accept an array of Person objects,
//    as well as a single person object to add to the passed array. It should return an array
//    whose length is 1 greater than the passed array, with the passed person object at the end of the array.

    public static Person[] addPerson(Person[] people, Person newPerson){
        Person[] updatedPeople = new Person[people.length +1];
        for(int i = 0; i <updatedPeople.length-1; i++){
            updatedPeople[i] = people[i];
        }
//        Person updatedPerson = new Person(newPerson);
        updatedPeople[updatedPeople.length-1] = newPerson;
        return updatedPeople;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));
//        String[] people = new String[3];
        Person[] people = new Person[3];
        System.out.println(Arrays.toString(people));
        Person alois = new Person("Alois");
        Person isa = new Person("Isa");
        Person isiah = new Person("Isiah");
        people[0] = alois;
        people[1] = isa;
        people[2] = isiah;

//        System.out.println(people[0]);
//        System.out.println(Arrays.toString(people));
//        people[1] = isa;
//        people[2] = isiah;
        Person louie = new Person("Louie");
        Person[] updated = addPerson(people, louie);
        for(Person person : updated){
            System.out.println(person.getName());
        }

//        addPerson(people, "Louie");
    }
}
