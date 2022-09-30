package com.gy.DataStructure.LinkedList;
@SuppressWarnings({"all"})
public class NodeManager {
    private HeroNode head = new HeroNode(0, "", "");

    // 找到当前链表最后节点，然后next指向新的节点
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
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {//已经在链表最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的数据编号%d已经存在\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
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
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("未找到%d编号的节点\n", no);
        }
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

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }
}
