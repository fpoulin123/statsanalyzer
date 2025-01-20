package statsanalyzer;

import java.io.IOException;
import java.util.List;

public class Start2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DataFormater frm = new DataFormater();
		List<String> lines = frm.format();
		frm.getLines(lines);
		
	}

}
