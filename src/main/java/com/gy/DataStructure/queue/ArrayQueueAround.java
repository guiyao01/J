package com.gy.DataStructure.queue;
@SuppressWarnings({"all"})
class ArrayQueueAround {
    private int maxSize;//最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//模拟队列存放数据

    public ArrayQueueAround(int defineSize) {
        maxSize = defineSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能添加");
            return;
        }
        arr[rear] = n;
        //需要考虑取模
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获取");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }


}
