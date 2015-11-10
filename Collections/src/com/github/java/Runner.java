package com.github.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import com.github.java.MethodsForLists;
import com.github.java.MethodsForSets;
import com.github.java.MethodsForMaps;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Integer> arrayListRandom = new ArrayList<Integer>();
		LinkedList<Integer> linkedListRandom = new LinkedList<Integer>();
		HashSet<Integer> hashSetRandom = new HashSet<Integer>();
		TreeSet<Integer> treeSetRandom = new TreeSet<Integer>();
		HashMap<Integer, Integer> hashMapRandom = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> treeMapRandom = new TreeMap<Integer, Integer>();
		
		MethodsForLists.compareLists(arrayListRandom, linkedListRandom);
		MethodsForSets.comparSets(hashSetRandom, treeSetRandom);
		MethodsForMaps.compareMaps(hashMapRandom, treeMapRandom);
		
	}

}
