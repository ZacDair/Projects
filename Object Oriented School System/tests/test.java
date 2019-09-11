import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class test {
    @Test
    void TestEditStudent(){
        Student s = new Student();
        Name n = new Name("Zac","Joeseph","Dair");
        s.setName(n);
        //check first name is now "Zac" as it should be set
        assertEquals("Zac", s.getName().getFirstName());
    }
    @Test
    void TestModuleGrade(){
        //test the module grade constructor
        int i = 0;
        ArrayList<ModuleGrade> moduleGrades = new ArrayList<>();
        while (i < 5){
            ModuleGrade m = new ModuleGrade("Module "+i,0);
            moduleGrades.add(m);
            i++;
        }
        i = 0;
        while(i<moduleGrades.size()){
            assertEquals(moduleGrades.get(i).getModuleName(),"Module "+i);
            i++;
        }
    }
    @Test
    void TestConnection(){
        String output = "Connection failed";
        try {
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", username, password);
            output = "Connection has been made";
        }catch (Exception e){
            System.out.println(e);
        }
        assertEquals(output,"Connection has been made");
    }
}
