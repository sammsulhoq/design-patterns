package structural.flyweight;

import java.util.*;

// Client — manages lots of particles
public class Game {
    private final List<Particle> particles = new ArrayList<>();
    private final Random rand = new Random();

    public void spawn(String type, String texture, String color) {
        int x = rand.nextInt(500);
        int y = rand.nextInt(500);
        int dir = rand.nextInt(360);
        ParticleType sharedType = ParticleFactory.getParticleType(type, texture, color);
        particles.add(new Particle(x, y, dir, sharedType));
    }

    public void drawParticles() {
        for (Particle p : particles) {
            p.draw();
        }
    }

    public int getParticleCount() {
        return particles.size();
    }
}
