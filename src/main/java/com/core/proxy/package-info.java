/**
 * @author chenxun
 * 
 * 
 * 1.增强某个类的方法的时候：继承,装饰者,动态代理
 *     动态代理:JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，如何实现动态代理呢，这就需
 * 要CGLib了。CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所
 * 有父类方法的调用，顺势织入横切逻辑。JDK动态代理与CGLib动态代理均是实现Spring AOP的基础。(springioc 
 * 通过反射创建对象)
 * 2.CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，但是CGLib在创建代理对象时所花费的时间却
 * 比JDK多得多，所以对于单例的对象，因为无需频繁创建对象，用CGLib合适，反之，使用JDK方式要更为合适一些。同时，由
 * 于CGLib由于是采用动态创建子类的方法，对于final方法，无法进行代理
 * 3具体实现过程
 *   jdk:接口InvocationHandler  实现invoke
 *   cglib：接口MethodInterceptor 实现intercept   创建Enhancer设置父接口
 */
package com.core.proxy;