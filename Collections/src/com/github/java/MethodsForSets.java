package com.github.java;

import java.util.HashSet;
import java.util.TreeSet;

public class MethodsForSets extends GeneralMethods {
	
	protected static void comparSets (HashSet<Integer> hSet, TreeSet<Integer> tSet) {
		
		double hTime = timeInsertCollection(hSet);
		double tTime = timeInsertCollection(tSet);
		printResults("INSERT", "HashSet", hTime, "TreeSet", tTime);
		
		hTime = timeFindSet(hSet);
		tTime = timeFindSet(tSet);
		printResults("FIND", "HashSet", hTime, "TreeSet", tTime);
		
		hTime = timeDeleteCollection(hSet);
		tTime = timeDeleteCollection(tSet);
		printResults("DELETE", "HashSet", hTime, "TreeSet", tTime);	
		
	}
}
