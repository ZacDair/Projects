import java.io.Serializable;
import java.util.ArrayList;

public class ClassGroup implements Serializable {
    //attributes
    private String groupName;
    private ArrayList<Student> students = new ArrayList<>();

    //constructors
    public ClassGroup(){}

    public ClassGroup(String name, ArrayList<Student>students){
        this.groupName = name;
        this.students = students;
    }

    //getters and setters
    public String getGroupName() {
        return groupName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addStudents(Student x) {
        this.students.add(x);
    }
    public void removeStudents(int x){
        this.students.remove(x);
    }
}
