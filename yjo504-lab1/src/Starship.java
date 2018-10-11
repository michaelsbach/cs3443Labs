// The Starship class holds a given starship's name, id tag, and category of ship.
	//It also can hold a crew of size MAXCREW, declared here as 10. 
//
// Michael Schwarzbach
// yjo504
public class Starship {
	
	private static final int MAXCREW = 10;
	private String name, id, category;
	private CrewMember[] members;
	private int memberCount = 0;
	
	//the constructor initializes a crew of size MAXCREW and uses the
		//given parameters to initialize the proper name, id, and category.
	public Starship(String shipName, String shipID, String shipClass)
	{
		this.members = new CrewMember[MAXCREW];
		this.name = shipName;
		this.id = shipID;
		this.category = shipClass;
	}
	
	//the following getters and setters are able to return or set info on the ship.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	//this method adds a crewmember to the ship, then adds to the count.
	public void addCrewMember(CrewMember newMember)
	{
		this.members[memberCount] = newMember;
		this.memberCount++;
	}
	
	//the toString method prints out the ship's name, id, and category, then invokes
		//the toString method for each crewmember.
	public String toString()
	{
		String ret = "\n";
		ret += this.name + "(" + this.id + ")\n\n" + "[Class: " + 
				this.category + "]\n";
			

		for(int i=0; i< memberCount; i++) 
			ret += members[i].toString();
		return ret;
		
	}
	

}
