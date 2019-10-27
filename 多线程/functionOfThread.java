//Thread中的一些方法
currentThread();
//返回对当前正在执行的线程对象的引用（实现接口方式时使用）
sleep(long millis);
//在指定的毫秒数内让当前执行的线程休眠（暂停执行）
yield()
//暂停当前正在执行的线程对象，并执行其他线程，只给本类或者优先级大于本类优先级的线程去抢
join()
//等待该线程终止，放在start之前则没有用处。
setDaemon(boolean on)
//该线程标记为守护线程，守护线程需要依赖其他线程，会在虚拟机停止的时候停止