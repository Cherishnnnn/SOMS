package Others;


import java.util.Date; 
import java.util.Calendar; 

import java.text.SimpleDateFormat; 

public class GetTime{ 

public static String getCurTime()
{
	
Date now = new Date(); 
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//���Է�����޸����ڸ�ʽ


String hehe = dateFormat.format( now ); 
return hehe;
//System.out.println(hehe); 

//Calendar c = Calendar.getInstance();//���Զ�ÿ��ʱ���򵥶��޸�
//
//int year = c.get(Calendar.YEAR); 
//int month = c.get(Calendar.MONTH); 
//int date = c.get(Calendar.DATE); 
//int hour = c.get(Calendar.HOUR_OF_DAY); 
//int minute = c.get(Calendar.MINUTE); 
//int second = c.get(Calendar.SECOND); 
//System.out.println(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second); 
} 
}
