package com.kung;

//測試CLASS什麼時候初始化
public class Test06 {
	static {
		System.out.println("Main類被加載");
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// 1.主動引用
//		Son son = new Son();
		
		// 反射也會產生引用
//		Class.forName("com.kung.Son");
		
		//不會產生Class的引用的方法
//		System.out.println(Son.b);
		
		Son[] array = new Son[5];
	}

}

class Father {
	static int b = 2;
	static {
		System.out.println("父類被加載");
	}
}

class Son extends Father {
	static {
		System.out.println("子類被加載");
	}

	static int m = 100;
	static final int M = 1;

}
