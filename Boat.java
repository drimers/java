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


	public class Boat extends JPanel {


//		// ----------------------------------------------------------------------------------

		JComboBox<String> typeModel = new JComboBox<String>();
		// -----------------------------------
		JLabel textMarka = new JLabel("Въведете Марка : ");
		JLabel textModel = new JLabel("Въведете Модел : ");
		JLabel textAge = new JLabel("Въведете Година : ");
	

		// ----------------------------------------------------------
		JPanel headerPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel midPanel2 = new JPanel();
		JPanel footerPanel = new JPanel();
		// -----------------------------------------------------------------
		JTextField textFieldMarka = new JTextField();
		JTextField textFieldModel = new JTextField();
		JTextField DoubleFieldAge = new JTextField();
	
		// -------------------------------------------
		JButton addButton = new JButton("Add to table");
		JButton surchButton = new JButton("Surch in table");
		JButton deleteButton = new JButton("Delete From table");
		JButton updateButton = new JButton("Update");

		// ----------------------------------------------
		public Boat() {
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

			headerPanel.add(textMarka);
			headerPanel.add(textFieldMarka);
			headerPanel.add(textModel);
			headerPanel.add(textFieldModel);
			headerPanel.add(textAge);
			headerPanel.add(DoubleFieldAge);
		
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
				String inputtextMarka = textFieldMarka.getText();
				String inputtextModel = textFieldModel.getText();
				Double inputDoubleAge = Double.parseDouble(DoubleFieldAge.getText());
						
				String sql = "insert into BOAT(MARKA,MODEL,YEAR) VALUES(?,?,?)";
				
				try {
					state = conn.prepareStatement(sql);
					state.setString(1, inputtextMarka);
					state.setString(2, inputtextModel);
					state.setDouble(3, inputDoubleAge);
			
					
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
				String inputtextMarka = textFieldMarka.getText();
				String inputtextModel = textFieldModel.getText();
				Double inputDoubleAge = Double.parseDouble(DoubleFieldAge.getText());
						
				String sql = "update BOAT set(MARKA,MODEL,YEAR)=(?,?,?) where MARKA=(?)";
				
				try {
					state = conn.prepareStatement(sql);
					state.setString(1, inputtextMarka);
					state.setString(2, inputtextModel);
					state.setDouble(3, inputDoubleAge);
					state.setString(4, inputtextMarka);
			
					
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



