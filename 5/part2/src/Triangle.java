public class Triangle extends Polygon {
    public Triangle(int side1,int side2,int side3){
        super(side1,side2,side3);
    }
    public boolean isEquilateral(){
        return (sides.get(0)==sides.get(1))&&(sides.get(1)==sides.get(2))&(sides.get(2)==sides.get(0));
    }

    @Override
    public String toString() {
        return "Triangle:: "+super.toString();
    }

    @Override
    public double calculateArea() {
        double area;
        double halfPerimeter=calculatePerimeter()/2;
        //Heron's formula
        area=Math.sqrt(halfPerimeter*(halfPerimeter-sides.get(0))*(halfPerimeter-sides.get(1))*
                (halfPerimeter-sides.get(2)));
        return area;
    }

    @Override
    public void draw() {
        System.out.println("Triangle - Perimeter: "+calculatePerimeter()+" - Area : "+calculateArea());
    }
}
