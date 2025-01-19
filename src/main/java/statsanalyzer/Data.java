package statsanalyzer;

public class Data {

	Long id;
	String date;
	Integer num;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public String toString() {
		return String.format("%s;%s;%s", this.id, this.date, this.num);
	}
}
