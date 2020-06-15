package il.ac.haifa.cs.sweng.HelloHibernate.entities;
import java.util.*;

public class Teacher extends  User{

    ArrayList<Course> Courses ;
    public Teacher(String name, String id, String pass){
        super(name, id, pass);
        this.Courses = null;
    }
}
