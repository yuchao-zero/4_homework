package club.banyuan.area;

public class Rectangle extends Shape {
    private int length;
    private int width;

    @Override
    public String getShapeName() {
        return "矩形";
    }
    public Rectangle(int length,int width){
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}
