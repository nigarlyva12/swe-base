package OOP.WordFrequencyAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordAnalyzer {
	private List<Map.Entry<String, Integer>> entries = new ArrayList<>(); // for values of wordMap
	private List<String> keys = new ArrayList<>(); //for keys of wordMap
	
	public List<Entry<String, Integer>> sort(HashMap<String, Integer> wordMap){
		entries.clear();
		for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
           entries.add(entry);
        }
		int n=entries.size();
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i; j++) {
				if(entries.get(j).getValue()<entries.get(j+1).getValue()) {
					Entry<String, Integer> temp = entries.get(j);
					entries.set(j, entries.get(j+1));
					entries.set(j+1, temp);
				}
			}
		}
		return entries;
	}
	
	public Integer linearSearch(HashMap<String, Integer> wordMap, String target) {
		for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
	           keys.add(entry.getKey());
	           System.out.println(entry.getKey());
	     }
			int n=keys.size();
			
			for(int i=0; i<n; i++) {
				if(keys.get(i).equalsIgnoreCase(target)) {
					return i;
				}
			}
			return -1;
	}
	
	public List<Map.Entry<String, Integer>> topN(HashMap<String, Integer> wordMap, int n){
		List<Entry<String, Integer>> sorted = sort(wordMap);
		return sorted.subList(0, n);
	}
	
}
