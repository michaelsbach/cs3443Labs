/** Lab2.java- this class initalizes a single fleet, and uses fleet.csv and personnel.csv to load in starships & crew, then calls the fleet toString
 * 
 * @author Michael Schwarzbach - yjo504
 */

import java.io.IOException;

public class Lab2 {	
  	public static void main( String[] args ) {	
     	Fleet federation = new Fleet( "United Federation of Planets" );	

     	try{	
        	federation.loadStarships( "data/fleet.csv" );	
        	federation.loadCrew( "data/personnel.csv" );	


     	}catch( IOException e ){	
        	System.out.println( "Error loading the file - please check its location." );	
        	e.printStackTrace();	
     	}	

     	System.out.println( federation );	

  	}	
}	