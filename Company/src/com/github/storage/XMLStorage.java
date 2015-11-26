package com.github.storage;


import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.github.plane.Plane;

public class XMLStorage implements Storage {
	
	final String PATH = "Planes.xml";

	@Override
	public ArrayList<Plane> loadFromStorage(ArrayList<Plane> List) {	
		try {
			File file = new File(PATH);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser sAXParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				
				boolean bname = false;
				boolean bcapacity = false;
				boolean bcarryingcapacity = false;
				boolean bflightrange = false;
				boolean brecord = false;
				
				String name ="";
				int cap = 0;
				int carcap = 0;
				int frange = 0;
				
				@Override
				public void characters(char[] ch, int start, int length)
						throws SAXException {
					if (bname) {
						name = new String(ch, start, length);
						bname = false;
					}
					if (bcapacity) {
						cap = Integer.parseInt(new String(ch, start, length));
						bcapacity = false;
					}
					if (bcarryingcapacity) {
						carcap = Integer.parseInt(new String(ch, start, length));
						bcarryingcapacity = false;
					}
					if (bflightrange) {
						frange = Integer.parseInt(new String(ch, start, length));
						bflightrange = false;
					}
					if (brecord) {
						List.add(new Plane(name,cap,carcap,frange));
						brecord = false;
					}
				}
				
				@Override
				public void startElement(String uri, String localName, String qName,
						Attributes attributes) throws SAXException {
					
					if (qName.equalsIgnoreCase("name")) {
						bname = true;
					} else if (qName.equalsIgnoreCase("capacity")) {
						bcapacity = true;
					} else if (qName.equalsIgnoreCase("carryingcapacity")) {
						bcarryingcapacity = true;
					} else if (qName.equalsIgnoreCase("flightrange")) {
						bflightrange = true;
					}
				}
				
				@Override
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					if (qName.equalsIgnoreCase("plane")) {
						brecord = true;
					}
				}
			};

			sAXParser.parse(file, handler);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return List;
	}

	@Override
	public void saveInStorage(ArrayList<Plane> listOfPlanes) {
		// TODO Auto-generated method stub

	}
	
	
	//Output of xml file
	public void outputXML () {
		try {
			File file = new File(PATH);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser sAXParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				
				boolean bname = false;
				boolean bcapacity = false;
				boolean bcarryingcapacity = false;
				boolean bflightrange = false;
				
				@Override
				public void characters(char[] ch, int start, int length)
						throws SAXException {
					if (bname) {
						System.out.println("\tName: " + new String(ch, start, length));
						bname = false;
					}
					if (bcapacity) {
						System.out.println("\tCapacity: " + new String(ch, start, length));
						bcapacity = false;
					}
					if (bcarryingcapacity) {
						System.out.println("\tCarrycapacity: " + new String(ch, start, length));
						bcarryingcapacity = false;
					}
					if (bflightrange) {
						System.out.println("\tFlightrange: " + new String(ch, start, length));
						bflightrange = false;
					}
				}
				
				@Override
				public void startElement(String uri, String localName, String qName,
						Attributes attributes) throws SAXException {
					
					if (qName.equalsIgnoreCase("plane")) {
						System.out.println("<" + qName + ">");
					} else if (qName.equalsIgnoreCase("name")) {
						bname = true;
					} else if (qName.equalsIgnoreCase("capacity")) {
						bcapacity = true;
					} else if (qName.equalsIgnoreCase("carryingcapacity")) {
						bcarryingcapacity = true;
					} else if (qName.equalsIgnoreCase("flightrange")) {
						bflightrange = true;
					}
				}
				
				@Override
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					if (qName.equalsIgnoreCase("plane")) {
						System.out.println("</" + qName + ">");
					}
				}
			};

			sAXParser.parse(file, handler);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
