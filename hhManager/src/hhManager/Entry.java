package hhManager;
import java.util.Date;

/**
 * PAT or SSH on GitHub is actually needed!
 * @author (Simon) 
 * @version (26.03.2022)
 * Hierdrin: Elemente für LinkedList
 */
public class Entry
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int _betrag;
    private String _kategorie;
    private boolean _einnahme;
    private String _details;
    private Date _datum;

    /**
     * Konstruktor fuer Objekte der Klasse Entry
     */
    public Entry(double betrag, String kategorie, boolean einnahme, String details)
    {
        _betrag = (int) betrag;
        _kategorie = kategorie;
        _einnahme = einnahme;
        _details = details;
        _datum = new Date();
    }
    
    /**
     * @return den Betrag des Eintrags
     */
    public int gibBetrag()
    {
        return _betrag;
    }
    
    /**
     * @return die Kategorie des Eintrags
     */
    public String gibKategorie()
    {
        return _kategorie;
    }
    
    /**
     * @return Einnahme oder Ausgabe
     */
    public boolean istEinnahme()
    {
        return _einnahme;
    }
    
    /**
     * @return Details des Eintrags
     */
    public String gibDetails()
    {
        return _details;
    }
    
    /**
     * @return Datum des Eintrags 
     */
    public Date gibDatum()
    {
        return _datum;
    }
    
    /**
     * Erzeugt eine Stringrepraesentation fuer den Eintrag mit Betrag, Kategorie, Einnahme, Details und Datum 
     * .
     */
    public String toString()
    {
        return _betrag + "    " + _kategorie + "    " + _einnahme + "    " + _details + "   " +_datum;
    }
    


}

