/**
*Collection的框架如下
*List
**LinkedList
**ArrayList
**Vector
***Stack
*Set
**/

/**
*Map
*Hashtable
*HashMap
*WeakHashMap
**/

//List：有序的存放元素，可重复的集合。
//ArryList：实质就是一个会自动增长的数组。查询效率比较高，适合与查询比较频繁，增删动作较少的元素管理集合。加载大量数据时，先收动扩容（调用ensureCapacity(int minCapacity))方法,这样可以提高效率。
//Set：无序的，不允许有重复元素的集合
//HashSet：Object类中的hashcode()方法是所有类都会继承成的方法，这个方法会拿出一个hash码值返回，HashSet会用hash值去和数组长度取模，对象的模值（对象存放的位置）相同时才会判断数组中的元素和要加入的对象的内容是否相同，如果不同才会找位置添加进去。
//TreeSet:可排序的Set

//SortedSet接口是Set的子接口，TreeSet是SortedSet接口的实现类，他可以对集合中的元素进行排序。
//将自定义的类对象存放在TreeSet中，这个类需要实现了Comparable接口，TreeSet可以自动的过滤掉重复元素，所以不需要重载hashcode()方法，TreeSet会根据比较规则判断元素内容是否相同。
//Comparable接口：
//也可以叫做可比较接口，这个接口在java.lang包下，只要根据指定的类型的排序规则实现了这个接口，就是可排序的。
//这个接口中只定义了一个compareTo(Object o)方法，该方法的返回值类型是整型，如果当前对象大于参数对象就返回正数，当前对象小于参数对象返回负数，等于返回0.

//Comparator接口：
//比较器Comparator接口，是另一种对自定义类型对象的集合整体排序的方法，存在于java.util包下。
//这个接口定义了一个compare(Object o1, Object o2)方法来比较两个对象，返回值和上一个介绍的一样

//HashMap:给予哈希表的Map接口的实现，此实现提供所有可选的映射操作，并允许使用null值和null键。
//遍历：1）先调用keySet()得到key的set集合；2）再遍历key的set集合；根据得到的key得到value。

//Hashtable：同HashMap,一般不使用。

//Hashtable与HashMap的区别：
//HashMap：非线程安全，不支持并发控制，允许空的键值对
//Hashtable：是线程安全的，支持并发控制，不允许有空的键值对
//实现类：TreeMap类。

//hashtable源码
public synchronized V put(K key, V value) {
    //确保value不为null
    if (value == null) {
        throw new NullPointerException();
    }
 
    //确保key不在hashtable中
    //首先，通过hash方法计算key的哈希值，并计算得出index值，确定其在table[]中的位置
    //其次，迭代index索引位置的链表，如果该位置处的链表存在相同的key，则替换value，返回旧的value
    Entry tab[] = table;
    int hash = hash(key);
    int index = (hash & 0x7FFFFFFF) % tab.length;
    for (Entry<K,V> e = tab[index] ; e != null ; e = e.next) {
        if ((e.hash == hash) && e.key.equals(key)) {
            V old = e.value;
            e.value = value;
            return old;
        }
    }
 
    modCount++;
    if (count >= threshold) {
        //如果超过阀值，就进行rehash操作
        rehash();
 
        tab = table;
        hash = hash(key);
        index = (hash & 0x7FFFFFFF) % tab.length;
    }
 
    //将值插入，返回的为null
    Entry<K,V> e = tab[index];
    // 创建新的Entry节点，并将新的Entry插入Hashtable的index位置，并设置e为新的Entry的下一个元素
    tab[index] = new Entry<>(hash, key, value, e);
    count++;
    return null;
}