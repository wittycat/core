package com.chenxun.other;

import java.util.Arrays;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年5月29日 下午11:10:32 
 * 参考：
 * 说明：浅拷贝:拷贝地址值，为同一个对象
 */
public class ShallowClone {
	
	@Test
	public void testShallowClone() {
		
		Person[] persons =new  Person[2];
		persons[0] = new Person(10,"Jim",HobbyColor.blue);
		persons[1] = new Person(9,"Kate",HobbyColor.red);
		
		Person[] copyOf = Arrays.copyOf(persons, persons.length);
		copyOf[0].age = 12;
		copyOf[0].name = "lucy";
		copyOf[0].hobbyColor = HobbyColor.white;
		
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i].toString());
		}
		
		for (int i = 0; i < copyOf.length; i++) {
			System.out.println(copyOf[i].toString());
		}
		System.out.println(persons[0]==copyOf[0]);
		System.out.println(persons[1]==copyOf[1]);
	}
	
   enum HobbyColor{
	   red,blue,white;
   }
	
   class Person {
	   private int age ;
	   private String name;
	   private HobbyColor hobbyColor;
	
	public Person(int age, String name,HobbyColor hobbyColor) {
		super();
		this.age = age;
		this.name = name;
		this.hobbyColor = hobbyColor;
	}
	
	
	/* (non-Javadoc)
	 * @see com.chenxun.util.Aa#getAge()
	 */
	public int getAge() {
		return age;
	}


	/* (non-Javadoc)
	 * @see com.chenxun.util.Aa#setAge(int)
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/* (non-Javadoc)
	 * @see com.chenxun.util.Aa#getName()
	 */
	public String getName() {
		return name;
	}


	/* (non-Javadoc)
	 * @see com.chenxun.util.Aa#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}


	/* (non-Javadoc)
	 * @see com.chenxun.util.Aa#getHobbyColor()
	 */
	public HobbyColor getHobbyColor() {
		return hobbyColor;
	}


	/* (non-Javadoc)
	 * @see com.chenxun.util.Aa#setHobbyColor(com.chenxun.util.ShallowClone.HobbyColor)
	 */
	public void setHobbyColor(HobbyColor hobbyColor) {
		this.hobbyColor = hobbyColor;
	}


	/* (non-Javadoc)
	 * @see com.chenxun.util.Aa#toString()
	 */
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", hobbyColor="
				+ hobbyColor + "]";
	}
	   
   }
}
