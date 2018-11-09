package shapes;

public class Square extends Quadrilateral {
    public Square(double side) {
        super(side, side);
    }

    @Override
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }

    @Override
    public double getArea() {
        return length*length;
    }

//    private double side;
//
//    public Square (double side){
//        super(side, side);
//        this.side = side;
//    }
//
//    public double getPerimeter(){
//        return 4 * side;
//    }
//
//    public double getArea(){
//        return side * side;
//    }
}
