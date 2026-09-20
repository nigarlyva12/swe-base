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
	
	public void addSubject(Subject subject) {
		attendingSubjects.add(subject);
	}
	
	public double calculateAverage() {
		int sum = 0;
		int size = grades.size();
		
		if (grades.isEmpty()) return 0.0;
		for(int i=0; i<size; i++) {
			sum += grades.get(i).getValue();
		}
		return (double) sum/size;
	}
	
	public Grade getGradeForSubject(Subject subject) {
		for(Grade grade : grades) {
			if(grade.getSubjectName().getSubjectId().equalsIgnoreCase(subject.getSubjectId()))
				return grade;
		}
		return null;
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
