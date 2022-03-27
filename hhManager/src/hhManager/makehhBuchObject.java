package hhManager;
import java.io.*;
import java.util.*;

public class makehhBuchObject  
{
	private static List<Entry> hhBuch;
	
	public static LinkedList<Entry> hhBuchFromHD()
	{
		BufferedReader br = new BufferedReader(new FileReader("/home/simon/eclipse-workspace/hhBuch.csv"));  
		hhBuch = new LinkedList<Entry>();
		String lin = "";
		while ((lin = br.readLine()) != null)
		{  
			String[] entryCsv = lin.split(",");  
			Entry entryObj = new Entry();  
			
			Integer betrag = Integer.valueOf(entryCsv[0]);
			
			
			entryObj.setzeBetrag(betrag);  
  	        entryObj.setSurname(entryCsv[1]);  
	        entryObj.setShoeSize(entryCsv[2]);  
	        entryObj.setGender(entryCsv[3]); 
	       
	        hhBuch.add(entryObj);
	    } 
	}
	
}


/* To do: write appropriate methods in class Entry
 * Get it to compile
 * How to make this class interact with entry?
 * https://stackoverflow.com/questions/22485041/how-to-easily-process-csv-file-to-listmyclass
 */


