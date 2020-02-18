package cn.itjinxun.Collection;

import org.junit.Test;

import java.util.*;

public class QueueTest {
    /*
    * 队列 Queue
    *   队列指的是一种在队尾插入元素，在队头删除元素
    *   两端队列：可以在队尾队头同时进行插入或删除
    * 队列的特点：
    *   只能对队头或者队尾的元素进行操作，而不能对中间的元素进行操作
    *   先进先出：FIFO
    *   先进后出
    * 队列的两个接口：Queue、Deque
    * 队列的两个实现类：
    *   1、LinkedList：具有队列，两端队列的功能，内部使用链表来实现；
    *   2、ArrayDeque：具有队列，两端队列的功能，内部使用循环数组来实现；
    *   3、PriorityQueue：优先级队列，它内部实现结构可以快速把所有元素中最小的元素单独放出来，
    *                       最典型的应用场景：任务调度
    * 两个应用场景：任务调度，LRU
    * 两个用具：Arrays，Collections
    * */
    @Test
    public void test1(){
        //队列
        //Queue 接口的方法
        Queue<String> queue = new LinkedList();
        //增删改查
        //添加
        //add(E)/offer(E)
        //在队列元素未满的情况下，添加元素到队列的尾部
        //如果队列已满：
        //  add 抛异常 IllegalStateException
        //  offer 返回 false
        queue.add("str1");
        queue.add("str3");
        queue.offer("str2");
        queue.offer("str4");
        System.out.println(queue);
        //删除
        //remove/poll
        //如果队列不为空，删除并返回队头元素
        //如果队列为空：
        //  remove 抛异常 noSuchElementException
        //      如果使用 remove 来获取队尾元素时，remove 前需要判断队列是否为空
        //           size() == 0，isEmpty()
        //  poll 返回 null
        //      如果使用 remove 来获取队尾元素时，获取结果后，先判断结果是否为 null
        /*System.out.println("remove:"+queue.remove());
        System.out.println(queue);
        System.out.println("remove:"+queue.remove());
        System.out.println(queue);
        System.out.println("poll:"+queue.poll());
        System.out.println(queue);
        System.out.println("poll:"+queue.poll());
        System.out.println(queue);
        System.out.println("poll:"+queue.poll());
        System.out.println("remove:"+queue.remove());*/
        //查，仅查看队头元素是什么，不删除
        //element/peek
        //如果队列不为空，返回队列的头部元素，但不删除
        //如果队列为空：
        //  element 抛异常 noSuchElementException
        //  peek 返回 null
        //注意：
        //  调用 element 方法前需要判断队列是否为空
        //  调用 peek 方法后先判断返回结果是否为 null
        queue.clear();
        System.out.println(queue);
        System.out.println("队头元素peek()="+queue.peek());
        System.out.println("队头元素element()="+queue.element());
        System.out.println(queue);

        //改，一般没有修改操作
    }

    @Test
    public void test2(){
        //两端队列Deque：增删查改
        Deque<String> deque = new ArrayDeque();
        //增（Queue:add/offer）
        //addFirst/addLast/offerFirst/offerLast
        //  如果队列未满，在队头或者队尾添加元素
        //  如果队列已满：
        //      addFirst/addLast 抛异常 IllegalStateException
        //      offerFirst/offerLast 返回 false
        deque.addFirst("str1");
        deque.addLast("str3");
        deque.offerFirst("str2");
        deque.offerLast("str4");
        System.out.println(deque);
        //删（Queue:remove/poll）
        //removeFirst/removeLast/pollFirst/pollLast
        //  如果队列非空，删除并返回队头或者队尾的元素
        //  如果队列为空：
        //      removeFirst/removeLast 抛异常 noSuchElementException
        //      pollFirst/pollLast 返回 null
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);
        //System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());

