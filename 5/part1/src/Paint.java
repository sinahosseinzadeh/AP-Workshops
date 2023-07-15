import  java.util.*;
public class Paint {
    ArrayList<Circle> circles;
    ArrayList<Triangle> triangles;
    ArrayList<Rectangle> rectangles;
    public Paint(){
        circles=new ArrayList<>();
        triangles=new ArrayList<>();
        rectangles=new ArrayList<>();
    }

    /**
     * adds circle to list
     * @param circleToAdd circle to add to list
     */
    public void addCircle(Circle circleToAdd){
        circles.add(circleToAdd);
    }

    /**
     *adds triangle to the list
     * @param triangleToAdd triangle to add
     */
    public void addTriangle(Triangle triangleToAdd){
        triangles.add(triangleToAdd);
    }

    /**
     * adds rectangle to the list
     * @param rectangleToAdd rectangle to add
     */
    public void addRectangle(Rectangle rectangleToAdd){
        rectangles.add(rectangleToAdd);
    }

    /**
     * draws all shapes
     */
    public void drawAll(){
        for(Circle circle:circles){
            circle.draw();
        }
        for(Triangle triangle:triangles){
            triangle.draw();
        }
        for(Rectangle rectangle:rectangles){
            rectangle.draw();
        }
    }

    /**
     * prints all shapes
     */
    public void printAll(){
        for(Circle circle:circles){
            System.out.println(circle.toString());
        }
        for(Triangle triangle:triangles){
            System.out.println(triangle.toString());
        }
        for(Rectangle rectangle:rectangles){
            System.out.println(rectangle.toString());
        }
    }

}
