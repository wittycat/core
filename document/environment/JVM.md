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
