package example;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class Example2 {

	public static void main(String[] args) {
		StringTemplateGroup group =  new StringTemplateGroup("myGroup", "resources", DefaultTemplateLexer.class);
		StringTemplate helloAgain = group.getInstanceOf("example2");
		 
		helloAgain.setAttribute("title", "Welcome To StringTemplate");
		helloAgain.setAttribute("name", "World");
		helloAgain.setAttribute("friends", "Ter");
		helloAgain.setAttribute("friends", "Kunle");
		helloAgain.setAttribute("friends", "Micheal");
		helloAgain.setAttribute("friends", "Marq");
		 
		System.out.println(helloAgain.toString());

	}

}
