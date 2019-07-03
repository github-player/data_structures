package cn.chci.yncccy.jucaiyun.z_data_struct.array;

/**
 * description: 自定义数组
 * author: dujun
 * created at: 2019.7.3 09:23 
 * update: 2019.7.3
 * version: 
 */
public class Array<E> {

    private E[] data;
    // 数组元素的个数
    private int size;


    /**
     * 构造函数，
     * @param capacity 数组的容量
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认容量为10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在index位置插入一个新元素
     * @param index
     * @param e
     */
    public void add(int index, E e){
        // 判断传入的index是否超出数组元素个数或者负数
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        // 如果数组元素的个数等于了数组的容量，则扩容 扩容大小为 2倍初始容量
        if(size == data.length)
            resize(2 * data.length);

        // index后面的元素向后挪1位
        for(int i = size - 1; i >= index ; i --)
            data[i + 1] = data[i];

        data[index] = e;

        size ++;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e){
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0, e);
    }

    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        // 获取要删除的元素
        E ret = data[index];
        // 把index后面的元素向前挪一位
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        // 将末尾的元素置空
        data[size] = null; // loitering objects != memory leak

        // 如果数组元素的个数少于数组容量的 四分之1， 则数组的容量减少1半 （lazy）
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity){
        // 创建新容量的数组
        E[] newData = (E[])new Object[newCapacity];
        // 将原来的数组的元素复制到新数组上
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[i];
        // 将数组的引用指向新的数组
        data = newData;
    }


    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }
}
