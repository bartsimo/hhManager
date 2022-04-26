package hhManager;

import java.util.Date;

public class HaushaltsBuchTest
{
    private static final int BETRAGTEST = -1;
    private static final String KATEGORIETEST = "Lebensmittel";
    private static final boolean EINNAHMETEST = false;
    private static final String DETAILSTEST = "teuer";
    private static final String DATUMSTRING = "01.01.1900";
    private static final Date DATUM = HaushaltsBuch.convertDate(DATUMSTRING);

    private HaushaltsBuch _buchTest;
    private Entry entryTest;

}
