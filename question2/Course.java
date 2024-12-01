package question2;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public abstract class Course implements Subject{

    protected String name;
    protected int courseNumber;
    private User practitioner ;
    private User lecturer;
    private CourseType courseType;
    static int NunberOfRegister=0;
    private List<Student> observers = new ArrayList<>();
    private List<Student> allreadyRegister= new ArrayList<>();




    public Course(String name, int courseNumber, User practitioner, User lecturer, CourseType courseType) {
        this.name = name;
        this.courseNumber = courseNumber;
        this.practitioner = practitioner;
        this.lecturer = lecturer;
        this.courseType = courseType;


    }

    public abstract String getType();

    public String getName() {
        return name;
    }
    public void addRegister(Student student){
        if(!allreadyRegister.contains(student)) {
            if(observers.contains(student)) {
                observers.remove(student);
            }
            allreadyRegister.add(student);
            NunberOfRegister++;
            this.courseNumber = NunberOfRegister + 1;
            //student.print();
        }
    }

    public int getCourseNumber() {
        return courseNumber;
    }
    public User getTeacher() {
        return practitioner;
    }
    public User getLecturer() {
        return lecturer;
    }
    public  void removeFromRegistered(Student student){
        allreadyRegister.remove(lecturer);
        this.courseNumber=NunberOfRegister-1;

    }
    public int getNunberOfRegister() {
        return (NunberOfRegister);
    }
    public void Print()
    {

        System.out.println("Name: " + this.name+ " lecturer "+this.lecturer.getName()+ " practitioner "+this.practitioner.getName()+" Type "+this.courseType);

    }
    @Override
    public void addObserver(Student observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Student observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Student observer : observers) {
            observer.update("new update for course your interested in"+this.courseNumber+" "+this.name+"you have available place in the course. ");
        }
    }

    public void setOnelessStudante(Student student) {
        if(!this.allreadyRegister.contains(student))
            return;
        NunberOfRegister=NunberOfRegister-1;
        this.allreadyRegister.remove(student);
        notifyObservers();
    }
    public void printAllRegister(){

        for(Student student:allreadyRegister){
            student.print();
        }
    }

}

