package hhManager;

import java.util.List;

import javax.swing.JTextArea;

//TODO Testen

/**
 * Ein EntryDetailAnzeigerWerkzeug liefert das aktuelle Haushaltsbuch in einem Format
 * welches mit Hilfe einer Java GUI dargestellt werden kann.
 * 
 * @author simon
 *
 */

public class EntryDetailAnzeigerWerkzeug
{
    private EntryDetailAnzeigerUI _ui;

    /**
     * Initialisiert ein neues MedienDetailAnzeigerWerkzeug.
     */
    public EntryDetailAnzeigerWerkzeug()
    {
        _ui = new EntryDetailAnzeigerUI();
    }

    /**
     * Setzt die Liste der Entries (=Haushaltsbuch) deren Details angezeigt werden sollen.
     * 
     * @param entries Eine Liste von Entries.
     * 
     * @require (medien != null)
     */
    public void setMedien(List<Entry> entries)
    {
        assert entries != null : "Vorbedingung verletzt: (entries != null)";
        JTextArea selectedEntryTextArea = _ui.getEntryAnzeigerTextArea();
        selectedEntryTextArea.setText("");
        for (Entry entry : entries)
        {
            selectedEntryTextArea.append(entry.toString());
            selectedEntryTextArea.append("--------------- \n");
        }
    }

}
