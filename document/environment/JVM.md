#### jvm内存划分
 	堆：（运行时常量池）	new的对象就会放在堆中
	方法区：	加载好的类放在方法区，静态成员
	栈：（JVM栈和本地方法栈）	局部变量
	程序计数器：存储的是地址描述的是当前线程接下来
	
	垃圾回收算法-标记清除算法
    垃圾回收算法-标记复制算法
    垃圾回收算法-标记整理算法
####常用6个命令， [可选参数] <必需参数>
基本
* jps：列出进程
* jinfo：列出jvm启动参数，可以动态修改，增加，删除

栈
* jstack：栈情况查看

堆
* jstat：堆使用统计
* jmap：堆dump生产，对象查看
* jhat：配合jmap使用，打开dump，打开后通过内嵌的http服务查看
#### jvm调优你用什么工具，[系统负载分析](https://mp.weixin.qq.com/s/Lz4cEt0LY_Fvqz2zAgOafw)
*   计算衡量标准 
    * load average: 3.04, 2.71, 2.45  （1 分钟、5 分钟、15 分钟机器的负载）
    * cpu 核数： grep "physical id"| wc -l	 
    * 衡量标准 = 0.7 * cpu 核数
* Jps:获取pid
* 获取现象id： top -H -p pid (P：按%CPU对进程排序  H：切换在进程列表中显示所有线程信息)
* 转化为16十进制： printf "%x\n" 线程id
* 查看线程栈信息 ： jstack pid |grep 线程id
