package il.ac.haifa.cs.sweng.HelloHibernate.entities;
import java.util.*;

public class Student extends User {

    ArrayList<Course> Courses;
    ArrayList<Grade> Grades;
    public Student(String name, String id, String pass){
        super(name, id, pass);
        this.Courses = null;
        this.Grades = null;
    }
}
