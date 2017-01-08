package applikation;

import javax.swing.*;
import java.awt.*;
import datenModell.TeilnehmerEreignis;

public class TeilnehmerEreignisCellRenderer extends JLabel implements ListCellRenderer 
{
 // wieder die JList definieren 
 JList listView;
 
 public TeilnehmerEreignisCellRenderer(JList pListView) 
 {
     setOpaque(true);
     setIconTextGap(12);
     // unsere Liste
     this.listView = pListView;
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
   TeilnehmerEreignis tTeilnehmerEreignis = (TeilnehmerEreignis)value;
   setText(tTeilnehmerEreignis.toString());
   setFont(new Font("Courier New",0,12));   //0=Normal 1=Bold 2=Kursiv
   if(tTeilnehmerEreignis.getTeilnehmerErkennung().equals(1))
     if(tTeilnehmerEreignis.getTeilnehmerStatus().equals("JA"))
     {
       setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/flag_green.png"));
     }
     else
     {
       setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/flag_red.png"));
     }
    else
    {      
     setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/help_klein.png"));
     setFont(new Font("Courier New",1,12));   //0=Normal 1=Bold 2=Kursiv
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
   //
   return this;
 }
}

