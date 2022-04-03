package hhManager;
import java.io.*;  
import java.util.Scanner;  

public class LeseCSV {


    public static void main(String[] args) throws Exception  
    {  
    //parsing a CSV file into Scanner class constructor  
    Scanner sc = new Scanner(new File("/home/simon/eclipse-workspace/hhBuch.csv"));  
    sc.useDelimiter(",");
    if (sc.hasNext()) {
    	sc.nextLine();
    }
    while (sc.hasNextLine())    
    {  
    String line = sc.nextLine();
    if (line.isEmpty()) {
    	continue;
    }
    String[] parts = line.split(",");
    /*for(int i = 0; i < parts.length; i++) {   
    	System.out.println(parts[i]);    
    	}
    
    System.out.println(parts[0]);
    System.out.println(parts[1]);
    System.out.println(parts[2]);
    System.out.println(parts[3]);
    System.out.println(parts[4]);
    
    */
    
    int betrag = convert(parts[0]);
    System.out.println("Integer value = " + betrag);
    }   
    sc.close();  //closes the scanner  
    

    
    }
    

    
    public static int convert(String str)
    {
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


}
