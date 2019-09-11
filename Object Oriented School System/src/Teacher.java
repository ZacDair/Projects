import java.io.Serializable;
import java.util.ArrayList;

public class Teacher extends Person implements Serializable {
    //attributes
    private ArrayList<String> degrees = new ArrayList<>();

    //constructors
    public Teacher(){
        super();

    }
    public Teacher(Name name, String email, int phoneNumber, ArrayList<String> degrees){
        super(name, email, phoneNumber);
        this.degrees = degrees;
    }

    //getters and setters
    public ArrayList<String> getDegrees() {
        return degrees;
    }
    public void addDegrees(String x){
        this.degrees.add(x);
    }
    public void removeDegrees(int x){
        this.degrees.remove(x);
    }
}
