/** House.java - holds House name and ArrayList of Students.
 * @author Michael Schwarzbach - yjo504
 *
 */
package application.model;
import java.util.*;

public class House {

	private String name;
	private ArrayList<Student> students;
	
	/** House() - the constructor initializes the students 
	 * ArrayList, and declares the House name
	 * @param houseName
	 */
	public House(String houseName) {
		this.name = houseName;
		this.students = new ArrayList<Student>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public void addStudent(String name, int year) {
		Student student = new Student(name, year);
		this.students.add(student);
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	
	
	
/*
	@Override
	public String toString() {
		return "" + name ;
	}
	
	*/
	
	
	/*
	@Override
	public String toString() {
		String ret = "";
		ret += name ;
		for (Student currStudent : students) {
			ret += currStudent.toString();
		}
		return ret;
	}
	
	*/
		
}
