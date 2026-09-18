package OOP.WordFrequencyAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyFileReader file = new MyFileReader(new File("C:\\Users\\Nigar\\eclipse-workspace\\swe-base\\src\\OOP\\WordFrequencyAnalyzer\\myFile.txt"));
		List<String> wordList = file.readTheFile();
		
		WordCounter wc = new WordCounter();
		HashMap<String,Integer> hm = wc.countFrequencyOfEachWord(wordList);
		
		WordAnalyzer wa = new WordAnalyzer();
		List<Integer> result = wa.sort(hm);
		
		for(Integer i : result) {
			System.out.println(i+" ");
		}
	}

}
