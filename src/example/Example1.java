package example;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class Example1 {
	public static void main(String[] args) {
		StringTemplate hello = new StringTemplate("Hello, $name$", DefaultTemplateLexer.class);
		hello.setAttribute("name", "World");
		System.out.println(hello.toString());
	}
}
