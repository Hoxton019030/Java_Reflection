package com.kung;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

public class Test04 {

	public static void main(String[] args) {
		Class c1 = Object.class; // 類
		Class c2 = Comparable.class; // 接口
		Class c3 = String[].class; // 一惟數組
		Class c4 = int[][].class;
		Class c5 = Override.class;
		Class c6 = ElementType.class;
		Class c7 = Integer.class;
		Class c8 = void.class;
		Class c9 = Class.class;
		List<Class> classarray = new ArrayList<Class>();
		classarray.add(c1);

		for (int i = 0; i < 10; i++) {
			System.out.println();
		}

	}

}
