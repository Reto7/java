package MiniPersonenVerwaltung.applikation;

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import MiniPersonenVerwaltung.datenModell.Person;

public class PersonBearbeitenDialog extends JDialog
{
	private Person person;
	
	private JPanel jContentPane = null;
	private JPanel southPanel = null;
	private JButton btOk = null;
	private JButton btAbbruch = null;
	private JPanel centerPanel = null;
	private JLabel lbOid = null;
	private JTextField efOid = null;
	private JLabel lbName = null;
	private JTextField efName = null;
	private JLabel lbGeburt = null;
	private JTextField efGeburt = null;
	private JLabel lbGehalt = null;
	private JTextField efGehalt = null;

	/**
	 * This is the default constructor
	 */
	public PersonBearbeitenDialog()
	{
		this(null, "", false);
	}

	
	public PersonBearbeitenDialog(Frame frame, String title, boolean modal)
	  {
	    // Frame ist das "Parent"-Objekt
	    super(frame, title, modal);
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
		this.setTitle("Person bearbeiten");
		this.setLocation(200, 200);
		this.setContentPane(getJContentPane());
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
			jContentPane.add(getCenterPanel(), java.awt.BorderLayout.CENTER);
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
			southPanel = new JPanel();
			southPanel.setBackground(java.awt.Color.orange);
			southPanel.add(getBtOk(), null);
			southPanel.add(getBtAbbruch(), null);
		}
		return southPanel;
	}

	/**
	 * This method initializes btOk	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBtOk() {
		if (btOk == null) {
			btOk = new JButton();
			btOk.setText("Ok");
			btOk.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					ok();
				}
			});
			btOk.setPreferredSize(new java.awt.Dimension(100,25));
		}
		return btOk;
	}

	/**
	 * This method initializes btAbbruch	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBtAbbruch() {
		if (btAbbruch == null) {
			btAbbruch = new JButton();
			btAbbruch.setText("Abbruch");
			btAbbruch.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					abbruch();
				}
			});
			btAbbruch.setPreferredSize(new java.awt.Dimension(100,25));
		}
		return btAbbruch;
	}

	/**
	 * This method initializes centerPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getCenterPanel() {
		if (centerPanel == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints31.gridy = 3;
			gridBagConstraints31.weightx = 0.0D;
			gridBagConstraints31.insets = new java.awt.Insets(5,5,5,5);
			gridBagConstraints31.gridx = 1;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.gridy = 3;
			lbGehalt = new JLabel();
			lbGehalt.setText("Gehalt");
			lbGehalt.setPreferredSize(new java.awt.Dimension(100,25));
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.gridy = 2;
			gridBagConstraints11.weightx = 0.0D;
			gridBagConstraints11.insets = new java.awt.Insets(5,5,5,5);
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 2;
			lbGeburt = new JLabel();
			lbGeburt.setText("Geburt");
			lbGeburt.setPreferredSize(new java.awt.Dimension(100,25));
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 0.0D;
			gridBagConstraints3.gridheight = 1;
			gridBagConstraints3.gridwidth = 1;
			gridBagConstraints3.insets = new java.awt.Insets(5,5,5,5);
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 1;
			lbName = new JLabel();
			lbName.setText("Name");
			lbName.setPreferredSize(new java.awt.Dimension(100,25));
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 0.0D;
			gridBagConstraints1.insets = new java.awt.Insets(5,5,5,5);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			lbOid = new JLabel();
			lbOid.setText("OID:");
			lbOid.setPreferredSize(new java.awt.Dimension(100,25));
			centerPanel = new JPanel();
			centerPanel.setLayout(new GridBagLayout());
			centerPanel.add(lbOid, gridBagConstraints);
			centerPanel.add(getEfOid(), gridBagConstraints1);
			centerPanel.add(lbName, gridBagConstraints2);
			centerPanel.add(getEfName(), gridBagConstraints3);
			centerPanel.add(lbGeburt, gridBagConstraints4);
			centerPanel.add(getEfGeburt1(), gridBagConstraints11);
			centerPanel.add(lbGehalt, gridBagConstraints21);
			centerPanel.add(getEfGehalt(), gridBagConstraints31);
		}
		return centerPanel;
	}

	/**
	 * This method initializes efOid	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getEfOid() {
		if (efOid == null) {
			efOid = new JTextField();
			efOid.setPreferredSize(new java.awt.Dimension(200,25));
			efOid.setEditable(false);
			efOid.setEnabled(false);
		}
		return efOid;
	}

	/**
	 * This method initializes efName	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getEfName() {
		if (efName == null) {
			efName = new JTextField();
			efName.setPreferredSize(new java.awt.Dimension(200,25));
		}
		return efName;
	}

	/**
	 * This method initializes efGeburt1	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getEfGeburt1() {
		if (efGeburt == null) {
			efGeburt = new JTextField();
			efGeburt.setPreferredSize(new java.awt.Dimension(200,25));
		}
		return efGeburt;
	}

	/**
	 * This method initializes efGehalt	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getEfGehalt() {
		if (efGehalt == null) {
			efGehalt = new JTextField();
			efGehalt.setPreferredSize(new java.awt.Dimension(200,25));
		}
		return efGehalt;
	}
	/*
	 * User definierte Operationen
	 */

	public Person getPerson()
	{
		return this.person;
	}

	public void setPerson(Person pPerson)
	{
	    // Parameter pPerson in Instanz-Variable person abspeichern
	    this.person = pPerson;

	    // Attribute der Person auf Bildschirm anzeigen

	    if (this.person.getOid() instanceof Integer)
	    {
	    	this.efOid.setText("" + this.person.getOid());
	    }
	    if (this.person.getName() instanceof String)
	    {
	    	this.efName.setText(this.person.getName());
	    }
	    if (this.person.getGeburt() instanceof Integer)
	    {
	        this.efGeburt.setText("" + this.person.getGeburt());
	    }
	    if (this.person.getGehalt() instanceof Double)
	    {
	    	this.efGehalt.setText("" + this.person.getGehalt());
	    }
	}

	private void ok()
	{
	    String tString;
	    Integer tInteger;
	    Double tDouble;

	    // Person aktualisieren
	    tString = this.efName.getText();
	    
	    if (tString.length()>0)
	    {
	    	this.person.setName(tString);
	    }

	    try
	    {
	    	tString = this.efGeburt.getText();

	    	if (tString.length()>0)
		    {
	    		tInteger = new Integer(tString);
	    		this.person.setGeburt(tInteger);
		    }
		    
	    	tString = this.efGehalt.getText();
		    if (tString.length()>0)
		    {
		    	tDouble = new Double(tString);
		    	this.person.setGehalt(tDouble);
		    }
		    
		    // Person in Datenbank ablegen
		    this.person.save();

		    // listeFuellen im PersonenListeFrame (parent-Objekt)
		    // getParent() liefert Container-Objekt --> Cast-Operator fuer PersonenListeFrame
		    // ((PersonenListeFrame)this.getParent()).listeFuellen();

		    this.dispose();
		}
		catch (Exception pException)
		{
			   pException.printStackTrace();
			   JOptionPane.showMessageDialog(this,"Allgemeiner Fehler bei der Eingabe\n" + pException);
		}
	}

	// -----------------------------------------------------------------
	private void abbruch()
	{
	    this.dispose();

	}
	
}
