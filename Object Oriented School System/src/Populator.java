import java.util.ArrayList;
import java.util.Random;

public class Populator {
    //attributes
    private ArrayList<String>fnames = new ArrayList<>();
    private ArrayList<String>mnames = new ArrayList<>();
    private ArrayList<String>lnames = new ArrayList<>();
    private ArrayList<ModuleGrade>modules = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<ClassGroup>classGroups = new ArrayList<>();

    public Populator(){
        fnames.add("Alice");
        fnames.add("John");
        fnames.add("Stefan");
        fnames.add("Elena");
        fnames.add("Michael");
        fnames.add("Zac");
        fnames.add("Anthea");
        fnames.add("Amy");
        fnames.add("Sammy");
        fnames.add("Andrew");
        fnames.add("Patrick");
        fnames.add("Caitlin");
        mnames.add("Elena");
        mnames.add("Alex");
        mnames.add("Guiseppe");
        mnames.add("Sarah");
        mnames.add("Tadgh");
        mnames.add("Joeseph");
        mnames.add("Caitlin");
        mnames.add("Angela");
        mnames.add("John");
        mnames.add("Henry");
        mnames.add("Paddy");
        mnames.add("Samantha");
        lnames.add("Gilbert");
        lnames.add("Mason");
        lnames.add("Salvatore");
        lnames.add("Donegan");
        lnames.add("Mahony");
        lnames.add("Dair");
        lnames.add("Ryan");
        lnames.add("McCarthy");
        lnames.add("Grinsell");
        lnames.add("Mells");
        lnames.add("ODea");
        lnames.add("Hurley");

    }
    public ArrayList<Student> generateStudents(){
        ArrayList<ModuleGrade>studentModules = new ArrayList<>();
        int i = 0;
        while (i<modules.size() && i < 6){
            studentModules.add(modules.get(i));
            i++;
        }
        i = 0;
        while (i<fnames.size()) {
            Name n = new Name(fnames.get(i), mnames.get(i), lnames.get(i));
            String email = n.getFirstName() + "." + n.getLastName() + "@mycit.ie";
            Student s = new Student(n, email, 32452352, "11/12/90", studentModules);
            students.add(s);
            i++;
        }
        return students;
    }
    public ArrayList<ModuleGrade> generateModules(){
        ModuleGrade m = new ModuleGrade("Computer Science",0);
        modules.add(m);
        m = new ModuleGrade("Probability",0);
        modules.add(m);
        m = new ModuleGrade("System Scripting",0);
        modules.add(m);
        m = new ModuleGrade("C Programming",0);
        modules.add(m);
        m = new ModuleGrade("Object Oriented Programming",0);
        modules.add(m);
        m = new ModuleGrade("Networking",0);
        modules.add(m);
        m = new ModuleGrade("AI Design",0);
        modules.add(m);
        m = new ModuleGrade("Statistics",0);
        modules.add(m);
        m = new ModuleGrade("Game Design",0);
        modules.add(m);
        m = new ModuleGrade("Database Fundamentals",0);
        modules.add(m);
        m = new ModuleGrade("Discrete Maths",0);
        modules.add(m);
        m = new ModuleGrade("Python Programming",0);
        modules.add(m);
        return modules;
    }
    public ArrayList<ClassGroup> generateClassGroups(){
        ClassGroup cg = new ClassGroup();
        cg.setGroupName("SD2A");
        int i = 0;
        while (i<5){
            cg.addStudents(students.get(i));
            i++;
        }
        classGroups.add(cg);
        cg = new ClassGroup();
        cg.setGroupName("SD2B");
        while(i<fnames.size()){
            cg.addStudents(students.get(i));
            i++;
        }
        classGroups.add(cg);
        return classGroups;
    }
    public ArrayList<Teacher> generateTeachers(){
        ArrayList<String>degrees = new ArrayList<>();
        degrees.add("Undergrad");
        degrees.add("Masters");
        degrees.add("PHD");
        int i = 0;
        while (i<fnames.size()) {
            Name n = new Name(fnames.get(i), mnames.get(i), lnames.get(i));
            String email = n.getFirstName() + "." + n.getLastName() + "@cit.ie";
            Teacher t = new Teacher(n, email, 32452352, degrees);
            teachers.add(t);
            i++;
        }
        return teachers;
    }
    public School generateSchool(){
        School s = new School("CIT","Cork Bishopstown",teachers,classGroups);
        return s;
    }
}
