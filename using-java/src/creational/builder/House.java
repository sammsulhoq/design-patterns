package creational.builder;

// Product Class
public class House {
    // Required parts
    private final int walls;
    private final int windows;
    private final boolean hasRoof;

    // Optional features
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;
    private final boolean hasGarden;
    private final boolean hasHeating;
    private final boolean hasPlumbing;
    private final boolean hasElectricity;

    private House(HouseBuilder builder) {
        this.walls = builder.walls;
        this.windows = builder.windows;
        this.hasRoof = builder.hasRoof;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
        this.hasHeating = builder.hasHeating;
        this.hasPlumbing = builder.hasPlumbing;
        this.hasElectricity = builder.hasElectricity;
    }

    public void describe() {
        System.out.println("House with:");
        System.out.println("- " + walls + " walls");
        System.out.println("- " + windows + " windows");
        System.out.println("- Roof: " + (hasRoof ? "Yes" : "No"));
        if (hasGarage) System.out.println("- Garage");
        if (hasSwimmingPool) System.out.println("- Swimming pool");
        if (hasGarden) System.out.println("- Garden");
        if (hasHeating) System.out.println("- Heating system");
        if (hasPlumbing) System.out.println("- Plumbing");
        if (hasElectricity) System.out.println("- Electrical wiring");
    }

    // Builder (Nested Static Class)
    public static class HouseBuilder {
        private final int walls;
        private final int windows;
        private final boolean hasRoof;

        // Optional features (defaults)
        private boolean hasGarage;
        private boolean hasSwimmingPool;
        private boolean hasGarden;
        private boolean hasHeating;
        private boolean hasPlumbing;
        private boolean hasElectricity;

        public HouseBuilder(int walls, int windows, boolean hasRoof) {
            this.walls = walls;
            this.windows = windows;
            this.hasRoof = hasRoof;
        }

        public HouseBuilder withGarage() {
            this.hasGarage = true;
            return this;
        }

        public HouseBuilder withSwimmingPool() {
            this.hasSwimmingPool = true;
            return this;
        }

        public HouseBuilder withGarden() {
            this.hasGarden = true;
            return this;
        }

        public HouseBuilder withHeating() {
            this.hasHeating = true;
            return this;
        }

        public HouseBuilder withPlumbing() {
            this.hasPlumbing = true;
            return this;
        }

        public HouseBuilder withElectricity() {
            this.hasElectricity = true;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}

