package CompareToMethod;

public class User implements Comparable <User> {
    private String name;
    private Integer age;
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public int compareTo(User o) {
        int result = this.name.compareTo(o.name);

        if (result == 0) {
            result = this.age.compareTo(o.age);
        }
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", email='" + email + '\'' +
                    '}').toString();
    }
}
