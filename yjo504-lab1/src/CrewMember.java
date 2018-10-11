// The CrewMember class is a basic one that sets the member's name and position.
//
// Michael Schwarzbach
// yjo504
public class CrewMember {
	
	private String name, position;
	
	//the constructor sets the passed in strings as each crew member's
		// respective name and position
	public CrewMember(String name, String position)
	{
		this.name = name;
		this.position = position;
	}
	
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//the toString method prints out formatting and the member's name and position.
	public String toString()
	{
		String ret = "";
		ret += "- " + this.getPosition() + ": " + 
						  this.getName() + "\n";	
		return ret;
	}
	

}
