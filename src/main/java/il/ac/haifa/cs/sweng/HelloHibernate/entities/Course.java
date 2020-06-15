package il.ac.haifa.cs.sweng.HelloHibernate.entities;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Subject_id")
    Subject subject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Teacher_id")
    Teacher teacher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Exam_id")
    Exam exam;
    int AccessCode;
    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = Student.class
    )
    @JoinTable(
            name = "Students_Courses",
            joinColumns = @JoinColumn(name = "Course_id"),
            inverseJoinColumns = @JoinColumn(name = "Student_id")
    )
    ArrayList<Student> students;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    ArrayList<Grade> grades;

    public Course(Subject subject, Teacher teacher, Exam exam, int accessCode) {
        this.subject = subject;
        this.teacher = teacher;
        this.exam = exam;
        AccessCode = accessCode;
        this.students = null;
        this.grades = null;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getAccessCode() {
        return AccessCode;
    }

    public void setAccessCode(int accessCode) {
        AccessCode = accessCode;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void AddStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void AddGrade(Grade grade) {
        grades.add(grade);
    }
}
