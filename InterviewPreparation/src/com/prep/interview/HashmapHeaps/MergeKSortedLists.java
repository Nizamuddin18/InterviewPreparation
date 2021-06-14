package com.prep.interview.HashmapHeaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class MergeKSortedLists {
	static class Pair implements Comparable<Pair>{
		int li; //listIndex - > to keep track of which list the data belongs to
		int di ; // dataIndex - > to keep track of data index from the present list
		int val;
		Pair(int li , int di , int val){
			this.li = li;
			this.di = di;
			this.val = val;
		}
		@Override
		public int compareTo(Pair other) {
			return this.val - other.val;
		}
	}
	
	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> rv = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i < lists.size() ; i++){
			Pair p = new Pair(i , 0 , lists.get(i).get(0));
			pq.add(p);
		}
		
		while(!pq.isEmpty()){
			Pair rem = pq.remove();
			rv.add(rem.val);
			rem.di++;
			
			if(rem.di < lists.get(rem.li).size()){
				rem.val = lists.get(rem.li).get(rem.di);
				pq.add(rem);
			}
			
		}
		return rv;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);

		list2.add(5);
		list2.add(9);
		list2.add(12);
		list2.add(18);
		list2.add(32);

		list3.add(11);
		list3.add(15);
		list3.add(17);

		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		ArrayList<Integer> res = mergeKSortedLists(lists);
		System.out.println(res);
	}

}
