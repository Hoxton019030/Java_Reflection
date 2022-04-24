package com.kung;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//練習反射操作註解
public class Test12 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class c1 = Class.forName("com.kung.Student2");

		// 通過反射獲得註解
		Annotation[] annotations = c1.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("註解有 :" + annotation); //註解有 :@com.kung.Tablekuang(value="db_student")
		}
		// 獲得註解的value值
		Tablekuang tablekuang = (Tablekuang) c1.getAnnotation(Tablekuang.class);
		String value = tablekuang.value();
		System.out.println("value:"+value); //value:db_student

		// 獲得類的指定註解
		Field name = c1.getDeclaredField("name");

		Fieldkuang annotation = name.getAnnotation(Fieldkuang.class); // getAnnotation放註釋類型的對象
		System.out.println("columnName:"+annotation.columnName());
		System.out.println("type:"+annotation.type());
		System.out.println("length:"+annotation.length());

	}

}

@Tablekuang("db_student")
class Student2 {
	@Fieldkuang(columnName = "db_id", type = "int", length = 10)
	private int id;
	@Fieldkuang(columnName = "db_age", type = "int", length = 10)
	private int age;
	@Fieldkuang(columnName = "db_name", type = "int", length = 10)
	private String name;

	public Student2(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablekuang {
	String value();
}

//屬性的註解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldkuang {
	String columnName();

	String type();

	int length();
}
