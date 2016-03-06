/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddelivery;

/**
 *
 * @author User
 */

    import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class currentTime {

    public static void main(String[] args) {
    	Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	System.out.println( sdf.format(cal.getTime()) );
        
        
        Date date = new Date();
    System.out.println(date);
    //System.out.println(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
    long t1 = date.getTime();
    System.out.println((t1 / 1000 / 60 / 60) % 24 + ":" + (t1 / 1000 / 60) % 60 + ":" + (t1 / 1000) % 60);
    long t2 = System.currentTimeMillis();
    System.out.println((t2 / 1000 / 60 / 60) % 24 + ":" + (t2 / 1000 / 60) % 60 + ":" + (t2 / 1000) % 60);
    }

}
    

