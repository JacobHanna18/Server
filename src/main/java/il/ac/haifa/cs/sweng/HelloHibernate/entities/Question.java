package il.ac.haifa.cs.sweng.HelloHibernate.entities;
import java.util.ArrayList;

public class Question {
    String Q;
    String  RightAnswer;
    String WrongAnswer1;
    String WrongAnswer2;
    String WrongAnswer3;
    ArrayList<Exam> exams;

    public Question(String q, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        Q = q;
        RightAnswer = rightAnswer;
        WrongAnswer1 = wrongAnswer1;
        WrongAnswer2 = wrongAnswer2;
        WrongAnswer3 = wrongAnswer3;
        this.exams = null;
    }

    public String getQ() {
        return Q;
    }

    public void setQ(String q) {
        Q = q;
    }

    public String getRightAnswer() {
        return RightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        RightAnswer = rightAnswer;
    }

    public String getWrongAnswer1() {
        return WrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        WrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return WrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        WrongAnswer2 = wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return WrongAnswer3;
    }

    public void setWrongAnswer3(String wrongAnswer3) {
        WrongAnswer3 = wrongAnswer3;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void AddExam(Exam exam) {
        exams.add(exam);
    }
}