package com.prep.interview.DynamicProgramming.Foundation;

public class ArrangeBuildings {

	public static void main(String[] args) {
		int n = 6; // binary String of length n
		int b = 1;
        int s = 1;
        for (int i = 2; i <= n; i++) {
            int nb = s;
            int ns = (b + s);
            b = nb;
            s = ns;
        }
        int ans = (int) Math.pow((b+s) , 2);
        System.out.println(ans);

	}

}
