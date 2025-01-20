package statsanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFormater {
	
	public List<String> format() throws IOException {
		List<String> lines = new ArrayList<String>();
		File inputFile = new File("data.txt");
		FileReader fr = new FileReader(inputFile);
		
		BufferedReader bfr = new BufferedReader(fr);
	
		String line = "";
		while((line=bfr.readLine())!=null) {
			if(line.contains("With Max Millions!")) {
				System.out.println("Skipped");
			}else if(line.startsWith("$")) {
				System.out.println("Skipped");	
				
			}else {
				lines.add(line);
			}
		}
		
		return lines;
	}
	
	public void getLines(List<String> lines){
		
		
		int i=0;
		String line = "";
		for (String data : lines) {
			if(i<9) {
				line += data +";";
				i++;
			}else {
				System.out.println(line);
				line = data + ";";
				i=1;
			}
			
		}
		
	}
 
}
