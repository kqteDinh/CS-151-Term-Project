package application;

public class Category {
	private int id;
	private String name;
	private String type; 
	//text, dropdown, date, 
	//droptext, multi, multitext
	
	public Category(int id, String name, String type) {
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
