package example;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class Example3 {
	public static void main(String[] args) {
		StringTemplateGroup group =  new StringTemplateGroup("myGroup", "resources", DefaultTemplateLexer.class);
		StringTemplate helloAgain = group.getInstanceOf("example3");
		 
		helloAgain.setAttribute("input", "mahesh");
		helloAgain.setAttribute("lives", new Place(1, "mumbai"));
		helloAgain.setAttribute("lives", new Place(2, "bangalore"));
		 
		System.out.println(helloAgain.toString());
	}
}

class Place{
	public int id;
	public String name;
	public Place(int id, String name){
		this.id = id;
		this.name = name;
	}
}