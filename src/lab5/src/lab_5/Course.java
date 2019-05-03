package lab_5;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String name;
	private List<Student> students;
	private GradeService gs;
	
	public Course(String name) {
		this.name = name;
		this.students = new ArrayList<Student>();
	}
	
	public double getAverageGrade() {
		return students.stream().mapToDouble(s -> gs.getGrade(s, this)).sum() / students.size();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Student> getStudents() {
		return this.students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void setGradeService(GradeService gs) {
		this.gs = gs;
	}
}
