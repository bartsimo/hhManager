/* To do:
 * javadoc
 * Testklassen
 * 
 * AKTUELLSTE CSV-Datei soll gelesen werden --> https://stackoverflow.com/questions/285955/java-get-the-newest-file-in-a-directory
 */

package hhManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HaushaltsBuch
{

    private LinkedList<Entry> hhBuch;

    public HaushaltsBuch()
    {

        hhBuch = new LinkedList<Entry>();
    }

    public static void main(String[] args) throws Exception
    {
        HaushaltsBuch buch = new HaushaltsBuch();
        buch.leseCSV();
        buch.fuegeHinzuTerminal();
        System.out.println(Arrays.toString(buch.hhBuch.toArray()));
        buch.schreibeCSV(getDateAsString());
    }

    public LinkedList<Entry> leseCSV() throws Exception
    {
        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(
                new File("/home/simon/eclipse-workspace/hhBuch.csv"));
        sc.useDelimiter(",");
        String line = "";

        if (sc.hasNext())
        {
            sc.nextLine();
        }
        while (sc.hasNextLine())
        {
            line = sc.nextLine();
            if (line.isEmpty())
            {
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

            Entry entryObj = new Entry();

            int betrag = convertInt(parts[0]);
            System.out.println("Integer value = " + betrag);
            entryObj.setzeBetrag(betrag);

            entryObj.setzeKategorie(parts[1]);

            boolean einnahme = convertBoolEinnahnme(parts[2]);
            entryObj.setzeIstEinnahme(einnahme);

            entryObj.setzeDetails(parts[3]);

            Date datum = convertDate(parts[4]);
            System.out.println("Date value = " + datum);
            entryObj.setzeDatum(datum);

            hhBuch.add(entryObj);
        }
        sc.close(); //closes the scanner  

        return hhBuch;

    }

    public void schreibeCSV(String dateiname) throws IOException
    {
        //To do: Implement writer
        // https://examples.javacodegeeks.com/core-java/writeread-csv-files-in-java-example/
        // Wo wird unter welchem Namen gespeichert?
        String komma = ",";
        String neueZeile = "\n";
        String ersteZeile = "_betrag, _kategorie, _einnahme, _details, _datum";
        String dir = "/home/simon/eclipse-workspace";

        FileWriter fw = new FileWriter(new File(dir, dateiname));
        fw.append(ersteZeile.toString());
        fw.append(neueZeile);
        for (Entry entryobj : hhBuch)
        {
            fw.append(String.valueOf(entryobj.gibBetrag()));
            fw.append(komma);
            fw.append(entryobj.gibKategorie());
            fw.append(komma);
            fw.append(String.valueOf(entryobj.istEinnahme()));
            fw.append(komma);
            fw.append(entryobj.gibDetails());
            fw.append(komma);
            fw.append(entryobj.gibDatum()
                .toString());
            fw.append(neueZeile);

        }

        fw.flush();
        fw.close();
    }

    //To do: Überladene Methode fuegeHinzu mit formalen Parametern schreiben, 
    //welche GUI Input direkt als aktuelle Parameter übergibt.

    public void fuegeHinzuTerminal() throws Exception
    {
        Entry entryObj = new Entry();

        Scanner sc = new Scanner(System.in);

        System.out.print("Wie hoch war der Betrag?");
        int betrag = sc.nextInt();
        sc.nextLine();
        entryObj.setzeBetrag(betrag);

        System.out.print("Wo oder was hast du gekauft?");
        String kategorie = sc.nextLine();
        entryObj.setzeKategorie(kategorie);

        System.out.print("War es eine Einnahme oder eine Ausgabe?");
        boolean einnahme = sc.nextBoolean();
        sc.nextLine();
        entryObj.setzeIstEinnahme(einnahme);

        System.out.print("Was möchtest du an Details mitteilen?");
        String details = sc.nextLine();
        entryObj.setzeDetails(details);

        System.out.print("Wann geschah die Transaktion?");
        String str = sc.nextLine();
        Date datum = convertDate(str);
        entryObj.setzeDatum(datum);

        hhBuch.add(entryObj);

        sc.close(); //closes the scanner  

        /*
        System.out.println(entryObj.gibBetrag());
        System.out.println(entryObj.gibKategorie());
        System.out.println(entryObj.istEinnahme());
        System.out.println(entryObj.gibDetails());
        System.out.println(entryObj.gibDatum());
        */
    }

    private int convertInt(String str)
    {
        int val = 0;
        System.out.println("String = " + str);

        // Convert the String
        try
        {
            val = Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {

            // This is thrown when the String
            // contains characters other than digits
            System.out.println("Invalid String");
        }
        return val;
    }

    private Date convertDate(String str) throws Exception
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date entryDate;
        entryDate = df.parse(str);
        return entryDate;
    }

    private boolean convertBoolEinnahnme(String str) throws Exception
    {
        boolean einnahme = false;
        String REGEX = "[Jj]a*";
        boolean matcher = Pattern.matches(REGEX, str);
        if (matcher)
        {
            einnahme = true;
        }
        return einnahme;
    }

    private static String getDateAsString()
    {
        String pattern = "dd.MM.yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date heute = Calendar.getInstance()
            .getTime();
        String jetztAlsString = df.format(heute);
        return jetztAlsString + ".csv";
    }

}
