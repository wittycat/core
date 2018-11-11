  Linux命令并不好记，那么命令是哪些的简写呢？这是一个有趣的问题，只要你能想到的基本都能搜到，于是搜索下。[知乎](https://www.zhihu.com/question/49073893?sort=created)
  
#### 命令格式
		  命令     命令修正  参数
		  commond -options -argument
  
#### 命令位置
* /bin
* /sbin
* /usr/bin
* /usr/sbin
* /usr/local/bin
* /usr/local/sbin

#### 系统
* top:cpu,内存，负载，僵尸进程查看
* iostat:cpu输入输入，cpu使用情况
* df（disk free）：磁盘分区上的可使用的磁盘空间。默认显示单位为KB
* du（disk usage）:命令也是查看使用空间的，但是与df命令不同的是Linux du命令是对文件和目录磁盘使用的空间的查看，还是和df命令有一些区别的
* cpu 核数 grep "physical id"| wc -l

#### 网络
* ssh
* ssh-add：[应用](https://www.cnblogs.com/edward2013/p/5396254.html)
* 查看Linux服务器有多少个用户连接ssh的方法：
  * 查看：who
  * 如果想要断开某个ssh 用户 可以在命令行输入 ：ps aux |grep sshd 
  * 得到pid 再用命令关闭那个pid: kill -111

#### 进程
* ps 
* kill 
 * -3
 * -9
 * -15 

#### 文件
* grep 
* awk
* sort
* uniq
* head
* tail