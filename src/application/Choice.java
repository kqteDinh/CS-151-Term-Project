package application;

public class Choice {
	private int id;
	private String name;
	private String type; 
	//text, dropdown, date, 
	//droptext, multi, multitext
	
	public Choice(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
}
