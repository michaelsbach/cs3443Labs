/** Fleet.java - The Fleet class holds the name of the fleet and initializes a number of starships.
 * @author Michael Schwarzbach - yjo504
 */

import java.util.*;
import java.io.*;

public class Fleet 
{
	
	private String name;
	private ArrayList<Starship> starships;
	
	/** Fleet() - the constructor initializes the starships ArrayList, 
	 * and declares the fleet name
	 * @param fleetName
	 */
	public Fleet(String fleetName) {
		this.name = fleetName;
		this.starships = new ArrayList<Starship>();
	}

	// the following getters and setters are able to return or set info on the fleet.
	
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return starships ArrayList
	 */
	public ArrayList<Starship> getStarships() {
		return this.starships;
	}

	
	
	/**
	 * 
	 * @param starships ArrayList
	 */
	public void setStarships(ArrayList<Starship> starships)
	{
		this.starships.addAll(starships);
	}	
	
	
	/**
	 * @param newShip
	 */
	public void addStarship(Starship newShip)
	{
		this.starships.add(newShip);
	}

	/**
	 * @param byeShip
	 */
	public void removeStarship(Starship byeShip)
	{
		this.starships.remove(byeShip);
	}
	
	/** loadStarships() - uses filename to add ships to fleet
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void loadStarships(String fileName) throws IOException{
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine())
		{
			String line = scan.nextLine();
			String[] token = line.split(",");
	
			Starship tempShip = new Starship(token[0], token[1], token[2]);
			
			starships.add(tempShip);
			
		}
		
		scan.close();
		
	}
	

	/** loadCrew() - uses filename to add crewmembers to ship
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void loadCrew(String fileName) throws IOException {
		
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		
		
		while(scan.hasNextLine())
		{
			String line = scan.nextLine();
			String[] token = line.split(",");
			int shipIndex= -3;

			CrewMember tempMem = new CrewMember(token[0], token[1], token[2], token[4]);		
			
			//uses provided shipId to add crewmember into proper ship
			//need to use token[3] (crewmember's ship) to find proper starship,
			// then add the member to that ship
			for (int i=0; i < starships.size(); i++)
			{
				Starship currShip = starships.get(i);
				if (currShip.getId().equals(token[3]))
				{
					shipIndex = i;
					break;
				}
			}
			
			if (shipIndex > 0)
				starships.get(shipIndex).addCrewMember(tempMem);
			
		}
		scan.close();
	
	}
	
	/** reassign() - removes a crewmember's ship assignment and adds to new ship using its ID
	 * 
	 * @param crewName
	 * @param shipId
	 */
	public void reassign(String crewName, String shipId) {		
		
		int oldShipIndex = -2, newShipIndex = -3, crewIndex = -4;
		//finds the new ship's index
		for(int i=0; i < starships.size(); i++)
		{
			Starship currShip = starships.get(i);
			
			//iterates through each ship until crewmember's location is found
			if (crewIndex < 0)
			{
				for(int j=0; j < currShip.getMembers().size(); j++)
				{
					CrewMember currMember = currShip.getMembers().get(j);
					if (currMember.getName().equals(crewName))
					{
						crewIndex = j;
						oldShipIndex = i;
					}
				}
			}	
			if (currShip.getId().equals(shipId))
				newShipIndex = i;
		}
		
		Starship oldShip = starships.get(oldShipIndex);
		CrewMember hoi = oldShip.getMembers().get(crewIndex);
		Starship newShip = starships.get(newShipIndex);
		newShip.addCrewMember(hoi);
		oldShip.removeCrewMember(hoi);

		//in case save() needs to be called after every reassign, can enable the comment
	//  save();
	
	}
	
	/** save() - saves current fleet & personnel information back into respective data files 
	 * (overwrites the data, not append)
	 */
	public void save()
	{
		//writes info to fleet.csv format "ShipNm,Id,Class"
		try{
			//FileWriter automatically overwrites data
			FileWriter fleetFile = new FileWriter("data/fleet.csv", false);
			for(int i=0; i < starships.size(); i++)
			{
				Starship currShip = starships.get(i);
				fleetFile.write(currShip.getName() + "," +currShip.getId()+","+currShip.getCategory());
				if (i != starships.size()-1)
					fleetFile.write("\n");
			}
			fleetFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//writes info to personnel.csv format "Nm,Pos,Rank,ShipId,Species"
		try{
			FileWriter hoiFile = new FileWriter("data/personnel.csv");
			for(int i=0; i < starships.size(); i++)
			{
				Starship currShip = starships.get(i);
				for(int j=0; j < currShip.getMembers().size(); j++)
				{
					CrewMember currMem = currShip.getMembers().get(j);
					hoiFile.write(currMem.getName() + "," +currMem.getPosition()+","+currMem.getRank()
					    +","+currShip.getId()+","+currMem.getSpecies());
					
					if (i != starships.size()-1)
						hoiFile.write("\n");
				}
				
			}
			hoiFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/** toString() - the toString method prints fleet information with 
	 * formatting, then calls the toString method for each starship
	 * @return ret (toString)
	 */
	public String toString()
	{
		String ret = "";
		ret += this.name + "\n";

		for(int i=0; i<29; i++)
			ret += "-";
		ret += "\n";
		
		
		for(int i = 0; i < starships.size(); i++ ) 
			ret += starships.get(i).toString();
		
		return ret;
	}
	
}
