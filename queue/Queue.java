package cn.chci.yncccy.jucaiyun.z_data_struct.queue;

/**
 * description:
 * author: dujun
 * created at: 2019.7.3 11:08
 * update: 2019.7.3
 * version:
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
