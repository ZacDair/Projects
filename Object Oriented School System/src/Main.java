import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        SQL mySQL = new SQL();
        mySQL.connect();
        mySQL.createTables();
        //Populator and uploads only needed when running the first time
        /*Populator myPop = new Populator();
        ArrayList<ModuleGrade> moduleGrades1 = myPop.generateModules();
        ArrayList<Student> students1 = myPop.generateStudents();
        ArrayList<Teacher> teachers1 = myPop.generateTeachers();
        ArrayList<ClassGroup> classGroups1 = myPop.generateClassGroups();
        School mySchool = myPop.generateSchool();
        mySQL.uploadList(moduleGrades1);
        mySQL.uploadList(teachers1);
        mySQL.uploadList(students1);
        mySQL.uploadList(classGroups1);
        mySQL.uploadObject(mySchool);
        */



        //Downloads data
        mySQL.download();
        ArrayList<ModuleGrade> moduleGrades = mySQL.getModuleGrades();
        ArrayList<Teacher> teachers = mySQL.getTeachers();
        ArrayList<Student> students = mySQL.getStudents();
        ArrayList<ClassGroup> classGroups = mySQL.getClassGroups();
        ArrayList<School> schools = mySQL.getSchools();
        Controller myController = new Controller();
        myController.setMaxModules(moduleGrades);
        myController.setMaxStudents(students);
        Pane mainPane = new Pane();
        Label mainWelcomeLabel = new Label("Welcome to the pupil management App");
        Button mainStudentButton = new Button("Manage Students");
        Button editStudentButton = new Button ("Edit Student");
        Button mainClassGroupButton = new Button("Manage Class groups");
        Button mainListStudentsButton = new Button("List Students");
        Button mainListTeachersButton = new Button("List Teachers");
        Button mainTeacherButton = new Button("Manage Teachers");
        Button mainQuitButton = new Button("Quit");
        Button backButton  = new Button("Back to Menu");
        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove");
        Button deleteButton = new Button("Delete");
        TextField inputTextField = new TextField("");
        Button nextButton = new Button("Next");
        Label warningLabel = new Label ("");
        Label inputLabel  = new Label ("");
        Button saveButton = new Button("Save");
        Label outputLabel = new Label ("");
        Button nextEditButton = new Button("Next");
        Button addModuleButton = new Button("Add Module");
        Button removeModuleButton = new Button("Remove Module");
        Button addGradeButton = new Button("Add a grade");
        Button saveEditButton = new Button("Save");
        Button removeMButton = new Button("Remove");
        Button addGradeToModuleButton = new Button ("Add grade");
        Button saveNewGradeButton = new Button ("Save Grade");

        //set warning label font color
        warningLabel.setTextFill(Color.web("#FF0000"));

        //set welcome label font details
        mainWelcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));


        //set sizes
        mainWelcomeLabel.setPrefHeight(50);
        mainStudentButton.setPrefWidth(200);
        mainClassGroupButton.setPrefWidth(200);
        mainTeacherButton.setPrefWidth(200);
        mainListStudentsButton.setPrefWidth(200);
        mainListTeachersButton.setPrefWidth(200);
        backButton.setPrefWidth(200);
        mainQuitButton.setPrefWidth(150);
        addButton.setPrefWidth(150);
        removeButton.setPrefWidth(150);
        inputTextField.setPrefWidth(200);
        nextButton.setPrefWidth(100);
        saveButton.setPrefWidth(200);
        deleteButton.setPrefWidth(200);
        editStudentButton.setPrefWidth(150);
        nextEditButton.setPrefWidth(200);
        addGradeButton.setPrefWidth(200);
        addModuleButton.setPrefWidth(200);
        removeModuleButton.setPrefWidth(200);
        saveEditButton.setPrefWidth(200);
        removeMButton.setPrefWidth(200);
        addGradeToModuleButton.setPrefWidth(200);
        saveNewGradeButton.setPrefWidth(200);

        //set main component layout
        mainWelcomeLabel.setLayoutX(180);
        mainStudentButton.setLayoutY(100);
        mainClassGroupButton.setLayoutY(150);
        mainTeacherButton.setLayoutY(200);
        mainListStudentsButton.setLayoutX(400);
        mainListStudentsButton.setLayoutY(100);
        mainListTeachersButton.setLayoutX(400);
        mainListTeachersButton.setLayoutY(150);
        mainQuitButton.setLayoutX(450);
        mainQuitButton.setLayoutY(350);
        addButton.setLayoutY(100);
        removeButton.setLayoutY(200);
        inputLabel.setLayoutY(80);
        inputTextField.setLayoutY(100);
        warningLabel.setLayoutY(130);
        nextButton.setLayoutX(200);
        nextButton.setLayoutY(100);
        nextEditButton.setLayoutX(200);
        nextEditButton.setLayoutY(100);
        saveButton.setLayoutX(400);
        saveButton.setLayoutY(100);
        deleteButton.setLayoutX(400);
        deleteButton.setLayoutY(100);
        outputLabel.setLayoutX(400);
        outputLabel.setLayoutY(150);
        editStudentButton.setLayoutY(150);
        addModuleButton.setLayoutY(100);
        removeModuleButton.setLayoutY(150);
        addGradeButton.setLayoutY(200);
        saveEditButton.setLayoutX(400);
        saveEditButton.setLayoutY(100);
        removeMButton.setLayoutX(400);
        removeMButton.setLayoutY(100);
        addGradeToModuleButton.setLayoutX(200);
        addGradeToModuleButton.setLayoutY(100);
        saveNewGradeButton.setLayoutX(400);
        saveNewGradeButton.setLayoutY(100);

        //set manage student layout
        backButton.setLayoutY(350);

        //add all main buttons to main pane
        mainPane.getChildren().addAll(mainWelcomeLabel,mainStudentButton,mainTeacherButton,mainClassGroupButton,
                mainListStudentsButton,mainListTeachersButton, mainQuitButton);

        primaryStage.setTitle("Pupil Management");
        primaryStage.setScene(new Scene(mainPane, 600, 400));
        primaryStage.show();

        //Event Handlers
        mainStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainWelcomeLabel.setText("You can Manage Students here");
                mainPane.getChildren().removeAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                        mainListStudentsButton,mainListTeachersButton, mainQuitButton);
                mainPane.getChildren().addAll(backButton,addButton,removeButton,editStudentButton);
            }
        });
        mainTeacherButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainWelcomeLabel.setText("You can Manage Teachers here");
                mainPane.getChildren().removeAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                        mainListStudentsButton,mainListTeachersButton, mainQuitButton);
                mainPane.getChildren().addAll(backButton,addButton,removeButton);

            }
        });
        mainClassGroupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainWelcomeLabel.setText("You can Manage Class Groups here");
                mainPane.getChildren().removeAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                        mainListStudentsButton,mainListTeachersButton, mainQuitButton);
                mainPane.getChildren().addAll(backButton,addButton,removeButton);

            }
        });
        mainListStudentsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainWelcomeLabel.setText("Here is a list of all the students");
                outputLabel.setText(myController.listStudents(students));
                mainPane.getChildren().removeAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                        mainListStudentsButton,mainListTeachersButton, mainQuitButton);
                outputLabel.setLayoutY(40);
                outputLabel.setLayoutX(400);
                mainPane.getChildren().addAll(backButton,outputLabel);

            }
        });
        mainListTeachersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainWelcomeLabel.setText("Here is a list of all the teachers");
                mainPane.getChildren().removeAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                        mainListStudentsButton,mainListTeachersButton, mainQuitButton);
                outputLabel.setLayoutY(40);
                outputLabel.setLayoutX(100);
                mainPane.getChildren().addAll(backButton,outputLabel);
                outputLabel.setText(myController.listTeachers(teachers));

            }
        });
        mainQuitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mySQL.clear();
                mySQL.createTables();
                mySQL.uploadList(moduleGrades);
                mySQL.uploadList(teachers);
                mySQL.uploadList(students);
                mySQL.uploadList(classGroups);
                mySQL.uploadList(schools);
                System.exit(0);
            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainWelcomeLabel.setText("Welcome to the pupil management App");
                warningLabel.setText("");
                inputLabel.setText("");
                outputLabel.setText("");
                outputLabel.setLayoutY(150);
                myController.clearInputtedAttributes();
                myController.setCount(0);
                myController.setLoop(false);
                myController.setValid(true);
                myController.clearStudentToEdit();
                mainPane.getChildren().removeAll(backButton,addButton,removeButton,warningLabel,inputLabel,saveButton,
                        nextButton,outputLabel,inputTextField,deleteButton,editStudentButton,nextEditButton,addGradeButton,
                        addModuleButton,saveEditButton,removeModuleButton,removeMButton,addGradeToModuleButton,saveNewGradeButton);
                mainPane.getChildren().addAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                        mainListStudentsButton,mainListTeachersButton, mainQuitButton);
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                myController.setStatus(mainWelcomeLabel.getText());
                switch (myController.getStatus()){
                    //Case 1 add students
                    case 1 :{
                        mainWelcomeLabel.setText("Fill out the required information to add a Student");
                        inputLabel.setText("Please enter the student's First Name here:");
                        mainPane.getChildren().removeAll(addButton,removeButton,editStudentButton);
                        mainPane.getChildren().addAll(inputTextField,nextButton,warningLabel,inputLabel);
                        break;
                    }
                    //Case 2 add teachers
                    case 2 :{
                        mainWelcomeLabel.setText("Fill out the required information to add a Teacher");
                        inputLabel.setText("Please enter the teacher's First Name here:");
                        mainPane.getChildren().removeAll(addButton,removeButton);
                        mainPane.getChildren().addAll(inputTextField,nextButton,warningLabel,inputLabel);
                        break;
                    }
                    //Case 3 add class groups
                    case 3 :{
                        mainWelcomeLabel.setText("Fill out the required information to add a Class Group");
                        inputLabel.setText("Please enter the " + myController.changeInputText() + " :");
                        mainPane.getChildren().removeAll(addButton,removeButton);
                        mainPane.getChildren().addAll(inputTextField,nextButton,warningLabel,inputLabel);
                        break;
                    }
                }


            }
        });
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                myController.setStatus(mainWelcomeLabel.getText());
                switch (myController.getStatus()){
                    //Case 1 remove students
                    case 1 :{
                        mainWelcomeLabel.setText("Fill out the required information to remove a Student");
                        inputLabel.setText("Please enter the number corresponding to the student to remove :");
                        outputLabel.setText(myController.showAllStudents(students));
                        mainPane.getChildren().removeAll(addButton,removeButton,editStudentButton);
                        mainPane.getChildren().addAll(inputLabel,inputTextField,warningLabel,deleteButton,outputLabel);
                        break;
                    }
                    //Case 2 remove teachers
                    case 2 :{
                        mainWelcomeLabel.setText("Fill out the required information to remove a Teacher");
                        inputLabel.setText("Please enter the number corresponding to the Teacher to remove :");
                        outputLabel.setText(myController.listTeachers(teachers));
                        mainPane.getChildren().removeAll(addButton,removeButton);
                        mainPane.getChildren().addAll(inputLabel,inputTextField,warningLabel,deleteButton,outputLabel);
                        break;
                    }
                    //Case 3 remove class groups
                    case 3 :{
                        mainWelcomeLabel.setText("Fill out the required information to remove a Class Groups");
                        inputLabel.setText("Please enter the number corresponding to the class group to remove :");
                        outputLabel.setText(myController.showAllClassGroups(classGroups));
                        mainPane.getChildren().removeAll(addButton,removeButton);
                        mainPane.getChildren().addAll(inputLabel,inputTextField,warningLabel,deleteButton,outputLabel);
                        break;
                    }
                }
            }
        });
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                warningLabel.setText(myController.checkInput(inputTextField.getText()));
                if(myController.getIsValid()) {
                    switch (myController.getStatus()) {
                        case 1: {
                            if(myController.getCount() == 5 && !myController.getLoop()) {
                                myController.storeAttributes(inputTextField.getText());
                                inputLabel.setText("Please choose a Module to add or click save");
                                if(!mainPane.getChildren().contains(outputLabel)){
                                    mainPane.getChildren().add(outputLabel);
                                }
                                if(!mainPane.getChildren().contains(saveButton)){
                                    mainPane.getChildren().add(saveButton);
                                }
                                outputLabel.setText(myController.showAllModules(moduleGrades));
                                inputTextField.setText("");
                                myController.setLoop(true);
                            }
                            else if(myController.getLoop()){
                                if(myController.getModuleGradeArrayList().size() == 6 ){
                                    inputLabel.setText("Please press save to add that student to the system");
                                    mainPane.getChildren().removeAll(inputTextField,nextButton);
                                }
                                else {
                                    inputLabel.setText("Please choose a Module to add or click save");
                                    myController.addModules(moduleGrades, Integer.parseInt(inputTextField.getText()) - 1);
                                    inputTextField.setText("");
                                    if (!mainPane.getChildren().contains(outputLabel)) {
                                        mainPane.getChildren().add(outputLabel);
                                    }
                                    if (!mainPane.getChildren().contains(saveButton)) {
                                        mainPane.getChildren().add(saveButton);
                                    }
                                }
                            }
                            else {
                                inputLabel.setText("Please enter the student's "+myController.changeInputText()+" here:");
                                myController.storeAttributes(inputTextField.getText());
                                inputTextField.setText("");

                            }
                            break;
                        }
                        case 2: {
                            if(myController.getCount() == 4 && !myController.getLoop()) {
                                myController.storeAttributes(inputTextField.getText());
                                inputLabel.setText("Please enter a degree to add or click save");
                                if(!mainPane.getChildren().contains(outputLabel)){
                                    mainPane.getChildren().add(outputLabel);
                                }
                                if(!mainPane.getChildren().contains(saveButton)){
                                    mainPane.getChildren().add(saveButton);
                                }
                                inputTextField.setText("");
                                myController.setLoop(true);
                            }
                            else if(myController.getLoop()){
                                inputLabel.setText("Please enter a degree to add or click save");
                                myController.addDegrees((inputTextField.getText()));
                                inputTextField.setText("");
                                if (!mainPane.getChildren().contains(outputLabel)) {
                                    mainPane.getChildren().add(outputLabel);
                                }
                                if (!mainPane.getChildren().contains(saveButton)) {
                                    mainPane.getChildren().add(saveButton);
                                }
                            }
                            else {
                                inputLabel.setText("Please enter the teacher's "+myController.changeInputText()+" here:");
                                myController.storeAttributes(inputTextField.getText());
                                inputTextField.setText("");
                            }
                            break;
                        }
                        case 3: {
                            if(myController.getCount() == 0 && !myController.getLoop()) {
                                myController.storeAttributes(inputTextField.getText());
                                inputLabel.setText("Please choose a student to add or click save");
                                if(!mainPane.getChildren().contains(outputLabel)){
                                    mainPane.getChildren().add(outputLabel);
                                }
                                if(!mainPane.getChildren().contains(saveButton)){
                                    mainPane.getChildren().add(saveButton);
                                }
                                outputLabel.setText(myController.showAllStudents(students));
                                inputTextField.setText("");
                                myController.setLoop(true);
                            }
                            else if(myController.getLoop()){
                                inputLabel.setText("Please choose a student to add or click save");
                                myController.addStudents(students,Integer.parseInt(inputTextField.getText())-1);
                                inputTextField.setText("");
                                if (!mainPane.getChildren().contains(outputLabel)) {
                                    mainPane.getChildren().add(outputLabel);
                                }
                                if (!mainPane.getChildren().contains(saveButton)) {
                                    mainPane.getChildren().add(saveButton);
                                }
                            }
                            else {
                                inputLabel.setText("Please enter the "+myController.changeInputText()+" here:");
                                myController.storeAttributes(inputTextField.getText());
                                inputTextField.setText("");
                            }
                            break;
                        }
                    }
                    myController.addToCount();
                }

            }
        });
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch(myController.getStatus()){
                    case 1:{
                        Student res = myController.createStudent();
                        System.out.println("The student added is:");
                        System.out.println("First Name: "+res.getName().getFirstName());
                        System.out.println("Middle Name: "+res.getName().getMiddleName());
                        System.out.println("Last Name: "+res.getName().getLastName());
                        System.out.println("Email: "+res.getEmail());
                        System.out.println("Phone Number: "+res.getPhoneNumber());
                        System.out.println("DOB: "+res.getDob());
                        int i =0;
                        ArrayList<ModuleGrade> resModules = res.getModuleGrades();
                        while (i < res.getModuleGrades().size()){
                            System.out.println("Module "+i+") is "+resModules.get(i).getModuleName());
                            i++;
                        }
                        students.add(res);
                        break;
                    }
                    case 2:{
                        Teacher res = myController.createTeacher();
                        System.out.println("The teacher added is:");
                        System.out.println("First Name: "+res.getName().getFirstName());
                        System.out.println("Middle Name: "+res.getName().getMiddleName());
                        System.out.println("Last Name: "+res.getName().getLastName());
                        System.out.println("Email: "+res.getEmail());
                        System.out.println("Phone Number: "+res.getPhoneNumber());
                        int i =0;
                        ArrayList<String> resDegrees = res.getDegrees();
                        while (i < resDegrees.size()){
                            System.out.println("Degree "+i+") is "+resDegrees.get(i));
                            i++;
                        }
                        teachers.add(res);
                        break;
                    }
                    case 3:{
                        ClassGroup res  = myController.createClassGroup();
                        System.out.println("The class group added is:");
                        System.out.println("First Name: "+res.getGroupName());
                        System.out.println("It contains "+res.getStudents().size()+" students");
                        int i = 0;
                        while (i < res.getStudents().size()){
                            Student temp = res.getStudents().get(i);
                            Name tempName = temp.getName();
                            System.out.println("Student "+(i+1)+" is "+tempName.getFirstName()+" "+
                                    tempName.getMiddleName()+" "+tempName.getLastName());
                            i++;
                        }
                        classGroups.add(res);
                        break;
                    }
                }
                mainWelcomeLabel.setText("Welcome to the pupil management App");
                warningLabel.setText("");
                inputLabel.setText("");
                outputLabel.setText("");
                inputTextField.setText("");
                myController.clearInputtedAttributes();
                myController.setCount(0);
                myController.setLoop(false);
                myController.setValid(true);
                mainPane.getChildren().removeAll(backButton,addButton,removeButton,warningLabel,inputLabel,saveButton,nextButton,outputLabel,inputTextField);
                mainPane.getChildren().addAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                        mainListStudentsButton,mainListTeachersButton, mainQuitButton);

            }
        });
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                warningLabel.setText(myController.checkRemoveInput(inputTextField.getText()));
                if (myController.getIsValid()) {
                    switch (myController.getStatus()) {
                        case 1: {
                            myController.removeFromList(students, Integer.parseInt(inputTextField.getText()));

                            break;
                        }
                        case 2: {
                             myController.removeFromList(teachers,Integer.parseInt(inputTextField.getText()));
                            break;
                        }
                        case 3: {
                             myController.removeFromList(classGroups,Integer.parseInt(inputTextField.getText()));
                            break;
                        }
                    }
                    mainWelcomeLabel.setText("Welcome to the pupil management App");
                    warningLabel.setText("");
                    inputLabel.setText("");
                    outputLabel.setText("");
                    inputTextField.setText("");
                    myController.setValid(true);
                    mainPane.getChildren().removeAll(backButton, addButton, removeButton, warningLabel, inputLabel, saveButton, nextButton, outputLabel, inputTextField, deleteButton);
                    mainPane.getChildren().addAll(mainStudentButton, mainTeacherButton, mainClassGroupButton,
                            mainListStudentsButton, mainListTeachersButton, mainQuitButton);
                }
            }
        });
        editStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainWelcomeLabel.setText("Here you can edit modules and add grades");
                inputLabel.setText("Choose a student from the list");
                outputLabel.setText(myController.listStudents(students));
                mainPane.getChildren().addAll(inputLabel,inputTextField,outputLabel,warningLabel,nextEditButton);
                mainPane.getChildren().removeAll(addButton,editStudentButton,removeButton);
            }
        });
        nextEditButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                warningLabel.setText(myController.checkRemoveInput(inputTextField.getText()));
                if (myController.getIsValid()) {
                    myController.setStudentToEdit(Integer.parseInt(inputTextField.getText()),students);
                    inputLabel.setText("Now do you want to add a module, remove a module or add grades");
                    mainPane.getChildren().addAll(addModuleButton,removeModuleButton,addGradeButton);
                    mainPane.getChildren().removeAll(inputTextField,outputLabel,warningLabel,nextEditButton);
                    inputTextField.setText("");
                }
            }
        });
        addModuleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inputLabel.setText("Choose a module to add");
                mainPane.getChildren().addAll(inputTextField,saveEditButton,outputLabel,warningLabel);
                mainPane.getChildren().removeAll(addGradeButton,addModuleButton,removeModuleButton);
                outputLabel.setText(myController.showAllModules(moduleGrades));
            }
        });
        removeModuleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inputLabel.setText("Choose a module to remove");
                mainPane.getChildren().addAll(inputTextField,saveEditButton,outputLabel,warningLabel,removeMButton);
                mainPane.getChildren().removeAll(addGradeButton,addModuleButton,removeModuleButton);
                outputLabel.setText(myController.showAllModules(myController.getStudentToEdit().getModuleGrades()));
            }
        });
        addGradeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inputLabel.setText("Choose a module to add a grade to");
                mainPane.getChildren().addAll(inputTextField,outputLabel,warningLabel,addGradeToModuleButton);
                mainPane.getChildren().removeAll(addGradeButton,addModuleButton,removeModuleButton);
                outputLabel.setText(myController.showAllModules(myController.getStudentToEdit().getModuleGrades()));
            }
        });
        addGradeToModuleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                warningLabel.setText(myController.checkRemoveInput(inputTextField.getText()));
                if (myController.getIsValid()) {
                    myController.setModuleGradeToEdit(Integer.parseInt(inputTextField.getText()),myController.getStudentToEdit().getModuleGrades());
                    inputLabel.setText("What Grade would you like to set to this module");
                    inputTextField.setText("");
                    mainPane.getChildren().removeAll(addGradeToModuleButton);
                    mainPane.getChildren().addAll(saveNewGradeButton);
                }
            }
        });
        saveNewGradeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                warningLabel.setText(myController.checkRemoveInput(inputTextField.getText()));
                if (myController.getIsValid()) {
                    myController.getModuleGradeToEdit().setGrade(Integer.parseInt(inputTextField.getText()));
                    System.out.println(myController.getModuleGradeToEdit().getModuleName()+" has it's grade been set to "
                            +myController.getModuleGradeToEdit().getGrade());
                    mainWelcomeLabel.setText("Welcome to the pupil management App");
                    warningLabel.setText("");
                    inputLabel.setText("");
                    outputLabel.setText("");
                    inputTextField.setText("");
                    myController.clearStudentToEdit();
                    myController.clearModuleGradeToEdit();
                    myController.setValid(true);
                    mainPane.getChildren().removeAll(warningLabel,inputLabel,outputLabel,inputTextField,saveNewGradeButton,backButton);
                    mainPane.getChildren().addAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                            mainListStudentsButton,mainListTeachersButton, mainQuitButton);

                }
            }
        });
        removeMButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                warningLabel.setText(myController.checkRemoveInput(inputTextField.getText()));
                if (myController.getIsValid()) {
                    myController.getStudentToEdit().removeModuleGrade(Integer.parseInt(inputTextField.getText())-1);
                    mainWelcomeLabel.setText("Welcome to the pupil management App");
                    warningLabel.setText("");
                    inputLabel.setText("");
                    outputLabel.setText("");
                    inputTextField.setText("");
                    myController.clearStudentToEdit();
                    myController.setValid(true);
                    mainPane.getChildren().removeAll(warningLabel,inputLabel,outputLabel,inputTextField,editStudentButton,nextEditButton,addGradeButton,
                            addModuleButton,saveEditButton,removeModuleButton,backButton,removeMButton);
                    mainPane.getChildren().addAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                            mainListStudentsButton,mainListTeachersButton, mainQuitButton);
                }
            }
        });
        saveEditButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                warningLabel.setText(myController.checkRemoveInput(inputTextField.getText()));
                if (myController.getIsValid()) {
                    myController.getStudentToEdit().addModuleGrade(moduleGrades.get(Integer.parseInt(inputTextField.getText())));
                    mainWelcomeLabel.setText("Welcome to the pupil management App");
                    warningLabel.setText("");
                    inputLabel.setText("");
                    outputLabel.setText("");
                    inputTextField.setText("");
                    myController.clearStudentToEdit();
                    myController.setValid(true);
                    mainPane.getChildren().removeAll(warningLabel,inputLabel,outputLabel,inputTextField,editStudentButton,nextEditButton,addGradeButton,
                            addModuleButton,saveEditButton,removeModuleButton,backButton);
                    mainPane.getChildren().addAll(mainStudentButton,mainTeacherButton,mainClassGroupButton,
                            mainListStudentsButton,mainListTeachersButton, mainQuitButton);
                }

            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
