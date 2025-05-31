package structural.flyweight;

// Flyweight class: Intrinsic state
public class ParticleType {
    private final String name;
    private final String texture;
    private final String color;

    public ParticleType(String name, String texture, String color) {
        this.name = name;
        this.texture = texture;
        this.color = color;
    }

    public void render(int x, int y, int direction) {
        System.out.println("Rendering [" + name + "] at (" + x + "," + y + ") dir=" + direction +
                " using texture=" + texture + " and color=" + color);
    }
}
