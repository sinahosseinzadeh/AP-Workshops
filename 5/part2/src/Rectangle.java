public class Rectangle extends Polygon {
    public Rectangle(int side1,int side2,int side3,int side4){
        super(side1,side2,side3,side4);
    }
    public boolean isSquare(){
        return (sides.get(0)==sides.get(2))&&(sides.get(1)==sides.get(3))&&(sides.get(0)==sides.get(1));
    }

    @Override
    public double calculateArea() {
        double area=sides.get(0)*sides.get(1);
        return area;
    }

    @Override
    public String toString() {
        return "Rectangle:: "+super.toString();
    }

    @Override
    public void draw() {
        System.out.println("Rectangle - Perimeter: "+calculatePerimeter()+" - Area : "+calculateArea());
    }
}
