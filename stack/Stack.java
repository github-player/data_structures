package cn.chci.yncccy.jucaiyun.z_data_struct.stack;

/**
 * description:
 * author: dujun
 * created at: 2019.7.3 09:52
 * update: 2019.7.3
 * version:
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
