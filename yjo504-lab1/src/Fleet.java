// The Fleet class holds the name of the fleet and initializes a number of starships.
//
// Michael Schwarzbach
// yjo504
public class Fleet 
{
	private String name;
	private Starship[] starships;
	private int shipCount = 0;
	
	//the constructor initializes space for 3 starships,
	//and declares the fleet name
	public Fleet(String fleetName) {
		this.name = fleetName;
		this.starships = new Starship[3];
	}


	//method to return info on starships
	public Starship[] getStarships() {
		return this.starships;
	}
	//method to set info on starships
	public void setStarships(Starship[] starships)
	{
		this.starships = starships;
		this.shipCount = starships.length;
	}	
	//method to add info on starships
	public void addStarship(Starship newShip)
	{
		this.starships[shipCount] = newShip;
		this.shipCount++;
	}

	
	// the toString method prints fleet information with
	//formatting, then calls the toString method for each starship
	public String toString()
	{
		String ret = "";
		
		for(int i=0; i<58; i++)
		{
			ret += "-";
			if (i == 28)
				ret +="\n" + this.name + "\n";
		}
		
		ret+= "\n";
		
		
		for(int i = 0; i < shipCount ; i++ ) 
		{
			ret += starships[i].toString() + "\n";
			if (i != shipCount-1)
				ret += "- - - - - - - - - - - - - - - - - -\n";
		}
		return ret;
	}
	

//executes creation of a fleet, two starships, and 8 crewmembers
	//the crewmembers are then assigned to one of the two ships. Finally,
	//information about the fleet is printed out using the toString method
	public static void main( String[] args ) { 
		Fleet federation = new Fleet( "United Federation of Planets" ); 
		Starship enterpriseA = new Starship( "USS Enterprise", "NCC-1701-A", "Constitution" ); 
		Starship enterpriseD = new Starship( "USS Enterprise", "NCC-1701-D", "Galaxy" );

		CrewMember jamesKirk = new CrewMember( "James T. Kirk", "Commanding Officer" ); 
		CrewMember spock = new CrewMember( "Spock", "First Officer" ); 
		CrewMember leonardMcCoy = new CrewMember( "Leonard McCoy", "Chief Medical Officer" ); 
		CrewMember montgomeryScott = new CrewMember( "Montgomery Scott", "Chief Engineering Officer" ); 
		CrewMember jeanLucPicard = new CrewMember( "Jean-Luc Picard", "Commanding Officer" ); 
		CrewMember williamRiker = new CrewMember( "William T. Riker", "First Officer" ); 
		CrewMember beverlyCrusher = new CrewMember( "Beverly Crusher", "Chief Medical Officer" ); 
		CrewMember geordiLaForge = new CrewMember( "Geordi La Forge", "Chief Engineering Officer" ); 

		enterpriseA.addCrewMember( jamesKirk ); 
		enterpriseA.addCrewMember( spock ); 
		enterpriseA.addCrewMember( leonardMcCoy ); 
		enterpriseA.addCrewMember( montgomeryScott ); 
		enterpriseD.addCrewMember( jeanLucPicard ); 
		enterpriseD.addCrewMember( williamRiker ); 
		enterpriseD.addCrewMember( beverlyCrusher ); 
		enterpriseD.addCrewMember( geordiLaForge ); 

		federation.addStarship( enterpriseA ); 
		federation.addStarship( enterpriseD ); 

		System.out.println( federation ); 
		} 
	
}
