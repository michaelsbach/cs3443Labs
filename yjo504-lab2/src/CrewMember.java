/** CrewMember.java - sets the member's name, position, rank, and species.
 * @author Michael Schwarzbach - yjo504
 *
 */

public class CrewMember {
	
	private String name, position, rank, species;
	
	
	/** CrewMember() - the constructor sets the passed in strings as each crew member's 
	 * name, position, rank, and species, respectively
	 * @param name (String)
	 * @param position (String)
	 * @param rank (String)
	 * @param species (String)
	 */
	public CrewMember(String name, String position, String rank, String species)
	{
		this.name = name;
		this.position = position;
		this.rank = rank;
		this.species = species;

	}
	

	/** toString() - prints the member's name, position, rank, and species.
	 * @return ret
	 */
	public String toString()
	{
		String ret = "";
		ret += "  - " + this.getRank() + " " + this.getName() + ", " +
				this.getPosition() + " (" + this.getSpecies() + 
						  ")";	
		return ret;
	}
	
	// the following getters & setters are able to return or set info on a crewmember.
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return position
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return rank
	 */
	public String getRank() {
		return rank;
	}
	
	/**
	 * @param rank
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	/**
	 * @return species
	 */
	public String getSpecies() {
		return species;
	}
	
	/**
	 * @param species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	

}
