package applikation;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Event;
import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;


import datenModell.DBManager;
import datenModell.Person;
import java.awt.*;
import javax.swing.plaf.basic.BasicToolBarUI;

public class StartFrame extends JFrame
{

  private JPanel jContentPane = null;

  private JMenuBar jJMenuBar = null;

  private JMenu fileMenu = null;

  private JMenu editMenu = null;

  private JMenu helpMenu = null;

  private JMenuItem exitMenuItem = null;

  private JMenuItem aboutMenuItem = null;

  private JMenuItem cutMenuItem = null;

  private JMenuItem copyMenuItem = null;

  private JMenuItem pasteMenuItem = null;

  private JToolBar ToolBar = null;

  private JButton btEreignisVerwalten = null;

  private JPanel jPanelRechts = null;

  private JTextField tfLogin = null;

  private JLabel lbKurzzeichen = null;

  private JButton btLogin = null;

  private JTextField tfBenutzername = null;

  private JButton btTeilnehmen = null;

  private JMenu menuAnwendungen = null;

  private JMenuItem menuItemAnwendEreignisse = null;

  private JMenuItem menuItemAnwendTeilnehmen = null;

  private JButton btExit = null;

  private JMenu menuStammdaten = null;

  private JMenuItem menuItemPersonenVerwalten = null;

  private BasicToolBarUI basicToolBarUI = null;  //  @jve:decl-index=0:visual-constraint=""

  private JPanel jPanelLinks = null;

  

