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
	
		
		list.set(0, "B");//��������
		list.add(2,"C");
		for(String num : list) {
			System.out.println(num);
		}
		
		// �ˬd��������m
		int pos = list.indexOf("B");
		System.out.println(pos);
		
		// ������w��m�W������
		String item = list.get(1);
		System.out.println(item);
		
		//��������
		list.remove(0);
		System.out.println(list);
		
		// �ഫ ArrayList �� Array
		String[] simpleAarry = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(simpleAarry));
		
		ArrayList<String> AList = new ArrayList<String>();
		/*AList�[�JString**/
		AList.add("30");
		
		AList.add("07");
		AList.add("01");
		AList.add("13");
		AList.add("45");
		AList.add("33");
		AList.add("28");
		String rest = "";
		String SpecialNumber = AList.get(0);//�s���Ĥ@�츹�X
		AList.remove(0);
		
		
		/*�Ƨ�AList**/
		
		
		/*�S�O���\�Ĥ@��**/
		AList.add(0,SpecialNumber);
		
		
		for(int i = 0;i < AList.size();i++) {
			if(i == 0) {
				rest += "�S: " + AList.get(i) + " ";
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
//		/*�Ƨǥ[�Jlist**/
//		list.add();
//		
//		/*�Ƨǫ�**/
//		list.add(0,specialNum);
//		
//		
//		for(int i = 0;i < AList.size();i++) {
//			if(i == 0) {
//				result = "�S: " + AList.get(i) + " ";
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
