package com.kung;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通過反射獲取泛型
public class Test11 {

	public void test01(Map<String, User> map, List<User> list) {
		System.out.println("test01");

	}

	public Map<String, User> test02() {
		System.out.println("test02");
		return null;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method method = Test11.class.getMethod("test01", Map.class, List.class);
		Type[] genericParameterTypes = method.getGenericParameterTypes();
		for (Type type : genericParameterTypes) {
			System.out.println("#"+type);
		}

	}

}
