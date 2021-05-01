package com.prep.interview.DynamicProgramming.Foundation;
import java.util.Scanner;

public class LCSDriver {

	public static void main(String[] args) {
		Reverse extra = new Reverse();
		LongestCommonSubsequence longestcommonsubsequence = new LongestCommonSubsequence();
		LongestCommonSubstring longestcommonsubstring = new LongestCommonSubstring();
		ShortestCommonSuperSequence shortestcommonsupersequence = new ShortestCommonSuperSequence();
		LongestRepeatingSubSequence longestrepeatingsubsequence = new LongestRepeatingSubSequence();
		Scanner sc = new Scanner(System.in);
		String a = "ATACTCGGA";
		String b = "GXTXAYB";
		int m = a.length();
		int n = b.length();
		System.out.println("Enter choice");
		System.out.println("1. LongestCommonSubSequence");
		System.out.println("2. LongestCommonSubString");
		System.out.println("3. ShortestCommonSuperSequence");
		System.out.println("4. LongestPalindromicSubSequence");
		System.out.println("5. LongestRepeatingSubSequence");
		int choice = sc.nextInt();
		int count;
		if(choice == 1){
			count = longestcommonsubsequence.getLCS(a, b,  m, n);
			System.out.println("Longest Common Subsequence : "+ count);
		}else if(choice == 2){
			count = longestcommonsubstring.getLowestCommonSubString(a, b, m, n);
			System.out.println("Longest Common SubString : "+ count);
		}else if(choice == 3){
			count = shortestcommonsupersequence.getCommonSuperSequence(a, b, m, n);
			System.out.println("Shortest Common Supersequence : "+ count);
		}else if(choice == 4){
			m = a.length();
			b= extra.getReverese(a);
			n = b.length();
			count = longestcommonsubsequence.getLCS(a, b, m, n);
			System.out.println("Longest Palindromic SubSequence : "+ count);
		}else if( choice == 5){
			b = a;
			count  = longestrepeatingsubsequence.getLongestRepeatingSubSequence(a, b, m, n);
			System.out.println("Longest Repeating SubSequence : "+ count);
		}	 
	}
}
