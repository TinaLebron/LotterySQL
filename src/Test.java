import java.util.ArrayList;

import enums.GameMenu;

public class Test {
	public Test() {
		
	}
	
	public static void main(String[]args){
		int[] nums = new int[3];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		
//		int size = ResultSet.getXXXXX //假設拿到的是2
//		Big[] bigs = new Bigs[size];
//		for(int i = 0; i < bigs.length; i++) {
//			bigs[i] = new Big();
//			bigs[i].setID(?);
//			bigs[i].setUserName(?);
//			bigs[i].setPickNumber(?);
//		}
		
		
		ArrayList<String> list = new ArrayList<>();
		list.add("02");
		list.add("07");
		list.add("01");
		list.add("13");
		list.add("45");
		list.add("33");
		list.add("28");
		
		
		
		String result = "";
		for(int i = 0; i < list.size(); i++) {
			if(i == 0) {
				result = "特: " + list.get(i) + " ";
			}
			else if( i < 6) {
				result += list.get(i) + ",";
			}
			else {
				result += list.get(i);
			}
			
		}
		System.out.println("" + result);
		
		ArrayList<String> list1 = new ArrayList<String>();
		String num = "";
		list1.add("01");
		list1.add("09");
		list1.add("12");
		for(int i = 0; i < list1.size();i++) {
			num = num + list1.get(i);
		}	
		System.out.println(num);
	
		String number1 = "";
		String number2 = "n";
		
		number1 = number1 + number2;
		System.out.println(number1);
		int[]array = {6,3,2,5,1};
		setBubbleSort(array);
		for(int i = 0;i < array.length;i++) {
			System.out.print(array[i]);
		}
		
	}
	public static void setBubbleSort(int[] array) {
		int swap = 0;
		for(int i = 0;i < array.length-1;i++) {
			for(int j = 0;j < array.length-1;j++) {
				if(array[j] > array[j+1]) {
					swap = array[j];
					array[j] = array[j+1];
					array[j+1] = swap;
				}
			}
		}
	}
}
