package question2;

public class RequiredCourse extends Course{


    public RequiredCourse(String name, int courseNumber, User practitioner, User lecturer) {
        super(name, courseNumber, practitioner, lecturer, CourseType.REQUIRED);
    }

    @Override
    public String getType() {
        return "RequiredCourse";
    }


}
