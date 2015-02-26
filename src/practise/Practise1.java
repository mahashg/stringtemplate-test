package practise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;

public class Practise1 {

	public static void main(String[] args) throws Exception {
		StringTemplateGroup group =  new StringTemplateGroup("myGroup", "resources", DefaultTemplateLexer.class);
		StringTemplate helloAgain = group.getInstanceOf("practise1");			
		
		JSONObject report = readJSONReport();
		report = (JSONObject) report.get("objects");
		Collection<Map<String, Object >> total_collection = new ArrayList<>();
		Map<String, Object> _map = new HashMap<>();

		_map.put("sprint_id", "11");
		_map.put("sprint_name", report.get("name"));
		_map.put("current_time", new Date(System.currentTimeMillis()));

		List<Object> list = Lists.newArrayList();
		SprintReportEntry entry1 = new SprintReportEntry("product", "role", "ldap", 24, 24, 0, false, "DQ-123", 445, 445, true);
		SprintReportEntry entry2 = new SprintReportEntry("multiproduct", "ENG", "mgupta3", 10, 24, 4, true, "DQ-123, DQ-223", 334, 100, false);
		list.add(entry1);
		list.add(entry2);

		_map.put("report", list);

		total_collection.add(_map);
		helloAgain.setAttribute("contents", total_collection);
		System.out.println(helloAgain.toString());

	}

	private static JSONObject readJSONReport() throws Exception {
		return (JSONObject) JSONValue.parse(new FileReader("resources/report.json"));
	}
}

class SprintReportEntry{
	public String product;
	public String role;
	public String ldap;
	public int action_items_completed;
	public int action_items_total;
	public int change_requests;
	public boolean contains_issues;
	public String jira_ticket;
	public int pagekeys_total;
	public int pagekeys_verified;
	public boolean signedoff;
	
	public SprintReportEntry(String product, String role, String ldap,
			int action_items_completed, int action_items_total,
			int change_requests, boolean contains_issues, String jira_ticket,
			int pagekeys_total, int pagekeys_verified, boolean signedoff) {
		super();
		this.product = product;
		this.role = role;
		this.ldap = ldap;
		this.action_items_completed = action_items_completed;
		this.action_items_total = action_items_total;
		this.change_requests = change_requests;
		this.contains_issues = contains_issues;
		this.jira_ticket = jira_ticket;
		this.pagekeys_total = pagekeys_total;
		this.pagekeys_verified = pagekeys_verified;
		this.signedoff = signedoff;
	}
}
