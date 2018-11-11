package com.core.guawa.base;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

public class TJoiner {
  
  @Test
  public  void join() {
	  int[] numbers = { 1, 2, 3, 4, 5 };  
	  String numbersAsString = Joiner.on(";").join(Ints.asList(numbers)); 
	  System.out.println(numbersAsString);
	  //或者
	  String numbersAsStringDirectly = Ints.join(";", numbers);  
	  System.out.println(numbersAsStringDirectly);
  }
}
