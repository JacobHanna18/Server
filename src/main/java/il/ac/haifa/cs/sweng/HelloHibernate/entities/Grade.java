package il.ac.haifa.cs.sweng.HelloHibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    int grade;

    String changeReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Student_id")
    Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Course_id")
    Course course;


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Grade(int grade, Student student, Course course) {
        this.grade = grade;
        this.student = student;
        this.course = course;
    }
}
