package shapes;

abstract class Quadrilateral extends Shape implements Measurable{

//    protected properties for length and width
//    a constructor that accepts two numbers for the length and width and sets those properties
//    methods for getting the length and width
//    abstract methods for setting the length and width

    protected double length;
    protected double width;

    public Quadrilateral(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public abstract void setLength(double length);


    public abstract void setWidth(double width);

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

}
