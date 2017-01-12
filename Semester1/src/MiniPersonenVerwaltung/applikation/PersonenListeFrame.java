package MiniPersonenVerwaltung.applikation;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.Collection;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import MiniPersonenVerwaltung.datenModell.Person;
import javax.swing.JList;

public class PersonenListeFrame extends JFrame
{
	private JPanel jContentPane = null;
	private JPanel southPanel = null;
	private JPanel eastPanel = null;
	private JButton btNeu = null;
	private JButton btAendern = null;
	private JButton btLoeschen = null;
	private JButton btUebernehmen = null;
	private JButton btEnde = null;
	private JTextField efSuchName = null;
	private JLabel lbSuchname = null;
	private JButton btSuchen = null;
	private JScrollPane jScrollPane = null;
	private JScrollPane listPane = null;
	private JList liste = null;
	private JButton btListeLeeren = null;

	/**
	 * This is the default constructor
	 */
	public PersonenListeFrame()
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
		this.setSize(400, 300);
		this.addWindowListener(new java.awt.event.WindowAdapter() { 
			public void windowActivated(java.awt.event.WindowEvent e) {    
				listeFuellen();
			}
		});
		this.setLocation(200, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Personen-Liste");
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
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.WEST);
			jContentPane.add(getListPane(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes southPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getSouthPanel() {
		if (southPanel == null) {
			lbSuchname = new JLabel();
			lbSuchname.setText("Such-Name: ");
			efSuchName = new JTextField();
			efSuchName.setText("");
			efSuchName.setBackground(java.awt.Color.white);
			efSuchName.setPreferredSize(new java.awt.Dimension(100,20));
			southPanel = new JPanel();
			southPanel.setBackground(java.awt.Color.yellow);
			southPanel.add(lbSuchname, null);
			southPanel.add(efSuchName, null);
			southPanel.add(getBtSuchen(), null);
			southPanel.add(getBtListeLeeren(), null);
		}
		return southPanel;
	}

	/**
	 * This method initializes eastPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getEastPanel() {
		if (eastPanel == null) 
		{
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.insets = new java.awt.Insets(10,5,5,5);
			gridBagConstraints4.gridy = 4;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.insets = new java.awt.Insets(20,5,5,5);
			gridBagConstraints3.gridy = 3;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new java.awt.Insets(5,5,5,5);
			gridBagConstraints2.gridy = 2;
			gridBagConstraints2.ipadx = 0;
			gridBagConstraints2.ipady = 0;
			gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.ipady = 0;
			gridBagConstraints1.insets = new java.awt.Insets(5,5,5,5);
			gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.ipady = 0;
			gridBagConstraints.insets = new java.awt.Insets(5,5,5,5);
			gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridy = 0;
			eastPanel = new JPanel();
			eastPanel.setPreferredSize(new java.awt.Dimension(120,0));
			eastPanel.setLayout(new GridBagLayout());
			eastPanel.setBackground(java.awt.Color.orange);
			eastPanel.add(getBtNeu(), gridBagConstraints);
			eastPanel.add(getBtAendern(), gridBagConstraints1);
			eastPanel.add(getBtLoeschen(), gridBagConstraints2);
			eastPanel.add(getBtUebernehmen(), gridBagConstraints3);
			eastPanel.add(getBtEnde(), gridBagConstraints4);
		}
		return eastPanel;
	}

	/**
	 * This method initializes btnNeu	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBtNeu() {
		if (btNeu == null) {
			btNeu = new JButton();
			btNeu.setName("btNeu");
			btNeu.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					neu();
				}
			});
			btNeu.setText("Neu");
		}
		return btNeu;
	}

	/**
	 * This method initializes Aendern	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBtAendern() {
		if (btAendern == null) {
			btAendern = new JButton();
			btAendern.setText("Aendern");
			btAendern.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					aendern();
				}
			});
		}
		return btAendern;
	}

	/**
	 * This method initializes btLoeschen	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBtLoeschen() {
		if (btLoeschen == null) {
			btLoeschen = new JButton();
			btLoeschen.setText("Loeschen");
			btLoeschen.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					loeschen();
				}
			});
			btLoeschen.setName("btLoeschen");
		}
		return btLoeschen;
	}

	/**
	 * This method initializes btUebernehmen	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBtUebernehmen() {
		if (btUebernehmen == null) {
			btUebernehmen = new JButton();
			btUebernehmen.setText("Uebernehmen");
			btUebernehmen.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					uebernehmen();
				}
			});
		}
		return btUebernehmen;
	}

	/**
	 * This method initializes btEnde	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBtEnde() {
		if (btEnde == null) {
			btEnde = new JButton();
			btEnde.setText("Ende");
			btEnde.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					ende();
				}
			});
		}
		return btEnde;
	}

	/**
	 * This method initializes btSuchen	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBtSuchen() {
		if (btSuchen == null) {
			btSuchen = new JButton();
			btSuchen.setText("Suchen");
			btSuchen.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					suchen();
				}
			});
			btSuchen.setPreferredSize(new java.awt.Dimension(77,20));
		}
		return btSuchen;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
		}
		return jScrollPane;
	}

	/**
	 * This method initializes listPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getListPane() {
		if (listPane == null) {
			listPane = new JScrollPane();
			listPane.setBackground(java.awt.SystemColor.inactiveCaptionText);
			listPane.setViewportView(getListe());
			listPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return listPane;
	}

	/**
	 * This method initializes liste	
	 * 	
	 * @return javax.swing.JList	
	 */    
	private JList getListe() {
		if (liste == null) {
			liste = new JList();
		}
		return liste;
	}
	

	/**
	 * This method initializes btListeLeeren	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBtListeLeeren() {
		if (btListeLeeren == null) {
			btListeLeeren = new JButton();
			btListeLeeren.setText("Liste leeren");
			btListeLeeren.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					listeLeeren();
				}
			});
			btListeLeeren.setPreferredSize(new java.awt.Dimension(101,20));
		}
		return btListeLeeren;
	}
	
	
	/*
	 * Event Methoden
	 */
	private void neu()
	{
	    // Neues Personen-Objekt anlegen und bearbeiten
	    Person tPerson = new Person();
	    // Dialog-Box als Child des aktuellen Frame-Objektes instanzieren
	    PersonBearbeitenDialog tDialog = new PersonBearbeitenDialog(this, "Neue Person bearbeiten", false);

	    // Person an Dailog-Box uebergeben
	    tDialog.setPerson(tPerson);

	    // Dialog-Box anzeigen
	    tDialog.setVisible(true);

	}

	//***********************************************************
	private void aendern()
	{
	    // Vorhandenes Personen-Objekt bearbeiten
	    int tInt;
	    tInt = this.liste.getSelectedIndex();

	    // selected Index -1,  bedeutet keine Selektion --> Index >= 0 ist ok
	    if (tInt >=0)
	    {
	      Person tPerson;
	      tPerson = (Person)this.liste.getModel().getElementAt(tInt);

	      // Dialog-Box als Child des aktuellen Frame-Objektes instanzieren
	      PersonBearbeitenDialog tDialog = new PersonBearbeitenDialog(this,
	          "Vorhandene Person bearbeiten", false);

	      // Person an Dailog-Box uebergeben
	      tDialog.setPerson(tPerson);

	      // Dialog-Box anzeigen
	      tDialog.setVisible(true);
	    }
	    else
	    {
	      JOptionPane.showMessageDialog(this,"Keine Selektion!");
	    }
		
	}

	//***********************************************************
	private void loeschen()
	{
	    // Vorhandenes Personen-Objekt bearbeiten
	    int tInt;
	    tInt = this.liste.getSelectedIndex();
	    if (tInt >= 0)
	    {
	      Person tPerson;
	      tPerson = (Person)this.liste.getModel().getElementAt(tInt);

	      tPerson.delete();
	      this.listeFuellen();
	    }
	    else
	    {
	      JOptionPane.showMessageDialog(this, "Keine Selektion!");
	    }
	}
	
	//***********************************************************
	private void uebernehmen()
	{
	}

	//***********************************************************
	private void ende()
	{
		System.exit(0);
	}

	//***********************************************************
	private void suchen()
	{
		this.listeFuellen();
	}

	//***********************************************************
	private void listeFuellen()
	{
 	   // Personen-Objekte suchen. Gefundene Objekte in "liste" anzeigen

	    // Personen-Objekt zum Suchen anlegen
	    Person tPerson = new Person();
	    
	    //	  Suchkriterien ins Personen-Objekt eintragen
	    String tString = this.efSuchName.getText();
	    
	    if (tString.length() > 0)
	    {
	    	tPerson.setName(tString);
	    }
	    
	    // Ergebnis-Vector anlegen und suchen
	    Collection<Person> tCollection = tPerson.search();

	    // ListModel anlegen und mit "liste" verbinden
	    DefaultListModel tModel = new DefaultListModel();
	    this.liste.setModel(tModel);
	    /*
	     * Zur Uebertragung der Daten in der Collection in die Liste fehlt eine Operation
	     * Deshalb Collection --> Array --> setListData()
	     */
	    this.liste.setListData(tCollection.toArray());
		
	}

	//***********************************************************
	private void listeLeeren()
	  {
	    // ListModel anlegen und mit "liste" verbinden
	    // Das Modell ist nach dem Instanzieren leer und damit ist die Lste leer
	    DefaultListModel tModel = new DefaultListModel();
	    this.liste.setModel(tModel);


	    // Alternative:
	    //
	    // DefaultListModel tModel = (DefaultListModel)this.liste.getModel();
	    // tModel.removeAllElements();
	  }



}
