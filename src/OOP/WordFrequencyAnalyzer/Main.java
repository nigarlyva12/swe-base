package OOP.WordFrequencyAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyFileReader file = new MyFileReader(new File("C:\\Users\\Nigar\\eclipse-workspace\\swe-base\\src\\OOP\\WordFrequencyAnalyzer\\myFile.txt"));
		List<String> wordList = file.readTheFile();
		
		WordCounter wc = new WordCounter();
		HashMap<String,Integer> hm = wc.countFrequencyOfEachWord(wordList);
		
		WordAnalyzer wa = new WordAnalyzer();
		List<Entry<String, Integer>> result = wa.sort(hm);
		
//		for(Entry<String, Integer> i : result) {
//			System.out.println(i+" ");
//		}
//		
//		Integer res = wa.linearSearch(hm, "the");
//		if(res == -1) {
//			System.out.println("target not found");
//		}else 
//			System.out.println("Element is present at index "+res);
		
		for(Entry<String, Integer> i : wa.topN(hm, 3)) {
			System.out.println(i+" ");
		}
		
	}

}
