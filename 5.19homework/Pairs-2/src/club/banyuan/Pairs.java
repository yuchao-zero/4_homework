package club.banyuan;

import java.util.Iterator;

public class Pairs<K, V> implements Iterable<Pair<K, V>> {

    /* 声明一对对象的固定大小的数组（最多10个元素） */
    /**
     * 数组
     * 数组固定大小
     * 记录当前数组大小
     */
    private Pair<K, V>[] pair;
    private final int capacity = 10;
    private int size;
    private int index;


    /**
     * 创建一个集合，该集合将存储成对添加的项目。
     * 构造方法
     */
    public Pairs() {
        pair =new Pair[capacity];
        size = 0;
        index = 0;
    }

    /**
     * 创建一个新的对，并在有空间的情况下将其添加到集合中。
     *
     * @param first  The first object.
     * @param second The second object.
     */
    public boolean addPair(K first, V second) {
        if(size == capacity){
            return false;
        }
        pair[size++] = new Pair<>(first, second);
        return true;
    }


    @Override
    public Iterator<Pair<K, V>> iterator() {
        index = 0;
        return new PairIterator();
    }

    /*
     * 根据以下位置的API文档在此处实现迭代器
     * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html
     * 按照规定抛出异常
     */
    private class PairIterator implements Iterator<Pair<K, V>> {

        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * 返回迭代器中的下一个对象
         */
        @Override
        public Pair<K, V> next() {
            if (hasNext()) {
                return pair[index++];
            }
            throw new UnsupportedOperationException();
        }

        /**
         * 从集合中移除next（）返回的上一个对象。
         */
        @Override
        public void remove() {
            if (index == size) {
                pair[--size] = null;
            } else if (index < size) {
                System.arraycopy(pair, index, pair, index - 1, size - index);
                pair[--size] = null;
            }else {
                throw new UnsupportedOperationException();
            }
        }
    }

}