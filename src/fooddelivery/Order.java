package fooddelivery;



import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Order {
     String order_id;
	float bill;
        Customer cc;
	Order(Customer c){
		order_id = c.rollno;
                cc = c;
}
       
	public void bill_generate(String menuo[][]) throws ClassNotFoundException, SQLException
	{
            bill=0;
		int row = menuo.length;
                for(int i=0;i<row;i++)
                {
                System.out.println("Quantity   :   "+menuo[i][3]+" Price:   "+menuo[i][2]);
                }
		for(int j = 0;j<row;j++)
		{
                    System.out.println("Before Bill                 :");
			bill = bill + (Float.parseFloat(menuo[j][3]))*Float.parseFloat(menuo[j][2]);
                        
                        System.out.println("After Bill                 :");
                       
		}
                System.out.println("Bill        :" +bill);
		
        JOptionPane.showConfirmDialog (null, "Bill Generated" +bill);

       
            HomePage hp = new HomePage(cc);
                    hp.setVisible(true);
                  
        }
						
	}
	
	
//}
