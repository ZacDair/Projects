import java.io.Serializable;

public class Name implements Serializable {
    //Attributes
    private String firstName;
    private String middleName;
    private String lastName;

    //Constructors
    public  Name(){

    }
    public Name(String fName, String mName, String lName){
        this.firstName = fName;
        this.middleName = mName;
        this.lastName = lName;

    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
