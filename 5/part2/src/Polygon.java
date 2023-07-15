import java.util.ArrayList;

public abstract class Polygon extends Shape {
    ArrayList<Integer> sides;
    public Polygon(int ...sides){
        this.sides=new ArrayList<>();
        for(int side:sides){
            this.sides.add(side);
        }
    }
    public ArrayList<Integer> getSides() {
        return sides;
    }
    /**
     *
     * @return returns the perimeter of the shape
     */
    @Override
    public double calculatePerimeter() {
        //cause both Rectangle and Triangle were similar in calculating perimeter i used it here
        double perimeter=0;
        for(int side:sides){
            perimeter+=side;
        }
        return perimeter;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<sides.size();i++){
            str.append(String.format("side%d:%d%c ",i+1,sides.get(i),i==sides.size()-1?' ':','));
        }
        return str.toString();
    }
}
