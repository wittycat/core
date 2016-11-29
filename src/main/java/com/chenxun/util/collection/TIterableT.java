package com.chenxun.util.collection;

import java.util.Iterator;

/** 
 * @author：chenxun
 * createDate：2016年11月21日 下午11:30:04 
 * Theme:
 * reference:
 * descript:
 */
public class TIterableT {
	
    private static class EIterable<E> implements Iterable<E>{
		
        private E[]  e;
        
		public EIterable(int size) {
//			this.e = new E[size];
//			for (int i = 0; i < size; i++) {
//				e[i] = new E("student_"+(i+1), 20+i);
//			}
		}

		@Override
		public Iterator<E> iterator() {
			return new TIterator();
		}
		
		private class TIterator implements Iterator<E>{
			
            private int index = 0;
            
			@Override
			public boolean hasNext() {
				return index!=e.length;
			}

			@Override
			public E next() {
				return e[index++];
			}
		}
	}
	
//	private static class Student {
//		private String name;
//		private Integer age;
//
//		public Student(String name, Integer age) {
//			super();
//			this.name = name;
//			this.age = age;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public Integer getAge() {
//			return age;
//		}
//
//		public void setAge(Integer age) {
//			this.age = age;
//		}
//
//		@Override
//		public String toString() {
//			return "Student [name=" + name + ", age=" + age + "]";
//		}
//
//	}
}
