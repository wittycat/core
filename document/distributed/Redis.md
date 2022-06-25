#### redis集群的几种方式详细说一下
* 单机
* 主从(replication)
* 哨兵(sentinel)
* cluster集群
* 具体 https://blog.csdn.net/dage_188/article/details/123236839
#### redis缓存穿透（cache无，db无） 缓存击穿（cache过期无，db有）  缓存雪崩（cache大量同期过期）
* https://baijiahao.baidu.com/s?id=1681691345944318719&wfr=spider&for=pc
### 如何保障数据一致性
* 先更新DB,再删除缓存:可以保证数据一致性
* 先删除缓存,再更新DB:造成数据不一致