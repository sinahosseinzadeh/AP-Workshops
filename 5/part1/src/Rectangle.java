import java.util.ArrayList;
import java.util.Collections;

public class Rectangle {
    ArrayList<Integer>sides;
    public Rectangle(int ...sides){
        this.sides=new ArrayList<>();
        for(int i=0;i<4;i++){
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
     * @return returns true if Rectangle is square or not
     */
    public boolean isSquare(){
        return (sides.get(0)==sides.get(2))&&(sides.get(1)==sides.get(3))&&(sides.get(0)==sides.get(1));
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
        double area=1;
        area=sides.get(0)*sides.get(1);
        return area;
    }

    /**
     * prints shape (information)
     */
    public void draw(){
        System.out.println("Rectangle - Perimeter: "+calculatePerimeter()+" - Area : "+calculateArea());
    }

    /**
     *
     * @return returns the type and sides of shape
     */
    @Override
    public String toString() {
        StringBuilder stringToReturn = new StringBuilder();
        stringToReturn.append("Rectangle - Sides : ");
        for(int side:sides){
          stringToReturn.append(side);
          stringToReturn.append(" ");
        }
        return stringToReturn.toString();
    }

    /**
     *
     * @param obj obj which is going to be checked
     * @return returns true if Rectangle be equal to this one
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Rectangle))
            return false;
        boolean isEqual=true;
        ArrayList<Integer> sidesToCheck=((Rectangle) obj).getSides();
        Collections.sort(sidesToCheck);
        Collections.sort(sides);
        return sides.equals(sidesToCheck);
    }
}
