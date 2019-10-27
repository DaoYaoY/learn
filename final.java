//final修饰变量，变量变为常量，一旦赋值不能改变。常量可以在初始化时直接赋值，也可以在构造方法里赋值，只能在两种方法中选一种。
//final修饰方法：该方法不能被其子类覆盖，保持方法的稳定不能被覆盖
//final修饰类：该类不能被继承。
//final类中的方法也是final的；注意final不能修饰构造方法
//final关键字修饰变量时，是指引用变量不能变，引用变量的的对象内容还是可以改变的。

final StringBuffer a = new StringBuffer("immutable");
a = new StringBuffer("");//将报错
a.append("broken!");//编译可以通过


//final finally finalize的区别
//final用来声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承
//内部类要访问局部变量，局部变量必须定义为final类型

//finally：是异常处理语句结构的一部份，是异常的统一出口，表示总是执行

//finalize：是object类的一个方法，在垃圾收集器执行的时候会调用被回对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等