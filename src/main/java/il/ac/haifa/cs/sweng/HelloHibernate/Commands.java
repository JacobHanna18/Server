package il.ac.haifa.cs.sweng.HelloHibernate;

import il.ac.haifa.cs.sweng.HelloHibernate.entities.Principle;
import il.ac.haifa.cs.sweng.HelloHibernate.entities.Student;
import il.ac.haifa.cs.sweng.HelloHibernate.entities.Teacher;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.json.simple.JSONObject;

public class Commands {
    static String LogIn (String user, String password){
        JSONObject js = new JSONObject();
        Student s = App.session.get(Student.class,user);
        if(s != null){
            if(s.getPass() == password){
                js.put(Global.success,true);
                js.put(Global.userType,Global.student);
                return js.toString();
            }
        }
        Teacher t = App.session.get(Teacher.class,user);
        if(t != null){
            if(t.getPass() == password){
                js.put(Global.success,true);
                js.put(Global.userType,Global.teacher);
                return js.toString();
            }
        }
        Principle p = App.session.get(Principle.class,user);
        if(p != null){
            if(p.getPass() == password){
                js.put(Global.success,true);
                js.put(Global.userType,Global.principle);
                return js.toString();
            }
        }
        js.put(Global.success,false);
        return js.toString();
    }
}


