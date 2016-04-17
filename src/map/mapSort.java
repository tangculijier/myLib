package Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



public final class mapSort {
	
	
	 /*
	  * LinkedHashMap�����˼�¼�Ĳ���˳������Iterator����LinkedHashMapʱ���ȵõ��ļ�¼�϶����Ȳ���ġ�
	  * �˴���Ϊ����map�޷��ﵽЧ��	
	  */
	public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) 
	{
		//LinkedHashMap 
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		if (oriMap != null && !oriMap.isEmpty())
		{
			List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(oriMap.entrySet());
			Collections.sort(entryList,
					new Comparator<Map.Entry<String, Integer>>()
					{
						public int compare(Entry<String, Integer> entry1,
								Entry<String, Integer> entry2)
						{
							
								//todo
								return 0 ;
						}
					});
			Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
			Map.Entry<String, Integer> tmpEntry = null;
			while (iter.hasNext())
			{
				tmpEntry = iter.next();
				sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
			}
		}
		return sortedMap;
	}
	
}


