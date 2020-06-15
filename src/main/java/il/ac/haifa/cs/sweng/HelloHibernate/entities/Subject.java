package il.ac.haifa.cs.sweng.HelloHibernate.entities;

import javax.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "subjects")
public class Subject {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        String Name;
        ArrayList<Question> questions;
        ArrayList<Exam> exams;


        ArrayList<Course> courses;

        public Subject(String name) {
                Name = name;
                this.courses = null;
                this.exams = null;
                this.Name = null;
        }

        public String getName() {
                return Name;
        }

        public void setName(String name) {
                Name = name;
        }

        public ArrayList<Question> getQuestions() {
                return questions;
        }

        public void AddQuestions(Question question) {
                questions.add(question);
        }

        public ArrayList<Exam> getExams() {
                return exams;
        }

        public void AddExam(Exam exam) {
                exams.add(exam);
        }

        public ArrayList<Course> getCourses() {
                return courses;
        }

        public void AddCourse(Course course) {
                courses.add(course);
        }
}
