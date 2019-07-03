package cn.chci.yncccy.jucaiyun.z_data_struct.queue;

/**
 * description: 循环队列
 * author: dujun
 * created at: 2019.7.3 11:57
 * update: 2019.7.3
 * version:
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity) {
        // 预留一个空位置，用来判断数组是否满了
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity(){
        // 减去预留的空间
        return data.length - 1;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 判断队列是否满了
        if ((tail + 1) % data.length == front){
            // 对队列扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    /**
     * 对队列扩容
     * @param newCapatity
     */
    private void resize(int newCapatity) {
        E[] newData = (E[]) new Object[newCapatity +1];
        // 将原来data中的元素放到新的空间中
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("cannot dequeue from empty queue");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        // 对队列缩容
        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }
}
