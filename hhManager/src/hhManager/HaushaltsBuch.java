/* To do:
 * Alle Schnittstellen (public-Methoden) müssen mit Schnittstellenkommentaren dokumentiert 
 * werden. Die Parameter müssen mit @param und die Rückgabewerte mit @return dokummentiert 
 * werden.
 * Shortcut: /**
 * 
 * 
 * Testklassen (zu jeder Klasse eine Testklasse, die die Nachbedingungen (@require) überprüft!)
 * javadoc
 * 

 * Scanner-Terminal-Input benutzerfreundlicher machen (z.B. boolean)
 * 
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

/**
 * Konstruktor deklariert zwei Klassenvariablen: ein Haushaltsbuch und 
 * eine LinkedList von Entries
 * @author simon
 *
 */
public class HaushaltsBuch
{

    private static LinkedList<Entry> _hhBuch;
    private static HaushaltsBuch _buch;

    public HaushaltsBuch()
    {

        _hhBuch = new LinkedList<Entry>();
    }

    public static void main(String[] args) throws Exception
    {

        leseCSV();
        _buch.fuegeHinzuTerminal();
        System.out.println(Arrays.toString(HaushaltsBuch._hhBuch.toArray()));
        _buch.schreibeCSV(getDateAsString());

        //buch.getLastModified();
    }

    /**
     * Liest eine formatierte CSV-Datei ein und gibt daraus das 
     * resultierende Haushaltsbuch zurück.
     * 
     * @return Haushaltsbuch als LinkedList Objekt mit Elementen des Typs Entry
     * @throws Exception
     */
    public static LinkedList<Entry> leseCSV() throws Exception
    {
        _buch = new HaushaltsBuch();
        Scanner sc = new Scanner(new File(getLastModified()));
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

            _hhBuch.add(entryObj);
        }
        sc.close(); //closes the scanner  

        return _hhBuch;

    }

    /**
     * Schreibt aus einem HaushaltsBuch-Objekt eine CSV-Datei.
     *
     * @param dateiname als String
     * @throws IOException
     */
    public void schreibeCSV(String dateiname) throws IOException
    {
        String komma = ",";
        String neueZeile = "\n";
        String ersteZeile = "_betrag, _kategorie, _einnahme, _details, _datum";
        String dir = "/home/simon/eclipse-workspace/HaushaltsbuchCSVs";

        FileWriter fw = new FileWriter(new File(dir, dateiname));
        fw.append(ersteZeile.toString());
        fw.append(neueZeile);
        for (Entry entryobj : _hhBuch)
        {
            fw.append(String.valueOf(entryobj.gibBetrag()));
            fw.append(komma);
            fw.append(entryobj.gibKategorie());
            fw.append(komma);
            fw.append(String.valueOf(entryobj.istEinnahme()));
            fw.append(komma);
            fw.append(entryobj.gibDetails());
            fw.append(komma);
            fw.append(entryobj.gibDatum());
            fw.append(neueZeile);

        }

        fw.flush();
        fw.close();
    }

    //To do: Überladene Methode fuegeHinzu mit formalen Parametern schreiben, 
    //welche GUI Input direkt als aktuelle Parameter übergibt.

    /**
     * 
     * Fügt einen Entry über Terminal-Prompt hinzu.
     * @throws Exception
     */
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

        _hhBuch.add(entryObj);

        sc.close(); //closes the scanner  

        /*
        System.out.println(entryObj.gibBetrag());
        System.out.println(entryObj.gibKategorie());
        System.out.println(entryObj.istEinnahme());
        System.out.println(entryObj.gibDetails());
        System.out.println(entryObj.gibDatum());
        */
    }

    private static int convertInt(String str)
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

    private static Date convertDate(String str) throws Exception
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date entryDate;
        entryDate = df.parse(str);
        return entryDate;
    }

    private static boolean convertBoolEinnahnme(String str) throws Exception
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
        String pattern = "dd.MM.yyyy_HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date heute = Calendar.getInstance()
            .getTime();
        String jetztAlsString = df.format(heute);
        return jetztAlsString + ".csv";
    }

    private static String getLastModified()
    {
        File directory = new File(
                "/home/simon/eclipse-workspace/HaushaltsbuchCSVs");
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;

        if (files != null)
        {
            for (File file : files)
            {
                if (file.lastModified() > lastModifiedTime)
                {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }
        System.out.println(chosenFile.getAbsolutePath());

        return chosenFile.getAbsolutePath();
    }

}
