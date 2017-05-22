package com.appx.demo.freemarker;

import java.io.StringWriter;
import java.util.Date;

import freemarker.template.Configuration;

public class App {

	public static void main(String[] args) throws Exception {

		Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
		cfg.setClassForTemplateLoading(App.class, "/templates");
		cfg.setDefaultEncoding("UTF-8");

		User user = prepareData();

		StringWriter sw = new StringWriter();
		cfg.getTemplate("helloworld.ftl").process(user, sw);

		System.out.println(sw);
	}

	private static User prepareData() {
		User user = new User("Terry", "Taiwan", 201234, new Date());
		user.addBook(new Book("Java in Action", "Anderson"));
		user.addBook(new Book("Oracle tutorial", "Tom"));
		return user;
	}
}
