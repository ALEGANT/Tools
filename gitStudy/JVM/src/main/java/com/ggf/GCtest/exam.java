package com.ggf.GCtest;

import java.util.Scanner;

public class exam {
	public static void main(String[] args) {
		int n,m,max,idx;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		int[] a = new int[100000];
		
		for(int i = 0; i < 100000; i++) {
			a[i] = 0;
		}
		
		for(int i = 0; i < m; i++) {
			int tmp = scan.nextInt();
			a[tmp] = a[tmp];
		}
		
		max = 0;
		idx = 0;
		for(int i = 0; i < 100000; i++) {
			if(max > a[i]) {
				max = a[i];
				idx = i;
			}
		}
		if(max > m/2) System.out.print(idx); else System.out.print(-1);
	}
}
