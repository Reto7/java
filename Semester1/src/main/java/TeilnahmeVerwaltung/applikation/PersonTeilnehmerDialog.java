package applikation;

import java.awt.BorderLayout;
import java.awt.ScrollPane;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JList;

import datenModell.Ereignis;
import datenModell.Person;
import datenModell.TeilnehmerEreignis;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class PersonTeilnehmerDialog extends JDialog
{
  private JPanel jContentPane = null;
  private JPanel southPanel = null;
  private JPanel eastPanel = null;
  private JPanel centerPanel = null;
  private JButton btExit = null;
  private JList listView = null;
  private JButton btTeilnehmen = null;
  private JButton btNichtTeilnehmen = null;
  private JTextField tfFreitext = null;
  private JPanel northPanel = null;
  private JTextField tfPersonAnzeige = null;
  private JLabel lbTeilnehmen = null;
  private JButton btUnbekannt = null;
  private JRadioButton rbAlle = null;
  private JRadioButton rbAktuelle = null;
  //
  private Boolean aktuelleKennzeichen = true;
  /**
   * This is the default constructor
   */
  public PersonTeilnehmerDialog()
  {
    super();
    initialize();
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize()
  {
    this.setSize(1260, 400);
    this.setTitle("Mitarbeiter-Teilnahme Dialog");
    this.setPreferredSize(new java.awt.Dimension(1260,400));
    this.setLocation(new java.awt.Point(10,103));
    this.setContentPane(getJContentPane());
    this.setAlwaysOnTop(true);
    this.addWindowListener(new java.awt.event.WindowAdapter()
    {
      public void windowOpened(java.awt.event.WindowEvent e)
      {
        System.out.println("windowOpened()"); 
        // kart
        personAnzeigen();
        listeFuellen();
      }
    });
  }
  
  /**
   * personAnzeigen Methode
   */
  private void personAnzeigen()
  {
    Person tPerson = new Person();
    tPerson = tPerson.suchenPersonId(Person.getLoginId());
    System.out.println("Person =" +tPerson.getBezeichnung());
    // Anzeigen der eingeloggten Person - des Organisators
    tfPersonAnzeige.setText(tPerson.toString());     
   }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane()
  {
    if (jContentPane == null)
    {
      jContentPane = new JPanel();
      jContentPane.setLayout(new BorderLayout());
      jContentPane.add(getSouthPanel(), java.awt.BorderLayout.SOUTH);
      jContentPane.add(getEastPanel(), java.awt.BorderLayout.EAST);
      jContentPane.add(getCenterPanel(), java.awt.BorderLayout.CENTER);
      jContentPane.add(getNorthPanel(), java.awt.BorderLayout.NORTH);
    }
    return jContentPane;
  }

  /**
   * This method initializes southPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getSouthPanel()
  {
    if (southPanel == null)
    {
      FlowLayout flowLayout = new FlowLayout();
      flowLayout.setAlignment(java.awt.FlowLayout.RIGHT);
      GridBagConstraints gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints.gridx = -1;
      gridBagConstraints.gridy = -1;
      gridBagConstraints.insets = new java.awt.Insets(35,15,5,5);
      southPanel = new JPanel();
      southPanel.setLayout(flowLayout);
      southPanel.setBackground(new java.awt.Color(204,204,204));
      southPanel.add(getRbAktuelle(), null);
      southPanel.add(getRbAlle(), null);
      southPanel.add(getBtExit(), null);
    }
    return southPanel;
  }

  /**
   * This method initializes eastPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getEastPanel()
  {
    if (eastPanel == null)
    {
      GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
      gridBagConstraints8.gridx = 2;
      gridBagConstraints8.insets = new java.awt.Insets(25,15,5,5);
      gridBagConstraints8.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints8.gridy = 14;
      GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
      gridBagConstraints7.gridx = 1;
      gridBagConstraints7.insets = new java.awt.Insets(5,15,5,5);
      gridBagConstraints7.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints7.gridwidth = 2;
      gridBagConstraints7.gridy = 0;
      lbTeilnehmen = new JLabel();
      lbTeilnehmen.setText("Ereignis Teilnahme:");
      GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
      gridBagConstraints6.gridx = 2;
      gridBagConstraints6.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints6.gridy = 1;
      gridBagConstraints6.insets = new java.awt.Insets(5,15,2,5);
      GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
      gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints4.gridy = 11;
      gridBagConstraints4.weightx = 1.0;
      gridBagConstraints4.insets = new java.awt.Insets(2,15,5,5);
      gridBagConstraints4.gridheight = 3;
      gridBagConstraints4.gridwidth = 2;
      gridBagConstraints4.gridx = 1;
      GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
      gridBagConstraints3.gridx = 2;
      gridBagConstraints3.insets = new java.awt.Insets(3,15,5,5);
      gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints3.gridy = 3;
      eastPanel = new JPanel();
      eastPanel.setLayout(new GridBagLayout());
      eastPanel.setBackground(new java.awt.Color(204,204,204));
      eastPanel.add(getBtTeilnehmen(), gridBagConstraints6);
      eastPanel.add(getBtNichtTeilnehmen(), gridBagConstraints3);
      eastPanel.add(getTfFreitext(), gridBagConstraints4);
      eastPanel.add(lbTeilnehmen, gridBagConstraints7);
      eastPanel.add(getBtUnbekannt(), gridBagConstraints8);
    }
    return eastPanel;
  }

  /**
   * This method initializes centerPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getCenterPanel()
  {
    if (centerPanel == null)
    {
      GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
      gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints1.gridx = 0;
      gridBagConstraints1.gridy = 0;
      gridBagConstraints1.weightx = 1.0;
      gridBagConstraints1.insets = new java.awt.Insets(5,15,5,5);
      GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
      gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
      gridBagConstraints2.gridy = 1;
      gridBagConstraints2.weightx = 1.0;
      gridBagConstraints2.weighty = 1.0;
      gridBagConstraints2.insets = new java.awt.Insets(5,15,5,5);
      gridBagConstraints2.gridx = 0;
      centerPanel = new JPanel();
      centerPanel.setLayout(new GridBagLayout());
      centerPanel.setBackground(new java.awt.Color(204,204,204));
      // kart: Manuell das ListView Objekt in eine JScrollPane einbinden !
      // damit auch ein Rollbalken erscheint
      centerPanel.add(new JScrollPane(getListView()), gridBagConstraints2);
      centerPanel.add(getTfPersonAnzeige(), gridBagConstraints1);
    }
    return centerPanel;
  }

  /**
   * This method initializes btOk	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtExit()
  {
    if (btExit == null)
    {
      btExit = new JButton();
      btExit.setText("Exit");
      btExit.setPreferredSize(new java.awt.Dimension(139,25));
      btExit.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          // kart
          exit();
        }
      });
    }
    return btExit;
  }

  /**
   * Exit Methode (Hier dasselbe wie ok oder abbruch)
   */
  private void exit()
  {
    System.out.println("ok - FINISH");
    // Maske schliessen und Ressourcen freigeben
    this.dispose();
  } 
  
  /**
   * This method initializes ListView	
   * 	
   * @return javax.swing.JList	
   */
  private JList getListView()
  {
    if (listView == null)
    {
      //getContentPane().add(new JScrollPane(listView));
      listView = new JList();
      listView.setFont(new java.awt.Font("Courier New", java.awt.Font.PLAIN, 12));
      listView.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray,0), "Ereignisse", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", java.awt.Font.BOLD, 14), java.awt.SystemColor.activeCaption));
      listView.setBackground(java.awt.SystemColor.controlHighlight);
      //
    }
    return listView;
  }

  
  
  /**
   * kart: ListeFuellen Methode
   * Ereignisse aus der Datenbank lesen und in der Liste anzeigen.
   */
  private void listeFuellen()
  {
    System.out.println("Liste füllen");
    // MVC: Neues Model erstellen
    DefaultListModel tModel = new DefaultListModel();
    // ereignisListView und Model verbinden
    listView.setModel(tModel);
    // 
    // objekt doch noch anlegen. Ereignisse aus der Datenbank lesen
    // und in Arraylist ablegen.
    TeilnehmerEreignis tTeilnehmerEreignis = new TeilnehmerEreignis();
    ArrayList<TeilnehmerEreignis> tListe;
    tListe = tTeilnehmerEreignis.alleLesenProLoginId(aktuelleKennzeichen);  //true=nur ab heute
    // TeilnehmerEreignis in das Model einsetzen
    // Abgekürzte Variante F.Letters
    /*
    for (Ereignis einEreignis: tListe)
    {
      tModel.addElement(einEreignis);
    }
    */
    // Personen in das Model einsetzen
    // Anfängervariante - dafür mit Zähler
    TeilnehmerEreignis einTeilnehmerEreignis;
    for (int i=0; i<tListe.size(); i++)
    {
      einTeilnehmerEreignis = tListe.get(i);   
      tModel.addElement(einTeilnehmerEreignis); //.toString());
    }
    // neu mit cell renderer!
    listView.setCellRenderer(new TeilnehmerEreignisCellRenderer(listView));

  }

  /**
   * This method initializes btTeilnehmen	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtTeilnehmen()
  {
    if (btTeilnehmen == null)
    {
      btTeilnehmen = new JButton();
      btTeilnehmen.setText("      Ja   ");
      btTeilnehmen.setPreferredSize(new java.awt.Dimension(135,38));
      btTeilnehmen.setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/check.png"));
      btTeilnehmen.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          // kart
          teilnehmen();
        }
      });
    }
    return btTeilnehmen;
  }
  
  private void teilnehmen()
  {
    System.out.println("teilnehmen...");  
    // selektierte Zeile abfragen. Könnte man auch direkt mit
    // getSelectedValue machen - da kommt ein ganzes Objet zurück
    // Falls keine Ereignis selektiert ist, resultiert:  -1
    Integer tZeile = this.listView.getSelectedIndex();
    if (tZeile >=0)
    {
      // Ereignisen aus Model abfragen
      // Auf Model über Liste zugreifen. In der Liste ist das 
      // Model ja immer noch referenziert...
      // Problem: Methode getElementAt liefert ein Resultat der Top-Klasse
      // "Object" zurück. Wir erwarten aber ein TeilnehmerEreignis Objekt
      // somit wird das Resultat auf TeilnehmerEreignis Objekt gecastet!
      TeilnehmerEreignis tTeilnehmerEreignis = (TeilnehmerEreignis)this.listView.getModel().getElementAt(tZeile);
      
      System.out.println("-->" +tTeilnehmerEreignis.getEreignisBezeichnung());
      System.out.println("-->" +tTeilnehmerEreignis.getTeilnehmerStatus());
      System.out.println("-->" +tTeilnehmerEreignis.getEreignisId());
      System.out.println("-->" +tTeilnehmerEreignis.getTeilnehmerId());
      
      if (tfFreitext.getText().length() >0)
        tTeilnehmerEreignis.setTeilnehmerFreitext(tfFreitext.getText());
      else
        tTeilnehmerEreignis.setTeilnehmerFreitext("");
      // Update machen.....
      tTeilnehmerEreignis.teilnehmen();
      listeFuellen();
    }
    else
    {
      // Message Box 
      JOptionPane.showMessageDialog(this, "Es wurde kein Ereignis aus der Liste selektiert.");
    }  
  }

  private void nichtTeilnehmen()
  {
    System.out.println("nicht mehr teilnehmen...");  
    // selektierte Zeile abfragen. Könnte man auch direkt mit
    // getSelectedValue machen - da kommt ein ganzes Objet zurück
    // Falls keine Ereignis selektiert ist, resultiert:  -1
    Integer tZeile = this.listView.getSelectedIndex();
    if (tZeile >=0)
    {
      // Ereignisen aus Model abfragen
      // Auf Model über Liste zugreifen. In der Liste ist das 
      // Model ja immer noch referenziert...
      // Problem: Methode getElementAt liefert ein Resultat der Top-Klasse
      // "Object" zurück. Wir erwarten aber ein TeilnehmerEreignis Objekte
      // somit wird das Resultat auf TeilnehmerEreignis Objekt gecastet!
      TeilnehmerEreignis tTeilnehmerEreignis = (TeilnehmerEreignis)this.listView.getModel().getElementAt(tZeile);
      //
      if (tfFreitext.getText().length() >0)
      {
        tTeilnehmerEreignis.setTeilnehmerFreitext(tfFreitext.getText());
      }
      else
      {
        tTeilnehmerEreignis.setTeilnehmerFreitext("");
      }
      // update...
      tTeilnehmerEreignis.nichtTeilnehmen();
      listeFuellen();
    }
    else
    {
      // Message Box 
      JOptionPane.showMessageDialog(this, "Es wurde kein Ereignis aus der Liste selektiert.");
    }  
  }
  
  
  
  /**
   * This method initializes btNichtTeilnehmen	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtNichtTeilnehmen()
  {
    if (btNichtTeilnehmen == null)
    {
      btNichtTeilnehmen = new JButton();
      btNichtTeilnehmen.setText("    Nein");
      btNichtTeilnehmen.setPreferredSize(new java.awt.Dimension(135,38));
      btNichtTeilnehmen.setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/forbidden.png"));
      btNichtTeilnehmen.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          // kart
          nichtTeilnehmen();
        }
      });
    }
    return btNichtTeilnehmen;
  }

  /**
   * This method initializes tfBemerkung	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfFreitext()
  {
    if (tfFreitext == null)
    {
      tfFreitext = new JTextField();
      tfFreitext.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bemerkung / Freitext", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
    }
    return tfFreitext;
  }

  /**
   * This method initializes northPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getNorthPanel()
  {
    if (northPanel == null)
    {
      northPanel = new JPanel();
      northPanel.setLayout(new GridBagLayout());
      northPanel.setBackground(java.awt.SystemColor.activeCaptionBorder);
    }
    return northPanel;
  }

  /**
   * This method initializes tfPersonBezeichnung	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfPersonAnzeige()
  {
    if (tfPersonAnzeige == null)
    {
      tfPersonAnzeige = new JTextField();
      tfPersonAnzeige.setBackground(new java.awt.Color(204,204,204));
      tfPersonAnzeige.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mitarbeiter/in", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", java.awt.Font.BOLD, 14), java.awt.SystemColor.activeCaption));
      tfPersonAnzeige.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
    }
    return tfPersonAnzeige;
  }

  /**
   * This method initializes btUnbekannt	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtUnbekannt()
  {
    if (btUnbekannt == null)
    {
      btUnbekannt = new JButton();
      btUnbekannt.setText("weiss nicht");
      btUnbekannt.setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/weissnicht.png"));
      btUnbekannt.setToolTipText("Hiermit löschen Sie eine allfällig gemachte Zu- oder Absage");
      btUnbekannt.setPreferredSize(new java.awt.Dimension(135,38));
      btUnbekannt.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          teilnehmenNichtBekannt();
        }
      });
    }
    return btUnbekannt;
  }

  private void teilnehmenNichtBekannt()
  {
    System.out.println("teilnehmen weiss ich nicht...");  
    // selektierte Zeile abfragen. Könnte man auch direkt mit
    // getSelectedValue machen - da kommt ein ganzes Objet zurück
    // Falls keine Ereignis selektiert ist, resultiert:  -1
    Integer tZeile = this.listView.getSelectedIndex();
    if (tZeile >=0)
    {
      // Ereignisen aus Model abfragen
      // Auf Model über Liste zugreifen. In der Liste ist das 
      // Model ja immer noch referenziert...
      // Problem: Methode getElementAt liefert ein Resultat der Top-Klasse
      // "Object" zurück. Wir erwarten aber ein TeilnehmerEreignis Objekte
      // somit wird das Resultat auf TeilnehmerEreignis Objekt gecastet!
      TeilnehmerEreignis tTeilnehmerEreignis = (TeilnehmerEreignis)this.listView.getModel().getElementAt(tZeile);
      //
      if (tTeilnehmerEreignis.getTeilnehmerErkennung().equals(1))
      {
        // löschen der JA/NEIN Teilnahme...
        tTeilnehmerEreignis.loeschenTeilnehmen();
        listeFuellen();
      }
      else
        System.out.println("Keine Teilnehmer Löschung da ja gar keiner vorhanden...");
    }
    else
    {
      // Message Box 
      JOptionPane.showMessageDialog(this, "Es wurde kein Ereignis aus der Liste selektiert.");
    }  
   
  }

  /**
   * This method initializes rbAlle	
   * 	
   * @return javax.swing.JRadioButton	
   */
  private JRadioButton getRbAlle()
  {
    if (rbAlle == null)
    {
      rbAlle = new JRadioButton();
      rbAlle.setText("alle");
      rbAlle.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
      rbAlle.setPreferredSize(new java.awt.Dimension(70,24));
      rbAlle.setBackground(new java.awt.Color(204,204,204));
      rbAlle.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed(): ALLE");
          aktuelleKennzeichen = false;
          rbAktuelle.setSelected(false);
          listeFuellen();
        }
      });
    }
    return rbAlle;
  }

  /**
   * This method initializes rbAktuelle	
   * 	
   * @return javax.swing.JRadioButton	
   */
  private JRadioButton getRbAktuelle()
  {
    if (rbAktuelle == null)
    {
      rbAktuelle = new JRadioButton();
      rbAktuelle.setText("aktuelle");
      rbAktuelle.setSelected(true);
      rbAktuelle.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
      rbAktuelle.setBackground(new java.awt.Color(204,204,204));
      rbAktuelle.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed(): NUR AKTUELLE");
          aktuelleKennzeichen = true;
          rbAlle.setSelected(false);
          listeFuellen();
        }
      });
    }
    return rbAktuelle;
  }

}  //  @jve:decl-index=0:visual-constraint="18,13"
