package interfaces;

public class Rectangle {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }

    public int perimeter() {
        return 2*width + 2*height;
    }

    public String toString() {
        return width + " " + height;
    }
}
