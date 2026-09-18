package OOP.WordFrequencyAnalyzer;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyFileReader file = new MyFileReader(new File("C:\\Users\\Nigar\\eclipse-workspace\\swe-base\\src\\OOP\\WordFrequencyAnalyzer\\myFile.txt"));
		file.readTheFile();
	}

}
