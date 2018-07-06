package outlook;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
 

@SuppressWarnings("serial")
public class FrameSam extends Frame implements ActionListener
{
	String msg;
	Frame f;
	Graphics g;
	Label l1, l2, l3, l4, l5, l6;
	Button b1, b2, b3, b4, b5;
	CheckboxGroup cbg;
	Checkbox c1, c2, c3, c4, c5;
	Choice city;
	TextField t1, t2, t3;
	Scrollbar sb;
	TextArea tf;
	//GridLayout = new GridLayout(7,3);
	
	FrameSam()
{
		 
		f=new Frame("Registration Form");
		f.setBackground(Color.pink);
		f.setForeground(Color.black);
		f.addWindowListener(new myWindowAdapter());
		f.setLayout(new FlowLayout());
		f.setSize(800, 600);
		f.setVisible(true);
		//f.setBackground(Color.magenta);
		
		//sb=new Scrollbar();
		//sb.setOrientation(Scrollbar.VERTICAL);
		l1=new Label("Student Name", Label.LEFT);
		l1.setBounds(25,65,90,20);
		t1=new TextField(10);
		//t1.setSize(1, 1);
		t1.setBounds(120,65,90,20);;
		f.add(l1);
		f.add(t1);
		
		
		l2=new Label("RollNo", Label.LEFT);
		t2=new TextField(10);
		l2.setBounds(25,105,90,20);
		t2.setBounds(120,105,90,20);
		
		f.add(l2);
		f.add(t2);
		 
		
		l3=new Label("Age", Label.LEFT);
		l3.setBounds(25,145,90,20);
		t3=new TextField(10);
		t3.setSize(2,3);
		t3.setBounds(120,145,90,20);
		cbg=new CheckboxGroup();
		c1=new Checkbox("Male", cbg, true);
		c2=new Checkbox("Female", cbg, false);
		c1.setBounds(250,145,50,20);
		c2.setBounds(320,145,70,20);
		f.add(l3);
		f.add(t3);
		f.add(c1);
		f.add(c2);
		
		 
		l4=new Label("Area of Interest", Label.LEFT);
		l4.setBounds(25,210,90,20);
		cbg=new CheckboxGroup();
		c3=new Checkbox("Algo", null, false);
		c4=new Checkbox("Design", null, false);
		c5=new Checkbox("Analyst", null, false);
		c3.setBounds(120,210,50,20);
		c4.setBounds(180,210,60,20);
		c5.setBounds(260,210,60,20);
		
		//c5.setSize(2, 3);
		//c3.setSize(2, 3);
		f.add(l4);
		f.add(c3);
		f.add(c4);
		f.add(c5);
		
		
		
		l5=new Label("Discussion", Label.LEFT);
		l5.setBounds(25,280,90,20);
		tf=new TextArea(10,30);
		tf.setBounds(120,280,60,40);
		f.add(l5);
		f.add(tf);
		
		l6=new Label("Department", Label.LEFT);
		l6.setBounds(25,370,90,20);
		city=new Choice();
		city.setBounds(120, 370, 60, 30);
		city.add("IT");
		city.add("CSE");
		city.add("EEE");
		city.add("ECE");
		f.add(l6);
		f.add(city);
	
		b1=new Button("Submit");
		b1.setBounds(25, 450, 70, 40);
		f.add(b1);
		b1.addActionListener(this);
		//f.add(b1);
		
		b2=new Button("Search");
		b2.setBounds(105, 450, 70, 40);
		f.add(b2);
		b2.addActionListener(this);
		
		b3=new Button("Clear");
		b3.setBounds(195, 450, 70, 40);
		f.add(b3);
		b3.addActionListener(this);

	
		b4=new Button("Update");
		b4.setBounds(285, 450, 70, 40);
		f.add(b4);
		b4.addActionListener(this);
		
		b5=new Button("Delete");
		b5.setBounds(365, 450, 70, 40);
		f.add(b5);
		b5.addActionListener(this);
}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
			
		
		String value1=t1.getText();
		//System.out.println(value1);
		String value2=t2.getText(); 
		String ag=t3.getText();
		String ma, mice;
		Connection con = null; 
		String driver = "com.mysql.jdbc.Driver"; 
		String student=""; 
		String roll="";
		String des="";
		String dest="";
		String desti="";
		String destin="";
		String destina="";
		 
