package com.taotao.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTest {
	
	public class Student{
		private int id;
		private String name;
		private String address;
		
		public Student(int id,String name,String address){
			this.id=id;
			this.name=name;
			this.address=address;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		
	}

	@Test
	public void testFreeMarker()throws Exception {
		//创建一个Configuration对象
		Configuration configuration=new Configuration(Configuration.getVersion());
		//告诉config对象模板文件存放的路径
		configuration.setDirectoryForTemplateLoading(new File("D:\\doc\\taotao\\workspace\\taotao-portal\\src\\main\\webapp\\WEB-INF\\ftl"));
		//设置config的默认字符集。一般是utf-8
		configuration.setDefaultEncoding("utf-8");
		//从config对象中获得模板对象。需要制定一个模板对象的名字
		Template template = configuration.getTemplate("second.ftl");
		Map root=new HashMap<>();
		root.put("hello", "first中的hello");
//		root.put("title", "hello freemarker");
		root.put("student", new Student(1, "张三", "北京市海淀区上地十街百度大厦"));
		List<Student> stuList=new ArrayList<>();
		stuList.add(new Student(1, "张三", "北京"));
		stuList.add(new Student(2, "张三2", "北京2"));
		stuList.add(new Student(3, "张三3", "北京3"));
		stuList.add(new Student(4, "张三4", "北京4"));
		stuList.add(new Student(5, "张三5", "北京5"));
		root.put("students", stuList);
		root.put("curdate", new Date());
		
		Writer out=new FileWriter("D:\\doc\\taotao\\workspace\\temp\\html\\second.html");
		template.process(root, out);
		out.flush();
		out.close();
	}
}
