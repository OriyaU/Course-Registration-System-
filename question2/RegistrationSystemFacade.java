package question2;

public interface RegistrationSystemFacade {

    public User registerToSystem(String name, String id, String password, String type);
    public void unregisterFromSystem(String id);
    public void logIntoSystem(String id, String password);
    public void logOutOfSystem(String id);
    public Course addCourse(User user, String name, int courseNumber, User practitioner, User lecturer, CourseType courseType);
    public void removeCourse(User user, Course course) ;
    public void registerToCourse(User student,Course course);
    public void unregisterFromCourse( User student,Course course);
    public void printAllCourses();

}
