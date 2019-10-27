//线程编程的两种方法
//1.继承Thread类，覆盖Thread类的run()方法
class MyThread extends Thread{
	public void run(){
		//覆盖run方法
	}
}

//启动线程

public class TestThread{
	public static void main(String[] args) {
		Thread t1 = new MyThread();
		t1.start();//调用start()启动线程，为一种可运行状态
	}
}

//写一个类，实现Runable接口，实现其中的run()方法。
Class MyThread implements Runnable {
	public void run(){

	}
}
//启动线程
public class TestThread{
	public static void main(String[] args) {
		Runnable myThread = new MyThread();
		Thread t = new Thread(myThread);//作为线程类创建时的参数
		t.start();
	}
}

//以下方法不常用
ExecutorService pool = Executors.newFixedThreadPool(3);
for (int i=0;i<10 ;i++ ) {
	pool.execute(new Runnable(){public void run(){}});

}
Executors.newCachedThreadPool().execute(new Runnable(){public void run(){}});
Executors.newSingleThreadExcutor().execute(new Runnable(){public void run(){}});