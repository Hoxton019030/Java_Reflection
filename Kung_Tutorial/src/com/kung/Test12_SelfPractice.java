package com.kung;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Test12_SelfPractice {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Class c1 = Student3.class;
		// 通過反射獲得註解
		Annotation[] annotations = c1.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation); //	@com.kung.TableKuang_test(value="db_student")
		}

		// 獲得註解的value值
		TableKuang_test tableKuang_test = (TableKuang_test) c1.getAnnotation(TableKuang_test.class);
		String value = tableKuang_test.value();
		System.out.println(value); //db_student

		// 獲得類的指定註解
		Field name = c1.getDeclaredField("name");
		FieldKuang_test fieldkuang_test = (FieldKuang_test) name.getAnnotation(FieldKuang_test.class);

		String columnName = fieldkuang_test.columnName();
		System.out.println("columnName: "+columnName); //columnName: name

	}

}

@TableKuang_test("db_student")
class Student3 {
	@FieldKuang_test(columnName = "id", type = "int", length = 10)
	private int id;
	@FieldKuang_test(columnName = "age", type = "int", length = 10)
	private int age;
	@FieldKuang_test(columnName = "name", type = "varchar", length = 10)
	private String name;

	public Student3(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getIdl() {
		return id;
	}

	public void setIdl(int idl) {
		this.id = idl;
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

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TableKuang_test {
	String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldKuang_test {
	String columnName();

	String type();

	int length();
}
