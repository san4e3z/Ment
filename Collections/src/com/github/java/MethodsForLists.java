package com.github.java;

import java.util.ArrayList;
import java.util.LinkedList;

public class MethodsForLists extends GeneralMethods{
	
	protected static void compareLists (ArrayList<Integer> arrList, LinkedList<Integer> linkList) {
		
		double arrTime = timeInsertCollection(arrList);
		double linkTime = timeInsertCollection(linkList);
		printResults("INSERT", "ArrayList", arrTime, "LinkedList", linkTime);
				
		arrTime = timeFindList(arrList);
		linkTime = timeFindList(linkList);
		printResults("FIND", "ArrayList", arrTime, "LinkedList", linkTime);
				
		arrTime = timeDeleteCollection(arrList);
		linkTime = timeDeleteCollection(linkList);
		printResults("DELETE", "ArrayList", arrTime, "LinkedList", linkTime);
		
	}	
}
