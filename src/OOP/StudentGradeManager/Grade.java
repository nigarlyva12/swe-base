package OOP.StudentGradeManager;

public class Grade {
	private int value;
	private String description;
	private Subject subjectName;
	
	Grade(int value, String description, Subject subjectName){
		this.value = value;
		this.description = description;
		this.subjectName = subjectName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Subject getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(Subject subjectName) {
		this.subjectName = subjectName;
	}
	
	
}
