/** Student.java - holds Student name and year.
 * @author Michael Schwarzbach - yjo504
 *
 */
package application.model;
import java.util.*;

public class Student {

	private String name;
	private int year;
	
	/** Student() - the constructor initializes the name & year
	 * of each student 
	 * @param name, year
	 */
	public Student(String name, int year) {
		this.name = name;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "" + year + " - " + name + "\n";
	}
	

}
