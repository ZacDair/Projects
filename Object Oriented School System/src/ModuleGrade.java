import java.io.Serializable;

public class ModuleGrade implements Serializable {
    //attributes
    private String moduleName;
    private int grade;

    //constructors
    public ModuleGrade(){}

    public ModuleGrade(String name, int grade){
        this.moduleName = name;
        this.grade = grade;
    }

    //getters and setters
    public String getModuleName() {
        return moduleName;
    }
    public int getGrade() {
        return grade;
    }
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
}
