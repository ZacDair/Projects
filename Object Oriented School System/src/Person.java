import java.io.Serializable;

public class Person implements Serializable {

    //attributes
    private Name name;
    private String email;
    private int phoneNumber;

    //constructors
    public Person(){

    }
    public Person(Name name,String email, int phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //getters and setters
    public Name getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
