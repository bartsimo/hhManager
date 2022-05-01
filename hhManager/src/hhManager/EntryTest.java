package hhManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class EntryTest
{
    private static final int BETRAG = 100;
    private static final String KATEGORIE = "Shopping";
    private static final boolean EINNAHME = false;
    private static final String DETAILS = "Mehl teurer";
    private static final String DATUMSTRING = "17.03.2022";
    private static Date DATUM;
    private static final String AUSGABESTRING = BETRAG + "    " + KATEGORIE
            + "    " + EINNAHME + "    " + DETAILS + "   " + DATUM;

    private Entry _entry1;

    public EntryTest() throws Exception
    {
        DATUM = convertDate(DATUMSTRING);
        _entry1 = getEntry();

    }

    @Test
    //Test zum Betrags-Getter
    public void testGibBetrag()
    {
        assertEquals(BETRAG, _entry1.gibBetrag());
    }

    @Test
    //Test zum Betrags-Getter
    public void testGibKategorie()
    {
        assertEquals(KATEGORIE, _entry1.gibKategorie());
    }

    @Test
    //Test zum Einnahms-Getter
    public void testGibEinnahme()
    {
        assertFalse((boolean) _entry1.istEinnahme());
    }

    @Test
    //Test zum Details-Getter
    public void testGibDetails()
    {
        assertEquals(DETAILS, _entry1.gibDetails());
    }

    @Test
    //Test zum Datums-Getter
    public void testGibDatum()
    {
        assertEquals(DATUMSTRING, _entry1.gibDatum());
    }

    @Test
    //Test fuer Setters
    public final void testSetter() throws Exception
    {
        _entry1.setzeBetrag(200);
        assertEquals(200, _entry1.gibBetrag());
        _entry1.setzeKategorie("Metzger");
        assertEquals("Metzger", _entry1.gibKategorie());
        _entry1.setzeIstEinnahme(true);
        assertTrue((boolean) _entry1.istEinnahme());
        _entry1.setzeDetails("Extrawurst");
        assertEquals("Extrawurst", _entry1.gibDetails());
        _entry1.setzeDatum(convertDate("27.03.2020"));
        assertEquals("27.03.2020", _entry1.gibDatum());
    }

    @Test
    //Test fuer ToString
    public final void testToString() throws Exception
    {
        Entry _entry = getEntry();
        assertEquals(AUSGABESTRING, _entry.toString());
    }

    private static Date convertDate(String str) throws Exception
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date entryDate;
        entryDate = df.parse(str);
        return entryDate;
    }

    private Entry getEntry()
    {
        return new Entry(BETRAG, KATEGORIE, EINNAHME, DETAILS, DATUM);
    }

}
