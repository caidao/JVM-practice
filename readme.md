###  java基础知识

### 1.数据结构——HashMap
它根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序是不确定的。HashMap最多只允许一条记录的键为null，允许多条记录的值为null。HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap， 可能会导致数据的不一致。如果需要满足线程安全，可以用 Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。
+ 通过数组+链表+红黑树实现的哈希表
+ hash值取的是hashCode与其高16位的异或，如`val ^ (val>>>16)`
+ 哈希桶数组 `transient Node[] table`,transient表示该变量不能进行序列化操作，Node节点本质上是键值对Map.Entry。
+ 解决冲突的方式：通过链地址法，每个数组元素上都是一个链表结构
+ 如何减少hash碰撞的概率，并且使得table空间占用少？：hash算法和扩容机制
+ table大小length、负载因子factor、键值对个数size；threshold = length * Load factor
+ 负载因子越大，所能容乃的键值个数越多