  /**
   * This is the default constructor
   */
  public StartFrame()
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
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setPreferredSize(new java.awt.Dimension(1280,766));
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    this.setJMenuBar(getJJMenuBar());
    this.setSize(1280, 766);
    this.setContentPane(getJContentPane());
    this.setTitle("Ereignis/Teilnahme System");
    this.setAlwaysOnTop(false);
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
      jContentPane.setBackground(java.awt.SystemColor.controlLtHighlight);
      jContentPane.add(getToolBar(), java.awt.BorderLayout.NORTH);
      
    }
    return jContentPane;
  }

  /**
   * This method initializes jJMenuBar	
   * 	
   * @return javax.swing.JMenuBar	
   */
  private JMenuBar getJJMenuBar()
  {
    if (jJMenuBar == null)
    {
      jJMenuBar = new JMenuBar();
      jJMenuBar.add(getFileMenu());
      jJMenuBar.add(getEditMenu());
      jJMenuBar.add(getMenuAnwendungen());
      jJMenuBar.add(getMenuStammdaten());
      jJMenuBar.add(getHelpMenu());
    }
    return jJMenuBar;
  }

  /**
   * This method initializes jMenu	
   * 	
   * @return javax.swing.JMenu	
   */
  private JMenu getFileMenu()
  {
    if (fileMenu == null)
    {
      fileMenu = new JMenu();
      fileMenu.setText("File");
      fileMenu.add(getExitMenuItem());
    }
    return fileMenu;
  }

  /**
   * This method initializes jMenu	
   * 	
   * @return javax.swing.JMenu	
   */
  private JMenu getEditMenu()
  {
    if (editMenu == null)
    {
      editMenu = new JMenu();
      editMenu.setText("Edit");
      editMenu.add(getCutMenuItem());
      editMenu.add(getCopyMenuItem());
      editMenu.add(getPasteMenuItem());
    }
    return editMenu;
  }

  /**
   * This method initializes jMenu	
   * 	
   * @return javax.swing.JMenu	
   */
  private JMenu getHelpMenu()
  {
    if (helpMenu == null)
    {
      helpMenu = new JMenu();
      helpMenu.setText("Help");
      helpMenu.add(getAboutMenuItem());
    }
    return helpMenu;
  }

  /**
   * This method initializes jMenuItem	
   * 	
   * @return javax.swing.JMenuItem	
   */
  private JMenuItem getExitMenuItem()
  {
    if (exitMenuItem == null)
    {
      exitMenuItem = new JMenuItem();
      exitMenuItem.setText("Exit");
      exitMenuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          exit();
        }
      });
    }
    return exitMenuItem;
  }

  /**
   * This method initializes jMenuItem	
   * 	
   * @return javax.swing.JMenuItem	
   */
  private JMenuItem getAboutMenuItem()
  {
    if (aboutMenuItem == null)
    {
      aboutMenuItem = new JMenuItem();
      aboutMenuItem.setText("About");
      aboutMenuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          new JDialog(StartFrame.this, "Ereignis/Teilnahme System V1", true).show();
        }
      });
    }
    return aboutMenuItem;
  }

  /**
   * This method initializes jMenuItem	
   * 	
   * @return javax.swing.JMenuItem	
   */
  private JMenuItem getCutMenuItem()
  {
    if (cutMenuItem == null)
    {
      cutMenuItem = new JMenuItem();
      cutMenuItem.setText("Cut");
      cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
          Event.CTRL_MASK, true));
    }
    return cutMenuItem;
  }

  /**
   * This method initializes jMenuItem	
   * 	
   * @return javax.swing.JMenuItem	
   */
  private JMenuItem getCopyMenuItem()
  {
    if (copyMenuItem == null)
    {
      copyMenuItem = new JMenuItem();
      copyMenuItem.setText("Copy");
      copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
          Event.CTRL_MASK, true));
    }
    return copyMenuItem;
  }

  /**
   * This method initializes jMenuItem	
   * 	
   * @return javax.swing.JMenuItem	
   */
  private JMenuItem getPasteMenuItem()
  {
    if (pasteMenuItem == null)
    {
      pasteMenuItem = new JMenuItem();
      pasteMenuItem.setText("Paste");
      pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
          Event.CTRL_MASK, true));
    }
    return pasteMenuItem;
  }

  /**
   * This method initializes ToolBar	
   * 	
   * @return javax.swing.JToolBar	
   */
  private JToolBar getToolBar()
  {
    if (ToolBar == null)
    {
      ToolBar = new JToolBar();
      ToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray,1));
      ToolBar.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
      ToolBar.setUI(getBasicToolBarUI());
      ToolBar.add(getJPanelLinks());
      ToolBar.add(getJPanelRechts());
    }
    return ToolBar;
  }

  /**
   * This method initializes jButton	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtEreignisVerwalten()
  {
    if (btEreignisVerwalten == null)
    {
      btEreignisVerwalten = new JButton();
      btEreignisVerwalten.setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/address_book.png"));
      btEreignisVerwalten.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          verwalten();
        }
      });
      btEreignisVerwalten.setText("Ereignisse verwalten");
      btEreignisVerwalten.setPreferredSize(new java.awt.Dimension(189,40));
      btEreignisVerwalten.setEnabled(false);
      btEreignisVerwalten.setToolTipText("Hiermit können Sie Ereignisse neu erfassen, ändern oder löschen");
    }
    return btEreignisVerwalten;
  }

  /**
   * verwalten Methode
   */
  private void verwalten()
  {
    System.out.println("verwalten button ...");
    EreignisVerwaltenFrame tGui = new EreignisVerwaltenFrame();
    tGui.setVisible(true);
  }
  



  /**
   * This method initializes jPanel	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getJPanelRechts()
  {
    if (jPanelRechts == null)
    {
      FlowLayout flowLayout = new FlowLayout();
      flowLayout.setAlignment(java.awt.FlowLayout.RIGHT);
      lbKurzzeichen = new JLabel();
      lbKurzzeichen.setText("Kurzzeichen");
      jPanelRechts = new JPanel();
      jPanelRechts.setBackground(new java.awt.Color(248,248,248));
      jPanelRechts.setLayout(flowLayout);
      jPanelRechts.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
      jPanelRechts.add(lbKurzzeichen, null);
      jPanelRechts.add(getTfLogin(), null);
      jPanelRechts.add(getTfBenutzername(), null);
      jPanelRechts.add(getBtLogin(), null);
      jPanelRechts.add(getBtExit(), null);
    }
    return jPanelRechts;
  }



  /**
   * This method initializes jTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfLogin()
  {
    if (tfLogin == null)
    {
      tfLogin = new JTextField();
      tfLogin.setPreferredSize(new java.awt.Dimension(60,20));
      tfLogin.setText("kart");
    }
    return tfLogin;
  }



  /**
   * This method initializes btLogin	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtLogin()
  {
    if (btLogin == null)
    {
      btLogin = new JButton();
      btLogin.setText("Login");
      btLogin.setPreferredSize(new java.awt.Dimension(130,36));
      btLogin.setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/check2.png"));
      btLogin.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          login();
        }
      });
    }
    return btLogin;
  }

  //--------------------------------------------------------------
  // login
  //--------------------------------------------------------------
  private void login()
  {
    if (tfLogin.getText().equals(""))
    {
      // Message Box - Meldung
      JOptionPane.showMessageDialog(this, "Bitte geben Sie oben zuerst Ihr Kurzzeichen ein");
    }
    else
    {
      String tKurzzeichen = tfLogin.getText().toUpperCase();
      DBManager.openDb();
      Person tPerson = new Person();
      try
      {
        tPerson = tPerson.suchenKurzzeichen(tKurzzeichen);
        System.out.println("Person=" +tPerson.getBezeichnung());
        // Abspeichern LoginId in Klassenvariable !
        Person.setLoginId(tPerson.getPersonId());
        // Anzeigen der eingeloggten Person
        tfBenutzername.setText(tPerson.getBezeichnung());
        // buttons auf enable
        btEreignisVerwalten.setEnabled(true);
        btTeilnehmen.setEnabled(true);
        // Menü auf enable
        menuAnwendungen.setEnabled(true);
        // 
        //System.out.println(Person.getLogin_id().toString());
        
      }
      catch(Exception e)
      {
        // buttons auf enable
        btEreignisVerwalten.setEnabled(false);
        btTeilnehmen.setEnabled(false);        
        // Message Box - Meldung
        String tText = "Person "
                      + tKurzzeichen
                      + " nicht in Datenbank gefunden";
        tfBenutzername.setText(tText);
        JOptionPane.showMessageDialog(this, tText);
      }
      
      // Löschen temporäre Variablen bzw. temporäre Objekte
      tPerson = null; 
      tKurzzeichen = null;
    }
  }
  


  /**
   * This method initializes tfBenutzername	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTfBenutzername()
  {
    if (tfBenutzername == null)
    {
      tfBenutzername = new JTextField();
      tfBenutzername.setPreferredSize(new java.awt.Dimension(190,20));
      tfBenutzername.setDisabledTextColor(new java.awt.Color(0,51,153));
      tfBenutzername.setEnabled(false);
      tfBenutzername.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
      tfBenutzername.setEditable(false);
    }
    return tfBenutzername;
  }



  /**
   * This method initializes jButton1	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getBtTeilnehmen()
  {
    if (btTeilnehmen == null)
    {
      btTeilnehmen = new JButton();
      btTeilnehmen.setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/businessman_preferences.png"));
      btTeilnehmen.setEnabled(false);
      btTeilnehmen.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          teilnehmen();
        }
      });
      btTeilnehmen.setText("Teilnehmen/Absagen");
      btTeilnehmen.setDefaultCapable(true);
      btTeilnehmen.setPreferredSize(new java.awt.Dimension(189,40));
      btTeilnehmen.setToolTipText("Hier können Sie an Ereignissen zu- oder absagen");
    }
    return btTeilnehmen;
  }

  /**
   * teilnehmen Methode
   */
  private void teilnehmen()
  {
    System.out.println("teilnehmen button ...");
    PersonTeilnehmerDialog tGui = new PersonTeilnehmerDialog();
    tGui.setVisible(true);
  }


  /**
   * This method initializes menuAnwendungen	
   * 	
   * @return javax.swing.JMenu	
   */
  private JMenu getMenuAnwendungen()
  {
    if (menuAnwendungen == null)
    {
      menuAnwendungen = new JMenu();
      menuAnwendungen.setText("Anwendungen");
      menuAnwendungen.setEnabled(false);
      menuAnwendungen.add(getMenuItemAnwendEreignisse());
      menuAnwendungen.add(getMenuItemAnwendTeilnehmen());
    }
    return menuAnwendungen;
  }



  /**
   * This method initializes menuItemAnwendEreignisse	
   * 	
   * @return javax.swing.JMenuItem	
   */
  private JMenuItem getMenuItemAnwendEreignisse()
  {
    if (menuItemAnwendEreignisse == null)
    {
      menuItemAnwendEreignisse = new JMenuItem();
      menuItemAnwendEreignisse.setText("Ereignisse verwalten");
      menuItemAnwendEreignisse.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          verwalten();
        }
      });
    }
    return menuItemAnwendEreignisse;
  }



  /**
   * This method initializes menuItemAnwendTeilnehmen	
   * 	
   * @return javax.swing.JMenuItem	
   */
  private JMenuItem getMenuItemAnwendTeilnehmen()
  {
    if (menuItemAnwendTeilnehmen == null)
    {
      menuItemAnwendTeilnehmen = new JMenuItem();
      menuItemAnwendTeilnehmen.setText("Teilnehmen/Absagen");
      menuItemAnwendTeilnehmen.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          teilnehmen();
        }
      });
    }
    return menuItemAnwendTeilnehmen;
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
      btExit.setPreferredSize(new java.awt.Dimension(91,36));
      btExit.setIcon(new ImageIcon("C:/Daten/eclipse/TeilnahmeProjekt/src/img/door.png"));
      btExit.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
          System.out.println("actionPerformed()"); 
          exit();
        }
      });
    }
    return btExit;
  }

  /**
   * exit Methode zum sauberen beenden des Programms
   */
  private void exit()
  {
    System.exit(0);
  }
  
  /**
   * This method initializes menuStammdaten	
   * 	
   * @return javax.swing.JMenu	
   */
  private JMenu getMenuStammdaten()
  {
    if (menuStammdaten == null)
    {
      menuStammdaten = new JMenu();
      menuStammdaten.setText("Stammdaten");
      menuStammdaten.add(getMenuItemPersonenVerwalten());
    }
    return menuStammdaten;
  }



  /**
   * This method initializes menuItemPersonenVerwalten	
   * 	
   * @return javax.swing.JMenuItem	
   */
  private JMenuItem getMenuItemPersonenVerwalten()
  {
    if (menuItemPersonenVerwalten == null)
    {
      menuItemPersonenVerwalten = new JMenuItem();
      menuItemPersonenVerwalten.setText("Personen verwalten");
    }
    return menuItemPersonenVerwalten;
  }



 
  /**
   * This method initializes basicToolBarUI	
   * 	
   * @return javax.swing.plaf.basic.BasicToolBarUI	
   */
  private BasicToolBarUI getBasicToolBarUI()
  {
    if (basicToolBarUI == null)
    {
      basicToolBarUI = new BasicToolBarUI();
    }
    return basicToolBarUI;
  }



  /**
   * This method initializes jPanelLinks	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getJPanelLinks()
  {
    if (jPanelLinks == null)
    {
      FlowLayout flowLayout1 = new FlowLayout();
      flowLayout1.setAlignment(java.awt.FlowLayout.LEFT);
      jPanelLinks = new JPanel();
      jPanelLinks.setBackground(new java.awt.Color(248,248,248));
      jPanelLinks.setLayout(flowLayout1);
      jPanelLinks.add(getBtEreignisVerwalten(), null);
      jPanelLinks.add(getBtTeilnehmen(), null);
    }
    return jPanelLinks;
  }



  /**
   * Launches this application
   */
  public static void main(String[] args)
  {
    StartFrame application = new StartFrame();
    application.show();
  }

  
  
}  //  @jve:decl-index=0:visual-constraint="10,10"
