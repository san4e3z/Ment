package com.github.java;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.github.java.MethodsForLists;

public class MethodsForSets {

	final static int SIZE = 10000;
	
	public static void comparSets (HashSet<Integer> hSet, TreeSet<Integer> tSet) {
		
		double hTime = MethodsForLists.timeInsertCollection(hSet);
		double tTime = MethodsForLists.timeInsertCollection(tSet);
		MethodsForLists.printResults("INSERT", "HashSet", hTime, "TreeSet", tTime);
		
		hTime = timeFindSet(hSet);
		tTime = timeFindSet(tSet);
		MethodsForLists.printResults("FIND", "HashSet", hTime, "TreeSet", tTime);
		
		hTime = MethodsForLists.timeDeleteCollection(hSet);
		tTime = MethodsForLists.timeDeleteCollection(tSet);
		MethodsForLists.printResults("DELETE", "HashSet", hTime, "TreeSet", tTime);
		
	}
	
	public static double timeFindSet(Set<Integer> set) {
		Long startTimeFind= System.nanoTime();
		findSet(set);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / 1000000000;
	}
	
	public static void findSet(Set<Integer> nonEmptySet) {
		int findingValue = SIZE*10;
		nonEmptySet.add(findingValue);
		if (nonEmptySet.contains(findingValue)) {
		//Something happens	
		} else {
			System.out.println("Error");
		}
	}
}
