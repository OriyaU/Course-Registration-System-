package question2;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;


public class Lecturer implements UniWorker {

    private String name;
    List<Course> courses;
    private String password;
    private String id;
    public Lecturer(String name, String id, String password) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public java.lang.String getPassword() {
        return this.password;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public Course createCource(String name, int courseNumber, User teacher, User lecturer, CourseType courseType) {
        FactoryCourse factory = new FactoryCourse();
        return factory.createCourse(name,courseNumber, teacher, lecturer, courseType);


    }

   // @Override
    public void CancelCource(String name, int courseNumber, Practitioner teacher, Lecturer lecturer, CourseType courseType) {

    }


}
