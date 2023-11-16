package softeng.cinecritique.app.domain;


import java.util.UUID;


public class User {

    private UUID id;
    private String name;
    private String userName;
    private Integer age;
    private String email;

    public User(UUID id, String name, String userName, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.age = age;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
