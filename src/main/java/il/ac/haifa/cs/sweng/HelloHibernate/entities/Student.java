package il.ac.haifa.cs.sweng.HelloHibernate.entities;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "students")
public class Student extends User {

    @ManyToMany(mappedBy = "students",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = Course.class
    )
    ArrayList<Course> Courses;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    ArrayList<Grade> Grades;
    public Student(String name, String id, String pass){
        super(name, id, pass);
        this.Courses = null;
        this.Grades = null;
    }
}
