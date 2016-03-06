package fooddelivery;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Iterator;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CustomerManagement {
    Customer cust;
    Connection con ;
    Statement stmt;
    ResultSet rs;
    String sql;
    Customer cmc = new Customer();
    static ArrayList<Order> odr=new ArrayList<Order>();  

    public CustomerManagement() {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliverysyatem","root","root");
        this.stmt = con.createStatement();
       // System.out.println("Connection established !!");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
                       
  
                        
    void addcustomer(Customer c) throws SQLException{
        
			sql = "INSERT INTO customer VALUES ('"+c.getRollNo()+"' , '"+c.getPwd()+"')";
                        int flag = stmt.executeUpdate(sql);
                       // System.out.println("Before Addition");
                        
                        c.cuslist.add(c);
                        //System.out.println("Customer added");
                        //System.out.println(c.cuslist);
                        
    }
    boolean checkcustomer(String username,String pwd) throws SQLException{
        
        System.out.println("in checkcustomer");
         rs = stmt.executeQuery("select * from customer where rollno like '"+username+"'");
         //rs = stmt.
         System.out.println("executed query");
        rs.next();
         String s = rs.getString(2);
         System.out.println(s);
         if (s.equals(pwd)){
             return(true);
         }        
         else
        return(false);   
    }
    Customer getcustomerobj(String username,String pwd){
                
        cmc = cmc.getdetails(username, pwd);
       // System.out.println("Inside Customer Management: id" + username+ "  password   : "+pwd);
        //System.out.println("Return value:            "+ cmc.rollno);
        return(cmc);
    }
    void OrderManager(Customer x)
    {
        cust=x;
    }
    
    public void place_order(Order e) throws ClassNotFoundException
    {
        odr.add(e);
       // System.out.println("Order_placed_Successfully!!");
    }
    public void cancel_order(Order e)
    {
         Order x;
        //Iterator iterator = odr.iterator();
          for (int i = 0; i < odr.size(); i++){
           x = odr.get(i);
            if(x.order_id.equals(cust.rollno))
                    {
                        odr.remove(x);
                        break;
                    }
            else
                JOptionPane.showConfirmDialog (null, "Order does not exist.. ");
                 HomePage hp = new HomePage(cmc);
                    hp.setVisible(true);
                   
        }
      
    }
    
}
