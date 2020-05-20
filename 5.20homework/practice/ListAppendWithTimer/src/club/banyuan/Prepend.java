package club.banyuan;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 比较在基于数组的列表和基于链表的列表的第一个元素前插入n个值所需的时间
 * <p>
 * 1.创建一个计时器。
 * <p>
 * 2.计算将n个值添加到空链表的时间：
 * a.创建一个空的链表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i插入到list中
 * d.停止计时器
 * e.显示时间
 * <p>
 * 3.计算将n个值添加到空数组列表的时间：
 * a.创建一个空的数组列表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i插入到list中
 * d.停止计时器
 * e.显示时间
 */
public class Prepend implements Timer {
    /**
     * 计时器要保存的时间数据
     */
    private long usedTime = 0;
    private long startTime;
    private long endTime;
    /**
     * 计时器状态
     */
    private boolean isStart = false;
    private boolean isEnd = true;

    /**
     * 开始计时，开始计时后，自动重置时间
     *
     * @throws IllegalStateException 如果已经开始计时后没有停止计时，
     *                               然后再次调用开始计时方法，抛出此异常
     *                               System.currentTimeMillis()方法返回数据类型是long的当前时间毫秒值
     */
    @Override
    public void start() throws IllegalStateException {
        reset();
        if (!isStart && !isEnd) {
            throw new IllegalStateException();
        }
        isStart = true;
        startTime = System.currentTimeMillis();//开始时间
    }

    /**
     * 停止计时
     *
     * @throws IllegalStateException 如果没有开始计时调用停止计时方法，
     *                               抛出此异常
     */
    @Override
    public void stop() throws IllegalStateException {
        if (!isStart && isEnd) {
            throw new IllegalStateException();
        }
        endTime = System.currentTimeMillis();//结束时间
        isStart = false;
    }

    /**
     * 计时器清零
     */
    @Override
    public void reset() {
        usedTime = 0;
    }

    /**
     * 返回开始时间到结束时间花费的毫秒值
     *
     * @return
     */
    @Override
    public long getTimeMillisecond() {
        return usedTime = endTime - startTime;
    }

    public static void main(String args[]) {
        Prepend append = new Prepend();

        /**
         * 创建一个空链表
         */
        LinkedList<Integer> linkedList = new LinkedList<>();

        append.start();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, i);
        }
        append.stop();
        System.out.print("添加到空链表所用时间为:");
        System.out.println(append.getTimeMillisecond() + "毫秒");

        /**
         * 创建一个空数组
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        append.start();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, i);
        }
        append.stop();
        System.out.print("添加到空数组所用时间为:");
        System.out.println(append.getTimeMillisecond() + "毫秒");
    }
}