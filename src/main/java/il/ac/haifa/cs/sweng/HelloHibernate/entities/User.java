package il.ac.haifa.cs.sweng.HelloHibernate.entities;
public class User {

    String Name;
    String Id;
    String Pass;

    public User(String name, String id, String pass) {
        Name = name;
        Id = id;
        Pass = pass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}