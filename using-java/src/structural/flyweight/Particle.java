package structural.flyweight;

// Context: Extrinsic data + Flyweight reference
public class Particle {
    private final int x;
    private final int y;
    private final int direction;
    private final ParticleType type;  // shared flyweight

    public Particle(int x, int y, int direction, ParticleType type) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.type = type;
    }

    public void draw() {
        type.render(x, y, direction);
    }
}

