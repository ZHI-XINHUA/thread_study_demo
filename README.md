# 线程学习
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
