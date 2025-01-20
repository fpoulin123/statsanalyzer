package statsanalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Randomizer {
	
	
	
	public void randomize(int numtirage) {
			
		for(int i=0;i<numtirage;i++) {
			List<String> catalog = new ArrayList<String>();
			
			catalog.add("4");
			catalog.add("5");
			catalog.add("8");
			catalog.add("15");
			catalog.add("18");
			catalog.add("22");
			catalog.add("23");
			catalog.add("29");
			catalog.add("30");
			catalog.add("32");
			catalog.add("40");
			catalog.add("42");
			catalog.add("45");
			catalog.add("46");
			catalog.add("47");
			catalog.add("49");
			catalog.add("50");
			String tirage = "";
			for(int y=0;y<7;y++) {
				Random rand = new Random();
				int pos = rand.nextInt(catalog.size());
				
				String num = catalog.get(pos);
				tirage += num +"-";
				catalog.remove(num);
			}
			System.out.println(tirage);
			
					
		}
		
		
		
	}

}
