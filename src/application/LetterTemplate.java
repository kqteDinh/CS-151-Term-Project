package application;

import java.util.List;

public class LetterTemplate {
	public static String compileLetter(/*String firstName,*/ String lastName, String gender,
			String date, String program, String firstSemester, String year, String firstCourse, 
			String firstGrade, List<String> courses, List<String> grades, List<String> academics,
			List<String> personals, FacultyInfo faculty) {
		
		String fullName =/* firstName + " " +*/ lastName;
		String uPronoun, lPronoun, oPronoun;
		switch(gender) {
		case "Male":
			uPronoun = "He";
			lPronoun = "he";
			oPronoun = "him";
			break;
		case "Female":
			uPronoun = "She";
			lPronoun = "she";
			oPronoun = "her";
			break;
		case "Other":
		default:
			uPronoun = "They";
			lPronoun = "they";
			oPronoun = "them";
			break;
		}
		
		
		String toReturn = "For: " + fullName +
			"\n\nDate: " + date + 
			"\n\nTo: Graduate Admissions Committee " +
			"\n\nI am writing this letter to recommend my former student " + fullName +  
			" who is applying for the " + program + " in your school." +
			"\n\nI met "/* + firstName*/ + " in " + firstSemester + " " + year + " when " + lPronoun + " enrolled in my \"" + 
			firstCourse + "\" course.\n" +
			/*firstName +*/ " earned " + firstGrade + 
			" from this tough course, and this shows how knowledgeable and hard worker " + lPronoun + " is.\n\n";
			
		if(courses != null && courses.size() > 0) {
			
			if(courses.size() > 1) {
				toReturn += uPronoun + " also earned ";
				for(int i = 0; i < courses.size() - 1; i++) {
					toReturn += grades.get(i) + " from my \"" + courses.get(i) + "\", ";
				}
				toReturn += "and " + grades.get(courses.size()-1) + " from my \"" + courses.get(courses.size()-1) + "\" ";
			}
			else {
				toReturn += uPronoun + " also earned " + grades.get(0) + " from my \"" + courses.get(0) + "\" ";
			}
			if(courses.size() < 2) {
				toReturn += "course.\n\n";
			}
			else {
				toReturn += "courses.\n\n";
			}
		}
		
		if(academics != null)  {
			if (academics.size() > 1) {
				//toReturn += firstName + " ";
				toReturn += lastName + " ";
				for(int i = 0; i < academics.size() - 1; i++) {
					toReturn += academics.get(i) + ", ";
				}
				toReturn += "and " + academics.get(academics.size() - 1) + ".\n\n";
			}
			else if(academics.size() == 1) {
				//toReturn += firstName + " " 
						toReturn += lastName + " " + academics.get(0) + ".\n\n";
			}
		}
		
		if(personals != null)  {
			if (personals.size() > 1) {
				//toReturn += firstName + "was always ";
				toReturn += lastName + " " + "was always ";
				for(int i = 0; i < personals.size() - 1; i++) {
					toReturn += personals.get(i) + ", ";
				}
				toReturn += "and " + personals.get(personals.size() - 1) + ".\n\n";
			}
			else if(personals.size() == 1) {
				//toReturn += firstName + " was always " + personals.get(0) + ".\n\n";
				toReturn += lastName + " was always " + personals.get(0) + ".\n\n";
			}
		}
		
		toReturn += "Furthermore, I noticed from the term project result, " + lPronoun + 
				" developed leadership, time management, and problem-solving skills. " +
				uPronoun + " worked effectively with the team members and delegated " + 
				"tasks appropriately. They were able to deliver a successful project in " +
				"a timely fashion." +
				"\n\nI believe that " + /*firstName*/lastName + " has the capacity to excel at higher " +
				"education program and this is my pleasure to highly recommend " + oPronoun + "." +
				"\n\nPlease do not hesitate to contact me with further questions." +
				"\n\nVery Respectfully,\n" + faculty.getName() + "\n" + faculty.getTitle() +
				"\n" + faculty.getSchool() + " " + faculty.getDepartment() + "\n" +
				faculty.getEmail() + "\n" + faculty.getPhone();
		return toReturn;
	}
}
