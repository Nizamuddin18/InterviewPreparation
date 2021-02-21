package com.prep.interview;

import java.util.Scanner;

public class ArrayInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {1,2,2,4,6};
		/*for(int i=0;i<arr.length;i++){
			arr[i] = sc.nextInt();
		}*/
		System.out.println("Input array=======");
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}

	}
}
