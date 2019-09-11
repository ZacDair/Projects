import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQL {
    //attributes
    private String username = "root";
    private String password = "root";
    private Connection con = null;
    private Statement stmt = null;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<ModuleGrade> moduleGrades = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<ClassGroup> classGroups = new ArrayList<>();
    private ArrayList<School> schools = new ArrayList<>();

    //constructor
    public SQL(){

    }
    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", username, password);
            System.out.println("Connection has been made to the database");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void createTables(){
        try {
            stmt = con.createStatement();
            String createString = "CREATE TABLE School"+
                    "(id INTEGER not NULL auto_increment, " +
                    " schoolName Varchar(255), " +
                    " address Varchar(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(createString);
            createString = "CREATE TABLE Name"+
                    "(id INTEGER not NULL auto_increment, " +
                    " fName Varchar(255), " +
                    " mName Varchar(255), " +
                    " lName Varchar(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(createString);
            createString = "CREATE TABLE Person"+
                    "(id INTEGER not NULL auto_increment, " +
                    " email Varchar(255), " +
                    " phoneNumber Varchar(255), " +
                    " nameID int, " +
                    " PRIMARY KEY ( id ), " +
                    " FOREIGN KEY ( nameID ) REFERENCES Name(id))";
            stmt.executeUpdate(createString);
            createString = "CREATE TABLE Student"+
                    "(id INTEGER not NULL auto_increment, " +
                    " DOB Varchar(255), " +
                    " personID int, " +
                    " PRIMARY KEY ( id ), " +
                    " FOREIGN KEY ( personID ) REFERENCES Person(id))";
            stmt.executeUpdate(createString);
            createString = "CREATE TABLE Teacher"+
                    "(id INTEGER not NULL auto_increment, " +
                    " personID int, " +
                    " PRIMARY KEY ( id ), " +
                    " FOREIGN KEY ( personID ) REFERENCES Person(id))";
            stmt.executeUpdate(createString);
            createString = "CREATE TABLE Degrees"+
                    "(id INTEGER not NULL auto_increment, " +
                    " degree Varchar(255), " +
                    " teacherID int, " +
                    " PRIMARY KEY ( id ), " +
                    " FOREIGN KEY (teacherID ) REFERENCES Teacher(id))";
            stmt.executeUpdate(createString);
            createString = "CREATE TABLE ModuleGrades"+
                    "(id INTEGER not NULL auto_increment, " +
                    " name Varchar(255), " +
                    " grade int, " +
                    " PRIMARY KEY ( id )) ";
            stmt.executeUpdate(createString);
            createString = "CREATE TABLE StudentModules"+
                    "(id INTEGER not NULL auto_increment, " +
                    " moduleID int, " +
                    " studentID int, " +
                    " PRIMARY KEY ( id ), "+
                    " FOREIGN KEY (moduleID ) REFERENCES ModuleGrades(id), "+
                    " FOREIGN KEY (studentID ) REFERENCES Student(id))";
            stmt.executeUpdate(createString);
            createString = "CREATE TABLE ClassGroup"+
                    "(id INTEGER not NULL auto_increment, " +
                    " name Varchar(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(createString);
            createString = "CREATE TABLE ClassGroupStudents"+
                    "(id INTEGER not NULL auto_increment, " +
                    " classGroupID int, " +
                    " studentID int, " +
                    " PRIMARY KEY ( id ), "+
                    " FOREIGN KEY (classGroupID ) REFERENCES ClassGroup(id), "+
                    " FOREIGN KEY (studentID ) REFERENCES Student(id))";
            stmt.executeUpdate(createString);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public String uploadObject(Object obj){
        String output = "Sorry "+obj.toString()+" was not uploaded";
        int scenario = -1;
        //check what object is being uploaded
        if(obj instanceof School){
            scenario = 0;
        }
        else if(obj instanceof Name){
            scenario = 1;
        }
        else if(obj instanceof Student){
            scenario = 2;
        }
        else if(obj instanceof Teacher){
            scenario = 3;
        }
        else if(obj instanceof ModuleGrade){
            scenario = 4;
        }
        else if(obj instanceof ClassGroup){
            scenario = 5;
        }
        switch (scenario){
            case -1:{
                return output;
            }
            case 0:{
                String name = ((School) obj).getSchoolName();
                String address = ((School) obj).getAddress();
                try {
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO School(schoolName, address) VALUES(?,?)");
                    pstmt.setString(1,name);
                    pstmt.setString(2,address);
                    pstmt.executeUpdate();
                    pstmt.close();
                    output = obj.toString()+" was uploaded";
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            }
            case 1:{
                String fName = ((Name) obj).getFirstName();
                String mName = ((Name) obj).getMiddleName();
                String lName = ((Name) obj).getLastName();
                try {
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO Name(fName,mName,lName) VALUES(?,?,?)");
                    pstmt.setString(1,fName);
                    pstmt.setString(2,mName);
                    pstmt.setString(3,lName);
                    pstmt.executeUpdate();
                    pstmt.close();
                    output = obj.toString()+" was uploaded";
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            }
            case 2:{
                try {
                    Name name = ((Student) obj).getName();
                    String fName = name.getFirstName();
                    String mName = name.getMiddleName();
                    String lName = name.getLastName();
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO Name(fName,mName,lName) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1,fName);
                    pstmt.setString(2,mName);
                    pstmt.setString(3,lName);
                    pstmt.executeUpdate();
                    ResultSet rs = pstmt.getGeneratedKeys();
                    rs.next();
                    int nameid = rs.getInt(1);
                    rs.close();
                    pstmt.close();
                    String email = ((Student) obj).getEmail();
                    int phoneNumber = ((Student) obj).getPhoneNumber();
                    pstmt = con.prepareStatement("INSERT INTO Person(email,phoneNumber,nameID) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1,email);
                    pstmt.setInt(2, phoneNumber);
                    pstmt.setInt(3,nameid);
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    rs.next();
                    int personID = rs.getInt(1);
                    rs.close();
                    pstmt.close();
                    String dob = ((Student) obj).getDob();
                    pstmt = con.prepareStatement("INSERT INTO Student(DOB,personID) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1,dob);
                    pstmt.setInt(2, personID);
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    rs.next();
                    int studentID = rs.getInt(1);
                    rs.close();
                    pstmt.close();
                    ArrayList<ModuleGrade> modules = ((Student) obj).getModuleGrades();
                    int i = 0;
                    while(i < modules.size()){
                        String moduleName = modules.get(i).getModuleName();
                        pstmt = con.prepareStatement("SELECT * FROM ModuleGrades WHERE name = "+'"'+moduleName+'"');
                        rs = pstmt.executeQuery();
                        rs.next();
                        int moduleID = rs.getInt(1);
                        rs.close();
                        pstmt.close();
                        pstmt = con.prepareStatement("INSERT INTO StudentModules(moduleID, studentID) VALUES(?,?)");
                        pstmt.setInt(1,moduleID);
                        pstmt.setInt(2,studentID);
                        pstmt.executeUpdate();
                        pstmt.close();
                        i++;
                    }
                    output = obj.toString()+" was uploaded";
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case 3:{
                try {
                    Name name = ((Teacher) obj).getName();
                    String fName = name.getFirstName();
                    String mName = name.getMiddleName();
                    String lName = name.getLastName();
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO Name(fName,mName,lName) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1,fName);
                    pstmt.setString(2,mName);
                    pstmt.setString(3,lName);
                    pstmt.executeUpdate();
                    ResultSet rs = pstmt.getGeneratedKeys();
                    rs.next();
                    int nameid = rs.getInt(1);
                    rs.close();
                    pstmt.close();
                    String email = ((Teacher) obj).getEmail();
                    int phoneNumber = ((Teacher) obj).getPhoneNumber();
                    pstmt = con.prepareStatement("INSERT INTO Person(email,phoneNumber,nameID) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1,email);
                    pstmt.setInt(2, phoneNumber);
                    pstmt.setInt(3,nameid);
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    rs.next();
                    int personID = rs.getInt(1);
                    rs.close();
                    pstmt.close();
                    pstmt = con.prepareStatement("INSERT INTO Teacher(personID) VALUES(?)",Statement.RETURN_GENERATED_KEYS);
                    pstmt.setInt(1, personID);
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    rs.next();
                    int teacherID = rs.getInt(1);
                    pstmt.close();
                    ArrayList<String>degrees = ((Teacher) obj).getDegrees();
                    int i = 0;
                    while (i< degrees.size()){
                        pstmt = con.prepareStatement("INSERT INTO Degrees(degree, teacherID) VALUES(?,?)");
                        pstmt.setString(1, degrees.get(i));
                        pstmt.setInt(2,teacherID);
                        pstmt.executeUpdate();
                        pstmt.close();
                        i++;
                    }
                    output = obj.toString()+" was uploaded";
                }catch (Exception e){
                   System.out.println(e);
                }
                break;
            }
            case 4:{
                try {
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO ModuleGrades(name,grade) VALUES(?,?)");
                    String name = ((ModuleGrade) obj).getModuleName();
                    int grade = ((ModuleGrade) obj).getGrade();
                    pstmt.setString(1, name);
                    pstmt.setInt(2,grade);
                    pstmt.executeUpdate();
                    pstmt.close();
                    output = obj.toString()+" was uploaded";
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            }
            case 5:{
                try {
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO ClassGroup(name) VALUES(?)",Statement.RETURN_GENERATED_KEYS);
                    String name = ((ClassGroup) obj).getGroupName();
                    pstmt.setString(1, name);
                    pstmt.executeUpdate();
                    ResultSet rs = pstmt.getGeneratedKeys();
                    rs.next();
                    int classGroupID = rs.getInt(1);
                    rs.close();
                    pstmt.close();
                    ArrayList<Student> students = ((ClassGroup) obj).getStudents();
                    pstmt = con.prepareStatement("SELECT * from person where id not in(select personid from teacher)");
                    ResultSet rs1 = pstmt.executeQuery();
                    while(rs1.next()) {
                        int personID = rs1.getInt(1);
                        //pstmt.close();
                        //String fname = students.get(i).getName().getFirstName();
                        //String mname = students.get(i).getName().getMiddleName();
                        //lname = students.get(i).getName().getLastName();
                        //pstmt = con.prepareStatement("SELECT * FROM Name WHERE fname = " + '"' + fname + '"' + "AND mname = " + '"' + mname + '"' + "AND lname = " + '"' + lname + '"');
                        //rs = pstmt.executeQuery();
                        //rs.next();
                        //int nameID = rs.getInt(1);
                        //rs.close();
                        //pstmt.close();
                        pstmt = con.prepareStatement("SELECT * FROM Student WHERE personID = " + personID);
                        ResultSet rs2 = pstmt.executeQuery();
                        rs2.next();
                        int studentID = rs2.getInt(1);
                        rs2.close();
                        pstmt.close();
                        pstmt = con.prepareStatement("INSERT INTO ClassGroupStudents(classGroupID, studentID) VALUES(?,?)");
                        pstmt.setInt(1, classGroupID);
                        pstmt.setInt(2, studentID);
                        pstmt.executeUpdate();
                    }

                    output = obj.toString()+" was uploaded";
                }catch (Exception e){
                  e.printStackTrace();
                }
                break;
            }
        }
        return output;
    }
    public void download(){
        try{
            //add students, get person details, get name details, get modules that student studies
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Student");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                ArrayList<ModuleGrade>moduleGrades = new ArrayList<>();
                int studentID = rs.getInt(3);
                String dob = rs.getString(2);
                pstmt = con.prepareStatement("SELECT * FROM Person where id = "+studentID);
                ResultSet rs1 = pstmt.executeQuery();
                rs1.next();
                int nameID = rs1.getInt(4);
                int phoneNumber = rs1.getInt(3);
                String email = rs1.getString(2);
                rs1.close();
                pstmt.close();
                pstmt = con.prepareStatement("SELECT * FROM Name where id = "+nameID);
                ResultSet rs2 = pstmt.executeQuery();
                rs2.next();
                String fname = rs2.getString(2);
                String mname = rs2.getString(3);
                String lname = rs2.getString(4);
                rs2.close();
                pstmt.close();
                pstmt = con.prepareStatement("SELECT * FROM studentModules where studentID = "+studentID);
                ResultSet rs3 = pstmt.executeQuery();
                while(rs3.next()){
                    int stmoduleID = rs3.getInt(2);
                    pstmt = con.prepareStatement("SELECT * FROM moduleGrades where id = "+stmoduleID);
                    ResultSet rs4 = pstmt.executeQuery();
                    while(rs4.next()){
                        ModuleGrade m = new ModuleGrade(rs4.getString(2),rs4.getInt(3));
                        moduleGrades.add(m);
                    }
                    rs4.close();
                }
                rs3.close();
                Name n = new Name(fname,mname,lname);
                Student s = new Student(n,email,phoneNumber,dob,moduleGrades);
                students.add(s);
            }
            rs.close();
            pstmt.close();
            //add teachers, get person details, get name details, get degrees
            pstmt = con.prepareStatement("SELECT * FROM Teacher");
            rs = pstmt.executeQuery();
            while(rs.next()){
                ArrayList<String>degrees = new ArrayList<>();
                int teacherID = rs.getInt(1);
                pstmt = con.prepareStatement("SELECT * FROM Person where id = "+teacherID);
                ResultSet rs1 = pstmt.executeQuery();
                rs1.next();
                int nameID = rs1.getInt(4);
                int phoneNumber = rs1.getInt(3);
                String email = rs1.getString(2);
                rs1.close();
                pstmt.close();
                pstmt = con.prepareStatement("SELECT * FROM Name where id = "+nameID);
                ResultSet rs2 = pstmt.executeQuery();
                rs2.next();
                String fname = rs2.getString(2);
                String mname = rs2.getString(3);
                String lname = rs2.getString(4);
                rs2.close();
                pstmt.close();
                pstmt = con.prepareStatement("SELECT * FROM degrees where teacherID = "+teacherID);
                ResultSet rs3 = pstmt.executeQuery();
                while(rs3.next()){
                    String degreeString = rs3.getString(2);
                    degrees.add(degreeString);

                }
                Name n = new Name(fname,mname,lname);
                Teacher t = new Teacher(n,email,phoneNumber,degrees);
                teachers.add(t);
            }
            rs.close();
            pstmt.close();
            //add all modules
            pstmt = con.prepareStatement("SELECT * FROM moduleGrades");
            rs = pstmt.executeQuery();
            while(rs.next()){
                String name = rs.getString(2);
                int grade = rs.getInt(3);
                ModuleGrade m = new ModuleGrade(name,grade);
                moduleGrades.add(m);
            }
            rs.close();
            pstmt.close();
            //add class groups and their students
            pstmt = con.prepareStatement("SELECT * FROM classGroup");
            rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                pstmt = con.prepareStatement("SELECT * FROM classGroupStudents where classGroupID = "+id);
                ResultSet rs1 = pstmt.executeQuery();
                ArrayList<Student> classStudents = new ArrayList<>();
                while (rs1.next()){
                    int studentID = rs1.getInt(3);
                    pstmt = con.prepareStatement("SELECT * FROM student where id = "+studentID);
                    ResultSet rs2 = pstmt.executeQuery();
                    rs2.next();
                    int personID = rs2.getInt(3);
                    String dob = rs2.getString(2);
                    pstmt = con.prepareStatement("SELECT * FROM person where id = "+personID);
                    ResultSet rs3 = pstmt.executeQuery();
                    rs3.next();
                    String email = rs3.getString(2);
                    int phoneNumber = rs3.getInt(3);
                    int i = 0;
                    while (i<students.size()){
                        Student temp = students.get(i);
                        if(temp.getEmail().equals(email) && phoneNumber == temp.getPhoneNumber()&& dob.equals(temp.getDob()) ){
                            classStudents.add(temp);
                        }
                        i++;
                    }
                }
                ClassGroup cg = new ClassGroup(name,classStudents);
                classGroups.add(cg);

            }
            rs.close();
            pstmt.close();
            //add school
            pstmt = con.prepareStatement("SELECT * FROM School");
            rs = pstmt.executeQuery();
            while(rs.next()){
                String name = rs.getString(1);
                String address = rs.getString(2);
                School s = new School(name,address,teachers,classGroups);
                schools.add(s);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void uploadList(ArrayList list){
        String res = "";
        int i = 0;
        while(i<list.size()){
            res = uploadObject(list.get(i));
            System.out.println(res);
            i++;
        }
    }
    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<ModuleGrade> getModuleGrades() {
        return moduleGrades;
    }

    public ArrayList<ClassGroup> getClassGroups() {
        return classGroups;
    }

    public ArrayList<School> getSchools() {
        return schools;
    }
    public void clear(){
        try {
            stmt = con.createStatement();
            String SQLString = "drop table studentModules;";
            stmt.executeUpdate(SQLString);
            SQLString = "drop table classGroupStudents;";
            stmt.executeUpdate(SQLString);
            SQLString = "drop table moduleGrades;";
            stmt.executeUpdate(SQLString);
            SQLString = "drop table student;";
            stmt.executeUpdate(SQLString);
            SQLString = "drop table degrees;";
            stmt.executeUpdate(SQLString);
            SQLString = "drop table teacher;";
            stmt.executeUpdate(SQLString);
            SQLString = "drop table person;";
            stmt.executeUpdate(SQLString);
            SQLString = "drop table name;";
            stmt.executeUpdate(SQLString);
            SQLString = "drop table school;";
            stmt.executeUpdate(SQLString);
            SQLString = "drop table classgroup;";
            stmt.executeUpdate(SQLString);

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
