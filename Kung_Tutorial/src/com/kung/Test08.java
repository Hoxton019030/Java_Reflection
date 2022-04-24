package com.kung;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//獲得類的資訊
public class Test08 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		Class<?> c1 = Class.forName("com.kung.User");

		User user = new User();
		c1 = user.getClass();
		//
		System.out.println(c1.getName());
		System.out.println(c1.getSimpleName());
		// 獲得類的屬性
		Field[] fields = c1.getFields(); // getFields只能找到public方法,public 屬性
		for (Field field : fields) {
			System.out.println(fields);
		}

		fields = c1.getDeclaredFields(); // 找到全部屬性
		for (Field field : fields) {
			System.out.println(field);
		}
		// 獲得指定屬性的值
		Field name = c1.getDeclaredField("name");
		System.out.println("getDeclaredField:" + name);

		// 獲得類的方法
		Method[] methods = c1.getMethods(); //獲得本類及其父類的全部public方法

		for (Method method : methods) {
			System.out.println("正常的:"+method);
		}
		methods = c1.getDeclaredMethods();//獲得本類的所有方法(包括私有的)
		for (Method method : methods) {
			System.out.println("getDeclaredMethods:"+method);
		}
		
		Method getName = c1.getMethod("getName", null);
		Method setName = c1.getMethod("setName", String.class);
		System.out.println(getName);
		System.out.println(setName);
		
		//獲得public 
		Constructor<?>[] constructors = c1.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println("getConstructors建構子:"+	constructor);
		}
		//獲得全部
		constructors =c1.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println("getDeclaredConstructors建構子"+constructor);
			
		}
		
		
		
	}

}
