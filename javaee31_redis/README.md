### redis的5中数据类型

> redis常用语法：

- 命令关键词不区分大小写，如hgetall，hgetAll，HGetAll等都可以，一般用小写即可；
- 字段区分大小写：如myset，mySet等为不同的set集合字段；
- 当字段内数据为空时，字段也不复存在;
```
- del field: 删除字段，可以删除5种类型数据，直接删除；
- keys *: 查询所有的键，5中类型；
- keys my*: 模糊查询当前数据库的键
- keys my???: 占位符？，模糊查询
- exists field: 是否存在指定的键
- type field: 获取指定键的类型
- select dbNum(0-15): 选择指定的数据库，0~15
- move field dbNum(0-15):某个键移动到另一个数据库中，如果另一个数据库中有同名的键，则移动失败
- expire field 秒: 设置键的国企时间，过期后不再可用。
- TTL field: 返回指定键的剩余时间（ttl,time to live）
```

> String字符串类型
```redis
描述：数据为单个键值对。

使用：
set: 增加键值对，如果键已经存在，就是覆盖修改；
    set company huawei
    set player jordan
    
get: 获取指定键的值；
    get company
    get aa 获取不存在的键，返回nil
    
del: 删除键，可以一次性删除多个键；
    del company jordan
```

> hash表类型
```redis
描述：相当于一张表，存储的数据有序，可重复，数据都是键值对，类似于map集合;
    该类型非常适合于存储对象的信息。
使用：
hset: 添加一个数据，重复则覆盖
    hset myHash name hsc
    
hmset: 添加多个数据
    hmset myHash age 23 hobby music
    
hget: 获取一个数据
    hget myHash name
    
hmget: 获取多个数据
    hmget myHash name hobby
    
hdel: 删除数据，可以一次性删除多个。
    hdel myHash age 
    hdel myHash name age
    
hgetAll: 获取表中所有数据，返回键和值
    hgetall myHash  
```

> list链表类型
```redis
描述：list为链表，类似LinkedLlist，可以在其左部(left)和右部(right)添加新的元素；
    如果list链表中所有的元素均被移除，那么该键也将会被从数据库中删除；
    list的数据是有序，可重复的；
    链表从左往右：0,1,2,3...;从右往左：-1,-2,-3...
    
使用：
llen: 获取list表的长度，数据个数
    llen myList
    
lrange: 获取某一范围内数据，从左到右，没有从右至左
    lrange myList 0 -1
    
lpush,rpush: 在左侧或右侧进栈（添加）数据，可以一次性添加多个
    lpush myList a b c  
    rpush myList  1 2 3
    结果：c b a 1 2 3
    
lpop,rpop: 在左侧或右侧弹出（删除）数据，一次只能删除一个
    lpop myList
    rpop myList
```

> set集合
```redis
描述：set集合，不可重复，无序

使用：
sadd: 添加数据，可以一次性添加多个数据
    sadd mySet name zhangsan age 12 birthday 2000-08-21
    
smembers: 查询所有数据
    smembers mySet
    
sismember: 判断是否是set中的成员
    sismember mySet age        

srem: remove 删除指定的一个或多个元素
    srem mySet name age
```

> zset有序集合
```redis
描述：有序集合存储的数据是字符串，每个字符串都会关联一个分数，依靠分数从小到大排序；
    有序集合分数可以重复，字符串数据不可重复。
    
使用：
zadd: 添加数据
    zadd myZset 3 zhangsan 7 lisi 5 wangwu
    
zrem: 删除数据
    zrem myZset wangwu
    
zrange: 通过索引区间返回有序集合中指定区间内的成员
    zrange myZset 0 -1
    
zcard: 获取有序集合的成员数
    zcard myZset   
    
zrank: 获取指定值的索引
    zrank myZset wangwu             
```