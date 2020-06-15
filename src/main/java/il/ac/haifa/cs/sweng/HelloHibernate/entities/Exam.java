package il.ac.haifa.cs.sweng.HelloHibernate.entities;
import java.util.*;

public class Exam {
    ArrayList<Question> Questions;
    Subject subject;
    int Id;

    public Exam(Subject subject, int id) {
        this.Questions = null;
        this.subject = subject;
        Id = id;
    }

    public ArrayList<Question> getQuestions() {
        return Questions;
    }

    public void AddQuestions(Question question) {
        Questions.add(question);
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
