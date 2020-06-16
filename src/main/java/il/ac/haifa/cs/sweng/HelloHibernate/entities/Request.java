package il.ac.haifa.cs.sweng.HelloHibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "requests")
public class Request {
    int timeAdded;
    String explaination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Course_id")
    Course course;
}
