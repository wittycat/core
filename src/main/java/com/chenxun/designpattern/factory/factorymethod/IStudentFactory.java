package com.chenxun.designpattern.factory.factorymethod;

import com.chenxun.designpattern.factory.student.IStudent;

/** 
 * @author：chenxun
 * createDate：2016年11月5日 下午8:06:25 
 * Theme:
 * reference:
 * descript:
 * 工厂方法是简单工厂的进一步抽象
 * 1.简单工厂
 *   优点：实现简单，易懂
 *   缺点：违背“开闭原则”，工厂中存在业务逻辑；增加一个实现，修改工厂逻辑
 *   区别：只定义1个实现类的接口，一个产生对象的工厂
 *        逻辑判断在服务端
 * 2.工厂方法
 *   优点：遵循“开闭原则”，易于扩展
 *   缺点：比较抽象，难懂，每增加一个实现，就要增加一个相应的工厂；
 *   区别：定义2个接口：一个实现类的接口，一个工厂的接口（工厂接口里面的方法返回实现类接口）；
 *        把实例化延迟到了子类的工厂；
 *        把简单工厂的逻辑判断移动到了客户端，让客户端去创建不同的实现工厂；
 *        n个具体实现工厂；
 *        
 */
public interface IStudentFactory {
    IStudent getStudent();
}
