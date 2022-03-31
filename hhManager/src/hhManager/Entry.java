package hhManager;
import java.util.Date;

/**
 * PAT or SSH on GitHub is actually needed!
 * 
 * Files saved under Git
 * https://www.java-forum.org/thema/haushaltsbuch.161060/
 * 
 * @author (Simon) 
 * @version (26.03.2022)
 * Hierdrin: Elemente für LinkedList
 */
public class Entry
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int _betrag;
    private String _kategorie;
    private String _einnahme;
    private String _details;
    private Date _datum;

    /**
     * Leerer Konstruktor fuer Objekte der Klasse Entry (z.B. Nutzung aus anderer Klasse)
     */
    public Entry()
    {

    }
    
    /**
     * Überladener Konstruktor fuer Objekte der Klasse Entry (z.B. Objekterzeugung über CommandLine)
     */
    public Entry(double betrag, String kategorie, String einnahme, String details)
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
    public String istEinnahme()
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
     * Setze Betrag des Eintrags
     * @param int betrag (Integer?) 
     */
    public void setzeBetrag(int betrag)
    {
        this._betrag = betrag;
    }
    
    /**
     * Setze Kategorie des Eintrags
     * @param String kategorie
     */
    public void setzeKategorie(String kategorie)
    {
        this._kategorie = kategorie;
    }
    
    /**
     * Setze Kategorie des Eintrags
     * @param String kategorie
     */
    public void setzeIstEinnahme(String einnahme)
    {
        this._einnahme = einnahme;
    }
    
    /**
     * Setze Kategorie des Eintrags
     * @param String kategorie
     */
    public void setzeDetails(String details)
    {
        this._details = details;
    }
    
    public void setzeDatum(Date datum)
    {
        this._datum = datum;
    }
    
    /**
     * Erzeugt eine Stringrepraesentation fuer den Eintrag mit Betrag, Kategorie, Einnahme, Details und Datum 
     * .
     */
    
    @Override
    public String toString()
    {
        return _betrag + "    " + _kategorie + "    " + _einnahme + "    " + _details + "   " +_datum;
    }
    


}

