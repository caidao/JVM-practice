###  java基础知识

### 1.数据结构——HashMap
它根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序是不确定的。HashMap最多只允许一条记录的键为null，允许多条记录的值为null。HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap， 可能会导致数据的不一致。如果需要满足线程安全，可以用 Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。
+ 通过数组+链表+红黑树实现的哈希表
+ hash值取的是hashCode与其高16位的异或，如`val ^ (val>>>16)`，这么做可以在数组的length比较小的时候，也能保证考虑到高低Bit都参与到Hash的计算中，同时不会有太大的开销
+ 哈希桶数组 `transient Node[] table`,transient表示该变量不能进行序列化操作，Node节点本质上是键值对Map.Entry。
+ 解决冲突的方式：通过链地址法，每个数组元素上都是一个链表结构
+ 如何减少hash碰撞的概率，并且使得table空间占用少？：hash算法和扩容机制
+ table大小length大小必须为2的n次方（优化）、负载因子factor、键值对个数size；threshold = length * Load factor
+ 负载因子越大，所能容乃的键值个数越多
+ 当拉链过长的时候，会严重影响HashMap的性能，JDK1.8对数据结构进行了优化，引入了红黑树，利用红黑树快速增删改查的特点提高HashMap的性能
+ 功能实现方法：
    + A、确定哈希通数组的索引位置：取key的hashCode值、高位运算、取模运算（计算`table[i]`的索引位置）。
    + B、分析HashMap的put方法:查找数组索引节点、若链表长度过大就转换为红黑树、是否需要扩容、
    + C、扩容机制：定义新的数组newTab、将旧的值copy到newTab、反转倒置链表；jdk8的优化（不需要像JDK1.7的实现那样重新计算hash，只需要看看原来的hash值新增的那个bit是1还是0就好了，是0的话索引没变，是1的话索引变成“原索引+oldCap，而且不会倒置链表，做法是将长链表拆成两个小链表再加到tab中）
    + D、线程安全性C:不安全，多线程同时触发rehash操作，容易出现环线链 [JAVA HASHMAP的死循环](http://coolshell.cn/articles/9606.html)