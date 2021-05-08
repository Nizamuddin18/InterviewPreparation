package com.prep.interview.Stacks;

import java.util.Stack;

public class DuplicateBrackets {
	private static boolean isDuplicate(String str) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ')') {
				if (st.peek() == '(') {
					return true;
				} else {
					while (st.peek() != '(') {
						st.pop();
					}
					st.pop();
				}
			} else {
				st.push(ch);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "((a + b) + (c + d))";
		boolean ret_val = isDuplicate(str);
		System.out.println(ret_val);

	}

}
