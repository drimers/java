package test1;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
		
	JTabbedPane tab =new JTabbedPane(); //��������� �� ���� ���(���)
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	Car tab1 =new Car();
	//Boat tab2=new Boat();
	//Person tab3=new Person();

	//------------------------------------------------------------------------------------------------------------------
	public MainFrame(){
		init();
		//fillModelCombo();
		//this.pack();
	}//end MainFrame	------------------------------------------------------------------------------------------------------------------
	public void init(){
		this.setTitle("Desislav&BobbyKurdov&�����");  //�������� �� ���������
		this.setVisible(true);  //������ �� �����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);   //������� ������� �� ������ ��� ��������� �� ���������
		this.setSize(1024, 768); //�������� �� ������� �� ������������
		this.setLayout(new GridLayout(3, 1)); //��������� �� ��������� �� 3-�� �����
		this.setResizable(false);  //������ �� �� ���� �� �� ������� ������� �� ���������
		this.add(tab);  //�������� ����
		
		//-----------------------------------------------
		tab.setBounds(new Rectangle(0, 0, 500, 500));//������� �� ����
		
		tab.add(p1, "����  ����");
		tab.add(p2, "������ ����");
		tab.add(p3, "������ ����������");
		
		p1.add(tab1);
		//p2.add(tab2);
		//p3.add(tab3);
		
	}//end init    -------------------------------------------------------------------------------------------------
	
	
	
	
}//end MainFrame
