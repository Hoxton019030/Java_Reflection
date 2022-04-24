package com.kung;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//動態的創建對象
public class Test09 {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {// 獲得Class對象
		Class<?> c1 = Class.forName("com.kung.User");
		System.out.println(c1);
		// 構造一個對象

		User user = (User) c1.getDeclaredConstructor().newInstance();
		System.out.println(user);

		// 通過構造器創建對象

		Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
		User user2 = (User) constructor.newInstance("秦疆", 001, 18);
		System.out.println(user2);

		// 通過反射調用普通方法

		User user3 = (User) c1.getDeclaredConstructor().newInstance();
		// 通過反射獲取一個方法
		Method setName = c1.getDeclaredMethod("setName", String.class);
		Method setAge = c1.getDeclaredMethod("setAge", int.class);
		Method setId = c1.getDeclaredMethod("setId", int.class);
		Method getName = c1.getDeclaredMethod("getName", null);

		// invoke:啟用的意思
		// invoke(物件,值) :傳入物件，告訴java這個方法屬於哪個物件

		setName.invoke(user3, "狂神");
		setAge.invoke(user3, 25);
		setId.invoke(user3, 3);

		System.out.println(user3);

		// 通過反射調用屬性
		User user4 = (User) c1.getDeclaredConstructor().newInstance();
		Field name = c1.getDeclaredField("name");

		// 不能直接操作私有屬性，我們需要關閉城市的安全檢測，屬性或者方法的setAccessible(true)
		name.setAccessible(true);
		name.set(user4, "狂神2");
		setAge.invoke(user4, 10);

		System.out.println(user4.getAge());
		System.out.println(getName.invoke(user4,  null));
	}

}
