package hhManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

    private Entry _entry1;

    public EntryTest() throws Exception
    {
        DATUM = convertDate(DATUMSTRING);
        _entry1 = new Entry(BETRAG, KATEGORIE, EINNAHME, DETAILS, DATUM);

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

    //TODO: Test cases with _entry1

    private static Date convertDate(String str) throws Exception
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date entryDate;
        entryDate = df.parse(str);
        return entryDate;
    }

}
