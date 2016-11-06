package com.chenxun.designpattern.factory.abstractfactory;

import com.chenxun.designpattern.factory.classs.IClass;
import com.chenxun.designpattern.factory.student.IStudent;

/** 
 * @author：chenxun
 * createDate：2016年11月5日 下午11:33:19 
 * Theme:
 * reference:
 * descript:
 * 抽象工厂就是稍微扩展了下工厂方法：提供创建一系列相关或相互依赖的对象接口
 * 工厂方法：一个实现接口+一个实现接口的工厂
 * 抽象工厂：多个实现的接口+一个实现接口的工厂（工厂接口里面的多个方法返回多个实现类接口）
 * 缺点：如果再增加一种数据库的实现，需要修改工厂接口和工厂接口的各个实现
 * 这是无法避免的，“是个设计模式都会有缺陷”
 * 其他优化点：由于工厂方法是把获取具体实现的逻辑交给了客户端去行使，当然抽象工厂也是一样的，
 * 当客户端多次创建后，如果需要切换到其他库就很麻烦？
 *      优化方式一：这样我们可以把交给客户端行使的这个权利收回到服务端利用简单工厂的优势代替掉，
 * 把选择类型也可以写到配置文件中读取等
 *      优化方式二：客户端自己建立统一获取方式类
 *      优化方式三：和优化方式一比较类似，创建实例通过反射bean = Class.forName("实现类
 *公共路径"+实现类名称)类名称也可以放到配置文件中
 * 
 */
interface IFromFactory {
   public IStudent getStudent();
   public IClass getClasss();
}
