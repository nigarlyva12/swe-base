package OOP.StudentGradeManager;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String studentId;
	private String studentName;
	private List<Subject> attendingSubjects;
	private List<Grade> grades;
	
	Student(String studentId, String studentName){
		this.studentId = studentId;
		this.studentName = studentName;
		attendingSubjects = new ArrayList<>();
		grades = new ArrayList<>();
	}
	
	public void addGrade(Grade grade) {
		grades.add(grade);
	}
	public String getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Subject> getAttendingSubjects() {
		return attendingSubjects;
	}

	public void setAttendingSubjects(List<Subject> attendingSubjects) {
		this.attendingSubjects = attendingSubjects;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
}
