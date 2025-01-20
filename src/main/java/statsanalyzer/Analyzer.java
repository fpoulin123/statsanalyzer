package statsanalyzer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Analyzer {
	
	Map<String, String> numberMap = new HashMap<String, String>();
	
	public List<Data> getStatsData() throws SQLException {
		
		List<Data> dataList = new ArrayList<Data>();
		DBConnector dbctr = new DBConnector();
		Connection cnx = dbctr.getConnection();
		
		Statement stmt = cnx.createStatement();
		
		ResultSet resultSet = stmt.executeQuery("select*from data;");
		cnx.close();
		while(resultSet.next()) {
			Data data = new Data();
			data.setId(resultSet.getLong("id"));
			data.setDate(resultSet.getString("date"));
			data.setNum(resultSet.getInt("num"));
			dataList.add(data);
		}
		
		return dataList;
		
	}
	
	public List<String> getDates(List<Data> datas){
		List<String> dates = new ArrayList<>();
		
		for (Data data : datas) {
			String date = data.getDate();
			if(!dates.contains(date)) {
				dates.add(date);
			}
			
		}
		
		return dates;
	}
	
	public List<Presence> getPresence(Integer num, List<String> dates, List<Data> datas){
		List<Presence> presences = new ArrayList<Presence>();
		List<String> flatPresenceList = new ArrayList<String>();
		
		
		
		
		for(Data data : datas) {
			
			String numStr = data.getNum().toString();
			if(numStr.length()==1)numStr="0"+numStr;
			flatPresenceList.add(data.getDate()+numStr);
		}
		
		for (String date : dates) {
			int in = 0;
			String numeroStr = num.toString();
			if(num<10)numeroStr= "0"+numeroStr;
			String key = date+numeroStr;
			if(flatPresenceList.contains(key)) {
				in = 1;
			}
			String previousNum = numberMap.get(date);
			if(previousNum==null)previousNum="";
			//System.out.println(date + ";" + in);
			numberMap.put(date, previousNum +in + ";") ;
		}
		
		return presences;
	}
	

}
