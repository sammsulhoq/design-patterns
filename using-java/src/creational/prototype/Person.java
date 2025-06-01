package creational.prototype;

public class Person implements Prototype<Person> {
    private String name;
    private int age;
    private Address address; // Nested object

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Custom clone method for deep copy
    @Override
    public Person clone() {
        // Deep clone of nested object
        return new Person(this.name, this.age, this.address.clone());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name + ", " + age + " yrs, " + address);
    }
}

