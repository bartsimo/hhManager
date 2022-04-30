package hhManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntryTest
{
    private static final int BETRAG = 100;
    private static final String KATEGORIE = "Shopping";
    private static final boolean EINNAHME = false;
    private static final String DETAILS = "Mehl teurer";
    private static final SimpleDateFormat SDF = new SimpleDateFormat(
            "dd-MM-yyyy");
    private static final String DATUMSTRING = "17-03-2022";
    private static Date DATUM;

    public EntryTest() throws Exception
    {
        DATUM = convertDate(DATUMSTRING);
    }

    private static Date convertDate(String str) throws Exception
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date entryDate;
        entryDate = df.parse(str);
        return entryDate;
    }

}
