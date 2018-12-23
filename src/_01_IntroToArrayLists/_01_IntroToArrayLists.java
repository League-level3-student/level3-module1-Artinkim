package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
ArrayList<String> st = new ArrayList<String>();
		//2. Add five Strings to your list
		st.add("1hi");
		st.add("2hi");
		st.add("3hi");
		st.add("4hie");
		st.add("5hi");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0;i<st.size();i++) {
			System.out.println(st.get(i));
		}
		
		//4. Print all the Strings using a for-each loop
		for(String s : st) {
			System.out.println(s);
		}
		//5. Print only the even numbered elements in the list.
		for(int i = 0;i<st.size();i+=2) {
			System.out.println(st.get(i));
		}
		//6. Print all the Strings in reverse order.
		for(int i = 1;i<st.size()+1;i++) {
			System.out.println(st.get(st.size()-i));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for(int i = 0;i<st.size();i++) {
			if(st.get(i).contains("e") == true) {
				System.out.println(st.get(i));
			}
		}
	}
}
