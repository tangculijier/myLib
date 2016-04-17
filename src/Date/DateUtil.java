package Date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * ����dateʱ��Ĺ�����
 */
public class DateUtil
{

	/**
	 * 
	 * @param last ǰһ������
	 * @param now  ��һ������
	 * @return ����������������
	 */
	public static String daysBetween(Date last,Date now)
	{
		if(last != null)
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(last);
			long lastTime = cal.getTimeInMillis();
			cal.setTime(now);
			long nowTime = cal.getTimeInMillis();       
	        long between_days=(nowTime - lastTime) / ( 1000 * 3600 * 24);  
	        return String.valueOf(between_days); 
		}
		else
		{
			return "0";
		}
		
	}

	/**
	 * @param dataStr eg:2015-10-01
	 * @return Date eg:Thu Oct 01 16:46:18 CST 2015
	 */
	public static Date StringToDate(String dataStr)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date temp = null;
		try
		{
			temp = sdf.parse(dataStr);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return temp;  
	}
	
	/**
	 * @param Date eg:Thu Oct 01 16:46:18 CST 2015
	 * @return String eg:2015-10-01 12:39:52
	 */
	public static String DateToString(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		return sdf.format(date); 
	}
	
	/**
	 * @param Date eg:Thu Oct 01 16:46:18 CST 2015
	 * @return String eg:2015-10-01 
	 */
	public static String DateToStringNoHour(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		return sdf.format(date); 
	}
	
	
	public static String DateToStringNoMinute(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		return sdf.format(date); 
	}
	
	/**
	 * @param Date eg:Thu Oct 01 16:46:18 CST 2015
	 * @return String[] eg:2015-10-01 00:00:00 and 2015-10-31 23:59:59
	 */
	public static String[] getMonthFirstAndLastDate(Date currentDate)
	{
		String[] res = new String[2];
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date first = cal.getTime();
		res[0] =DateToStringNoHour(first) + " 00:00:00";
		cal.add(Calendar.MONTH, 1);// ��calendar�ƺ�һ����
		cal.set(Calendar.DAY_OF_MONTH, 0);
		Date last = cal.getTime();
		res[1] =DateToStringNoHour(last) + " 23:59:59";
		return res;
	}
	
	/**
	 * �õ�����ݵĵ�һ������һ��
	 * @param Date eg:Thu Oct 01 16:46:18 CST 2016
	 * @return String[] eg:2016-01-01 and 2016-12-31 23:59:59
	 */
	public static String[] getThisYearFirstDayAndLastDay(Date currentDate)
	{
		
		String[] res = new String[2];
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		int currentYear = cal.get(Calendar.YEAR);
		
		cal.clear();
		cal.set(Calendar.YEAR, currentYear);  
		Date currYearFirstDay = cal.getTime();
		res[0] = DateToStringNoHour(currYearFirstDay);

		cal.clear();  
        cal.set(Calendar.YEAR, currentYear);  
        cal.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLastDay = cal.getTime();  
        res[1] = DateToStringNoHour(currYearLastDay);

		return res;
	}
	
	
	
	
	/**
	 * @param currentDate ��ǰʱ�� example : 2015-11-15
	 * @return ���ر������һ�� example:2015/11/30
	 */
	
	public static Date getLastDateInMonth(Date currentDate)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 0);
		return cal.getTime();
	}
	
	
	/**
	 * @param ����1 ����2
	 * @return �Ƿ�����ͬ����ݺ��·�
	 */
	
	public static boolean isSameMonth(Date date1,Date date2)
	{
		if(date1 ==null || date2 == null )
		{
			return false;
		}
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int year1 = cal1.get(Calendar.YEAR); 
		int year2 = cal2.get(Calendar.YEAR); 
		boolean isSameYear = year1 == year2 ? true : false;
		
		int month1 = cal1.get(Calendar.MONTH) + 1; 
		int month2 = cal2.get(Calendar.MONTH) + 1; 
		
		boolean isSameMonth = month1 == month2 ? true : false;
		return isSameYear && isSameMonth;
	}
	
	/**
	 * @param ��ǰʱ��
	 * @return �ڼ��죨�ڵ�ǰ�·��У�
	 */
	public static int getDateIndexInMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return  cal.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * @param ��ǰʱ��
	 * @return �ڼ�����
	 */
	public static int getMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return  cal.get(Calendar.MONDAY) + 1;
	}
	
	
	/**
	 * @param currentDate ��ǰʱ�� example : 2015-11-15
	 * @return �����ϸ������һ�� example:2015/10/31
	 */
	
	public static Date getPreMonthLastDay(Date currentDate)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.set(Calendar.DAY_OF_MONTH, 1);//�õ����µ�һ��
		cal.add(Calendar.DATE, -1);//��ǰ��һ��
		return cal.getTime();
	}
	
}
