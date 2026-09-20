package OOP.StudentGradeManager;

public class Subject {
	private String subjectId;
	private String subjectName;
	
	Subject(String subjectId, String subjectName){
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}
