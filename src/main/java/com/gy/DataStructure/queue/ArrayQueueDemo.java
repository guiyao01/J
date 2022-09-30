package com.gy.DataStructure.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：获取队列头");
            key = in.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    in.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数字:");
                    int i = in.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.println("取出的数据是:"+queue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println("头结点是:" + head);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }

        }
    }
}
