public class Circle extends Shape {
    private int radius;
    public Circle(int radius){
        super();
        this.radius=radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public void draw(){
            System.out.println("Circle - Perimeter: "+calculatePerimeter()+" - Area : "+calculateArea());
    }

    @Override
    public String toString() {
        return String.format("Circle:: radius:%d",radius);
    }

    public int getRadius() {
        return radius;
    }
}
