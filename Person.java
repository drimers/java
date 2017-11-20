package test1;



import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Person extends JPanel {


//	// ----------------------------------------------------------------------------------

	JComboBox<String> typeModel = new JComboBox<String>();
	// -----------------------------------
	JLabel textFName = new JLabel("Въведете Име : ");
	JLabel textLName = new JLabel("Въведете Фамилия : ");
	JLabel textAge = new JLabel("Въведете Години : ");
	JLabel textSex = new JLabel("Въведете Пол : ");
	JLabel textCity = new JLabel("Въведете Град : ");

	// ----------------------------------------------------------
	JPanel headerPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel midPanel2 = new JPanel();
	JPanel footerPanel = new JPanel();
	// -----------------------------------------------------------------
	JTextField textFieldFName = new JTextField();
	JTextField textFieldLName = new JTextField();
	JTextField DoubleFieldAge = new JTextField();
	JTextField textFieldSex = new JTextField();
	JTextField textFieldCity = new JTextField();
	// -------------------------------------------
	JButton addButton = new JButton("Add to table");
	JButton surchButton = new JButton("Surch in table");
	JButton deleteButton = new JButton("Delete From table");
	JButton updateButton = new JButton("Update");

	// ----------------------------------------------
	public Person() {
		// add to Frame
		this.setVisible(true);
		this.setSize(900, 900);
		this.setLayout(new GridLayout(4, 1));
		this.add(headerPanel);
		this.add(midPanel);
		this.add(midPanel2);
		this.add(footerPanel);

		// headerPanel
		headerPanel.setLayout(new GridLayout(5, 2));

		headerPanel.add(textFName);
		headerPanel.add(textFieldFName);
		headerPanel.add(textLName);
		headerPanel.add(textFieldLName);
		headerPanel.add(textAge);
		headerPanel.add(DoubleFieldAge);
		headerPanel.add(textSex);
		headerPanel.add(textFieldSex);
		headerPanel.add(textCity);
		headerPanel.add(textFieldCity);
		
		// midPanel
		// midLanel1
		midPanel.setLayout(new GridLayout(3, 2));
		midPanel.add(addButton);
		addButton.addActionListener(new addToTable());// ne raboti insert -a vika metod addToTalbe
		midPanel.add(updateButton);
		updateButton.addActionListener(new updateTable());
	}



	// ----------------------------------------------------------------

	public class addToTable implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Connection conn = DBConnector.createConn();
			PreparedStatement state = null;
			String inputtextFName = textFieldFName.getText();
			String inputtextLName = textFieldLName.getText();
			Double inputDoubleAge = Double.parseDouble(DoubleFieldAge.getText());
			String inputtextSex = textFieldSex.getText();
			String inputtextField = textFieldCity.getText();
			
			
			String sql = "insert into PERSON(FNAME,LNAME,age,sex,CITY) VALUES(?,?,?,?,?)";
			
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, inputtextFName);
				state.setString(2, inputtextLName);
				state.setDouble(3, inputDoubleAge);
				state.setString(4, inputtextSex);
				state.setString(5, inputtextField);
				
				state.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				try {
					state.close();
					conn.close();

				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		}
	}
	
	public class updateTable implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Connection conn = DBConnector.createConn();
			PreparedStatement state = null;
			String inputtextFName = textFieldFName.getText();
			String inputtextLName = textFieldLName.getText();
			Double inputDoubleAge = Double.parseDouble(DoubleFieldAge.getText());
			String inputtextSex = textFieldSex.getText();
			String inputtextField = textFieldCity.getText();
			
			
			String sql = "update PERSON set(FNAME,LNAME,age,sex,CITY)=(?,?,?,?,?) where FNAME=(?)";
			
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, inputtextFName);
				state.setString(2, inputtextLName);
				state.setDouble(3, inputDoubleAge);
				state.setString(4, inputtextSex);
				state.setString(5, inputtextField);
				state.setString(6, inputtextFName);
				
				state.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				try {
					state.close();
					conn.close();

				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		}
	}
	
}

