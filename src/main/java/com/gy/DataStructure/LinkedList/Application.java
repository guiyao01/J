package com.gy.DataStructure.LinkedList;

import java.util.Stack;

public class Application {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode h2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode h3 = new HeroNode(3, "吴用", "智多星");
        HeroNode h4 = new HeroNode(4, "林冲", "豹子头");

        NodeManager nodeManager = new NodeManager();
//        nodeManager.add(h1);
//        nodeManager.add(h2);
//        nodeManager.add(h3);
//        nodeManager.add(h4);

        nodeManager.addByOrder(h2);
        nodeManager.addByOrder(h4);
        nodeManager.addByOrder(h1);
        nodeManager.addByOrder(h3);

        HeroNode newHeroNode = new HeroNode(2, "卢俊义", "玉麒麟~~~");
        nodeManager.update(newHeroNode);

        nodeManager.delete(4);

//        NodeManager.reverse(nodeManager.head);
        System.out.println(getLength(nodeManager.getHead()));

        System.out.println(findLastIndexNode(nodeManager.getHead(), 1));
        System.out.println("-----------------");
//        reverse(nodeManager.getHead());
        reversePrint(nodeManager.getHead());
        nodeManager.list();


    }
    //获取链表长度
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
    //查找链表中倒数第k个节点
    public static HeroNode findLastIndexNode(HeroNode head, Integer index) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        if (index <= 0 || index > length) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < length - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static void reverse(HeroNode head) {
        //如果当前链表为空，或只有一个节点，无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义辅助指针，帮助遍历原链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向cur的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //每遍历一个链表，就放到新链表的最前端，也就是head后面
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    
}
