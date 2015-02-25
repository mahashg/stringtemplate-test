package practise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Practise1 {

	public static void main(String[] args) throws Exception {
		StringTemplateGroup group =  new StringTemplateGroup("myGroup", "resources", DefaultTemplateLexer.class);
		StringTemplate helloAgain = group.getInstanceOf("practise1");			
		
		JSONObject report = readJSONReport();
		report = (JSONObject) report.get("objects");
		
		helloAgain.setAttribute("sprint_id", "22");
		helloAgain.setAttribute("sprint_name", report.get("name"));
		helloAgain.setAttribute("current_time", new Date(System.currentTimeMillis()));
		
		JSONArray summary = (JSONArray) report.get("summary");
		helloAgain.setAttribute("summary", "");
		for(int i=0 ; i<summary.size() ; ++i)
			helloAgain.setAttribute("summary", summary.get(i));
		
		helloAgain.setAttribute("pk", new Pagekey(1, "one").getMap());
		helloAgain.setAttribute("pk", new Pagekey(2, "two").getMap());
						
		System.out.println(helloAgain.toString());

	}

	private static JSONObject readJSONReport() throws Exception {
		return (JSONObject) JSONValue.parse(new FileReader("resources/report.json"));
	}
}

class Pagekey{
	public int id;
	public String name;
	
	public Pagekey(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Map<String, Object> getMap(){
		Map<String, Object> _map = new HashMap<>();
		_map.put("id", id);
		_map.put("name", name);
		return _map;
	}
}
