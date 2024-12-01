package question2;

import javax.swing.*;
import java.util.*;

public class RegistrationSystem {
    private static RegistrationSystem instance = null;

    private HashMap<String, String> registerUsers = new HashMap<String, String>();
    private HashMap<String, String> allactive = new HashMap<String, String>();
    private HashMap<Integer, Course> allCourse = new HashMap<Integer, Course>();
    static int numberOfActiveUsers;
    String nameOfUniversity;
    private final int MAX_ACTIVE = 100;
    private final int MAX_REGISTER_FOR_COURSE = 50;


    private RegistrationSystem(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }
    public static RegistrationSystem getInstance(String nameOfUniversity) {
        if (instance == null) {
            instance = new RegistrationSystem(nameOfUniversity);
        }
        return instance;
    }


    public User registerToSystem(String name, String id, String password, String type) {
        if (registerUsers.containsKey(id)) {
            System.out.println("User with id " + id + " already exists");
            return null;
        } else {
            if (type.equals("student")) {
                System.out.println(name +"register successfully");
                registerUsers.put(id, password);
                return new Student(name, id, password);
            } else if (type.equals("lecturer")) {
                System.out.println(name +"register successfully");
                registerUsers.put(id, password);
                return new Lecturer(name, id, password);
            } else if (type.equals("practitioner")) {
                System.out.println(name +"register successfully");
                registerUsers.put(id, password);
                return new Practitioner(name, id, password);
            }
        }
        return null;
    }

    public void unregisterFromSystem(String id) {
        if (registerUsers.containsKey(id)) {
            registerUsers.remove(id);
            if(allactive.containsKey(id)) {
                allactive.remove(id);
            }

        }
    }

    public void logIntoSystem(String id, String password) {

        if (registerUsers.containsKey(id)) {
            if (!registerUsers.get(id).equals(password)) {
                System.out.println("your password is incorrect");
            } else {
                if (numberOfActiveUsers < MAX_ACTIVE) {
                    numberOfActiveUsers++;
                    allactive.put(id, password);
                    System.out.println("log in successful");

                }
                else
                    System.out.println("there are too many active users");

            }
        }
    }
    public void logOutOfSystem(String id) {
        if (registerUsers.containsKey(id)&& allactive.containsKey(id)) {
            numberOfActiveUsers--;
            allactive.remove(id);
            System.out.println("log out successful");
        }
    }



    public Course addCourse(User user, String name, int courseNumber, User practitioner, User lecturer, CourseType courseType) {


        if(!allactive.containsKey(user.getID())) {

            System.out.println(user.getID()+"you did not log in");
            return null;

        }
        if ((user instanceof Practitioner || user instanceof Lecturer)&& allactive.containsKey(user.getID())) {
            if(allCourse.containsKey(courseNumber)){
                System.out.println("Course" + courseNumber + " already exists");
                return allCourse.get(courseNumber);
            }
            else
            {
                Course course3= ((UniWorker) user).createCource(name, courseNumber, practitioner, lecturer, courseType);
                allCourse.put(courseNumber, course3);
                return course3;
            }
        }
        System.out.println("cannot add course");
        return null;
    }

    public void removeCourse(User user, Course course) {
        if(!allactive.containsKey(user.getID())) {

            System.out.println(user.getID()+"you did not log in");
            return;
        }
        if ((user instanceof Practitioner || user instanceof Lecturer)&& allactive.containsKey(user.getID())) {
            if(allCourse.containsKey(course.getCourseNumber())) {
                allCourse.remove(course.getCourseNumber());
                System.out.println("Course" + course.getCourseNumber() + " is delete");

        }
            else {
                System.out.println("cannot delete course because its not exists");
            }
        }
    }

    public void registerToCourse(User student,Course course) {
        if(!allactive.containsKey(student.getID())) {
            System.out.println(student.getID()+"you did not log in");
            return;
        }
        if (student instanceof Student) {
            if (!allactive.containsKey(student.getID()))
                return;
           // System.out.println("getNunberOfRegister"+course.getNunberOfRegister()+"max"+MAX_REGISTER_FOR_COURSE);
            if(!allCourse.containsKey(course.getCourseNumber())) {
                System.out.println("there is no course with this number");
                return;
            }

            if (course.getNunberOfRegister() >= MAX_REGISTER_FOR_COURSE) {
                System.out.println("course already  full for new registeration, we're adding you to a waiting list for this course");
                course.addObserver((Student) student);
                return;
            }
            course.addRegister((Student) student);
        }

    }
    public void unregisterFromCourse( User student,Course course) {
        if(!allactive.containsKey(student.getID())) {
            System.out.println(student.getID() + "you did not log in");
            return;
        }
         if (student != null && course != null) {
             if (course.getNunberOfRegister() == MAX_REGISTER_FOR_COURSE) {
                 course.setOnelessStudante((Student) student);
                 return;
             }
             course.removeFromRegistered((Student) student);
         }
    }
    public void printAllCourses(){
        for(Course course: allCourse.values()) {
            course.Print();
        }
    }
    public void printAllactive() {
        for (Map.Entry<String, String> entry : allactive.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("User ID: " + key + ", Password: " + value);
        }
    }
    public void printAllUsers() {
        for (Map.Entry<String, String> entry : registerUsers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("User ID: " + key + ", Password: " + value);
        }
    }

}