package OOP.WordFrequencyAnalyzer;

import java.util.HashMap;
import java.util.List;

public class WordCounter {
	private HashMap<String, Integer> wordMap = new HashMap<>();
	
	public HashMap<String, Integer> countFrequencyOfEachWord(List<String> wordList){
		for(String word : wordList) {
			word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
			wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
		}
		return wordMap;
	}
	
	public HashMap<String, Integer> getWordMap() {
		return wordMap;
	}
	public void setWordMap(HashMap<String, Integer> wordMap) {
		this.wordMap = wordMap;
	}
}
