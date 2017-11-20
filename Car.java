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

public class Car extends JPanel {

	String selectType = " "; // ��� ����,�����,�����
	// --------------------------------------------------------------
	String[] comboType = { "", "����", "�����", "�����", "������", "������", "����" };
	JComboBox<String> typeCombo = new JComboBox<String>(comboType);
	// ----------------------------------------------------------------------------
	String selectMarka = " "; // ����� ����,�����,����
	// --------------------------------------------------------------------
	String[] comboMarka = { "", "����", "���", "�����", "����" }; // ����� �
																	// �����
	JComboBox<String> typeMarka = new JComboBox<String>(comboMarka);
	// ------------------------------------------------------------------------
	String selectModel = " "; // ����� �����,������,�7
	// --------------------------------------------------------------------------
	String[] comboAudi = { "", "�3", "�4", "�7", "��", "Q7" }; // ����� � ������
																// �� ����
	JComboBox<String> typeAudi = new JComboBox<String>(comboAudi);
	// ------------------------------------------------------------------------------
	String[] comboBMW = { "", "M3", "M5", "X5", "X3" }; // ����� � ������ �� ���
	JComboBox<String> typeBMW = new JComboBox<String>(comboBMW);
	// ------------------------------------------------------------------------------
	String[] comboHonda = { "", "�����", "�����", "������", "S2000" }; // �����
																		// �
																		// ������
																		// ��
																		// �����
	JComboBox<String> typeHonda = new JComboBox<String>(comboHonda);
	// -------------------------------------------------------------------------------
	String[] comboOpel = { "", "�����", "�����", "�����", }; // ����� � ������
																// �� ����
	JComboBox<String> typeOpel = new JComboBox<String>(comboOpel);
	// ----------------------------------------------------------------------------------

	JComboBox<String> typeModel = new JComboBox<String>();
	// -----------------------------------
	JLabel textType = new JLabel("������ ���� : ");
	JLabel textMarka = new JLabel("������ ����� : ");
	JLabel textModel = new JLabel("������ ����� : ");
	JLabel textCena = new JLabel("�������� ���� : ");

	// ----------------------------------------------------------
	JPanel headerPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel midPanel2 = new JPanel();
	JPanel footerPanel = new JPanel();
	// -----------------------------------------------------------------
	JTextField DoubleField = new JTextField();
	// -------------------------------------------
	JButton addButton = new JButton("Add to table");
	JButton surchButton = new JButton("Surch in table");
	JButton deleteButton = new JButton("Delete From table");
	JButton updateButton = new JButton("Update");

	// ----------------------------------------------
	public Car() {
		// add to Frame
		this.setVisible(true);
		this.setSize(700, 900);
		this.setLayout(new GridLayout(4, 1));
		this.add(headerPanel);
		this.add(midPanel);
		this.add(midPanel2);
		this.add(footerPanel);

		// headerPanel
		headerPanel.setLayout(new GridLayout(4, 2));
		headerPanel.add(textType);
		headerPanel.add(typeCombo);
		typeCombo.addActionListener(new SelectType());
		headerPanel.add(textMarka);
		headerPanel.add(typeMarka);
		typeMarka.addActionListener(new SelectMarka());
		headerPanel.add(textModel);
		headerPanel.add(typeBMW);
		typeOpel.addActionListener(new SelectModel());
		headerPanel.add(textCena);
		headerPanel.add(DoubleField);
		// midPanel
		// midLanel1
		midPanel.setLayout(new GridLayout(3, 2));
		midPanel.add(addButton);
		addButton.addActionListener(new addToTable());// ne raboti insert -a vika metod addToTalbe
		midPanel.add(updateButton);
		updateButton.addActionListener(new updateTable());
	}

	class SelectType implements ActionListener { // "����", "�����",
													// "�����","������","������","����"

		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedItem = (String) typeCombo.getSelectedItem();

			switch (selectedItem) {
			case "����":
				selectType = "����";
				break;
			case "�����	":
				selectType = "�����";
				break;
			case "�����":
				selectType = "�����";
				break;
			case "������":
				selectType = "������";
				break;
			case "������":
				selectType = "������";
				break;
			case "����":
				selectType = "����";
				break;

			}// end switch
		}
	}// end SelectType
		// ---------------------------------------------------

	class SelectMarka implements ActionListener { // sets Selected type to car
													// type before adding in
													// table 1

		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedItem = (String) typeMarka.getSelectedItem();

			switch (selectedItem) {

			case "����":
				selectMarka = "����";
				break;
			case "���":
				selectMarka = "���";
				break;
			case "�����":
				selectMarka = "�����";
				break;
			case "����":
				selectMarka = "����";
				break;

			}// end switch
		}
	}// end SelectMarka
		// -----------------------------------------------------------------------

	class SelectModel implements ActionListener { // sets Selected type to car
													// type before adding in
													// table 1

		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedItem = (String) typeModel.getSelectedItem();

			if (selectedItem == null)
			
				;

		}// actionPerform

	} // end class SelectModel

	// ----------------------------------------------------------------

	public class addToTable implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Connection conn = DBConnector.createConn();
			PreparedStatement state = null;
			Double inputDoubleField = Double.parseDouble(DoubleField.getText());
			//String sql = "insert into cars set CARS_ID='2'";
			String sql = "insert into CARS(TYPE,MARKA,MODEL,CENA) VALUES(?,?,?,?)";
			//String sql = "insert into CARS " + " set VALUES(null,?,?,?,?)";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, selectType);
				state.setString(2, selectMarka);
				state.setString(3, selectModel);
				state.setDouble(4, inputDoubleField);
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
			Double inputDoubleField = Double.parseDouble(DoubleField.getText());
			//String sql = "insert into cars set CARS_ID='2'";
			String sql = "update CARS set(TYPE,MARKA,MODEL,CENA)=(?,?,?,?) where TYPE=(?)";
			//String sql = "insert into CARS " + " set VALUES(null,?,?,?,?)";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, selectType);
				state.setString(2, selectMarka);
				state.setString(3, selectModel);
				state.setDouble(4, inputDoubleField);
				state.setString(5, selectType);
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

// public class updateTable implements ActionListener {
//
// @Override
// public void actionPerformed(ActionEvent e) {
//
//
// Connection conn = DBConnector.createConn();
// PreparedStatement state = null;
// Double inputDoubleField = Double.parseDouble(DoubleField.getText());
// String sql = "update into cars values(null,?,?,?,?)";
// try {
// state = conn.prepareStatement(sql);
// state.setString(1, selectType);
// state.setString(2, selectMarka);
// state.setString(3, selectModel);
// state.setDouble(4, inputDoubleField);
// state.execute();
// } catch (SQLException e1) {
// e1.printStackTrace();
// } finally {
// try {
// state.close();
// conn.close();
//
// } catch (SQLException e2) {
// e2.printStackTrace();
// }
// }
//
// }}}
//
