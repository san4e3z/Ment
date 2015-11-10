package com.github.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Collections {
	
	public static void fillRandom (Collection<Integer> emptyCollection, int size) {
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			emptyCollection.add(10000 + rand.nextInt(10000));
		}
	}
	
	public static void fillRandomMap (Map<Integer, Integer> emptyMap, int size) {
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			emptyMap.put(i, 10000 + rand.nextInt(10000));
		}
	}
	
	public static void delectCollection (Collection<Integer> nonEmptyCollection) {
		Iterator<Integer> iter = nonEmptyCollection.iterator();
		while(iter.hasNext()){
			iter.next();
			iter.remove();
		}
	}
	
	public static void delectMap (Map<Integer, Integer> nonEmptyMap) {
		for (Iterator<Integer> it = nonEmptyMap.keySet().iterator(); it.hasNext();) {
			it.next();
			it.remove();		
		}
	}
	
	public static void compareCollections (ArrayList<Integer> firstCollection, 
			LinkedList<Integer> secondCollection) {
		Random rand = new Random();
		
		System.out.println("Fill");
		Long firstStartTimeFill= System.nanoTime();
		fillRandom(firstCollection, 10000);
		double firstEndTineFill = (System.nanoTime() - firstStartTimeFill);
		System.out.format("%f", firstEndTineFill/10000000);
		System.out.print("\t");
		Long secondStartTimeFill= System.nanoTime();
		fillRandom(secondCollection, 10000);
		double secondEndTineFill = (System.nanoTime() - secondStartTimeFill);
		System.out.format("%f", secondEndTineFill/10000000);
		
		System.out.println("\nFind element");
		Long firstStartTimeFind= System.nanoTime();
		int exampleVar = firstCollection.get(rand.nextInt(firstCollection.size()));;
		double firstEndTimeFind = (System.nanoTime() - firstStartTimeFind);
		System.out.format("%f", firstEndTimeFind/10000000);
		System.out.print("\t");
		Long secondStartTimeFind = System.nanoTime();
		exampleVar = secondCollection.get(rand.nextInt(secondCollection.size()));
		double secondEndTimeFind = (System.nanoTime() - secondStartTimeFind);
		System.out.format("%f%n", secondEndTimeFind/10000000);
		
		System.out.println("Delete");
		Long firstStartTimeDelete = System.nanoTime();
		delectCollection(firstCollection);
		double firstEndTimeDelete  = (System.nanoTime() - firstStartTimeDelete);
		System.out.format("%f", firstEndTimeDelete/10000000);
		System.out.print("\t");
		Long secondStartTimeDelete = System.nanoTime();
		delectCollection(firstCollection);
		double secondEndTimeDelete  = (System.nanoTime() - secondStartTimeDelete);
		System.out.format("%f%n", secondEndTimeDelete/10000000);	
	}
	
	public static void compareCollections (Set<Integer> firstSet, 
			Set<Integer> secondSet) {	
		System.out.println("Fill");
		Long firstStartTimeFill= System.nanoTime();
		fillRandom(firstSet, 10000);
		double firstEndTineFill = (System.nanoTime() - firstStartTimeFill);
		System.out.format("%f", firstEndTineFill/10000000);
		System.out.print("\t");
		Long secondStartTimeFill= System.nanoTime();
		fillRandom(secondSet, 10000);
		double secondEndTineFill = (System.nanoTime() - secondStartTimeFill);
		System.out.format("%f%n", secondEndTineFill/10000000);
		
		System.out.println("Find element");
		firstSet.add(10000001);
		Long firstStartTimeFind= System.nanoTime();
		if (firstSet.contains(10000001)) {
			double firstEndTimeFind = (System.nanoTime() - firstStartTimeFind);
			System.out.format("%f", firstEndTimeFind/10000000);
		} else {
			System.out.println("Error");
		}
		secondSet.add(1000002);
		Long secondStartTimeFind= System.nanoTime();
		if (secondSet.contains(1000002)) {
			double secondEndTimeFind = (System.nanoTime() - secondStartTimeFind);
			System.out.print("\t");
			System.out.format("%f%n", secondEndTimeFind/10000000);
		} else {
			System.out.println("Error");
		}
		
		System.out.println("Delete");
		Long firstStartTimeDelete = System.nanoTime();
		delectCollection(firstSet);
		double firstEndTimeDelete  = (System.nanoTime() - firstStartTimeDelete);
		System.out.format("%f", firstEndTimeDelete/10000000);
		System.out.print("\t");
		Long secondStartTimeDelete = System.nanoTime();
		delectCollection(secondSet);
		double secondEndTimeDelete  = (System.nanoTime() - secondStartTimeDelete);
		System.out.format("%f%n", secondEndTimeDelete/10000000);
	}
	
	public static void compareCollections (Map<Integer, Integer> firstMap, 
			Map<Integer, Integer> secondMap) {	
		Random rand = new Random();
		
		System.out.println("Fill");
		Long firstStartTimeFill= System.nanoTime();
		fillRandomMap(firstMap, 10000);
		double firstEndTineFill = (System.nanoTime() - firstStartTimeFill);
		System.out.format("%f", firstEndTineFill/10000000);
		System.out.print("\t");
		Long secondStartTimeFill= System.nanoTime();
		fillRandomMap(secondMap, 10000);
		double secondEndTineFill = (System.nanoTime() - secondStartTimeFill);
		System.out.format("%f%n", secondEndTineFill/10000000);
		
		System.out.println("Find element");
		Long firstStartTimeFind= System.nanoTime();
		firstMap.get(rand.nextInt(firstMap.size()));
		double firstEndTineFind = (System.nanoTime() - firstStartTimeFind);
		System.out.format("%f", firstEndTineFind/10000000);
		System.out.print("\t");
		Long secondStartTimeFind = System.nanoTime();
		secondMap.get(rand.nextInt(secondMap.size()));
		double secondEndTimeFind  = (System.nanoTime() - secondStartTimeFind);
		System.out.format("%f%n", secondEndTimeFind/10000000);
		
		System.out.println("Delete");
		Long firstStartTimeDelete = System.nanoTime();
		delectMap(firstMap);
		double firstEndTimeDelete  = (System.nanoTime() - firstStartTimeDelete);
		System.out.format("%f", firstEndTimeDelete/10000000);
		System.out.print("\t");
		Long secondStartTimeDelete = System.nanoTime();
		delectMap(secondMap);
		double secondEndTimeDelete  = (System.nanoTime() - secondStartTimeDelete);
		System.out.format("%f%n", secondEndTimeDelete/10000000);
	}
	
	public static void main(String args[]) {
		
		ArrayList<Integer> arrayListRandom = new ArrayList<Integer>();
		LinkedList<Integer> linkedListRandom = new LinkedList<Integer>();
		HashSet<Integer> hashSetRandom = new HashSet<Integer>();
		TreeSet<Integer> treeSetRandom = new TreeSet<Integer>();
		HashMap<Integer, Integer> hashMapRandom = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> treeMapRandom = new TreeMap<Integer, Integer>();
		
		//ArrayList vs LinkedList
		System.out.println("ArrayList\tLinkedList");
		compareCollections(arrayListRandom, linkedListRandom);
		
		//HashSet vs TreeSet
		System.out.println("\nHashSet\t\tTreeSet");
		compareCollections(hashSetRandom, treeSetRandom);
		
		//HashMap vs TreeMap
		System.out.println("\nHashMap\t\tTreeMap");
		compareCollections(hashMapRandom, treeMapRandom);

	}

}
