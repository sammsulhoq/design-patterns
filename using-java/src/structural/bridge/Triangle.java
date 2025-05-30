package structural.bridge;

public class Triangle extends Shape{
    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle in " + color.applyColor() + " color.");
    }
}
