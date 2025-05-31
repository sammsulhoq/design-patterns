package structural.flyweight;

import java.util.*;

// Flyweight Factory
public class ParticleFactory {
    private static final Map<String, ParticleType> types = new HashMap<>();

    public static ParticleType getParticleType(String name, String texture, String color) {
        String key = name + texture + color;
        if (!types.containsKey(key)) {
            types.put(key, new ParticleType(name, texture, color));
        }
        return types.get(key);
    }

    public static int getTotalTypes() {
        return types.size();
    }
}
