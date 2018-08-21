package com.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestArrayList {
	public static void main(String[]args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("E");
		list.add("D");
		for(String num : list) {
			System.out.println(num);
		}
	
		
		list.set(0, "B");//替換元素
		list.add(2,"C");
		for(String num : list) {
			System.out.println(num);
		}
		
		// 檢查元素的位置
		int pos = list.indexOf("B");
		System.out.println(pos);
		
		// 獲取指定位置上的元素
		String item = list.get(1);
		System.out.println(item);
		
		//移除元素
		list.remove(0);
		System.out.println(list);
		
		// 轉換 ArrayList 為 Array
		String[] simpleAarry = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(simpleAarry));
		
		ArrayList<String> AList = new ArrayList<String>();
		/*AList加入String**/
		AList.add("30");
		
		AList.add("07");
		AList.add("01");
		AList.add("13");
		AList.add("45");
		AList.add("33");
		AList.add("28");
		String rest = "";
		String SpecialNumber = AList.get(0);//存取第一位號碼
		AList.remove(0);
		
		
		/*排序AList**/
		
		
		/*特別號擺第一位**/
		AList.add(0,SpecialNumber);
		
		
		for(int i = 0;i < AList.size();i++) {
			if(i == 0) {
				rest += "特: " + AList.get(i) + " ";
			}
			else if(i < 6) {
				rest += AList.get(i) + ",";
			}
			else {
				rest += AList.get(i);
			}
		}
		System.out.println(rest);
		
		
		
		
		
		
//	
//		String result = "";
//		String specialNum = "02";
//		
//		/*排序加入list**/
//		list.add();
//		
//		/*排序後**/
//		list.add(0,specialNum);
//		
//		
//		for(int i = 0;i < AList.size();i++) {
//			if(i == 0) {
//				result = "特: " + AList.get(i) + " ";
//			}
//			else if(i < 6){
//				//result = result +
//				result += AList.get(i) + ",";
//			}
//			else{
//				result += AList.get(i);
//			}
//		}
//		
//			System.out.println(result);
	
	}
	
	
}
