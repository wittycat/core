package com.chenxun.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

import org.junit.Test;

/** 
 * @author：chenxun
 * 创建时间：2016年5月29日 下午11:10:32 
 * 参考：
 * 说明：深拷贝测试成功
 *     clone()在java1.8下未测试成功??? 
 *      原因分析：1.java版本原因
 *             2.测试方法不正确
 */
public class DeepClone implements Serializable {

	private static final long serialVersionUID = -7651019854487334358L;

	@Test
	public void testShallowClone() throws CloneNotSupportedException, OptionalDataException, ClassNotFoundException, IOException {
		
		Person person1= new Person(10,"Jim",HobbyColor.blue);
		Person person2 = (Person) person1.clone();
		Person person3 = (Person) person1.deepClone();
		person2.setHobbyColor(HobbyColor.red);
		System.out.println(person1);
		System.out.println(person2);
//		System.out.println(person1);
//		System.out.println(person2);
//		System.out.println(person3);
//		System.out.println(person1==person2);
//		System.out.println(person1==person3);  
	}
	
   enum HobbyColor {
	   red,blue,white;
   }
	
	class Person implements Serializable,Cloneable {
		/**
	 * 
	 */
		private static final long serialVersionUID = -1469506771660388239L;
		private int age;
		private String name;
		private HobbyColor hobbyColor;

		public Person(int age, String name, HobbyColor hobbyColor) {
			super();
			this.age = age;
			this.name = name;
			this.hobbyColor = hobbyColor;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.chenxun.util.Aa#getAge()
		 */
		public int getAge() {
			return age;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.chenxun.util.Aa#setAge(int)
		 */
		public void setAge(int age) {
			this.age = age;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.chenxun.util.Aa#getName()
		 */
		public String getName() {
			return name;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.chenxun.util.Aa#setName(java.lang.String)
		 */
		public void setName(String name) {
			this.name = name;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.chenxun.util.Aa#getHobbyColor()
		 */
		public HobbyColor getHobbyColor() {
			return hobbyColor;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.chenxun.util.Aa#setHobbyColor(com.chenxun.util.ShallowClone.
		 * HobbyColor)
		 */
		public void setHobbyColor(HobbyColor hobbyColor) {
			this.hobbyColor = hobbyColor;
		}

		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + ", hobbyColor="
					+ hobbyColor + "]";
		}

		public Object deepClone()  throws IOException, OptionalDataException,ClassNotFoundException {
			// 将对象写到流里
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(this);// 从流里读出来
			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			return (oi.readObject());
		}
	}
}