		try
		{ 
		Class.forName(driver); 
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deform", "root", "Aarthi@1one"); 
		Statement st = con.createStatement(); 
		//Resultset rs=null;
		if (e.getSource()==b1) 
		{ 
			if(c1.getState()==true)
			{ma=c1.getLabel();}
			else
			{	ma=c2.getLabel();
			}
			if(c3.getState()==true)	
			{
				mice=c3.getLabel();
			}
			else if(c4.getState()==true)
			{
				mice=c4.getLabel();
			}
			else
			{
				mice=c5.getLabel();
			}
			String d=city.getSelectedItem();
			String ero=tf.getText();
		String s="insert into stud(stname, stroll, age, sex, Areas, dept, Discussed) values('" + value1 + "' , '" + value2 + "' , '" + ag + "', '" + ma + "', '" + mice + "', '" + d + "', '" + ero + "')";
		st.executeUpdate(s);
		msg="Student details saved!";
		//g.drawString(msg, 50, 20);
		System.out.println(msg);
		
		
		//ResultSet res = st.executeQuery("SELECT * from stud");
		
		}
		
		if (e.getSource()==b2) 
		{ 
			
			String value6=t2.getText(); 
		String s="SELECT * from stud where stroll='" +value6 +"'";
		ResultSet res=st.executeQuery(s);
		while (res.next()) { 
			student = res.getString("stname"); 
			roll = res.getString("stroll");
			des= res.getString("age");
			dest= res.getString("sex");
			desti= res.getString("Areas");
			destin= res.getString("dept");
			destina=res.getString("Discussed");
			} 
		//msg=("Student details Retrieved!" +student + "" +roll);
		//g.drawString(msg, 10, 20);
		System.out.println(roll + " " +student + "" + des + "" + dest + "" + desti + "" + destin + "" + destina + "" );
		 t1.setText(student);
		 t2.setText(roll);
		 t3.setText(des);
		 tf.setText(destina);
		 if(c1.getLabel().equals(dest))
		 {
			 c1.setState(true);
		 }
		 else
		 {
			 c2.setState(true);
		 }
		 
		 if(c3.getLabel()==desti)
		 {
			 c3.setState(true);
		 }
		 else if(c4.getLabel()==desti)
		 {
			 c4.setState(true);
			 
		 }
		 else
		 {
		 c5.setState(true);
		 }
		 if(city.getSelectedItem()==destin)
		 {
			 city.select(destin);
		 }
		}
		
		if (e.getSource()==b3) 
		{ 
			
			t1.setText("");
			t2.setText("");
			t3.setText("");
			tf.setText("");
			
			msg="Entered details are Cleared!";
		}
		
		
		if (e.getSource()==b4) 
		{ 
			String value4=t1.getText();
			//System.out.println(value1);
			String value3=t2.getText(); 
			String s="update stud set stname= '" + value4 + "' where stroll= '" + value3 +"'";
			st.executeUpdate(s);
			msg="Student details are updated!";
		}
		
		if (e.getSource()==b5) 
		{ 
			
		String s = ("delete  from stud where stroll = '" + value2 + "'");
		st.executeUpdate(s);
		msg="Details Deleted";
		System.out.println("The Details are cleared");
		//g.drawString(msg, 10, 20);
		}
		
		
		
		
		
		}
		catch(Exception s)
		{ 
		System.out.println(s); 
		} 
	}
	

	
	  
	
	public static void main(String args[])
	{
	FrameSam f1= new FrameSam();
	}
	
	
}

