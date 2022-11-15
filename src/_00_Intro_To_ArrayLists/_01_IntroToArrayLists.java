package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
ArrayList<String> list1 = new ArrayList();
        // 2. Add five Strings to your list
list1.add("Barbarian");
list1.add("Bard");
list1.add("Cleric");
list1.add("Druid");
list1.add("Fighter");

        // 3. Print all the Strings using a standard for-loop
for (int i = 0; i < list1.size(); i++) {
	System.out.println(list1.get(i));
}
        // 4. Print all the Strings using a for-each loop
for (String s : list1) {
	System.out.println(s);
}
        // 5. Print only the even numbered elements in the list.
for (int i = 0; i< list1.size(); i++) {
	if(i%2==0) {
	System.out.println(list1.get(i));
	}
}
        // 6. Print all the Strings in reverse order.
for (int i = list1.size()-1; i >=0; i--) {
	System.out.println(list1.get(i));
}
        // 7. Print only the Strings that have the letter 'e' in them.
for (int i = 0; i < list1.size(); i++) {
	String yeet = list1.get(i);
	if(yeet) {
	System.out.println(yeet);
	}
}  
    }
}
