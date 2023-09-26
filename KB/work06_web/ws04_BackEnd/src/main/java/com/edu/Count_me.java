package com.edu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Count_me {

	public String execute(String book) {
		book=book.toLowerCase();
	    // 코드구현
		String[] arr = book.split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		
		for (String s : arr) {
			if(!map.containsKey(s)) map.put(s, 1);
			else map.put(s, map.get(s)+1);
		}
		
		ArrayList<ArrayList<String>> word = new ArrayList<>();
		for (int i = 0; i < arr.length + 1; i++) {
            word.add(new ArrayList<>());
        }
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			
			word.get(val).add(key);
		}
		for (int i = word.size() - 1; i >= 0; i--) {
	        ArrayList<String> words = word.get(i);
	        if (words.size() > 0) {
	            Collections.sort(words);
	            return words.get(0);
	        }
	    }
		return"";
	}

 public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count_me c = new Count_me();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
