package hhManager;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;  

public class create {
	
	public static LinkedList<Entry> hhBuch;


    public static void main(String[] args) throws Exception 
    {  
    	LeseCSV();
    }
    
    public static LinkedList<Entry> LeseCSV() throws Exception {
    	//parsing a CSV file into Scanner class constructor  
    	Scanner sc = new Scanner(new File("/home/simon/eclipse-workspace/hhBuch.csv"));  
    	sc.useDelimiter(",");
    	String line = "";
    	
    	if (sc.hasNext()) {
    		sc.nextLine();
    	}
    	while (sc.hasNextLine()) {  
    		line = sc.nextLine();
    		if (line.isEmpty()) {
    			continue;
    		}
    		String[] parts = line.split(",");
	    /*for(int i = 0; i < parts.length; i++) {   
	    	System.out.println(parts[i]);    
	    	}
	    	*/
	    
	    System.out.println(parts[0]);
	    System.out.println(parts[1]);
	    System.out.println(parts[2]);
	    System.out.println(parts[3]);
	    System.out.println(parts[4]);
	    
	    	Entry entryObj = new Entry(); 
	    
    		int betrag = convertInt(parts[0]);
    		System.out.println("Integer value = " + betrag);
			entryObj.setzeBetrag(betrag);  
			
			Date datum = convertDate(parts[4]);
			System.out.println("Date value = " + datum);
			entryObj.setzeDatum(datum);
    		
    		
    		
    		hhBuch = new LinkedList<Entry>();
    		System.out.println(entryObj.gibBetrag());
    		System.out.println(entryObj.gibDatum());
    	}   
    	sc.close();  //closes the scanner  
    
    return hhBuch;
    
    
    }
    

    

    
    private static int convertInt(String str) {
        int val = 0;
        System.out.println("String = " + str);
  
        // Convert the String
        try {
            val = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
  
            // This is thrown when the String
            // contains characters other than digits
            System.out.println("Invalid String");
        }
        return val;
    }
    
    private static Date convertDate(String str) throws Exception {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy"); 
		Date entryDate;
		entryDate = df.parse(str);
		return entryDate;
    }


}
