package fooddelivery;



import java.util.LinkedHashSet;


public class Customer extends User{
     //int custid;
    int rno;
    static int h = 1;
    String hostel;
    String rollno;
    static LinkedHashSet<Customer> cuslist = new LinkedHashSet<Customer>(); 
    
    void setHostel(String s)
	{
		hostel = s;
	}
	String getHostel()
	{
		return hostel;
	}
        void setRollno(String s)
	{
		rollno = s;
	}
	String getRollNo()
	{
		return rollno;
	}
    void setRNo(int s)
	{
		rno=s;
	}
	Integer getRno()
	{
		return rno;
	}
         public int hashCode(){
        //System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = h*20;
        hashcode += rollno.hashCode();
        return hashcode;
    }
     
    public boolean equals(Object obj){
        //System.out.println("In equals");
        if (obj instanceof Customer) {
            Customer pp = (Customer) obj;
            return (pp.rollno.equals(this.rollno));
        } else {
            return false;
        }
    }
    
    Customer getdetails(String username,String pawd){
        Customer c  = new Customer();
        for(Customer c1 : cuslist){
            if(c1.rollno.equals(username) && c1.pwd.equals(pawd)){
                System.out.println("Inside If of get details");
                c = c1;
               // return(c1);
            }
                
        }
         /*Iterator iterator = cuslist.iterator();
          for (int i = 0; i < cuslist.size(); i++){
           x = cuslist.get(i);
            if(x.order_id.equals(cust.rollno))
                    {
                        odr.remove(x);
                        break;
                    }*/
        
        return(c);
    }

}
