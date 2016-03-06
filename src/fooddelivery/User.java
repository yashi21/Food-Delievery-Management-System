package fooddelivery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
abstract public class User {
    String fname,lname,email,pwd,mno;
    int id;
	void setFName(String s)
	{
		fname=s;
	}
	String getFName()
	{
		return fname;
	}
        void setLName(String s)
	{
		lname=s;
	}
	String getLName()
	{
		return lname;
	}
	void setLoginId(String s)
	{
		email=s;
	}
	void setContact(String x)
	{
		mno=x;
	}
	void setPassword(String s) //ONLY SET METHOD FOR PASSWORD TO ENSURE SECURITY
	{
		pwd=s;
	}
	String getLoginId()
	{
		return email;
	}
        String getPwd()
        {
            return pwd;
        }
	void setpwd(String s){
		pwd = s;
	}
	String getmno()
        {
            return mno;
        }
	void setmno(String s){
		mno = s;
	}
    
}
