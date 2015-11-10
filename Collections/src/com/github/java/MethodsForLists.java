package com.github.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MethodsForLists {
	
	final static int SIZE = 10000;
	
	public static void compareLists (ArrayList<Integer> arrList, LinkedList<Integer> linkList) {
		
		double arrTime = timeInsertCollection(arrList);
		double linkTime = timeInsertCollection(linkList);
		printResults("INSERT", "ArrayList", arrTime, "LinkedList", linkTime);
		
		arrTime = timeFindCollection(arrList);
		linkTime = timeFindCollection(linkList);
		printResults("FIND", "ArrayList", arrTime, "LinkedList", linkTime);
		
		arrTime = timeDeleteCollection(arrList);
		linkTime = timeDeleteCollection(linkList);
		printResults("DELETE", "ArrayList", arrTime, "LinkedList", linkTime);

	}
	
	public static void printResults(String action, String typeOfCol1, double resultForCol1, String typeOfCol2, double resultForCol2) {
		System.out.println(action + "\t" + typeOfCol1 + " " + String.format( "%.9f", resultForCol1) + 
				" sec\t" + typeOfCol2 + " " + String.format( "%.9f", resultForCol2) + " sec");
		if (action.equals("DELETE")) {
			System.out.println();
		}
	}

	public static double timeDeleteCollection(Collection<Integer> collection) {
		Long startTimeFind= System.nanoTime();
		deleteCollection(collection);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / 1000000000;
	}

	public static double timeFindCollection(List<Integer> list) {
		Long startTimeFind= System.nanoTime();
		findCollection(list);
		double endTimeFind = (System.nanoTime() - startTimeFind);
		return endTimeFind / 1000000000;
	}

	public static double timeInsertCollection(Collection<Integer> collection) {
		Long startTimeInsert= System.nanoTime();
		fillCollection(collection);
		double endTimeInsert = (System.nanoTime() - startTimeInsert);
		return endTimeInsert / 1000000000;
	}

	public static void fillCollection (Collection<Integer> emptyCollection) {
		Random rand = new Random();
		for (int i = 0; i < SIZE; i++) {
			emptyCollection.add(rand.nextInt(SIZE));
		}
	}
	
	public static void findCollection(List<Integer> nonEmptyList) {
		Random rand = new Random();
		int exampleVar = nonEmptyList.get(rand.nextInt(SIZE));;
	}
	
	public static void deleteCollection(Collection<Integer> nonEmptyCollection) {
		Iterator<Integer> iter = nonEmptyCollection.iterator();
		while(iter.hasNext()){
			iter.next();
			iter.remove();
		}
	}

}
