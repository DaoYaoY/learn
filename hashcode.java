//hashcode方法可以这样理解：它返回的就是根据一个对象的内存地址换算出的一个值。
//equals与hashcode都是从object类中继承来的。
//equals在object中的实现为：
public boolean equals(Object obj){
	retuen (this == obj);
}
//明显是两个对象的地址值进行比较。
//double interger string math等这些封装类都是 覆盖了object中的equals方法
public boolean equals(Object obj){
	if (this == obj){
		return true;
	}
	if (obj instanceof String){
		String otherStrng = (String)obj;
		int n = count;
		if (n == otherStrng.count) {
			char v1[] = value;
			char v2[] = otherStrng.value;
			int i = offset;
			int j = otherStrng.offset;
			while(n-- != 0){
				if (v1[i++] != v2[j++]) {
					return false;
				}
			}
			return true;
		}
	}
	return false;
}


//String类型中的hashcode
public int hashCode(){
	int h = hash;
	if (h == 0) {
		int off = offset;
		char val[] = value;
		int len = count;

		for (int i = 0;i<len ;i++) {
			h = 31*h + val[off++];
		}
		hash = h;

	}
	return h;
}

//String的API这样写道：
//s[0]*31^(n-1) + s[1]*31^(n-2) + ...+ s[n-1]      ^表示求幂

//hashmap,hashset,hashtable
//Hashset是继承Set接口，Set接口又实现Collection接口。hashset不允许出现重复对象；判断是否重复是根据
//1.判断两个对象的hashcode是否相等，如果不相等，则认为两个对象不相等，如果相等则转入条件 2 
//2.判断两个对象用equals运算是否相等。

public static void main(String[] args) {
	String s1 = new String("zhangsan");
	String s1 = new String("zhangsan");
	System.out.println(s1==s2);//false
	System.out.println(s1.hashCode(s2));//true
	System.out.println(s2.hashCode());
	Set hashset = new HashSet();
	hashset.add(s1);
	hashset.add(s2);
	System.out.println(hashset.size());//1
}

import java.util.ArrayList;
import java.util.Collection;
public class Point{
	private int x;
	private int y;
	public Point(int x,int y){
		super();
		this.x = x;
		this.y = y;  
	}
	public static void main(String[] args) {
		Point p1 = new Point(3,3);
		Point p2 = new Point(5,5);
		Point p3 = new Point(3,3);
		Collection <Point> collection = new ArrayList <Point> ();
		collection.add(p1);
		collection.add(p2);
		collection.add(p3);
		collection.add(p1);
		System。out.println(collection.size());//4 List中可以有重复元素，而且是有序的
	}
}

//将上面的例子稍作改变，用HashSet
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
public class Point{
	private int x;
	private int y;
	public Point(int x,int y){
		super();
		this.x = x;
		this.y = y;  
	}
	public static void main(String[] args) {
		Point p1 = new Point(3,3);
		Point p2 = new Point(5,5);
		Point p3 = new Point(3,3);
		Collection <Point> collection = new HashSet <Point> ();
		collection.add(p1);
		collection.add(p2);
		collection.add(p3);
		collection.add(p1);
		System。out.println(collection.size());//3 hashset中不保存重复对象，并且无序。
	}
}

//hashcode不相等，那么equals方法绝对不相等；hashcode相等，equals方法可能相等，也可能不等。
//equals方法不相等，hashcode不一定不相等。