        //查（Queue:element/peek）
        //getFirst/getLast/peekFirst/peekLast
        //  如果队列非空，返回队头或者队尾的元素，但不删除
        //  如果队列为空：
        //      getFirst/getLast 抛异常 noSuchElementException
        //      peekFirst/peekLast 返回 null
        deque.clear();
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

    }

    @Test
    public void test3(){
        //优先级队列：任务调度
        //特点：内部使用了一种堆的数据结构，是一种自我调整的二叉树
        //      当向队列中添加/删除元素的时候，它能快速的找到队列中最小的元素
        //      并且移动到树的根部，而不是对所有元素进行排序
        //对优先级队列进行遍历的时候，无序
        PriorityQueue<String> pq = new PriorityQueue();
        pq.add("1");
        pq.add("3");
        pq.add("5");
        pq.add("7");
        pq.add("2");
        pq.add("4");
        pq.add("6");
        pq.add("8");
        //数组或者实现了Iterator接口的类可以使用 for each 语法
        for (String str : pq) {
            System.out.println(">"+str);
        }
        System.out.println("get");
        //remove 删除并返回队列中最小的元素
        //如果队列为空则抛 NoSuchElementException 异常
        //remove 方法之前判断队列是否为空
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        //System.out.println(pq.remove());
        //优先级队列如何查找最小元素：
        //  1、构建时指定 Comparator 接口
        //  2、或者存放元素实现 Comparable 接口
        PriorityQueue<Task> tasks = new PriorityQueue<>(
                new Comparator<Task>() {
                    @Override
                    public int compare(Task o1, Task o2) {
                        if(o1.priority < o2.priority){
                            return -1;
                        }
                        if(o1.priority == o2.priority){
                            return 0;
                        }
                        return 1;
                    }
                }
        );
        for (int i = 0; i < 10; i++) {
            int priority = new Random().nextInt(10);
            tasks.add(new Task(priority,"任务"+(i+1)));
        }
        System.out.println(tasks);
        //执行任务
        while(true){
            if(tasks.isEmpty()){
                System.out.println("任务执行完成，退出");
                break;
            }
            Task task = tasks.remove();
            //System.out.println("执行任务："+task.name+"，优先级："+task.priority);
            //提高代码可读性
            System.out.println(String.format("执行任务：%s，优先级：%d",task.name,task.priority));
        }
        // 、、
    }

    static class Task{
        private int priority;
        private String name;

        public Task(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public String toString() {
            return "任务"+name+"("+priority+")";
        }
    }

    @Test
    public void test4(){
        //LRU:Least Recently Used，最近最少使用
        //缓存：缓存热点数据，经常使用的数据
        //缓存的一种淘汰算法
        //当缓存已满时，再向缓存内添加内容时，
        //删除（淘汰）掉缓存中已存在元素最近最少被使用的那个

        //LinkedHashMap 支持 LRU 算法
        //LinkedHashMap 具有 HashMap 的所有功能 + 可保持插入顺序（遍历）
        //HashMap + 双向链表
        //双向链表：head/tail, after/before
        //LinkedHashMap 是有序的 boolean accessOrder
        //  1、插入顺序：每次插入元素，将元素放到双向链表的末尾
        //  2、访问顺序：每次插入元素/获取元素，将插入的元素或者访问的元素放到双向链表的末尾
        LRU<String,String> lru = new LRU<>();
        lru.put("001","张三");
        lru.put("002","李四");
        lru.put("003","王五");
        lru.put("004","赵六");
        lru.put("005","胡七");
        System.out.println(lru);

        System.out.println(lru.get("003"));
        System.out.println(lru);

        System.out.println(lru.get("001"));
        System.out.println(lru);

        lru.put("006","魏八");
        System.out.println(lru);

        lru.put("005","钱七");
        System.out.println(lru);

        lru.put("007","孙九");
        System.out.println(lru);
        //  ..
    }

    static class LRU<K,V> extends LinkedHashMap<K,V> implements Map<K,V>{
        private int maxCount = 6;
        public LRU(){
            super(10,0.75f,true);
        }

        public LRU(int maxCount){
            super(10,0.75f,true);
            this.maxCount = maxCount;
        }

        //参数：eldest 最近最少使用的元素
        //当调用 put 方法时，并且 Key 值不存在时调用
        @Override
        protected boolean removeEldestEntry(Entry<K, V> eldest) {
            boolean remove = size() > maxCount;
            if(remove){
                System.out.println("淘汰最近最少使用元素：" + eldest);
                return true;
            }
            return false;
        }
    }
}
