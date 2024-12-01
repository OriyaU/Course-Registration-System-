package question2;

public class ElectiveCourse extends Course{
    public ElectiveCourse(String name, int courseNumber, User teacher, User lecturer) {
        super(name, courseNumber, teacher, lecturer, CourseType.ELECTIVE);
    }

    @Override
    public String getType() {
        return "ElectiveCourse";
    }

}
