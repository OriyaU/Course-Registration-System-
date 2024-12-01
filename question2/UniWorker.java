package question2;

public interface UniWorker extends User {

    Course createCource(String name, int courseNumber, User teacher, User lecturer, CourseType courseType);
}
