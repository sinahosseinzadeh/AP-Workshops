import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Triangle {
    ArrayList<Integer> sides;
    public Triangle(int ... sides){
        this.sides=new ArrayList<>();
        for (int i=0;i<3;i++){
            this.sides.add(sides[i]);
        }
    }

    /**
     *
     * @return returns the list of sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     *
     * @return returns true if triangle is equilateral ,and false if it isn't
     */
    public boolean isEquilateral(){
        return (sides.get(0)==sides.get(1))&&(sides.get(1)==sides.get(2))&(sides.get(2)==sides.get(0));
    }

    /**
     *
     * @return returns the perimeter of the shape
     */
    public double calculatePerimeter(){
        double perimeter=0;
        for(int side:sides){
            perimeter+=side;
        }
        return perimeter;
    }

    /**
     *
     * @return returns the Area of the shape
     */
    public double calculateArea(){
        double area;
        double halfPerimeter=calculatePerimeter()/2;
        //Heron's formula
        area=Math.sqrt(halfPerimeter*(halfPerimeter-sides.get(0))*(halfPerimeter-sides.get(1))*
                (halfPerimeter-sides.get(2)));
        return area;
    }

    /**
     * prints the shape ( information)
     */
    public void draw(){
        System.out.println("Triangle - Perimeter: "+calculatePerimeter()+" - Area : "+calculateArea());
    }

    /**
     *
     * @param obj obj which equality is going to be checked
     * @return returns true if obj is triangle and has same sides ,and false if it isn't or doesn't
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Triangle)) return false;
        ArrayList<Integer>sidesToCheck=((Triangle)obj).getSides();
        Collections.sort(sidesToCheck);
        Collections.sort(sides);
        return sidesToCheck.equals(sides);
    }

    /**
     *
     * @return returns type and sides of shape in string
     */
    @Override
    public String toString() {
        return String.format("Triangle - sides : %d %d %d",sides.get(0),sides.get(1),sides.get(2));
    }
}
