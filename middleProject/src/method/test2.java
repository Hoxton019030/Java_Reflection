package method;

import org.json.JSONArray;
import org.json.JSONException;

import url.Url;

public class test2 {
public static void main(String[] args) {
	Url url = new Url();
	String jString = url.getJsonString();
	System.out.println(jString);
	try {
		JSONArray jArray = new JSONArray(jString);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
