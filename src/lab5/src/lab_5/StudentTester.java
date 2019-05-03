package lab_5;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
 
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class StudentTester {
	
	public ArrayList<Student> students;
	public ArrayList<Course> courses;
	public GradeService gsMock;
	
	@Before
	public void setup() {
		students = new ArrayList<Student>();
		students.add(new Student(1));
		students.add(new Student(2));
		students.add(new Student(3));
		
		courses = new ArrayList<Course>();
		courses.add(new Course("Math1"));
		courses.add(new Course("Math2"));
		courses.add(new Course("Math3"));
		gsMock = Mockito.mock(GradeService.class);
		
		for(Student s : students) {
			s.setCourses(courses);
			s.setGradeService(gsMock);
		}
		
		for(Course c : courses) {
			c.setStudents(students);
			c.setGradeService(gsMock);
		}
		
		for(Student s : students) {
			for(Course c : courses) {
				double grade = ThreadLocalRandom.current().nextInt(6,11);
				when(gsMock.getGrade(s, c)).thenReturn(7.00);
			}
		}
	}
	
	@Test
	public void testAverageStudent() {
		
		for(Student s : students) {
			assertTrue(s.calculateAverageGrade() == 7.00);
		}
	}
	
	@Test
	public void testAverageCourse() {
		for(Course c : courses) {
			assertTrue(c.getAverageGrade() == 7.00);
		}
	}
}
