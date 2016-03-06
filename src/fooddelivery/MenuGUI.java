package fooddelivery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.*;
        import javax.swing.*;

public class MenuGUI extends JFrame {
    //JLabel sabji[];
                //setTitle("")
                
		String hotel_name;
		JTextField qty[];
		//JLabel pricehalf[];
		JLabel pricefull[];
		JCheckBox cbox[];
		JButton confirm , reset;
		JPanel p[];
                JPanel p1;
		//int custid;
		//JComboBox cb;
                Customer cc; 
                
		
		MenuGUI(Customer c, String name) throws ClassNotFoundException, SQLException{
			//custid = id;
                        
                        System.out.println("Inside Menu GUI");
                        cc = c;
			hotel_name = "Tadka";
                        name = "Tadka";
                        setTitle("" + name+" Menu");
			new JFrame(name);
			int i;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliverysyatem","root","root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Tadka");
                       // System.out.println("Query Executed");
			rs.last();
			i = rs.getRow();
                              GridLayout gl = new GridLayout(i,3);
			System.out.println("No. of rows got:" +i);
			
			//sabji = new JLabel[i];
			qty = new JTextField[i];
                        
			//pricehalf = new JLabel[i];
			pricefull = new JLabel[i];
			cbox = new JCheckBox[i];
			p = new JPanel[i + 1];
                        p1 = new JPanel();
			
			handler h = new handler();
			
			confirm = new JButton("Save");
			//cancel = new JButton("Cancel");
			reset = new JButton("Reset");
			reset.addActionListener(h);
			confirm.addActionListener(h);
			//cancel.addActionListener(h);
			
		
			
			
			rs.beforeFirst();
                        //rs.next();
			int count =0;
			do
			{
                                rs.next();
				//sabji[count] = new JLabel(rs.getString("sabji"));
				//pricehalf[count] = new JLabel(Float.toString(rs.getFloat("half")));
				qty[count] = new JTextField(20);
				//qty[count].setSize(10,10);
                                //qty[count].setVisible(false);
				pricefull[count] = new JLabel(Float.toString(rs.getFloat(2)));
                                //pricefull[count].setSize(100,100);
				cbox[count] = new JCheckBox(rs.getString(1));
                                //cbox[count].setSize(100,100);
                                //System.out.println("Before check Box");
                                JPanel p_count =new JPanel();
				p_count.add(cbox[count]);
				//p1.add(pricehalf[count]);
				p_count.add(pricefull[count]);
				p_count.add(qty[count]);
                                add(p_count);
				//rs.next();
				count++;
                                
				
			}while(count < i && !rs.isLast());
                       // System.out.println("outside while loop");
			p1.add(confirm);
			p1.add(reset);
                        add(p1);
			
			//p[i].add(cancel);
			//add(p[i]);
		
			setLayout(gl);
			setVisible(true);
			setSize(400,600);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		public class handler implements ActionListener {
			
			public void actionPerformed(ActionEvent e){
				String n;
				String menu[][];
				int i = 0,count = 0;
				//Remember to pass customer id
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliverysyatem","root","root");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from " +hotel_name);
					rs.last();
					i = rs.getRow();
					rs.beforeFirst();
				
					if(e.getSource() == confirm)
					{
						int dialogButton = JOptionPane.YES_NO_OPTION;
		                JOptionPane.showConfirmDialog (null, "Would You Like to Confirm your Order?", "",dialogButton);

		                if(dialogButton == JOptionPane.YES_OPTION)
		                {
                                    //System.out.println("yes option selected");
		                	Order o = new Order(cc);
		                	menu = new String[i][4];
		                	
		                	do{
                                            rs.next();
		                	if(cbox[count].isSelected())
		                	{
		                	//qty[count].setVisible(true);
                                            
		                	menu[count][1] = rs.getString(1);
		                	menu[count][3] = qty[count].getText();
		                	menu[count][2] = Float.toString(rs.getFloat(2));
		                	menu[count][0] =cc.rollno;
                                      //  System.out.println(rs.getString(1));
                                       // System.out.println(qty[count].getText());
                                        //System.out.println(Float.toString(rs.getFloat(2)));
                                        //System.out.println(cc.rollno);
                                       // System.out.println(cc.id);
                                        
		                	//rs.next();
		                	}
		                	}while(count<i && !rs.isLast());
                                        
                                        
                                        CustomerManagement cm=new CustomerManagement();
		                	cm.OrderManager(cc);
                                        cm.place_order(o);
                                        o.bill_generate(menu);
                                        
                                         //place_order(Order e)
		                	
		                	
		                }
						
						//cbox[0].
						//n = (String)cb.getSelectedItem();
						//rs = stmt.executeQuery("select * from " + n);
					
					}
					
					else if(e.getSource() == reset)
					{
						MenuGUI mmg = new MenuGUI(cc,hotel_name);
					}
						
					
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			

		

		
	}}

}
