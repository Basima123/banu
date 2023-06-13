package com.saya.interfacedemo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	

	public static void main(String[] args) {
		
		Set set1=new HashSet();//random order
		set1.add(45);
		set1.add(4.5f);
		set1.add(null);
		set1.add("apple");
		System.out.println(set1);
		Set<Integer> set3=new HashSet<>();
		set3.add(45);
		set3.add(5);
		set3.add(40);
		set3.add(15);
		System.out.println(set3);
		
		//set3.add(4.5f);
		//set3.add(null);
		//set3.add("apple");
	   Set<Integer> set2=new LinkedHashSet<>();//insertion order
			
	    set2.add(45);
		set2.add(5);
		set2.add(40);
		set2.add(15);
		System.out.println(set2);
		 TreeSet<Integer> set4=new TreeSet<>();//ascending order
			
		    set4.add(40);
			set4.add(5);
			set4.add(40);
			set4.add(15);
			System.out.println(set4);
			System.out.println(set4.ceiling(15));
			System.out.println(set4.higher(15));
			System.out.println(set4.floor(15));
			System.out.println(set4.lower(15));
			HashSet<Employee> emp=new HashSet<Employee>();
			
			emp.add(new Employee("saya", 30, new Address(12,"anbunagar",613431),new Location(15,2,"bus")));
			emp.add(new Employee("saya", 30, new Address(12,"anbunagar",613431),new Location(15,2,"bus")));
			emp.add(new Employee("liza", 30, new Address(12,"anbunagar",613431),new Location(15,2,"bus")));
			
			Iterator<Employee> itr = emp.iterator();
					while(itr.hasNext())
					{System.out.println(itr.next());
					}
		HashSet<Integer> hs= new HashSet<Integer> ();
		hs.add(14);
		hs.add(55);
		hs.add(33);
		hs.add(33);
		hs.add(55);
		hs.add(14);
		
		Iterator<Integer> itr1 = hs.iterator();
		while(itr1.hasNext())
		{System.out.println(itr1.next());}
Map<Integer,String> ob=new HashMap<>();	
ob.put(1, "apple");
ob.put(2, "banana");
System.out.println(ob);
System.out.println(ob.keySet());
System.out.println(ob.values());
System.out.println(ob.get(1));
System.out.println(ob.entrySet());
for(Map.Entry<Integer,String> mp:ob.entrySet()) {
	System.out.println(mp.getKey()+"---------------------------------->"+mp.getValue());
}

		
	}

}
