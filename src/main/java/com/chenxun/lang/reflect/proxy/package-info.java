/**
 * @author chenxun
 * 泛型和反射
 * 动态代理：Spring.
 * 增强某个类的方法的时候：
 * 继承：
 * 装饰者：
 * 动态代理：
 *     JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，如何实现动态代理呢，这就需要CGLib了。
 * CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所
 * 有父类方法的调用，顺势织入横切逻辑。JDK动态代理与CGLib动态代理均是实现Spring AOP的基础。(springioc 
 * 通过反射创建对象)
 */
package com.chenxun.lang.reflect.proxy;