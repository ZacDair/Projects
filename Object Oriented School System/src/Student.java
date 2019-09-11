import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Person implements Serializable {
    //attributes
    private String dob;
    private ArrayList<ModuleGrade>moduleGrades = new ArrayList<>(6);

    //constructors
    public Student(){
        super();
    }
    public Student(Name name, String email, int phoneNumber,String dob,ArrayList<ModuleGrade>moduleGrades){
        super(name, email, phoneNumber);
        this.dob = dob;
        this.moduleGrades = moduleGrades;
    }

    //getters and setters
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public ArrayList<ModuleGrade> getModuleGrades() {
        return moduleGrades;
    }
    public void addModuleGrade(ModuleGrade x){
        if(moduleGrades.size()<6){
            moduleGrades.add(x);
        }
        else{
            System.out.println("6 modules max");
        }
    }
    public void removeModuleGrade(int x){
        moduleGrades.remove(x);
    }
}
