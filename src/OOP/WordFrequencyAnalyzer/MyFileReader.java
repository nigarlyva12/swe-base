package OOP.WordFrequencyAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyFileReader {
	private File filePath;
	
	MyFileReader(File filePath){
		this.filePath = filePath;
	}
	
	public List<String> readTheFile() throws IOException {
		List<String> wordList = new ArrayList<>();
		String text ="";
		try (FileReader reader = new FileReader(filePath)) {
			int i=0;
			
			while((i=reader.read())!=-1) {
				text+= (char) i;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringTokenizer t = new StringTokenizer(text, " ");
		
		while(t.hasMoreTokens()) {
			wordList.add(t.nextToken());
		}
		return wordList;
	}
}
