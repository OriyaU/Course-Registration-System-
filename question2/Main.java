package question2;

import static question2.CourseType.ELECTIVE;
import static question2.CourseType.REQUIRED;

public class Main {
    public static void main(String[] args) {


        RegistrationSystem ArielUniversity=RegistrationSystem.getInstance("Ariel University");
        RegistrationSystem bla=RegistrationSystem.getInstance("Bla");
        if(ArielUniversity ==bla)
            System.out.println("it is Singelton");
        User lecturer1=ArielUniversity.registerToSystem("moshe cam", "2136287","123","lecturer");
        User practitioner1=ArielUniversity.registerToSystem("moshe pre","2136289", "133","practitioner");
        User lecturer2=ArielUniversity.registerToSystem("Dany cam", "2136254","2136254","lecturer");
        User practitioner2=ArielUniversity.registerToSystem("Dany pre","2132459", "155","practitioner");

        ArielUniversity.printAllUsers();
        ArielUniversity.logIntoSystem("2136287", "123");
        ArielUniversity.logIntoSystem("2132459","155");
        ArielUniversity.printAllactive();
        Course algo=ArielUniversity.addCourse(lecturer1,"Algo",111,practitioner1,lecturer1,ELECTIVE);
        Course opp=ArielUniversity.addCourse(lecturer1,"Opp",222,practitioner2,lecturer2,REQUIRED);
        Course algo2=ArielUniversity.addCourse(lecturer1,"Algo",111,practitioner1,lecturer1,ELECTIVE);
        //checking that you cant create two same courses
        if(algo==algo2){
            System.out.println("Algo equals ");
        }


        ArielUniversity.printAllCourses();
        User student1=ArielUniversity.registerToSystem("david nan", "2135266","166", "student");
        ArielUniversity.logIntoSystem("2135266","1666");
        ArielUniversity.logIntoSystem("2135266","166");
        ArielUniversity.registerToCourse(student1,algo);

        User student2=ArielUniversity.registerToSystem("dana ", "21352324","177", "student");
        ArielUniversity.logIntoSystem("21352324","177");
        ArielUniversity.registerToCourse(student2,algo);
        ArielUniversity.logOutOfSystem("2135266");

        User student3=ArielUniversity.registerToSystem("ariye", "21352355","188", "student");

        ArielUniversity.logIntoSystem("21352355","188");
        ArielUniversity.registerToCourse(student3,algo2);
        System.out.println("print all registers");
        algo.printAllRegister();


        ArielUniversity.unregisterFromCourse(student2,algo);
        ArielUniversity.registerToCourse(student3,algo);
        ArielUniversity.unregisterFromCourse(student1,algo);

        ArielUniversity.printAllactive();
        ArielUniversity.unregisterFromSystem("21352355");
        ArielUniversity.printAllCourses();
        ArielUniversity.removeCourse(lecturer1,opp);
        ArielUniversity.printAllCourses();


        Course mavo=ArielUniversity.addCourse(student2,"Mavo",222,practitioner1,lecturer1,ELECTIVE);














    }

}