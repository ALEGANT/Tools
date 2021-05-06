package com.ggf.GCtest;

public class NameChecker {
	
	public static void main(String[] args) {
		System.out.print(getSum(99));
	}
	
	public static int getSum(int n) {
		if(n == 0) return n;
		return n + getSum(n - 1);
	}
}