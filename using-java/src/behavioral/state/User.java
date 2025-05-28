package behavioral.state;

public class User {
    private String name;
    private boolean isAdmin;

    public User(String name, boolean isAdmin) {
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
