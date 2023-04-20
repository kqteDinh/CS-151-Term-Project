package application;

public class FacultyInfo {
	private String name;
	private String title;
	private String school;
	private String department;
	private String email;
	private String phone;
	
	public FacultyInfo(String name, String title, String school, String department, String email, String phone) {
		super();
		this.name = name;
		this.title = title;
		this.school = school;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getSchool() {
		return school;
	}

	public String getDepartment() {
		return department;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}


}
