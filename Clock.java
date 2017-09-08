import java.util.Calendar;
import javax.swing.JLabel;


public class Clock extends Thread
{
	
	 JLabel jb;
	 public Clock(JLabel jb)
	 {
		 this.jb=jb;
		 
	 }
	 
	 public void run()
	 {
		 while(true)
		 {
			 try{
				  jb.setText(timeNow());
				  Thread.sleep(1000);
				  
			 }
			 catch(InterruptedException ex)
			 {
				 System.out.println(ex);
				 
			 }
		 }
		 
	 }
	 public String timeNow()
	 {
		 Calendar now=Calendar.getInstance();
		 int dd=now.get(Calendar.DATE);
		 int mm=now.get(Calendar.MONTH);
		 int yy=now.get(Calendar.YEAR);
		 int hrs=now.get(Calendar.HOUR_OF_DAY);
		 int min=now.get(Calendar.MINUTE);
		 int sec=now.get(Calendar.SECOND);
		 String time = dd+"/"+mm+"/"+yy+" "+zero(hrs)+":"+zero(min)+":"+zero(sec);
		 return time;
    }
    public String zero(int num)
    {
    	String number=(num<10)?("0"+num):(""+num);
    	return number;
    }
}
