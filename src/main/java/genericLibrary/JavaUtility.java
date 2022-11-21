package genericLibrary;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public static int getRanDomNumber() {
		Random random=new Random();
		int ranDomNum=random.nextInt(1000);
		return ranDomNum;
	}
	
	public String getSystemDate() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr=currentDate.split(" ");
		String yyyy=arr[5];
		String dd=arr[2];
		int mm=date.getMonth()+1;
		String formate=yyyy+"-"+mm+"-"+dd;
		return formate;
	}
	public String getSystemDateInIST() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr=currentDate.split(" ");
		String yyyy=arr[5];
		String dd=arr[2];
		int mm=date.getMonth()+1;
		String formate=dd+"-"+mm+"-"+yyyy;
		return formate;
		
	}
	public String getSystemDateAndTimeInFormat() 
	{
		SimpleDateFormat dateformate = new SimpleDateFormat("dd-MM-yyyy HH :mm:SS");
		Date systemdate = new Date();
		String getDateAndTime = dateformate.format(systemdate);
		System.out.println(getDateAndTime);
		return getDateAndTime.replaceAll(":","-");
	}
	
		
		
	

}
