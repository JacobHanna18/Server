package il.ac.haifa.cs.sweng.HelloHibernate.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "students")
public class Student extends User {

    ArrayList<Course> Courses;
    ArrayList<Grade> Grades;
    public Student(String name, String id, String pass){
        super(name, id, pass);
        this.Courses = null;
        this.Grades = null;
    }
}
