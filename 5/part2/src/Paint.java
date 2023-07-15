import java.util.ArrayList;

public class Paint {
    ArrayList<Shape> shapes;
     public Paint (){
         shapes=new ArrayList<>();
     }

    /**
     * adds shape to the list
     * @param shapeToAdd is the shape which is going to be add
     */
     public void addShape(Shape shapeToAdd){
         shapes.add(shapeToAdd);
     }
    public void drawAll(){
        for(Shape shape:shapes){
            shape.draw();
        }
    }
    public void printAll(){
        for (Shape shape:shapes){
            System.out.println(shape.toString());
        }
    }
    public void describeEqualSides(){
        for(Shape shape:shapes){
            if(shape instanceof  Rectangle){
                Rectangle rectangle =(Rectangle) shape;
                if(rectangle.isSquare())
                    System.out.println(rectangle.toString());
            }
            else if(shape instanceof Triangle){
                Triangle triangle=(Triangle) shape;
                if(triangle.isEquilateral())
                    System.out.println(triangle.toString());
            }
        }
    }
}
