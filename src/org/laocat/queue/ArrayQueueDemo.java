package org.laocat.queue;

import java.util.Arrays;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.show();
        System.out.println(queue.showHead());

        System.out.println(queue.pop());
        queue.show();
        System.out.println(queue.showHead());

        System.out.println(queue.pop());
        queue.show();
        System.out.println(queue.showHead());
    }
}

class ArrayQueue {
    // 队列的最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列位
    private int rear;
    // 存放数据
    private int[] arr;

    // 创建队列
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        // 指向队列头部前一个位置
        front = -1;
        // 指向队列尾 队列最后一个数据
        rear = -1;
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize-1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加
    public void add(int n) {
        if (isFull()) {
            System.out.println("已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    // 出
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("null");
        }
        front++;
        return arr[front];
    }

    // show
    public void show() {
        if (isEmpty()) {
            System.out.println("为空");
            return;
        }

        System.out.println(Arrays.toString(arr));
    }

    // 展示头
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("null");
        }

        return arr[front + 1];
    }
}