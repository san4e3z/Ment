package com.github.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class TestRunner {

	public static void main(String[] args) {
		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG tng = new TestNG();
		tng.addListener(tla);
		
		//tng.addListener(new MyTestListener);
		
		XmlSuite suite = new XmlSuite();
		suite.setName("FirstSuite");
		
		List<String> files = new ArrayList<String>();
		files.addAll(new ArrayList<String>() {{
			add("./src/testng.xml");
		}});
		
		suite.setSuiteFiles(files);
		suite.setParallel(XmlSuite.PARALLEL_CLASSES);
		suite.setThreadCount(4);
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		tng.setXmlSuites(suites);
		
		tng.run();
	}

}
