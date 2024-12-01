package question2;

public class FactoryCourse {


    public Course createCourse(String name, int number, User practitioner, User lecturer, CourseType type) {
        switch (type) {
            case SEMINAR:
                return new SeminarCourse(name, number, practitioner, lecturer);

            case ELECTIVE:
                return new ElectiveCourse(name, number,practitioner, lecturer);

            case REQUIRED:
                return new RequiredCourse(name, number, practitioner, lecturer);

        }
        return null;

    }

}
