package statsanalyzer;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Start {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Analyzer analyzer = new Analyzer();
		
		List<Data> datas = analyzer.getStatsData();
		
		//datas.forEach(data-> System.out.println(data.toString()));
		
		List<String> dates = analyzer.getDates(datas);
		
		//dates.forEach(date-> System.out.println(date));
		
		for(int count = 1; count<=49; count++) {
			analyzer.getPresence(count, dates, datas);
		}
		
		Iterator<Entry<String, String>> itr = analyzer.numberMap.entrySet().iterator();
		
		while(itr.hasNext()) {
			Entry<String, String> entry = itr.next();
			System.out.println(entry.getKey()+";" + entry.getValue());
		}

	}

}
