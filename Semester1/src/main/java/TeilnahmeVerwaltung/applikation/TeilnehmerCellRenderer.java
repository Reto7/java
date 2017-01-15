package applikation;

import javax.swing.*;

import datenModell.Teilnehmer;

import java.awt.*;

public class TeilnehmerCellRenderer extends JLabel implements ListCellRenderer {
 private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
 JList teilnehmerListView;
 public TeilnehmerCellRenderer(JList pTeilnehmerListView) {
     setOpaque(true);
     setIconTextGap(12);
     // unsere Liste
     this.teilnehmerListView = pTeilnehmerListView;
 }

 // wichtigste methode im ListCellRenderer Interface
 public Component getListCellRendererComponent(
     JList list,
     Object value,
     int index,
     boolean isSelected,
     boolean cellHasFocus)
 {
   // der teilnehmer
   Teilnehmer tTeilnehmer = (Teilnehmer)value;
   setText(tTeilnehmer.toString());
   setFont(new Font("Courier New",0,12));   //0=Normal 1=Bold 2=Kursiv
   if(tTeilnehmer.getStatus().equals("JA"))
   {
     setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/flag_green.png"));
   }
   else
   {
     setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/flag_red.png"));
   }

   // Selected oder nicht muss hier explizit angegeben werden. Wir wollen 
   // hier aber nicht manuell irgendwelche Farben definieren sondern die 
   // Standardfarben verwenden.
   if(isSelected)
   {
     setBackground(list.getSelectionBackground());
     setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
   }
   else
   {
     setBackground(list.getBackground());
   //setBorder(BorderFactory.createLineBorder(getBackground(), 2));
   //setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
   //setBorder(BorderFactory.createBevelBorder(0,Color.GRAY,java.awt.SystemColor.controlHighlight));
   //setBorder(BorderFactory.createEtchedBorder(0));
     setBorder(null);
   }

   
   return this;
 }
}

