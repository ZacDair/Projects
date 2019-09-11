import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class Controller {
    //attributes
    private ArrayList<String> studentAttributes = new ArrayList<>();
    private ArrayList<String> teacherAttributes = new ArrayList<>();
    private ArrayList<String> classGroupAttributes = new ArrayList<>();
    private ArrayList<String> inputtedAttributes = new ArrayList<>();
    private ArrayList<String> degrees = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<ModuleGrade> moduleGradeArrayList = new ArrayList<>();
    private Student studentToEdit = new Student();
    private ModuleGrade moduleGradeToEdit = new ModuleGrade();
    private int count = 0;
    private int status = -1;
    private int maxModules = 0;
    private int maxStudents = 0;
    private boolean loop = false;
    private boolean isValid = true;

    //constructor
    public Controller(){
        studentAttributes.add(0,"Middle Name");
        studentAttributes.add(1,"Last Name");
        studentAttributes.add(2,"Email Address");
        studentAttributes.add(3,"Phone Number");
        studentAttributes.add(4,"DOB");

        teacherAttributes.add(0,"Middle Name");
        teacherAttributes.add(1,"Last Name");
        teacherAttributes.add(2,"Email Address");
        teacherAttributes.add(3,"Phone Number");

        classGroupAttributes.add(0,"Class Group Name");
    }
    public void setStatus(String label){
        status = -1;
        if(label.equals("You can Manage Students here")){
            status = 1;
        }
        else if(label.equals("You can Manage Teachers here")){
            status = 2;
        }
        else if(label.equals("You can Manage Class Groups here")){
            status = 3;
        }
    }
    public int getStatus() {
        return this.status;
    }
    public boolean getIsValid() {
        return isValid;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int x){
        this.count = x;
    }
    public boolean getLoop(){
        return this.loop;
    }
    public void setLoop(Boolean x){
        this.loop = x;
    }
    public void setMaxModules(ArrayList<ModuleGrade> x){
        maxModules = x.size();
    }
    public void setMaxStudents(ArrayList<Student>x){
        maxStudents = x.size();
    }
    public ArrayList<ModuleGrade> getModuleGradeArrayList(){
        return this.moduleGradeArrayList;
    }
    public void setValid(Boolean x){
        isValid = x;
    }

    public String checkInput(String input){
        String res = "";
        if(status == 1 || status == 2){
            if (count == 4){
                try{
                    int temp = Integer.parseInt(input);
                    isValid = true;
                }
                catch(Exception e) {
                    res = "Sorry you need to input a Integer";
                    isValid = false;
                }
            }
            if (loop && status == 1){
                try{
                    int temp = Integer.parseInt(input);
                    if(temp > maxModules){
                        throw new InputMismatchException();
                    }
                    isValid = true;
                }
                catch(Exception e) {
                    res = "Sorry you need to input a Integer between 1 and "+maxModules;
                    isValid = false;
                }
            }
        }
        else if (status == 3 && loop){
            try{
                int temp = Integer.parseInt(input);
                if(temp > maxStudents){
                    throw new InputMismatchException();
                }
                isValid = true;
            }
            catch(Exception e) { res = "Sorry you need to input a Integer between 1 and "+maxStudents;
            isValid = false;
            }
        }
        return res;
    }
    public String checkRemoveInput(String input){
        String res = "";
        try{
            int temp = Integer.parseInt(input);
            isValid = true;
        }
        catch(Exception e) {
            res = "Sorry you need to input a Integer";
            isValid = false;
        }
        return res;
    }

    public void storeAttributes(String x){
        inputtedAttributes.add(x);
    }
    public String changeInputText(){
        String res = "";
        switch (status) {
            case 1: {
                res = studentAttributes.get(count);
                break;
            }
            case 2:{
                res = teacherAttributes.get(count);
                break;
            }
            case 3:{
                res = classGroupAttributes.get(count);
            }
        }
        return res;
    }
    public void clearInputtedAttributes(){
        inputtedAttributes.clear();
    }
    public void addToCount(){
        count++;
    }
    public void addDegrees(String x){
        degrees.add(x);
    }
    public void addStudents(ArrayList<Student> x , int i){
        students.add(x.get(i));
    }
    public void addModules(ArrayList<ModuleGrade> x , int i){
        moduleGradeArrayList.add(x.get(i));
    }
    public Student createStudent(){
        Name name = new Name(inputtedAttributes.get(0),inputtedAttributes.get(1),inputtedAttributes.get(2));
        Student student = new Student(name, inputtedAttributes.get(3), Integer.parseInt(inputtedAttributes.get(4)),
                inputtedAttributes.get(5),moduleGradeArrayList);
        return student;
    }
    public Teacher createTeacher(){
        Name name = new Name(inputtedAttributes.get(0),inputtedAttributes.get(1),inputtedAttributes.get(2));
        Teacher teacher = new Teacher(name, inputtedAttributes.get(3), Integer.parseInt(inputtedAttributes.get(4)),degrees);
        return teacher;
    }
    public ClassGroup createClassGroup(){
        ClassGroup classGroup = new ClassGroup(inputtedAttributes.get(0),students);
        return classGroup;
    }
    public String showAllModules(ArrayList<ModuleGrade> x){
        int i = 1;
        String res = "";
        while (i<= x.size()){
            res = res + i+")"+x.get(i-1).getModuleName()+"\n";
            i++;
        }
        return res;
    }
    public String showAllStudents(ArrayList<Student> x) {
        int i = 1;
        String res = "";
        while (i <= x.size()) {
            Student temp = x.get(i - 1);
            Name tempName = temp.getName();
            res = res + i + ")" + tempName.getFirstName() + " " +
                    tempName.getMiddleName() + " " + tempName.getLastName() + "\n";
            i++;
        }
        return res;
    }
    public String showAllClassGroups(ArrayList<ClassGroup> x) {
        int i = 1;
        String res = "";
        while (i <= x.size()) {
            ClassGroup temp = x.get(i - 1);
            res = res + i + ")" + temp.getGroupName()+ "\n";
            i++;
        }
        return res;
    }
    public void removeFromList(ArrayList list, int index){
        list.remove(index-1);
    }
    public String listStudents(ArrayList<Student>x){
        String res = "";
        Collections.sort(x, this::compareStudents);
        res = showAllStudents(x);
        return res;
    }
    public String listTeachers(ArrayList<Teacher>x){
        String res = "";
        int i = 0;
        while(i<x.size()){
            Teacher temp = x.get(i);
            int y = 0;
            String degreeString = "Degrees: ";
            while (y<temp.getDegrees().size()){
                degreeString = degreeString + temp.getDegrees().get(y)+" ";
                y++;
            }
            Name tempName = temp.getName();
            res = res + (i+1) + ")" + tempName.getFirstName() + " " +
                    tempName.getMiddleName() + " " + tempName.getLastName() +" "+ degreeString +"\n";
            i++;
        }
        return res;
    }
    public int compareStudents(Student a, Student b){
        return a.getName().getFirstName().compareTo(b.getName().getFirstName());
    }
    public void setStudentToEdit(int x, ArrayList<Student> list){
        this.studentToEdit = list.get(x-1);
    }
    public Student getStudentToEdit(){
        return studentToEdit;
    }
    public void clearStudentToEdit(){
        this.studentToEdit = new Student();
    }
    public void setModuleGradeToEdit(int x, ArrayList<ModuleGrade> list){
        this.moduleGradeToEdit = list.get(x-1);
    }
    public ModuleGrade getModuleGradeToEdit(){
        return this.moduleGradeToEdit;
    }
    public void clearModuleGradeToEdit(){
        this.moduleGradeToEdit = new ModuleGrade();
    }
}
