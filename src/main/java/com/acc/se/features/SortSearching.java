package com.acc.se.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortSearching {
	
	public static List<String> sortKey(Map<Integer, String> hm) {
		Map<Integer, String> map=new HashMap<Integer, String>();  
		List<String> filename = new ArrayList<String>();
		
		System.out.println("After Sorting");  
		
		TreeMap<Integer,String> tm=new  TreeMap<Integer,String> (hm);  
		Iterator itr=tm.keySet().iterator();               
		while(itr.hasNext())    
		{    
			int key=(int)itr.next();  
			System.out.println("Occurrences:  "+key+"     File_name:   "+hm.get(key) +"\n");  
			filename.add(hm.get(key));
		}   
		return filename;
		//Map<Integer, String> reverseSortedMap = new TreeMap<Integer,String>(Collections.reverseOrder()); 
		//reverseSortedMap.putAll(hm);
		//System.out.println(reverseSortedMap);	 
	}
}
