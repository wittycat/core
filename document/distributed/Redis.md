### redis数据类型
* 字符串 哈希 列表 Set（集合） 有序集合（zset）
#### redis集群的几种方式详细说一下
* 单机
* 主从(replication)：一主一（多）从
* 哨兵(sentinel)：master失败后，选举制度
* cluster集群：分卡槽存储
* 具体 https://blog.csdn.net/dage_188/article/details/123236839
#### redis缓存穿透（cache无，db无） 缓存击穿（cache过期无，db有）  缓存雪崩（cache大量同期过期）
* https://baijiahao.baidu.com/s?id=1681691345944318719&wfr=spider&for=pc
### 如何保障数据一致性
* 先更新DB,再删除缓存:可以保证数据一致性
* 先删除缓存,再更新DB:造成数据不一致
### redis为何快
* Redis是单线程模型的，而单线程避免了CPU不必要的上下文切换和竞争锁的消耗。也正因为是单线程，如果某个命令执行过长（如hgetall命令），会造成阻塞。Redis是面向快速执行场景的数据库。，所以要慎用如smembers和lrange、hgetall等命令。