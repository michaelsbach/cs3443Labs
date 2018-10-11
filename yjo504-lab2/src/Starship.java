/** Starship.java- The Starship class holds a given starship's name, id tag, and category of ship. 
 * It also holds an array list of CrewMembers assigned to a given starship
 * @author Michael Schwarzbach - yjo504
 */ 

import java.util.ArrayList;

public class Starship {
	
	private String name, id, category;
	private ArrayList<CrewMember> members;
	
	
	/** Starship() - the constructor initializes a crew of size MAXCREW and uses the
	 * given parameters to initialize the proper name, id, and category.
	 * 
	 * @param shipName
	 * @param shipId
	 * @param shipClass
	 */
	public Starship(String shipName, String shipId, String shipClass)
	{
		this.members = new ArrayList<CrewMember>();
		this.name = shipName;
		this.id = shipId;
		this.category = shipClass;
	}
	
	//the following getters and setters are able to return or set info on the ship.
	
	/** getName() - 
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/** setName() - 
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** getId() - 
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/** setId() - 
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** getCategory() - 
	 * 
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/** setCategory() - 
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/** getMembers() - 
	 * 
	 * @return members ArrayList
	 */
	public ArrayList<CrewMember> getMembers() {
		return members;
	}

	/** setMembers() - 
	 * 
	 * @param members ArrayList
	 */
	public void setMembers(ArrayList<CrewMember> members) {
		this.members = members;
	}


	/** addCrewMember() - this method adds a single crewmember to the ship
	 * 
	 * @param newMember
	 */
	public void addCrewMember(CrewMember newMember)
	{
		this.members.add(newMember);
	}
	

	/** removeCrewMember() - removes a single crewmember from the ship using their index
	 * @param redShirt
	 */
	public void removeCrewMember(CrewMember redShirt)
	{
		this.members.remove(redShirt);
	}
	
	
	/** toString() - prints out the ship's name, id, and category, then invokes
	 * the toString method for each crewmember.
	 * @return ret (toString)
	 */
	public String toString()
	{
		String ret = "\n";
		ret += this.name + " [" + this.id + "]," + " Class: " + 
				this.category + ", Crew: " + this.members.size();
			
		if (this.members.size() > 0)
			for(int i=0; i< this.members.size(); i++) 
				ret +=  "\n" + members.get(i).toString();
		return ret;
		
	}
	

}
