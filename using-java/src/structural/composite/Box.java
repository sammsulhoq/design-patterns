package structural.composite;

import java.util.*;

// Composite Node
public class Box implements Item{
    private final String name;
    private final List<Item> items = new ArrayList<>();

    public Box(String name) {
        this.name = name;
    }

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    @Override
    public String getName() {
        return name;
    }
}
