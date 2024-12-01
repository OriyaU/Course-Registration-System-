package question2;

import java.util.HashMap;
import java.util.List;

public class Student implements User ,Observer {
    private HashMap<String, String> allStudents=new HashMap<String,String>();
    private String name;
    private String password;
    private String id;

    public Student(String name, String id, String password) {

                this.name = name;
                this.password = password;
                this.id = id;
                allStudents.put(id, password);
    }

    public void print(){
        System.out.println("ID Student"+this.id+" Password"+this.password);
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getID() {
        return this.id;
    }


    @Override
    public void update(String d) {
        System.out.println("New massage for"+this.name+" "+d);

    }

}
