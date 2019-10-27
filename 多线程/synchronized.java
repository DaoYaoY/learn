//多线程的同步
//synchronized修饰代码块：对括号内的对象object加锁，只有拿到对象锁标记的线程才可以进入代码块
public void push(char c){
	synchronized(object){//object只要是对象就可以，但必须保证是同一对象
	...	
	同步代码
	...
	}
}


//synchronized修饰方法：在整个方法范围内对当前对象的加锁，只有拿到对象锁标记的线程才能执行该方法，尽可能少用
public synchronized void push(char c){
	...
	同步代码
	...
}

/**
*一个线程可以拥有多个对象的锁标记，锁标记如果过多，可能会造成锁死
*
*静态方法可以是同步方法：但是他锁的并不是当前对象而是类对象
*
*抽象方法不能是synchronized同步的方法
*
*构造方法不能是synchronized同步方法
**/

//wait()与sleep()实例

public class MultiThread{
	public static void main(String[] args) {
		new Thread(new Thread1()).start();
		try{
			Thread.sleep(10);

		}catch(InterruptedException e){
			e.printStackTrace();
		}
		new Thread(new Thread2()).start();
	}

	private static class Thread1 implements Runnable{
		public void run(){
			//由于这里的Thread1和下面的Thread2内部run方法要用同一对象作为监视器，我们这里不能用this，
			//因为Thread2里面的this和这个Thread1的this不是同一个对象。我们用MultiThread.class这个字节码对象，当前虚拟机里引用这个变量时，指向的都是同一个对象
			synchronized(MultiThread.class){
				System.out.println("enter thread1...");
				System.out.println("thread1 is waiting");
				try{
					//释放锁有两种方式，第一种方式是程序自然离开监视器的范围，也就是离开了synchronized关键字管辖的代码范围
					//另一种方式就是在synchronized关键字管辖的代码内部调用监视器对象的wait方法。这里用wait()释放对象锁。
					MultiThread.class.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("thread1 is going on ...")
				System.out.println("thread1 is being over!");
			}
		}
	}

	private static class Thread2 implements Runnable{
		public void run(){
			synchronized(MultiThread.class){
				System.out.println("enter thread2");
				System.out.println("thread2 notify other thread can release wait status..");
				//由于notify方法并不释放锁，即使thread2调用下面的sleep方法休息了10毫秒，但thread1任然不会执行，因为thread2没有释放锁，所以Thread1无法得不到锁。
				MultiThread.class.notify();
				System.out.println("thread2 is sleeping ten millisecond...");
				try{
					Thread.sleep(10);

				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("thread2 is going on...");
				System.out.println("thread2 is being over!");
			}
		}
	}

}
