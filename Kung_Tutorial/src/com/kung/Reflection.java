package com.kung;

public class Reflection {
	public static void main(String[] args) throws ClassNotFoundException {

		Class c1 = Class.forName("com.kung.User");
		Class c2 = Class.forName("com.kung.User");
		Class c3 = Class.forName("com.kung.User");
		Class c4 = Class.forName("com.kung.User");
		
		//一個類在內存中只有一個Class對象
		//一個類被加載後，類的整個結構都會被封裝在class對象中
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c3.hashCode());
		
	
		

	}
}

class User {
	private String name;
	private int id;
	private int age;

	public User() {
	}

	public User(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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

}