/** School.java - holds School name and ArrayList of Houses,
 *     as well as an arraylist of .csv files for the Houses.
 *    It is also the access point for the Controller
 * @author Michael Schwarzbach - yjo504
 *
 */
package application.model;
import java.io.*;
import java.util.*;

public class School {

	private String name;
	private ArrayList<House> houses;
	private ArrayList<String> files;


	/** School() - the constructor initializes the houses
	 * ArrayList, and declares the school name
	 * @param schoolName
	 */
	public School(String schoolName) {
		this.name = schoolName;
		this.houses = new ArrayList<House>();
	}
	

	public School load() {
		File folder = new File("data");
		if (folder.exists()) {
			File[] fileArray = folder.listFiles();
			int count = 0;
			this.files = new ArrayList<String>();
			for (int i = 0; i < fileArray.length; i++) {
			    if (fileArray[i].isFile() && count < 5 ){
			        this.files.add(fileArray[i].getName());
			    	count++;
			    }
			    
			}
			try {
			for (int i = 0; i < fileArray.length; i++) {
				String hName = fileArray[i].getName();
				House currHouse = new House(hName.substring(0, hName.length() - 4));
				Scanner scan = new Scanner(fileArray[i]);
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					String[] info = line.split(",");
					int year = Integer.parseInt(info[1]);
					currHouse.addStudent(info[0], year);
				}
				this.houses.add(currHouse);
				scan.close();
			}
			}
			catch (Exception e){
				e.printStackTrace();
			}
		
		}
		return this;
	
	}
		
		
	
	
	/** save() - saves current House & Student information into "House".csv 
	 * (overwrites the data, not append)
	 */
	/*
	public void save()
	{
		//writes info to "HouseName".csv format "StudentName, Student Year"
		try{
			//FileWriter automatically overwrites data
			File folder = new File("../../../data");
			File[] fileArray = folder.listFiles();
			FileWriter fleetFile = new FileWriter("data/fleet.csv", false);
			for()
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
	*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<House> getHouses() {
		return houses;
	}

	public void setHouses(ArrayList<House> houses) {
		this.houses = houses;
	}
			
	//need toString
	
}
