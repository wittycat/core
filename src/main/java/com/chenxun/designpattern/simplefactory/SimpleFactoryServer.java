package com.chenxun.designpattern.simplefactory;


/** 
 * @author：chenxun
 * createDate：2016年11月3日 下午10:29:45 
 * Theme:
 * reference:
 * descript:
 */
public class SimpleFactoryServer {
	public SimpleFactoryServer() {
	}

	public Fruit createFruit(String type) {
		Fruit fruit = null ;
		switch (type) {
		case "peach":
			fruit = new Peach();
			break;
		case "orange":
			fruit = new Orange();
			break;
		case "banana":
			fruit = new Banana();
			break;
		default:
			break;
		}
      return fruit;
	}
}
