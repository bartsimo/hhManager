package hhManager;
import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class makehhBuchObject  
{
	private static LinkedList<Entry> hhBuch;
	
	public static LinkedList<Entry> hhBuchFromHD()
	{
		try (BufferedReader br = new BufferedReader(new FileReader("/home/simon/eclipse-workspace/hhBuch.csv"))) {
			hhBuch = new LinkedList<Entry>();
			String lin = "";
			while ((lin = br.readLine()) != null)
			{  
				String[] entryCsv = lin.split(",");  
				Entry entryObj = new Entry();  
				
				Integer betrag = Integer.valueOf(entryCsv[0]);
				
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy"); 
				Date entryDate;
				try {
					entryDate = df.parse(entryCsv[4]);
					entryObj.setzeDatum(entryDate); 
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				
				entryObj.setzeBetrag(betrag);  
			    entryObj.setzeKategorie(entryCsv[1]);  
			    entryObj.setzeIstEinnahme(entryCsv[2]);  
			    entryObj.setzeDetails(entryCsv[3]); 
			    
			   
			    hhBuch.add(entryObj);
			}
			return hhBuch;
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			return null;
		}  
		
	}
	
}


/* To do: Testing (does that show in activities?) Test Test Test Test Test Test Test Test
 * Get it to compile
 * How to make this class interact with entry?
 * https://stackoverflow.com/questions/22485041/how-to-easily-process-csv-file-to-listmyclass
 */


