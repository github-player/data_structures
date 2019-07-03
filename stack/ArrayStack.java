package cn.chci.yncccy.jucaiyun.z_data_struct.stack;

import cn.chci.yncccy.jucaiyun.z_data_struct.array.Array;

/**
 * description:
 * author: dujun
 * created at: 2019.7.3 09:54
 * update: 2019.7.3
 * version:
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }


    public int getCapacity(){
        return array.getCapacity();
    }
}
