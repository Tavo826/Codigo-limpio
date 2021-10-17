'''
Builder organiza la construcción del objeto en una serie de pasos, siendo estos pasos básicamente los métodos que hay por cada atributo del objeto

VENTAJAS:

* Mayor control a la hora de contruir un objeto
* Se pueden construir objetos inmutables
'''

// El cliente (Director) dirige la construcción del objeto user usando el UserBuilder

// User user = new UserBuilder().city.("Madrid").build()

public class User {
    private String name;
    private String username;
    private Long age;
    private String city;

    public User(String name, String username, Long age, String city) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.city = city;
    }
    // getters...
}

public class UserBuilder {
    private String name;
    private String username;
    private Long age;
    private String city;

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder username(String username) {
        this.username = username;
        return this
    }

    public UserBuilder age(String age) {
        this.age = age;
        return this
    }

    public UserBuilder city(String city) {
        this.city = city;
        return this
    }

    public UserBuilder build() {
        return new User(name, username, age, city)
    }
}
