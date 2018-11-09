package shapes;

public class ShapesTest {

//    Test your code by creating a new class, ShapesTest
// (also inside of shapes) with a main method. Inside the main method,
//
//    create a variable of the type Rectangle named box1 and assign it a
// new instance of the Rectangle class with a width of 4 and a length of 5
//    verify that the getPerimeter and getArea methods return 18 and 20, respectively.
//    create a variable of the type Rectangle named box2 and assign it a new
// instance of the Square class that has a side value of 5.
//    verify that the getPerimeter and getArea methods return 20 and 25, respectively.
//    In the Square class, override the getArea and getPerimeter methods with the
// following definitions for a square

    public static void main(String[] args) {
//        Rectangle box1 = new Rectangle(5, 4);
//        System.out.println("Area is " + box1.getArea());
//        System.out.println("Perimeter is " + box1.getPerimeter());
//
//        Rectangle box2 = new Square(5);
//        System.out.println("Area is " + box2.getArea());
//        System.out.println("Perimeter is " + box2.getPerimeter());


//    declare a variable of the type Measurable named myShape.
//    display the shape's area and circumference
//Test your code by creating instances of both Square and Rectangle and assigning them to myShape.

        Measurable myShape = new Square(3);
        System.out.println(myShape.getArea());
        System.out.println(myShape.getPerimeter());
    }
}
