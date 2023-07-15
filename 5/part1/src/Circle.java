public class Circle {
    private int radius;
    public Circle(int radius){
        this.radius=radius;
    }

    /**
     *
     * @return returns the radius of circle
     */
    public int getRadius() {
        return radius;
    }

    /**
     *
     * @return returns the perimeter of circle
     */
    public double calculatePerimeter(){
        return 2*Math.PI*radius;
    }

    /**
     *
     * @return returns the Area of the circle
     */
    public double calculateArea(){
        return Math.PI*Math.pow(radius,2);
    }

    /**
     * draws shape (information)
     */
    public void draw(){
        System.out.println("Circle - Perimeter: "+calculatePerimeter()+" - Area : "+calculateArea());
    }

    /**
     *
     * @return returns type of shape and radius as String
     */
    @Override
    public String toString() {
       return String.format("Circle - Radius : %d",getRadius());
    }

    /**
     *
     * @param obj obj to be checked as equal
     * @return returns true if object be a circle with equal radius
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Circle))
            return false;
        Circle circle=(Circle)obj;
        return circle.getRadius()==radius;
    }
}
