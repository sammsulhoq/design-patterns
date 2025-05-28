package iterator;

public class Profile {
    private String name;
    private String email;
    private String company;

    public Profile(String name, String email, String company) {
        this.name = name;
        this.email = email;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return name + " (" + email + ") - " + company;
    }
}
