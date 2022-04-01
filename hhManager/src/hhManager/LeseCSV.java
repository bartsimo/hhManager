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
    */
    System.out.println(parts[0]);
    System.out.println(parts[1]);
    System.out.println(parts[2]);
    System.out.println(parts[3]);
    System.out.println(parts[4]);
    }   
    sc.close();  //closes the scanner  
    }  


}
