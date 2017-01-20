package test1;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
		
	JTabbedPane tab =new JTabbedPane(); //създаване на меню бар(таб)
	
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
		this.setTitle("Desislav&BobbyKurdov&Ангел");  //заглажие на прозореца
		this.setVisible(true);  //правим го видим
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);   //спирасе процеса на работа при затваряне на прозореца
		this.setSize(1024, 768); //задаваме му размери по подразбиране
		this.setLayout(new GridLayout(3, 1)); //разделяме си прозореца на 3-ри линии
		this.setResizable(false);  //правим да не може да се променя размера на прозореца
		this.add(tab);  //добавяме таба
		
		//-----------------------------------------------
		tab.setBounds(new Rectangle(0, 0, 500, 500));//размери на таба
		
		tab.add(p1, "Изри  Коли");
		tab.add(p2, "Избери Яхта");
		tab.add(p3, "Въведи Собственик");
		
		p1.add(tab1);
		//p2.add(tab2);
		//p3.add(tab3);
		
	}//end init    -------------------------------------------------------------------------------------------------
	
	
	
	
}//end MainFrame
