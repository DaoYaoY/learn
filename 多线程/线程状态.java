//线程的生命周期
/**
*1）初始状态：此时线程只是处于JVM进程中，只是创建了一个线程对象，并没有开始运行
*2）可运行状态：调用线程的Start()方法，此时线程才真正呗创建，进入可运行状态，等待CPU调度
*3）运行状态：正在运行的线程，此时拥有CPU的执行权
*4）阻塞状态：运行状态中的线程，如果正在等待用户输入或调用了sleep()和join()等方法都会导致线程进入阻塞状态，
*从阻塞状态出来后，线程进入可运行状态
*5）等待队列状态：一个线程调用一个对象的wait()会自动放弃该对象的锁标记，进入等待队列状态，只有当有另外一个线程调用临界资源(对象)
*的notify()或notifyAll()方法，建议多使用notifyAll()，才会将等待队列中的线程释放，此时线程进入锁池状态
*6）锁池状态：每个对象都有互斥锁标记，以防对临界资源的访问造成数据的不一致，和数据的不完整性。
*一个线程拥有一个对象的锁标记后，另一个线程想访问该对象，必须在锁池等待。
*由系统决定哪个线程拿到锁标记并运行。注意从锁池状态出来后，是进入到可运行状态。
*7）终止状态：一个线程运行结束后称为终止状态，一个进程中只有所有的线程都退出后才会终止。
***/
