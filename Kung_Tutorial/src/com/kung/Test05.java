package com.kung;

public class Test05 {
	public static void main(String[] args) {
		System.out.println(A.m);

	}

}

class A {
	static {
		System.out.println("A類靜態代碼塊初始化");
		m = 300;
	}
	static int m = 100;

	public A() {
		System.out.println("A類無參構造初始化");
	}
}