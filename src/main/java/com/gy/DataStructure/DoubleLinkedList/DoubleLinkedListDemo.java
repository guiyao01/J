package com.gy.DataStructure.DoubleLinkedList;

public class DoubleLinkedListDemo {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode heroNode = head.next;
        while (true) {
            if (heroNode == null) {
                break;
            }
            System.out.println(heroNode);
            heroNode = heroNode.next;
        }
    }

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //退出循环时，temp就指向了最后
        temp.next = node;
        node.pre = temp;
    }

    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("未找到编号%d的节点", newHeroNode.no);
        }
    }

    public void delete(Integer no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
//            temp.next = temp.next.next;
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("未找到%d编号的节点\n", no);
        }
    }




}
