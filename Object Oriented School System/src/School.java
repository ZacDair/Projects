import java.io.Serializable;
import java.util.ArrayList;

public class School implements Serializable {

    //attributes
    private String schoolName;
    private String address;
    private ArrayList<Teacher>teachers = new ArrayList<>();
    private ArrayList<ClassGroup>classGroups = new ArrayList<>();

    //constructors
    public School(){

    }
    public School(String name, String address, ArrayList<Teacher> teachers, ArrayList<ClassGroup>classGroups){
        this.schoolName = name;
        this.address = address;
        this.teachers = teachers;
        this.classGroups = classGroups;
    }

    //getters and setters
    public String getSchoolName() {
        return schoolName;
    }
    public String getAddress() {
        return address;
    }
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
    public ArrayList<ClassGroup> getClassGroups() {
        return classGroups;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void addTeacher(Teacher x){
        this.teachers.add(x);
    }
    public void addClassgroups(ClassGroup x){
        this.classGroups.add(x);
    }
    public void removeTeacher(int x){
        this.teachers.remove(x);
    }
    public void removeClassGroup(int x){
        this.classGroups.remove(x);
    }

}
