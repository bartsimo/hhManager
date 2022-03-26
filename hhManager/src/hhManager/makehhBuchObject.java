package hhManager;
import java.io.*;
import java.util.*;

public class makehhBuchObject  
{
	List<Entry> hhBuch;

	
	
	BufferedReader br = new BufferedReader(new FileReader("/home/simon/eclipse-workspace/hhBuch.csv"));  
	hhBuch = new LinkedList<Entry>();
	String lin = "";
	while ((lin = br.readLine()) != null) {  
	       // split on comma(',')  
	       String[] entryCsv = lin.split(",");  

	       // create new entry object to store values  
	       Entry entryObj = new Entry();  

	       // add values from csv to entry object  
	       entryObj.setName(personCsv[0]);  
	       entryObj.setSurname(personCsv[1]);  
	       entryObj.setShoeSize(personCsv[2]);  
	       entryObj.setGender(personCsv[3]); 

	       // adding car objects to a list  
	       hhBuch.add(entryObj);         
	} 
}

}

/* To do: write appropriate methods in class Entry
 * Get it to compile
 * How to make this class interact with entry?
 * https://stackoverflow.com/questions/22485041/how-to-easily-process-csv-file-to-listmyclass
 */


