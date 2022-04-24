package com.kung;

//測試class類的創建方法有哪些
public class Test03 {

	public static void main(String[] args) throws ClassNotFoundException {
		Person person = new Student();
		System.out.println("這個人是" + person.name);

		// 方式一:通過對象獲得
		Class<? extends Person> c1 = person.getClass();
		System.out.println(c1.hashCode());

		// 方式二:透過forName獲取
		Class<?> c2 = Class.forName("com.kung.Student");
		System.out.println(c2.hashCode());

		// 方式三:透過纇名.class
		Class c3 = Student.class;
		System.out.println(c3.hashCode());
		
		//方式四:基本內痔類型的包裝類都有一個Type屬性
		Class c4=Integer.TYPE;
		System.out.println(c4.hashCode());
		
		//獲得父類類型 
		Class c5=c1.getSuperclass();
		System.out.println(c5);
	}

}

class Person {
	String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}

class Student extends Person {

	public Student() {
		this.name = "學生";
	}
}

class Teacher extends Person {
	public Teacher() {
		this.name = "教師";
	}
}
