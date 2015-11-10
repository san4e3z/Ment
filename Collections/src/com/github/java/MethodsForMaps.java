package com.github.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import com.github.java.MethodsForLists;

public class MethodsForMaps {
	
	final static int SIZE = 10000;
	
	public static void compareMaps (HashMap<Integer, Integer> hMap, TreeMap<Integer, Integer> tMap) {
		
		double hTime = timeInsertMap(hMap);
		double tTime = timeInsertMap(tMap);
		MethodsForLists.printResults("INSERT", "HashMap", hTime, "TreeMap", tTime);
		
		hTime = timeFindMap(hMap);
		tTime = timeFindMap(tMap);
		MethodsForLists.printResults("FIND", "HashMap", hTime, "TreeMap", tTime);
		
		hTime = timeDeleteMap(hMap);
		tTime = timeDeleteMap(tMap);
		MethodsForLists.printResults("DELETE", "HashMap", hTime, "TreeMap", tTime);

	}
	
	public static double timeDeleteMap(Map<Integer, Integer> map) {
		Long startTimeFind= System.nanoTime();
		deleteMap(map);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / 1000000000;
	}

	public static double timeFindMap(Map<Integer, Integer> map) {
		Long startTimeFind= System.nanoTime();
		findMap(map);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / 1000000000;
	}

	public static double timeInsertMap(Map<Integer, Integer> map) {
		Long startTimeInsert= System.nanoTime();
		fillMap(map);
		double endTimeInsert = (System.nanoTime() - startTimeInsert);
		return endTimeInsert / 1000000000;
	}

	public static void fillMap (Map<Integer, Integer> emptyMap) {
		Random rand = new Random();
		for (int i = 0; i < SIZE; i++) {
			emptyMap.put(i, rand.nextInt(SIZE));
		}
	}
	
	public static void findMap(Map<Integer, Integer> nonEmptyMap) {
		Random rand = new Random();
		int exampleVar = nonEmptyMap.get(rand.nextInt(SIZE));;
	}
	
	public static void deleteMap(Map<Integer, Integer> nonEmptyMap) {
		for (Iterator<Integer> it = nonEmptyMap.keySet().iterator(); it.hasNext();) {
			it.next();
			it.remove();		
		}
	}

}
