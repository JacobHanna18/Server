package il.ac.haifa.cs.sweng.HelloHibernate;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringWriter;

public class json {
    JSONObject obj = new JSONObject();

    public json() {
    }

    public json (String in) {
        JSONParser parser = new JSONParser();

        try {
            obj = (JSONObject)(parser.parse(in));
        } catch (ParseException e) {

        }

    }

    public void add (String key, Object value){
        obj.put(key,value);
    }

    public Object get(String key){
        return obj.get(key);
    }

    public String toString(){
        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
            return out.toString();
        } catch (IOException e) {
            return "";
        }
    }
}
