#### volatile和synchronized的区别
* volatile仅能使用在变量级别,synchronized则可以使用在变量,方法
* volatile本质是在告诉jvm当前变量在寄存器中的值是不确定的,需要从主存中读取,synchronized则是锁定当前变量,只有当前线程可以访问该变量,其他线程被阻塞住
* 多线程访问volatile变量不会发生阻塞，而synchronized可能会阻塞。
* volatile能保证数据的可见性，但是不能保证原子性；而synchronized可以保证原子性，也可以保证可见性。
* 关键字volatile解决的是变量在多个线程之间的可见性；synchronized关键字解决多个线程之间访问公共资源的同步性。
#### synchronized和lock区别
* Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
* synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；
* Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；
#### 大顶堆小顶堆怎么删除根节点

#### CSRF攻击是什么，怎么预防

#### 快速排序的思想?
* 先从数列中选取一个数作为基准数
* 分区过程中,将比这个数大的数放在它的右边,小于或等于它的数全放在它的左边
* 重复上一个步骤,知道左右区间只剩下一个数
#### HashMap
* 为什么HashMap线程不安全?
  
* 1.7环形成

    https://www.bilibili.com/video/BV1n541177Ea?spm_id_from=333.337.search-card.all.click&vd_source=a30bba17223939a1bea53d90c11ab6f3
    
    头插入法
    
    ![](./hashmap扩容形成环过程.png "hashmap扩容形成环过程")
