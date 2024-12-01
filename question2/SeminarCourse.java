package question2;


class SeminarCourse extends Course {




    public SeminarCourse(String name, int courseNumber,User teacher, User lecturer) {
        super(name, courseNumber, teacher, lecturer, CourseType.SEMINAR);
    }

    @Override
    public String getType() {
        return "Seminar";
    }
}



