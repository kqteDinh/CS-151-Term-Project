package application;

public class Option {
	private int id;
	private int choice_id;
	private String name;
	
	public Option(int id, int choice_id, String name) {
		this.id = id;
		this.name = name;
		this.choice_id = choice_id;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getChoiceId() {
		return choice_id;
	}
	
	public String toString(){
		return name;
		
	}
}
