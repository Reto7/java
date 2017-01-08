package applikation;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import datenModell.Ereignis;
import datenModell.TeilnehmerEreignis;
import java.awt.FlowLayout;

public class EreignisTeilnehmerBearbeitenDialog extends JDialog
{

  private JPanel jContentPane = null;
  private JPanel centerPanel = null;
  private JPanel eastPanel = null;
  private JTextField tfEreignisBezeichnung = null;
  private JTextField tfEreignisDatum = null;
  private JTextField tfEreignisPerson = null;
  private JTextField tfEreignisFreitext = null;
  private JList listView = null;
  private JButton btTeilnehmen = null;
  private JButton btNichtTeilnehmen = null;
  private JLabel lbBezeichnung = null;
  private JLabel lbDatum = null;
  private JLabel lbPerson = null;
  private JLabel lbBemerkung = null;
  private JTextField tfNeueBemerkung = null;
  private JButton btExit = null;
  /**
   * This is the default constructor
   */
  
  /**
   * This is the default constructor
   * kart: jetzt rufen wir unseren eigenen constructor mit 3 param. auf!
   */
  public EreignisTeilnehmerBearbeitenDialog()
  {
    //super();       kart-entfernt
    this(null, false);
    //initialize();  kart-entfernt
  }
  
  /**
   * kart: Eigener constructor mit 3 parametern
   * 1. parameter = frame
   * 2. parameter = titelzeile (in Window Titel ersichtlich)
   * 3. parameter = modal (im Vordergrund, nicht wegzukriegen)
   */
  public EreignisTeilnehmerBearbeitenDialog(JFrame pParentFrame
                                            ,Boolean pModal)
  {
    super(pParentFrame,  pModal);
    initialize();
  }  

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize()
  {
    this.setSize(793, 714);
    this.setTitle("Ereignis-Teilnehmer Bearbeiten");
    this.setContentPane(getJContentPane());
    this.setAlwaysOnTop(true);
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
      jContentPane.add(getCenterPanel(), java.awt.BorderLayout.CENTER);
      jContentPane.add(getEastPanel(), java.awt.BorderLayout.EAST);
      jContentPane.add(getSouthPanel(), java.awt.BorderLayout.SOUTH);
    }
    return jContentPane;
  }

  /**
   * This method initializes northPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  /**
   * This method initializes centerPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getCenterPanel()
  {
    if (centerPanel == null)
    {
      GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
      gridBagConstraints14.gridx = 0;
      gridBagConstraints14.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints14.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints14.gridy = 4;
      lbBemerkung = new JLabel();
      lbBemerkung.setText("Bemerkung");
      GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
      gridBagConstraints13.gridx = 0;
      gridBagConstraints13.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints13.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints13.gridy = 3;
      lbPerson = new JLabel();
      lbPerson.setText("Organisator");
      GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
      gridBagConstraints12.gridx = 0;
      gridBagConstraints12.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints12.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints12.gridy = 2;
      lbDatum = new JLabel();
      lbDatum.setText("Datum");
      GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
      gridBagConstraints10.gridx = 0;
      gridBagConstraints10.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints10.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints10.gridy = 1;
      lbBezeichnung = new JLabel();
      lbBezeichnung.setText("Bezeichnung");
      GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
      gridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints5.gridx = 1;
      gridBagConstraints5.gridy = 2;
      gridBagConstraints5.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints5.weightx = 1.0;
      GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
      gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints3.gridx = 1;
      gridBagConstraints3.gridy = 1;
      gridBagConstraints3.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints3.weightx = 1.0;
      GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
      gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints4.gridx = 1;
      gridBagConstraints4.gridy = 3;
      gridBagConstraints4.weightx = 1.0;
      gridBagConstraints4.insets = new java.awt.Insets(5,5,5,5);
      GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
      gridBagConstraints6.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints6.gridx = 1;
      gridBagConstraints6.gridy = 4;
      gridBagConstraints6.weightx = 1.0;
      gridBagConstraints6.insets = new java.awt.Insets(5,5,5,5);
      GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
      gridBagConstraints7.fill = java.awt.GridBagConstraints.BOTH;
      gridBagConstraints7.gridy = 6;
      gridBagConstraints7.weightx = 1.0;
      gridBagConstraints7.weighty = 1.0;
      gridBagConstraints7.gridheight = 1;
      gridBagConstraints7.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints7.gridwidth = 2;
      gridBagConstraints7.gridx = 0;
      centerPanel = new JPanel();
      centerPanel.setLayout(new GridBagLayout());
      centerPanel.add(getListView(), gridBagConstraints7);
      centerPanel.add(getTfEreignisDatum(), gridBagConstraints5);
      centerPanel.add(getTfEreignisFreitext(), gridBagConstraints6);
      centerPanel.add(getTfEreignisPerson(), gridBagConstraints4);
      centerPanel.add(getTfEreignisBezeichnung(), gridBagConstraints3);
      centerPanel.add(lbBezeichnung, gridBagConstraints10);
      centerPanel.add(lbDatum, gridBagConstraints12);
      centerPanel.add(lbPerson, gridBagConstraints13);
      centerPanel.add(lbBemerkung, gridBagConstraints14);
    }
    return centerPanel;
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
      GridBagConstraints gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints.gridy = 2;
      gridBagConstraints.weightx = 1.0;
      gridBagConstraints.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints.gridx = 0;
      GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
      gridBagConstraints9.gridx = 0;
      gridBagConstraints9.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints9.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints9.gridy = 1;
      GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
      gridBagConstraints8.insets = new java.awt.Insets(85,5,5,5);
      gridBagConstraints8.gridy = 0;
      gridBagConstraints8.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints8.gridx = 0;
      eastPanel = new JPanel();
      eastPanel.setLayout(new GridBagLayout());
      eastPanel.setBackground(new java.awt.Color(204,204,255));
      eastPanel.add(getBtTeilnehmen(), gridBagConstraints8);
      eastPanel.add(getBtNichtTeilnehmen(), gridBagConstraints9);
      eastPanel.add(getTfNeueBemerkung(), gridBagConstraints);
    }
    return eastPanel;
  }

  /**
   * This method initializes tfEreignis	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfEreignisBezeichnung()
  {
    if (tfEreignisBezeichnung == null)
    {
      tfEreignisBezeichnung = new JTextField();
    }
    return tfEreignisBezeichnung;
  }

  /**
   * This method initializes tfEreignisDatum	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfEreignisDatum()
  {
    if (tfEreignisDatum == null)
    {
      tfEreignisDatum = new JTextField();
      tfEreignisDatum.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
      tfEreignisDatum.setHorizontalAlignment(javax.swing.JTextField.LEFT);
      tfEreignisDatum.setPreferredSize(new java.awt.Dimension(100,20));
    }
    return tfEreignisDatum;
  }

  /**
   * This method initializes tfEreignisPerson	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfEreignisPerson()
  {
    if (tfEreignisPerson == null)
    {
      tfEreignisPerson = new JTextField();
    }
    return tfEreignisPerson;
  }

  /**
   * This method initializes tfEreignisBemerkung	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfEreignisFreitext()
  {
    if (tfEreignisFreitext == null)
    {
      tfEreignisFreitext = new JTextField();
    }
    return tfEreignisFreitext;
  }

  /**
   * This method initializes jList	
   * 	
   * @return javax.swing.JList	
   */
  private JList getListView()
  {
    if (listView == null)
    {
      listView = new JList();
      listView.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Person / Teilnehmer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", java.awt.Font.BOLD, 14), java.awt.SystemColor.activeCaption));
      listView.setPreferredSize(new java.awt.Dimension(60,30));
    }
    return listView;
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
      btTeilnehmen.setText("teilnehmen");
    }
    return btTeilnehmen;
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
      btNichtTeilnehmen.setText("nicht teilnehmen");
    }
    return btNichtTeilnehmen;
  }

  /**
   * This method initializes tfNeueBemerkung	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfNeueBemerkung()
  {
    if (tfNeueBemerkung == null)
    {
      tfNeueBemerkung = new JTextField();
    }
    return tfNeueBemerkung;
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
      btExit.setPreferredSize(new java.awt.Dimension(120,26));
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
  
  //--------------------------------------------------------------
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
    tListe = tTeilnehmerEreignis.alleLesenProLoginId(false);
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
      tModel.addElement(einTeilnehmerEreignis);  //toString wird aufgerufen!
      // wenn 1. Element, dann gleich auch etspr. Details zeigen
      //if (i==0)
    }
  }

  
  //--------------------------------------------------------------
  // Neue Instanzvariable
  private Ereignis ereignis;
  private JPanel southPanel = null;
  
  // Neue setter Methode zu dieser Instanzvariable "ereignis"
  public void setEreignis(Ereignis pEreignis)
  {
    // kart:  Ereignisenobjekt wird über die ganze Lebensdauer 
    // des Dialog Objekts benötigt. 
    // ==> Ergibt eine Instanzvariable "ereignis" für diese Dialog Klasse!
    //
    // Die übergebene Ereignis der Instanzvariable (attribut)
    // zuordnen.
    this.ereignis = pEreignis;
    System.out.println("Ereignis " +pEreignis +" an Teilnehmer-Änderungsdialog übergeben");
    // Die Attribute des Ereignisenobjekts anzeigen
    // Also: View aktualisieren  (this ist hier also das Dialog Objekt!)
    //
    // Meisten Felder sind sowieso schon ein String 
    // und kann einfach angezeigt werden
    this.tfEreignisBezeichnung.setText(this.ereignis.getBezeichnung());
    this.tfEreignisDatum.setText(ereignis.getDatum());
    this.tfEreignisFreitext.setText(ereignis.getBemerkung());
//  if (ereignis.getEreignisId() != null)
//    this.tfEreignisId.setText(ereignis.getEreignisId().toString());
    if (ereignis.getPersonId() !=  null)
      this.tfEreignisPerson.setText(ereignis.getPerson().getBezeichnung());    
  }
  
  // Neue getter Methode für "ereignis"
  public Ereignis getEreignis()
  {
    return ereignis;
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
      southPanel = new JPanel();
      southPanel.setBackground(java.awt.SystemColor.activeCaptionBorder);
      southPanel.setLayout(flowLayout);
      southPanel.add(getBtExit(), null);
    }
    return southPanel;
  }
  
  //-------------------------------------------------------------------------
  

  
}  //  @jve:decl-index=0:visual-constraint="10,10"
