package application;

public class Letter {


	private int id;
    private String firstName;
    private String lastName;
    private String date;
    private String school;
    private String program;
    private String content;
    
    public Letter(int id, String firstName, String lastName, String date, String school, String program, String content) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.school = school;
		this.program = program;
		this.content = content;
	}
    
    public String getName() {
    	return firstName + " " + lastName;
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDate() {
		return date;
	}

	public String getProgram() {
		return program;
	}
	
	public String getSchool() {
		return school;
	}
}
