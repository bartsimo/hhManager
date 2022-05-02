package hhManager;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * EntryDetailAnzeigerUI beschreibt die grafische Benutzungsoberfläche für das
 * EntryDetailAnzeigerWerkzeug.
 * 
 * @author Simon
 */
class EntryDetailAnzeigerUI
{
    private JPanel _hauptPanel;
    private JTextArea _entryAnzeigerTextArea;

    /**
     * Initialisiert eine neue MedienDetailAnzeigerUI.
     */
    public EntryDetailAnzeigerUI()
    {
        erzeugeHauptPanel();
        erzeugeEntryAnzeiger();
    }

    /**
     * Ereugt das Haupt-Panel.
     */
    private void erzeugeHauptPanel()
    {
        _hauptPanel = new JPanel(new BorderLayout());
    }

    /**
     * Erzeugt das Panel in dem die Entrydetails angezeigt werden.
     */
    private void erzeugeEntryAnzeiger()
    {
        JScrollPane entryAnzeigerScrollPane = new JScrollPane();
        entryAnzeigerScrollPane.setPreferredSize(new Dimension(-1, 160));
        entryAnzeigerScrollPane.setSize(-1, -1);
        entryAnzeigerScrollPane.setBorder(BorderFactory.createTitledBorder(null,
                "Ausgewählte Eintraege", TitledBorder.LEADING,
                TitledBorder.DEFAULT_POSITION, UIConstants.HEADER_FONT));
        entryAnzeigerScrollPane.setBackground(UIConstants.BACKGROUND_COLOR);
        entryAnzeigerScrollPane.getVerticalScrollBar()
            .setBackground(UIConstants.BACKGROUND_COLOR);
        entryAnzeigerScrollPane.getHorizontalScrollBar()
            .setBackground(UIConstants.BACKGROUND_COLOR);

        _entryAnzeigerTextArea = new JTextArea();
        _entryAnzeigerTextArea.setBackground(UIConstants.BACKGROUND_COLOR);
        entryAnzeigerScrollPane.setViewportView(_entryAnzeigerTextArea);
        _entryAnzeigerTextArea.setEditable(false);
        _entryAnzeigerTextArea.setFont(UIConstants.TEXT_FONT);

        _hauptPanel.add(entryAnzeigerScrollPane, BorderLayout.CENTER);
    }

    /**
     * Gibt die JTextArea, die zur Anzeige der ausgewählten Entries verwendet
     * wird.
     * 
     * @ensure result != null
     */
    public JTextArea getEntryAnzeigerTextArea()
    {
        return _entryAnzeigerTextArea;
    }

    /**
     * Gibt das Haupt-Panel der UI zurück.
     * 
     * @ensure result != null
     */
    public JPanel getUIPanel()
    {
        return _hauptPanel;
    }
}
