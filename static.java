//static  可以修饰属性、方法、代码块和内部类
//静态方法内不能出现this关键词
//动态初始代码块

class UseStatic{
	static int a = 3;
	static int b;

	static void meth(int x){
		
		System.out.println("x = "+ x);
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);
	}

	static{
		System.out.println("static block initialized");
		b = a * 4;
	}

	public static void main(String[] args) {
		meth();
	}
}
//一旦UseStatic类被挂载，所有的static语句被执行。