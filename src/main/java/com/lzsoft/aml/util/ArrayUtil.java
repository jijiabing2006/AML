package com.lzsoft.aml.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lzsoft.aml.common.Constants;

public class ArrayUtil {
	public static <T> T[] concat(T[] first, T[] second) {  
		  T[] result = Arrays.copyOf(first, first.length + second.length);  
		  System.arraycopy(second, 0, result, first.length, second.length);  
		  return result;  
		} 
   public static <T> List<List<T>> separateList(List<T> list,int countlines){
	   
	   List<List<T>> slist=new ArrayList<List<T>>();
	    
	   // int countlines=Constants.EXCEL_EXPORT_LINES;
	    int count = list.size() /countlines;
	    int yu = list.size() % countlines;
	    if(yu>0){
	    	count++;
	    }
	    for (int i = 0; i < count; i++) {
	    	 List<T> subList = new ArrayList<T>();
		      if (i == count-1&&yu>0) {
		        subList = list.subList(i * countlines, i * countlines + yu);
		      } else {
		        subList = list.subList(i * countlines, countlines * (i + 1));
		      }
		      slist.add(subList);
		}
	return slist;
	   
   }
}
