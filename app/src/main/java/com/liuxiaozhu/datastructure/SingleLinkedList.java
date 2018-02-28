package com.liuxiaozhu.datastructure;

/**
 * Author：Created by liuxiaozhu on 2018/2/27.
 * Email: chenhuixueba@163.com
 * 单链表
 * 实现链表的添加，删除和逆置
 */

public class SingleLinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    int size;

    public SingleLinkedList() {
    }

    /**
     * 单链表末尾添加元素
     *
     * @param element
     */
    private void linklast(E element) {
        Node<E> node = new Node<>(element, null);
        if (head == null) {
            head = node;
        } else {
            last.next = node;
        }
        size++;
        last = node;
    }

    /**
     * 随机插入元素
     *
     * @param element
     * @param index
     */
    private void linkBefore(E element, int index) {
        Node<E> newNode = new Node<>(element, null);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> node = node(index);
            node(index - 1).next = newNode;
            newNode.next = node;
        }
        size++;
    }

    /**
     * 查找指定节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        Node<E> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 创建一个IndexOutOfBoundsException细节信息。
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * ****************************外部方法**************************
     */

    /**
     * 添加单个元素
     *
     * @param element
     */
    public void add(E element) {
        linklast(element);
    }

    /**
     * 获取指定下标的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    /**
     * 指定位置添加元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            linklast(element);
        } else {
            linkBefore(element, index);
        }
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     */
    public void remove(int index) {
        checkElementIndex(index);
        Node<E> node = node(index);
        if (index == 0) {
            head = node.next;
        } else {
            Node<E> prev = node(index - 1);
            prev.next = node.next;
        }
        node.next = null;
        size--;
    }

    /**
     * 链表的逆置
     */
    public void inverse() {
        //存放待操作的链表头结点
        Node<E> list = head;
//        存放逆置完成的链表
        Node<E> node = null;
        while (list != null) {
            Node<E> temp = list;
            list = list.next;
            temp.next = node;
            node = temp;
        }
        head = node;
    }

    /**
     * 递归转置
     */
    public void inverses() {
        head = inverse(head);
    }

    /**
     * 递归转置
     *
     * @param node
     * @return
     */
    private Node<E> inverse(Node<E> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<E> tial = inverse(node.next);
        node.next.next = node;
        //将后一个元素置空
        node.next = null;
        return tial;
    }


    /**
     * 节点
     *
     * @param <E>
     */
    private class Node<E> {
        E item;
        Node<E> next;

        public Node(E elament, Node<E> last) {
            this.item = elament;
            this.next = last;
        }
    }
}
