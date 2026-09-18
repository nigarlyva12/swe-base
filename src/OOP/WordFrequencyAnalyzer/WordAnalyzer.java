package OOP.WordFrequencyAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordAnalyzer {
	private List<Integer> entries = new ArrayList<>();
	
	public List<Integer> sort(HashMap<String, Integer> wordMap){
		
		for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
           entries.add(entry.getValue());
        }
		int n=entries.size();
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i; j++) {
				if(entries.get(j)>entries.get(j+1)) {
					Integer temp = entries.get(j);
					entries.set(j, entries.get(j+1));
					entries.set(j+1, temp);
				}
			}
		}
		return entries;
	}
}
