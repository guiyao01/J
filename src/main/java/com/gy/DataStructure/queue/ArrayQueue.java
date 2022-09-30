package com.gy.DataStructure.queue;
@SuppressWarnings({"all"})
class ArrayQueue {
    private int maxSize;//最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//模拟队列存放数据

    public ArrayQueue(int defineSize) {
        maxSize = defineSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize -1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能添加");
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获取");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }

}
