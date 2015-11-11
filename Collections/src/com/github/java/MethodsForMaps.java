package com.github.java;

import java.util.HashMap;
import java.util.TreeMap;

public class MethodsForMaps extends GeneralMethods {
	
	protected static void compareMaps (HashMap<Integer, Integer> hMap, TreeMap<Integer, Integer> tMap) {
		
		double hTime = timeInsertMap(hMap);
		double tTime = timeInsertMap(tMap);
		printResults("INSERT", "HashMap", hTime, "TreeMap", tTime);
		
		hTime = timeFindMap(hMap);
		tTime = timeFindMap(tMap);
		printResults("FIND", "HashMap", hTime, "TreeMap", tTime);
		
		hTime = timeDeleteMap(hMap);
		tTime = timeDeleteMap(tMap);
		printResults("DELETE", "HashMap", hTime, "TreeMap", tTime);

	}
}
