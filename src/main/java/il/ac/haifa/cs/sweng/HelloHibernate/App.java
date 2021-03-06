package il.ac.haifa.cs.sweng.HelloHibernate;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.google.gson.Gson;

import il.ac.haifa.cs.sweng.HelloHibernate.entities.*;
import jdk.dynalink.Operation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App 
{
	public static Session session;
	
	private static SessionFactory getSessionFactory() throws HibernateException {
		Configuration configuration =new Configuration();
		configuration.addAnnotatedClass(Course.class);
		configuration.addAnnotatedClass(Exam.class);
		configuration.addAnnotatedClass(Grade.class);
		configuration.addAnnotatedClass(Principle.class);
		configuration.addAnnotatedClass(Question.class);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(Answer.class);
		configuration.addAnnotatedClass(Request.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build();
		
		return configuration.buildSessionFactory(serviceRegistry);
	}
	
	private static void initializeData() throws Exception {

		Teacher t = new Teacher("zonaaa2","7894561235","123");
		session.save(t);

		Subject s = new Subject("Computer Science");
		System.out.println(s.getName());
		session.save(s);

		Course c = new Course(s,t);
		session.save(c);

		session.flush();
    	session.getTransaction().commit();
	}
	
	public static <T> List<T> getAll(Class<T> object) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(object);
		Root<T> rootEntry = criteriaQuery.from(object);
		CriteriaQuery<T> allCriteriaQuery = criteriaQuery.select(rootEntry);
		TypedQuery<T> allQuery = session.createQuery(allCriteriaQuery);
		return allQuery.getResultList();
	}

	public static void main2 (String[] args){
		Course s = App.session.get(Course.class,"1");
		System.out.println(s.getTeacher().getName());
//		Gson g = new Gson();
//		System.out.println(g.toJson(arr));
//		System.out.println(g.fromJson(g.toJson(arr), jsonobject[].class)[2].i);
	}
    public static void main( String[] args )
    {
        try {
        	
        	//Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        	
        	SessionFactory sessionFactory = getSessionFactory();
        	session = sessionFactory.openSession();
        	session.beginTransaction();
        	
        	initializeData();

			Course s = App.session.get(Course.class,"1");
			System.out.println(s.getSubject().getName());

        	
        	
        } catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				session.getSessionFactory().close();
			}
		}
    }
}
