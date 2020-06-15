package il.ac.haifa.cs.sweng.HelloHibernate.entities;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "teachers")
public class Teacher extends  User{

    ArrayList<Course> Courses ;
    public Teacher(String name, String id, String pass){
        super(name, id, pass);
        this.Courses = null;
    }
}
