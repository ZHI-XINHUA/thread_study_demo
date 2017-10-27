# 线程学习
### JDK并发包
**1、ReentrantLock（重入锁）**
>  ReentrantLock：重入锁可以完全替换synchronized关键字，重入锁的性能远远好于synchronized。
 *  lock()：获得锁，如果锁已经被占用，则等待
 *  lockInterruptibly()：获得锁，但优先响应中断
 *  tryLock()：尝试获得锁，如果成功，返回true，失败返回false。该方法不等待，立即返回
 *  tryLock(long time,TimeUnit unit)：在给定时间内尝试获得锁
 *  unlock()：释放锁

**2、Condition（重入锁的好搭档）**
> Condition:它和wait()和notify()方法的作用大致相同，但是wait()和notify()是和synchronized关键字合作使用，而Condition是与重入锁相关联的。
 * await():方法会使当前线程等待，同时释放当前锁，当其他线程使用signal()或signalAll()方法时，线程会重现获取锁并继续执行。或者当前线程被中断时，也就能跳出等待。者和Object.wait()很相似。
 * awaitUninterruptibly():与await()基本相同，但是它并不会在等待过程中响应中断。
 * signal():唤醒一个在等待中的线程，这和Object.notify()很类似。
 * signalAll():唤醒所有在等待中的线程。
 
 **3、BlockingQueue（信号量）**
>信号量指定多个线程，同时访问某一个资源

**4、ReadWriteLock（读写锁）**

|| 读 | 写|
|--|--|--|
|读|非阻塞|阻塞|
|写|阻塞|阻塞|

```java
  ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  Lock readLock = readWriteLock.readLock();//读锁
  Lock writeLock = readWriteLock.writeLock();//写锁
```


**5、CountDownLatch（倒计时器）**
>多线程控制工具类，用来控制线程等待，它可以让某一个线程等待知道倒计时结束，再开始执行

**6、CyclicBarrier（循环栅栏）**
>CyclicBarrier:和CountDownLatch非常类似，它也可以实现线程间的计数等待，但它的功能比CountDownLatch更加复杂且强大。Cyclic意为循环，也就是说这个计数器可以反复使用。比如，假设我们将计数器设置为10，那么凑齐第一批10个线程后，计数器就会归零，然后接着凑齐下一批10个线程，这就是循环栅栏内在的含义。（如：跑步，10个人准备好后一抢令下一起起跑；接着下一批开始。

### 并发Queue
![image](https://github.com/ZHI-XINHUA/imageResource/blob/master/queue1.png)

**1、ConcurrentLinkedQueue**
>是一个使用鱼高并发场景下的队列，通过无锁的方式，实现来高并发状态下的高性能，通常ConcurrentLinkedQueue性能好于BlockingQueue。它是一个基于链接节点的无界线程安全队列。该队列的元素遵循先进先出的原则，该队列不允许null元素
- add()和offer()都是加入元素的方法（在ConcurrentLinkedQueue中没有任务区别）
- pool()和peek()都是取头节点，区别在于前者会删除元素，后者不会

**2、BlockingQueue**
- ArrayBlockingQueue
    >基于数组的阻塞队列实现，在ArrayBlockingQueue内部为何一个 定长数组，以便缓存队列中的数据对象，其内部实现读写分离，也就意味着生产和消费不能完全并行，长度是需要定义的，可以指定先进先出或者先进后出，也叫有界队列。

- LinkedBlockbingQueue
    >基于链表的阻塞队列，同ArrayBlockingQueue类似，其内部也维持着一个数据缓冲队列（该队列由一个链表构成），LinkedBlockbingQueue之所以能够高效的处理并发数据，是因为其内部实现采用分离锁（读写分离两个锁），从而实现生产者和消费者操作的完全并行运行，是一个无界队列。

- PriorityBlockingQueue
    >基于优先级的阻塞队列（有限级的判断通过构造函数传入的Compator对象来决定，也就是说传入队列的对象必须实现Comparable接口），在实现PriorityBlockingQueue时，内部控制线程同步的锁采用的是公平锁，他也是一个无界的队列。

- SynchronousQueue
    > 一种没有缓冲的队列，生产者生产的数据会直接被消费者获取并消费。

- DelayQueue
    >带有延迟时间的Queue，其中的元素只有当其指定的延迟时间到了，才能够从队列中获取得到该元素。DelayQueue中的元素必须实现Delayed接口，DelayQueue是一个没有大小限制的队列。应用场景很多，比如对缓存超时的数据进行移除、任务超时处理、空闲连接的关闭等等
    
    
### 并行模式
   **Future模式**
>&nbsp;&nbsp;Future模式是多线程开发中非常常见的一种设计模式，核心思想是异步调用。<br>
    &nbsp;&nbsp;当我们调用一个函数方法时，如果这个函数执行很慢，那么我们就要进行等待。但是这个时候，我们可能不着急获取结果。因此，我们可以让被调用者立即返回，让它在后台慢慢处理这个请求。对于调用者来说，则可以先处理一些其它任务，在真正需要数据的场合再去尝试获取需要的数据。<br>
    &nbsp;&nbsp;Future模式虽然无法立即给出你需要的数据，但是它会返回一个契约，以后可以凭借这个契约重新获取你所需要的数据。
    
- Future模式流程图模式

![流程图](https://github.com/ZHI-XINHUA/imageResource/blob/master/future.png)

- 常用的方法
    * V get() 获取返回对象
    * V get(long timeout, TimeUnit unit) 获取返回对象，可以设置超时实际
    * boolean isDone() 是否已完成
    * boolean isCancelled() 是否已取消
    * boolean cancel(boolean mayInterruptIfRunning) 取消任务
