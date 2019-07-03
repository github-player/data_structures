package cn.chci.yncccy.jucaiyun.z_data_struct.queue;

import cn.chci.yncccy.jucaiyun.z_data_struct.array.Array;

/**
 * description:
 * author: dujun
 * created at: 2019.7.3 11:11
 * update: 2019.7.3
 * version:
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }


    public int getCatacity(){
        return array.getCapacity();
    }
}
