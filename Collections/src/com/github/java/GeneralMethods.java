package com.github.java;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GeneralMethods {
	
	final static int SIZE = 10000;
	final static int FORMAT = 1000000000;
	
	//Methods for all type of collections
	protected static void printResults(String action, String typeOfCol1, double resultForCol1, String typeOfCol2, double resultForCol2) {
		
		System.out.println(action + "\t" + typeOfCol1 + " " + String.format( "%.9f", resultForCol1) + 
				" sec\t" + typeOfCol2 + " " + String.format( "%.9f", resultForCol2) + " sec");
		if (action.equals("DELETE")) {
			System.out.println();
		}
	}
	//Methods for Lists and Sets
	protected static double timeDeleteCollection(Collection<Integer> collection) {
		Long startTimeFind= System.nanoTime();
		deleteCollection(collection);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / FORMAT;
	}
	
	protected static void deleteCollection(Collection<Integer> nonEmptyCollection) {
		Iterator<Integer> iter = nonEmptyCollection.iterator();
		while(iter.hasNext()){
			iter.next();
			iter.remove();
		}
	}
	
	protected static double timeInsertCollection(Collection<Integer> collection) {
		Long startTimeInsert= System.nanoTime();
		fillCollection(collection);
		double endTimeInsert = (System.nanoTime() - startTimeInsert);
		return endTimeInsert / FORMAT;
	}

	protected static void fillCollection (Collection<Integer> emptyCollection) {
		Random rand = new Random();
		for (int i = 0; i < SIZE; i++) {
			emptyCollection.add(rand.nextInt(SIZE));
		}
	}
	//Methods only for Lists
	public static double timeFindList(List<Integer> list) {
		Long startTimeFind= System.nanoTime();
		findList(list);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / FORMAT;
	}
	
	public static void findList(List<Integer> nonEmptyList) {
		Random rand = new Random();
		int exampleVar = nonEmptyList.get(rand.nextInt(SIZE));
	}
	//Methods only for Sets
	public static double timeFindSet(Set<Integer> set) {
		Long startTimeFind= System.nanoTime();
		findSet(set);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / FORMAT;
	}
	
	public static void findSet(Set<Integer> nonEmptySet) {
		int findingValue = SIZE * 10;
		nonEmptySet.add(findingValue);
		if (nonEmptySet.contains(findingValue)) {
		//Something happens	
		} else {
			System.out.println("Error");
		}
	}
	//Methods only for Maps
	public static double timeDeleteMap(Map<Integer, Integer> map) {
		Long startTimeFind= System.nanoTime();
		deleteMap(map);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / FORMAT;
	}
	
	public static void deleteMap(Map<Integer, Integer> nonEmptyMap) {
		for (Iterator<Integer> it = nonEmptyMap.keySet().iterator(); it.hasNext();) {
			it.next();
			it.remove();		
		}
	}

	public static double timeFindMap(Map<Integer, Integer> map) {
		Long startTimeFind= System.nanoTime();
		findMap(map);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / FORMAT;
	}
	
	public static void findMap(Map<Integer, Integer> nonEmptyMap) {
		Random rand = new Random();
		int exampleVar = nonEmptyMap.get(rand.nextInt(SIZE));;
	}

	public static double timeInsertMap(Map<Integer, Integer> map) {
		Long startTimeInsert= System.nanoTime();
		fillMap(map);
		double endTimeInsert = (System.nanoTime() - startTimeInsert);
		return endTimeInsert / FORMAT;
	}

	public static void fillMap (Map<Integer, Integer> emptyMap) {
		Random rand = new Random();
		for (int i = 0; i < SIZE; i++) {
			emptyMap.put(i, rand.nextInt(SIZE));
		}
	}	
}
