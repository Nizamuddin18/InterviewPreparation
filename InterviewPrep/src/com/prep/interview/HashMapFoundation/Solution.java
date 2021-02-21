package com.prep.interview.HashMapFoundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class Solution {

	public static void main(String[] args) {
		ArrayList<Integer> list  = new ArrayList<>();
		list.add(222);
		list.add(555);
		list.add(666);
		list.add(333);
		list.add(111);
		list.add(888);
		list.add(777);
		list.add(444);
		PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min_heap = new PriorityQueue<>();
		max_heap.addAll(list);
		min_heap.addAll(list);
        System.out.println("MAX HEAP => " + max_heap);
        System.out.println("Max element in the list => " + max_heap.peek());
        System.out.println(".............................................");
        System.out.println("MIN HEAP => " + min_heap);
        System.out.println("Min element in the list => " + min_heap.peek());
	}

}
