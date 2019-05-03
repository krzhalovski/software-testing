package lab_5;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int index;
	private List<Course> courses;
	private GradeService gradeService;
	
	public double calculateAverageGrade() {
		return courses.stream().mapToDouble(c -> gradeService.getGrade(this, c)).sum() / courses.size();
	}
	
	public GradeService getGradeService() {
		return this.gradeService;
	}
	
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	
	public List<Course> getCourses() {
		return this.courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public List<Double> getGrades() {
		ArrayList<Double> grades = new ArrayList<Double>();
		
		for(Course c : courses) {
			grades.add(gradeService.getGrade(this, c));
		}
		
		return grades;
	}
	
	public Student(int id) {
		this.index = id;
		this.courses = new ArrayList<Course>();
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
}