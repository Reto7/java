package applikation;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;

import datenModell.Ereignis;
import datenModell.Person;
import datenModell.Teilnehmer;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class EreignisVerwaltenFrame extends JFrame
{

  private JPanel jContentPane = null;
  private JPanel eastPanel = null;
  private JPanel centerPanel = null;
  private JPanel southPanel = null;
  private JButton btNeu = null;
  private JList ereignisListView = null;
  private JButton btAendern = null;
  private JButton btLoeschen = null;
  private JButton btExit = null;
  private JList teilnehmerListView = null;
  private JButton btAendernTeilnehmer = null;
  private JTextField tfAnzahlJa = null;
  private JPanel westPanel = null;
  private JLabel lbJa = null;
  private JLabel lbNein = null;
  private JTextField tfAnzahlNein = null;
  private JLabel lbOffen = null;
  private JTextField tfAnzahlOffen = null;
  private JScrollPane jScrollPane = null;
  private JScrollPane ScrollPaneEreignisse = null;
  private JScrollPane ScrollPaneTeilnahmen = null;

  /**
   * This is the default constructor
   */
  public EreignisVerwaltenFrame()
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
    this.setSize(1000, 400);
    this.setPreferredSize(new java.awt.Dimension(1260,400));
    this.setLocation(new java.awt.Point(10,103));
    this.setContentPane(getJContentPane());
    this.setTitle("Ereignisse Verwalten");
    this.setAlwaysOnTop(true);
    this.addWindowListener(new java.awt.event.WindowAdapter()
    {   
    	public void windowActivated(java.awt.event.WindowEvent e) {    
    		System.out.println("windowActivated()"); 
        // kart: Gleich mal die Ereignisliste anzeigen lassen...
        ereignisListeFuellen();
    	}
      public void windowOpened(java.awt.event.WindowEvent e)
      {
        System.out.println("windowOpened()"); 
        // kart: Gleich mal die Ereignisliste anzeigen lassen...
        //listeFuellen();
      }
    });
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
      jContentPane.add(getEastPanel(), java.awt.BorderLayout.EAST);
      jContentPane.add(getCenterPanel(), java.awt.BorderLayout.CENTER);
      jContentPane.add(getSouthPanel(), java.awt.BorderLayout.SOUTH);
      jContentPane.add(getWestPanel(), java.awt.BorderLayout.WEST);
      jContentPane.add(getJScrollPane(), java.awt.BorderLayout.NORTH);
    }
    return jContentPane;
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
      gridBagConstraints8.gridx = 0;
      gridBagConstraints8.insets = new java.awt.Insets(5,15,45,5);
      gridBagConstraints8.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints8.gridy = 4;
      GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
      gridBagConstraints5.gridx = 0;
      gridBagConstraints5.insets = new java.awt.Insets(5,15,80,5);
      gridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints5.gridy = 2;
      GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
      gridBagConstraints4.gridx = 0;
      gridBagConstraints4.insets = new java.awt.Insets(5,15,5,5);
      gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints4.gridy = 1;
      GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
      gridBagConstraints3.insets = new java.awt.Insets(5,15,5,5);
      gridBagConstraints3.gridy = 0;
      gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints3.gridx = 0;
      eastPanel = new JPanel();
      eastPanel.setLayout(new GridBagLayout());
      eastPanel.setBackground(new java.awt.Color(204,204,204));
      eastPanel.add(getBtNeu(), gridBagConstraints3);
      eastPanel.add(getBtAendern(), gridBagConstraints4);
      eastPanel.add(getBtLoeschen(), gridBagConstraints5);
      eastPanel.add(getBtAendernTeilnehmer(), gridBagConstraints8);
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
      GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
      gridBagConstraints22.fill = java.awt.GridBagConstraints.BOTH;
      gridBagConstraints22.weighty = 1.0;
      gridBagConstraints22.gridx = 0;
      gridBagConstraints22.gridy = 1;
      gridBagConstraints22.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints22.weightx = 1.0;
      GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
      gridBagConstraints12.fill = java.awt.GridBagConstraints.BOTH;
      gridBagConstraints12.weighty = 1.0;
      gridBagConstraints12.gridx = 0;
      gridBagConstraints12.gridy = 0;
      gridBagConstraints12.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints12.weightx = 1.0;
      centerPanel = new JPanel();
      centerPanel.setLayout(new GridBagLayout());
      centerPanel.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
      centerPanel.setBackground(new java.awt.Color(204,204,204));
      centerPanel.add(getScrollPaneEreignisse(), gridBagConstraints12);
      centerPanel.add(getScrollPaneTeilnahmen(), gridBagConstraints22);
    }
    return centerPanel;
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
      GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
      gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
      gridBagConstraints1.gridx = -1;
      gridBagConstraints1.gridy = -1;
      gridBagConstraints1.insets = new Insets(5, 15, 5, 5);
      southPanel = new JPanel();
      southPanel.setLayout(flowLayout);
      southPanel.setBackground(new java.awt.Color(204,204,204));
      southPanel.add(getBtExit(), null);
    }
    return southPanel;
  }

  /**
   * This method initializes btNeu	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtNeu()
  {
    if (btNeu == null)
    {
      btNeu = new JButton();
      btNeu.setText("Neues Ereignis");
      btNeu.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          // kart
          neu();
        }
      });
    }
    return btNeu;
  }

  /**
   * neu Methode
   */
  private void neu()
  {
    System.out.println("Neu...");
    EreignisBearbeitenDialog tGui = new EreignisBearbeitenDialog(this, "Ereignis neu erfassen", true);
    // Neues Ereignisobjekt erstellen ! und an ändern-Dialog übergeben!
    // Somit ist es dem ändern-dialgo egal ob neues oder änderndes Ereignis
    // es ist ja eigentlich immer eine änderung !!!!
    tGui.setEreignis(new Ereignis());
    tGui.setVisible(true);
  }
  
  /**
   * This method initializes listEreignisse	
   * 	
   * @return javax.swing.JList	
   */
  private JList getListEreignisse()
  {
    if (ereignisListView == null)
    {
      ereignisListView = new JList();
      ereignisListView.setBackground(java.awt.SystemColor.controlHighlight);
      ereignisListView.setFont(new java.awt.Font("Courier New", java.awt.Font.PLAIN, 12));
      ereignisListView.setPreferredSize(new java.awt.Dimension(160,30));
      ereignisListView.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray,0), "Ereignisse", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", java.awt.Font.BOLD, 14), java.awt.SystemColor.activeCaption));
      JScrollPane pane = new JScrollPane();
      pane.add(ereignisListView);
      // e manuell
      ereignisListView
          .addListSelectionListener(new javax.swing.event.ListSelectionListener()
          {
            public void valueChanged(javax.swing.event.ListSelectionEvent e)
            {
              System.out.println("valueChanged()"); 
              // kart
              masterDetailHandling(-1);
            }
          });
      
      ereignisListView.addFocusListener(new java.awt.event.FocusAdapter()
      {
        public void focusGained(java.awt.event.FocusEvent e)
        {
          System.out.println("focusGained()"); 
          // kart: Künstlich den obersten Record auswählen
          // bastel bastel....
          // ereignisListView.setSelectedIndex(0);
        }
      }
      
      );
    }
    return ereignisListView;
  }
  
  
  public void masterDetailHandling(Integer pZeile)
  {
    Integer tZeile;
    System.out.println("Master-Detail Handling.... Z=" +pZeile);
    if (pZeile <0)
    {
      // selektierte Zeile abfragen. Könnte man auch direkt mit
      // getSelectedValue machen - da kommt ein ganzes Objet zurück
      // Falls keine Ereignis selektiert ist, resultiert:  -1
      tZeile = this.ereignisListView.getSelectedIndex();
    }
    else
      tZeile = pZeile;
    //
    if (tZeile >=0)
    {
      // Ereignisen aus Model abfragen
      // Auf Model über Liste zugreifen. In der Liste ist das 
      // Model ja immer noch referenziert...
      // Problem: Methode getElementAt liefert ein Resultat der Top-Klasse
      // "Object" zurück. Wir erwarten aber ein Ereignisen-Objekt
      // somit wird das Resultat auf Ereignis-Object gecastet!
      Ereignis tEreignis = (Ereignis)this.ereignisListView.getModel().getElementAt(tZeile);
      System.out.println("Master: " +tEreignis.getBezeichnung());
      //
      teilnehmerListeFuellen(tEreignis.getEreignisId());
      //
      // Auch noch Anzahl Teilnehmer ermitteln und Summenfelder anzeigen
      tfAnzahlJa.setText(tEreignis.getAnzahlTeilnehmer("JA").toString());
      tfAnzahlNein.setText(tEreignis.getAnzahlTeilnehmer("NEIN").toString());
      tfAnzahlOffen.setText(tEreignis.getAnzahlTeilnehmer("-").toString());
      //
      // Wenn kein "Master" selected dann den obersten "selektieren" - optisch
      if (ereignisListView.getSelectedIndex() == -1)
        ereignisListView.setSelectedIndex(0);
    }
    //System.out.println("-----------------------");
    //System.out.println("zeile:   " +tZeile);  //ok ist 0,1,2,3,4...
    
  }

  /**
   * kart: teilnehmerListeFuellen Methode
   * Teilnehmer für das entsprechende Ereignis
   * aus der Datenbank lesen und in der Liste anzeigen.
   */
  private void teilnehmerListeFuellen(Integer pEreignisId)
  {
    System.out.println("Teilnehmer Liste füllen mit ER_ID="+pEreignisId);
    // MVC: Neues Model erstellen
    DefaultListModel tTeilnehmerModel = new DefaultListModel();
    // ereignisListView und Model verbinden
    teilnehmerListView.setModel(tTeilnehmerModel);
    
    // 
    // objekt doch noch anlegen. Teilnehmer aus der Datenbank lesen
    // und in Arraylist ablegen.
    Teilnehmer tTeilnehmer = new Teilnehmer();
    ArrayList<Teilnehmer> tListe;
    tListe = tTeilnehmer.alleLesenByEreignisId(pEreignisId);
    // Personen in das Model einsetzen
    // Anfängervariante - dafür mit Zähler
    Teilnehmer einTeilnehmer;
    for (int i=0; i<tListe.size(); i++)
    {
      // Teilnehmer aus der Arrayliste auslesen und mit
      // der standard Teilnehmer toString() Methode anzeigen
      einTeilnehmer = tListe.get(i);
      tTeilnehmerModel.addElement(einTeilnehmer);
      System.out.println("====>Summe Teilnehmer: " +i);
    }    
    //
    // neu mit cell renderer!
    teilnehmerListView.setCellRenderer(new TeilnehmerCellRenderer(teilnehmerListView));
  }
  
  
  
  
  
  
  /**
   * kart: ereignisListeFuellen Methode
   * Ereignisse aus der Datenbank lesen und in der Liste anzeigen.
   */
  private void ereignisListeFuellen()
  {
    System.out.println("--------------------------");
    System.out.println("Ereignis Liste füllen");
    System.out.println("--------------------------");    
    // MVC: Neues Model erstellen
    DefaultListModel tModel = new DefaultListModel();
    // ereignisListView und Model verbinden
    ereignisListView.setModel(tModel);
    // 
    // objekt doch noch anlegen. Ereignisse aus der Datenbank lesen
    // und in Arraylist ablegen.
    Ereignis tEreignis = new Ereignis();
    ArrayList<Ereignis> tListe;
    tListe = tEreignis.alleLesen();
    // Personen in das Model einsetzen
    // Abgekürzte Variante F.Letters
    /*
    for (Ereignis einEreignis: tListe)
    {
      tModel.addElement(einEreignis);
    }
    */
    // Personen in das Model einsetzen
    // Anfängervariante - dafür mit Zähler
    Ereignis einEreignis;
    for (int i=0; i<tListe.size(); i++)
    {
      einEreignis = tListe.get(i);
      tModel.addElement(einEreignis);
      // wenn 1. Element, dann gleich auch etspr. Details zeigen
      if (i==0)
        masterDetailHandling(0);
    }
    
  }

 
  
  /**
   * This method initializes btAendern	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtAendern()
  {
    if (btAendern == null)
    {
      btAendern = new JButton();
      btAendern.setText("Aendern Ereignis");
      btAendern.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          // kart
          aendernEreignis();
        }
      });
    }
    return btAendern;
  }

  /**
   * aendernEreignis Methode
   */
  private void aendernEreignis()
  {
    System.out.println("Aendern...Ereignis....");  
    // selektierte Zeile abfragen. Könnte man auch direkt mit
    // getSelectedValue machen - da kommt ein ganzes Objet zurück
    // Falls keine Ereignis selektiert ist, resultiert:  -1
    Integer tZeile = this.ereignisListView.getSelectedIndex();
    if (tZeile >=0)
    {
      // Ereignisen aus Model abfragen
      // Auf Model über Liste zugreifen. In der Liste ist das 
      // Model ja immer noch referenziert...
      // Problem: Methode getElementAt liefert ein Resultat der Top-Klasse
      // "Object" zurück. Wir erwarten aber ein Ereignisen-Objekt
      // somit wird das Resultat auf Ereignis-Object gecastet!
      Ereignis tEreignis = (Ereignis)this.ereignisListView.getModel().getElementAt(tZeile);
      // änderungs-gui aufrufen
      // ausgewählte Ereignis als Objekt übergeben mit setEreignis() Methode
      EreignisBearbeitenDialog tGui = new EreignisBearbeitenDialog(this, "Ereignis ändern", true);
      tGui.setEreignis(tEreignis);
      tGui.setVisible(true);
    }
    else
    {
      // Message Box 
      JOptionPane.showMessageDialog(this, "Es wurde kein Ereignis aus der Liste selektiert.");
    }  
  }
  
  /**
   * This method initializes btLoeschen	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtLoeschen()
  {
    if (btLoeschen == null)
    {
      btLoeschen = new JButton();
      btLoeschen.setText("Loeschen Ereignis");
      btLoeschen.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          // kart
          loeschen();
        }
      });
    }
    return btLoeschen;
  }

  /**
   * loeschen Methode
   */
  public void loeschen()
  {
      System.out.println("Loeschen...");  
      // selektierte Zeile abfragen. Könnte man auch direkt mit
      // getSelectedValue machen - da kommt ein ganzes Objet zurück
      // Falls keine Ereignis selektiert ist, resultiert:  -1
      Integer tZeile = this.ereignisListView.getSelectedIndex();
      if (tZeile >=0)
      {
        // Ereignisen aus Model abfragen
        // Auf Model über Liste zugreifen. In der Liste ist das 
        // Model ja immer noch referenziert...
        // Problem: Methode getElementAt liefert ein Resultat der Top-Klasse
        // "Object" zurück. Wir erwarten aber ein Ereignisen-Objekt
        // somit wird das Resultat auf Ereignis-Object gecastet!
        Ereignis tEreignis = (Ereignis)this.ereignisListView.getModel().getElementAt(tZeile);
        //
        // Prüfen ob das Löschen möglich ist (FK Constraints)
        if (tEreignis.getAnzahlTeilnehmer("JA") > 0
          ||tEreignis.getAnzahlTeilnehmer("NEIN") >0)
        {
          // Löschen nicht möglich - Detail Rows vorhanden
          // Message Box 
          JOptionPane.showMessageDialog(this
              , "Löschen nicht möglich da bereits Zu- oder Absagen vorhanden sind");
        } 
        else
        {
          // physisches löschen des Ereignis 
          tEreignis.loeschen();
          // refresh der liste
          ereignisListeFuellen();
        }
      }
  }
  
  /**
   * This method initializes btExit	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtExit()
  {
    if (btExit == null)
    {
      btExit = new JButton();
      btExit.setText("Exit");
      btExit.setPreferredSize(new java.awt.Dimension(149,26));
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
   * Exit Methode
   * 
   */
  public void exit()
  {
    // System.exit(0);
    // Maske schliessen und Ressourcen freigeben
    this.dispose();    
  }
  
  /**
   * This method initializes teilnahmerListView	
   * 	
   * @return javax.swing.JList	
   */
  private JList getTeilnehmerListView()
  {
    if (teilnehmerListView == null)
    {
      teilnehmerListView = new JList();
      teilnehmerListView.setFont(new java.awt.Font("Courier New", java.awt.Font.PLAIN, 12));
      teilnehmerListView.setToolTipText("Hier sind die Personen ersichtlich welche explizit Zu- oder Abgesagt haben");
      teilnehmerListView.setPreferredSize(new java.awt.Dimension(160,30));
      teilnehmerListView.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray,0), "Teilnahmen / Absagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", java.awt.Font.BOLD, 14), java.awt.SystemColor.activeCaption));
      teilnehmerListView.setBackground(java.awt.SystemColor.controlHighlight);
      // s manuell
      JScrollPane pane = new JScrollPane();
      pane.add(teilnehmerListView);
      // e manuell
    }
    return teilnehmerListView;
  }

  /**
   * This method initializes btAendernTeilnehmer	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtAendernTeilnehmer()
  {
    if (btAendernTeilnehmer == null)
    {
      btAendernTeilnehmer = new JButton();
      btAendernTeilnehmer.setText("Aendern Teilnehmer");
      btAendernTeilnehmer.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          // kart
          aendernTeilnehmer();
        }
      });
    }
    return btAendernTeilnehmer;
  }

  /**
   * aendernTeilnehmer Methode
   */
  private void aendernTeilnehmer()
  {
    System.out.println("Aendern...Teilnehmer...");  
    // selektierte Zeile abfragen. Könnte man auch direkt mit
    // getSelectedValue machen - da kommt ein ganzes Objet zurück
    // Falls keine Ereignis selektiert ist, resultiert:  -1
    Integer tZeile = this.ereignisListView.getSelectedIndex();
    if (tZeile >=0)
    {
      // Ereignisen aus Model abfragen
      // Auf Model über Liste zugreifen. In der Liste ist das 
      // Model ja immer noch referenziert...
      // Problem: Methode getElementAt liefert ein Resultat der Top-Klasse
      // "Object" zurück. Wir erwarten aber ein Ereignisen-Objekt
      // somit wird das Resultat auf Ereignis-Object gecastet!
      Ereignis tEreignis = (Ereignis)this.ereignisListView.getModel().getElementAt(tZeile);
      // änderungs-gui aufrufen
      // ausgewählte Ereignis als Objekt übergeben mit setEreignis() Methode
      EreignisTeilnehmerBearbeitenDialog tGui = new EreignisTeilnehmerBearbeitenDialog(this, true);
      tGui.setEreignis(tEreignis);
      tGui.setVisible(true);
    }
    else
    {
      // Message Box 
      JOptionPane.showMessageDialog(this, "Es wurde kein Ereignis aus der Liste selektiert.");
    }  
  }

  /**
   * This method initializes tfAnzahlJa	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfAnzahlJa()
  {
    if (tfAnzahlJa == null)
    {
      tfAnzahlJa = new JTextField();
      tfAnzahlJa.setPreferredSize(new java.awt.Dimension(20,20));
      tfAnzahlJa.setForeground(new java.awt.Color(0,153,0));
      tfAnzahlJa.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
      tfAnzahlJa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      tfAnzahlJa.setBackground(new java.awt.Color(204,204,204));
    }
    return tfAnzahlJa;
  }

  /**
   * This method initializes jPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getWestPanel()
  {
    if (westPanel == null)
    {
      GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
      gridBagConstraints11.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints11.gridy = 5;
      gridBagConstraints11.weightx = 1.0;
      gridBagConstraints11.insets = new java.awt.Insets(1,5,5,5);
      gridBagConstraints11.gridx = 0;
      GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
      gridBagConstraints10.gridx = 0;
      gridBagConstraints10.insets = new java.awt.Insets(5,5,1,5);
      gridBagConstraints10.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints10.gridy = 4;
      lbOffen = new JLabel();
      lbOffen.setText("Offen");
      lbOffen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lbOffen.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
      GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
      gridBagConstraints9.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints9.gridy = 3;
      gridBagConstraints9.weightx = 1.0;
      gridBagConstraints9.insets = new java.awt.Insets(1,5,5,5);
      gridBagConstraints9.gridx = 0;
      GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
      gridBagConstraints7.gridx = 0;
      gridBagConstraints7.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints7.insets = new java.awt.Insets(5,5,1,5);
      gridBagConstraints7.gridy = 2;
      lbNein = new JLabel();
      lbNein.setText("Nein");
      lbNein.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lbNein.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
      GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
      gridBagConstraints6.gridx = 0;
      gridBagConstraints6.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints6.insets = new java.awt.Insets(165,5,1,5);
      gridBagConstraints6.gridy = 0;
      lbJa = new JLabel();
      lbJa.setText("Ja");
      lbJa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lbJa.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
      GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
      gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints2.gridx = 0;
      gridBagConstraints2.gridy = 1;
      gridBagConstraints2.weightx = 1.0;
      gridBagConstraints2.insets = new java.awt.Insets(1,5,5,5);
      westPanel = new JPanel();
      westPanel.setLayout(new GridBagLayout());
      westPanel.setBackground(new java.awt.Color(204,204,204));
      westPanel.add(getTfAnzahlJa(), gridBagConstraints2);
      westPanel.add(lbJa, gridBagConstraints6);
      westPanel.add(lbNein, gridBagConstraints7);
      westPanel.add(getTfAnzahlNein(), gridBagConstraints9);
      westPanel.add(lbOffen, gridBagConstraints10);
      westPanel.add(getTfAnzahlOffen(), gridBagConstraints11);
    }
    return westPanel;
  }

  /**
   * This method initializes tfAnzahlNein	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfAnzahlNein()
  {
    if (tfAnzahlNein == null)
    {
      tfAnzahlNein = new JTextField();
      tfAnzahlNein.setBackground(new java.awt.Color(204,204,204));
      tfAnzahlNein.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
      tfAnzahlNein.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      tfAnzahlNein.setForeground(new java.awt.Color(204,0,0));
    }
    return tfAnzahlNein;
  }

  /**
   * This method initializes tfAnzahlOffen	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfAnzahlOffen()
  {
    if (tfAnzahlOffen == null)
    {
      tfAnzahlOffen = new JTextField();
      tfAnzahlOffen.setBackground(new java.awt.Color(204,204,204));
      tfAnzahlOffen.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
      tfAnzahlOffen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      tfAnzahlOffen.setForeground(java.awt.Color.black);
    }
    return tfAnzahlOffen;
  }

  /**
   * This method initializes jScrollPane	
   * 	
   * @return javax.swing.JScrollPane	
   */
  private JScrollPane getJScrollPane()
  {
    if (jScrollPane == null)
    {
      jScrollPane = new JScrollPane();
    }
    return jScrollPane;
  }

  /**
   * This method initializes jScrollPane1	
   * 	
   * @return javax.swing.JScrollPane	
   */
  private JScrollPane getScrollPaneEreignisse()
  {
    if (ScrollPaneEreignisse == null)
    {
      ScrollPaneEreignisse = new JScrollPane();
      ScrollPaneEreignisse.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      ScrollPaneEreignisse.setBackground(new java.awt.Color(204,204,204));
      ScrollPaneEreignisse.setViewportView(getListEreignisse());
    }
    return ScrollPaneEreignisse;
  }

  /**
   * This method initializes jScrollPane2	
   * 	
   * @return javax.swing.JScrollPane	
   */
  private JScrollPane getScrollPaneTeilnahmen()
  {
    if (ScrollPaneTeilnahmen == null)
    {
      ScrollPaneTeilnahmen = new JScrollPane();
      ScrollPaneTeilnahmen.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      ScrollPaneTeilnahmen.setViewportView(getTeilnehmerListView());
    }
    return ScrollPaneTeilnahmen;
  }

  
  

}  //  @jve:decl-index=0:visual-constraint="10,10"
