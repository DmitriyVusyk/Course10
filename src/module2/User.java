package module2;

/**
 * this class is an implementation of Abstract User of system
 */
class User {

    private String name;
    private String city;
    private int age;
    private String hobby;

    User() {
    }

    User(String name, String city, int age, String hobby) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.hobby = hobby;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    String getHobby() {
        return hobby;
    }

    void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        return hobby != null ? hobby.equals(user.hobby) : user.hobby == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User" +
                "\n name: " + name +
                "\n city: " + city +
                "\n age: " + age +
                "\n hobby: " + hobby
                ;
    }
}
