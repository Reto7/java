package applikation;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;

import datenModell.Ereignis;
import javax.swing.ImageIcon;

public class EreignisBearbeitenDialog extends JDialog
{

  private JPanel jContentPane = null;
  private JPanel centerPanel = null;
  private JPanel southPanel = null;
  private JLabel lbBezeichnung = null;
  private JTextField tfBezeichnung = null;
  private JLabel lbDatum = null;
  private JTextField tfDatum = null;
  private JLabel lbText = null;
  private JTextField tfText = null;
  private JLabel lbOrganisator = null;
  private JTextField tfOrganisator = null;
  private JLabel lbEreignisId = null;
  private JTextField tfEreignisId = null;
  private JButton btOk = null;
  private JButton btAbbruch = null;

  
  /**
   * This is the default constructor
   * kart: jetzt rufen wir unseren eigenen constructor mit 3 param. auf!
   */
  public EreignisBearbeitenDialog()
  {
    //super();       kart-entfernt
    this(null,"Irgendein Titel", false);
    //initialize();  kart-entfernt
  }
  
  /**
   * kart: Eigener constructor mit 3 parametern
   * 1. parameter = frame
   * 2. parameter = titelzeile (in Window Titel ersichtlich)
   * 3. parameter = modal (im Vordergrund, nicht wegzukriegen)
   */
  public EreignisBearbeitenDialog(JFrame pParentFrame
                                 ,String pTitel
                                 ,Boolean pModal)
  {
    super(pParentFrame, pTitel, pModal);
    initialize();
    this.tfEreignisId.setEnabled(false);
    this.tfOrganisator.setEnabled(false);
  }  

  
  
  
  
  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize()
  {
    this.setSize(610, 300);
//  this.setTitle("Teilnahme Verwaltung System - Ereignis bearbeiten");
    this.setLocation(new java.awt.Point(290,270));
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
      jContentPane.add(getSouthPanel(), java.awt.BorderLayout.SOUTH);
    }
    return jContentPane;
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
      GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
      gridBagConstraints12.gridx = 3;
      gridBagConstraints12.insets = new java.awt.Insets(5,0,25,0);
      gridBagConstraints12.fill = java.awt.GridBagConstraints.NONE;
      gridBagConstraints12.gridy = 9;
      GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
      gridBagConstraints41.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints41.gridy = 2;
      gridBagConstraints41.weightx = 1.0;
      gridBagConstraints41.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints41.gridx = 3;
      GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
      gridBagConstraints31.gridx = 2;
      gridBagConstraints31.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints31.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints31.gridy = 2;
      lbEreignisId = new JLabel();
      lbEreignisId.setText("Ereignis Nr.");
      GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
      gridBagConstraints21.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints21.gridy = 8;
      gridBagConstraints21.weightx = 1.0;
      gridBagConstraints21.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints21.gridwidth = 3;
      gridBagConstraints21.gridx = 1;
      GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
      gridBagConstraints11.gridx = 0;
      gridBagConstraints11.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints11.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints11.gridy = 8;
      lbOrganisator = new JLabel();
      lbOrganisator.setText("Organisator");
      GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
      gridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints5.gridy = 3;
      gridBagConstraints5.weightx = 1.0;
      gridBagConstraints5.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints5.gridwidth = 3;
      gridBagConstraints5.gridheight = 2;
      gridBagConstraints5.gridx = 1;
      GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
      gridBagConstraints4.gridx = 0;
      gridBagConstraints4.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints4.gridy = 3;
      lbText = new JLabel();
      lbText.setText("Bemerkung");
      lbText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
      lbText.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
      GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
      gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints3.gridy = 2;
      gridBagConstraints3.weightx = 1.0;
      gridBagConstraints3.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints3.gridx = 1;
      GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
      gridBagConstraints2.gridx = 0;
      gridBagConstraints2.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints2.gridy = 2;
      lbDatum = new JLabel();
      lbDatum.setText("Datum");
      lbDatum.setToolTipText("Geplantes Ereignisdatum im Format dd.mm.yyyy");
      GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
      gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints1.gridy = 1;
      gridBagConstraints1.weightx = 1.0;
      gridBagConstraints1.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints1.gridheight = 1;
      gridBagConstraints1.gridwidth = 3;
      gridBagConstraints1.gridx = 1;
      GridBagConstraints gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 0;
      gridBagConstraints.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
      gridBagConstraints.gridy = 1;
      lbBezeichnung = new JLabel();
      lbBezeichnung.setText("Bezeichnung");
      centerPanel = new JPanel();
      centerPanel.setLayout(new GridBagLayout());
      centerPanel.setBackground(new java.awt.Color(204,204,204));
      centerPanel.add(lbBezeichnung, gridBagConstraints);
      centerPanel.add(getTfBezeichnung(), gridBagConstraints1);
      centerPanel.add(lbDatum, gridBagConstraints2);
      centerPanel.add(getTfDatum(), gridBagConstraints3);
      centerPanel.add(lbText, gridBagConstraints4);
      centerPanel.add(getTfText(), gridBagConstraints5);
      centerPanel.add(lbOrganisator, gridBagConstraints11);
      centerPanel.add(getTfOrganisator(), gridBagConstraints21);
      centerPanel.add(lbEreignisId, gridBagConstraints31);
      centerPanel.add(getTfEreignisId(), gridBagConstraints41);
      centerPanel.add(getBtMail(), gridBagConstraints12);
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
      GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
      gridBagConstraints7.gridx = 1;
      gridBagConstraints7.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints7.gridy = 0;
      GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
      gridBagConstraints6.insets = new java.awt.Insets(5,5,5,5);
      gridBagConstraints6.gridy = 0;
      gridBagConstraints6.gridx = 0;
      southPanel = new JPanel();
      southPanel.setLayout(new GridBagLayout());
      southPanel.setBackground(new java.awt.Color(204,204,204));
      southPanel.add(getBtOk(), gridBagConstraints6);
      southPanel.add(getBtAbbruch(), gridBagConstraints7);
    }
    return southPanel;
  }

  /**
   * This method initializes tfBezeichnung	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfBezeichnung()
  {
    if (tfBezeichnung == null)
    {
      tfBezeichnung = new JTextField();
      tfBezeichnung.setPreferredSize(new java.awt.Dimension(8,20));
    }
    return tfBezeichnung;
  }

  /**
   * This method initializes tfDatum	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfDatum()
  {
    if (tfDatum == null)
    {
      tfDatum = new JTextField();
      tfDatum.setPreferredSize(new java.awt.Dimension(44,20));
      tfDatum.addFocusListener(new java.awt.event.FocusAdapter()
      {
        public void focusLost(java.awt.event.FocusEvent e)
        {
          System.out.println("focusLost()"); 
          // kart
          pruefenDatum();
        }
      });
    }
    return tfDatum;
  }
  
  private void pruefenDatum()
  {
    Boolean checkDatum = Util.pruefenDatumFormat(tfDatum.getText());    
    // Fehler in Message Box ausgeben wenn Datumformat inkorrekt
    if (!checkDatum)
    {
      JOptionPane.showMessageDialog(this, "Bitte geben Sie das Datumformat DD.MM.JJJJ an");
      btOk.setEnabled(false);
    }
    else
      btOk.setEnabled(true);
    //
  }

  /**
   * This method initializes tfText	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfText()
  {
    if (tfText == null)
    {
      tfText = new JTextField();
      tfText.setPreferredSize(new java.awt.Dimension(4,60));
    }
    return tfText;
  }

  /**
   * This method initializes tfOrganisator	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfOrganisator()
  {
    if (tfOrganisator == null)
    {
      tfOrganisator = new JTextField();
    }
    return tfOrganisator;
  }

  /**
   * This method initializes tfEreignisId	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfEreignisId()
  {
    if (tfEreignisId == null)
    {
      tfEreignisId = new JTextField();
    }
    return tfEreignisId;
  }

  /**
   * This method initializes btOk	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtOk()
  {
    if (btOk == null)
    {
      btOk = new JButton();
      btOk.setText("Ok");
      btOk.setPreferredSize(new java.awt.Dimension(90,26));
      btOk.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          // kart
          ok();
        }
      });
    }
    return btOk;
  }

  /**
   * ok Methode
   */
  private void ok()
  {
    System.out.println("ok");
    // Ereignisobjekt aktualisieren aus View (Maske)
    // und dann speichern
    String tString; 
    //
    try
    {
      tString = this.tfBezeichnung.getText();
      this.ereignis.setBezeichnung(tString);
      //
      tString = this.tfDatum.getText();
      this.ereignis.setDatum(tString);
      //
      tString = this.tfText.getText();
      this.ereignis.setBemerkung(tString);
      //
      this.ereignis.speichern();
      //
      // Maske schliessen und Ressourcen freigeben
      this.dispose();
    }
    catch (Exception pException)
    {
      JOptionPane.showMessageDialog(this, "Fehler bei der Eingabe: " 
                                        + pException);
    }
  }
  
  
  /**
   * This method initializes btAbbruch	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtAbbruch()
  {
    if (btAbbruch == null)
    {
      btAbbruch = new JButton();
      btAbbruch.setText("Abbruch");
      btAbbruch.setPreferredSize(new java.awt.Dimension(90,26));
      btAbbruch.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()");
          // kart
          abbruch();
        }
      });
    }
    return btAbbruch;
  }

  /**
   * abbruch Methode
   */
  private void abbruch()
  {
    System.out.println("abbruch - FINISH");
    // Maske schliessen und Ressourcen freigeben
    this.dispose();
  } 
  
  //-------------------------------------------------------------------------  
  // Neue Instanzvariable
  private Ereignis ereignis;
  private JButton btMail = null;
  
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
    //
    // Die Attribute des Ereignisenobjekts anzeigen
    // Also: View aktualisieren  (this ist hier also das Dialog Objekt!)
    //
    // Meisten Felder sind sowieso schon ein String 
    // und kann einfach angezeigt werden
    this.tfBezeichnung.setText(this.ereignis.getBezeichnung());
    this.tfDatum.setText(ereignis.getDatum());
    this.tfText.setText(ereignis.getBemerkung());
    if (ereignis.getEreignisId() != null)
      this.tfEreignisId.setText(ereignis.getEreignisId().toString());
    if (ereignis.getPersonId() !=  null)
      this.tfOrganisator.setText(ereignis.getPerson().getBezeichnung());
    
  }
  
  // Neue getter Methode für "ereignis"
  public Ereignis getEreignis()
  {
    return ereignis;
  }

  /**
   * This method initializes btMail	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtMail()
  {
    if (btMail == null)
    {
      btMail = new JButton();
      btMail.setText("Mail versenden");
      btMail.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
      btMail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      btMail.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
      btMail.setToolTipText("Hiermit versenden Sie ein Info Mail bezüglich dieses neuen Ereignisses an alle Personen");
      btMail.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
      btMail.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          // kart
          mailVersenden();
        }
      });
    }
    return btMail;
  }
  
  /** 
   * mailVersenden Methode
   */
  public void mailVersenden()
  {
    JOptionPane.showMessageDialog(this, "Hiermit würde ein Einladungs-Mail an alle "
         + "gespeicherten Personen versendet ....");
  }
  
    
  
}  //  @jve:decl-index=0:visual-constraint="10,10"
