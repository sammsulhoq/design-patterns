package creational.singleton;

public class Logger {
    // Private static instance (eager initialization — thread-safe)
    private static final Logger instance = new Logger();

    // Private constructor prevents instantiation from outside
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Global access point
    public static Logger getInstance() {
        return instance;
    }

    // Logging functionality
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
