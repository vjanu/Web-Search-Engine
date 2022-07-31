package com.acc.se.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.acc.se.dto.RankingPage;

public class SortSearching {
	
	public static List<RankingPage> sortKey(Map<Integer, String> hm) {
		List<RankingPage> filename = new ArrayList<RankingPage>();
		int i = 0;
		
		System.out.println("After Sorting");   
		
		Map<Integer, String> reverseSortedMap = new TreeMap<Integer,String>(Collections.reverseOrder()); 
		reverseSortedMap.putAll(hm);
		
		Iterator itr=reverseSortedMap.keySet().iterator();  
		while(itr.hasNext())    
		{    
			i++;
			RankingPage rp = new RankingPage();
			int key=(int)itr.next();  
			System.out.println("Occurrences:  "+key+"     File_name:   "+hm.get(key)  +"\n"); 
			
			rp.setFileName(hm.get(key));
			rp.setRank(i);
			
			filename.add(rp);
			System.out.println("rank: "+rp.getRank());
			if(i == 10) 
				break;
		}   
		return filename;
	}
}
