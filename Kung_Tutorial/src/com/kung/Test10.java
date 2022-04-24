package com.kung;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test10 {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		test01();
		test02();
		test03();
	}

	// 普通方式調用
	public static void test01() {
		User user = new User();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			user.getName();
		}
		long endTime = System.currentTimeMillis();

		System.out.println("普通方式執行十億次，所需的時間" + (endTime - startTime)+"ms");
	}

	// 反射方式調用

	public static void test02() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		Class<?> c1 = Class.forName("com.kung.User");
		User user1 = (User) c1.getDeclaredConstructor().newInstance();
		Method getName = c1.getDeclaredMethod("getName", null);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			getName.invoke(user1, null);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("反射方式執行十億次，所需的時間" + (endTime - startTime)+"ms");

	}

	// 反射方式調用 關閉檢測

	public static void test03() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		Class<?> c1 = Class.forName("com.kung.User");
		User user1 = (User) c1.getDeclaredConstructor().newInstance();
		Method getName = c1.getDeclaredMethod("getName", null);
		getName.setAccessible(true);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			getName.invoke(user1, null);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("反射方式執行十億次，所需的時間" + (endTime - startTime)+"ms");

	}

}
