package com.liuxiaozhu.datastructure;


/**
 * Author：Created by liuxiaozhu on 2018/2/27.
 * Email: chenhuixueba@163.com
 * 双链表
 * 模仿LinkedList实现add get remove
 */

public class LinkedList<E> {
    //指向第一个节点
    private Node<E> first;
    //指向最后一个节点
    private Node<E> last;
    //    节点数量
    int size;

    public LinkedList() {
    }

    /**
     * 在链表末尾添加一个元素
     *
     * @param e
     */
    private void linkLast(E e) {
        Node<E> newNode = new Node<>(last, e, null);
        Node<E> l = last;
        //将新创建的节点赋值个last
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 随机插入元素
     *
     * @param element
     * @param node
     */
    private void linkBefore(E element, Node<E> node) {
        //保存当前节点的前驱
        final Node<E> pred = node.prev;
        //创建新的节点
        final Node<E> newNode = new Node<>(pred, element, node);
        node.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    /**
     * 获取指定下标的元素
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        //如果在后半段，则从后面进行遍历
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    /**
     * 检查下标是否越界
     *
     * @param index 0~size-1
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 创建一个IndexOutOfBoundsException细节信息。
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * 判断数组下标是否为空
     *
     * @param index
     * @return
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * **********************************外部方法***********************************
     */
    /**
     * 添加一个元素
     *
     * @param element
     */
    public void add(E element) {
        linkLast(element);
    }

    /**
     * 取出一个元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    /**
     * 指定位置替换元素
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    /**
     * 指定位置插入元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    /**
     * 删除指定位置的元素
     * @param index
     */
    public void remove(int index) {
        checkElementIndex(index);
        unlink(node(index));
    }

    /**
     * 删除指定元素
     * @param node
     */
    private void unlink(Node<E> node) {
        final Node<E> next = node.next;
        final Node<E> prev = node.prev;

        if (prev == null) {
            //删除第一个元素
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            //删除最后一个
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.item = null;
        size--;
    }

    /***********************************************************************
     * 节点
     *
     * @param <E>
     */
    class Node<E> {
        //当前节点
        E item;
        //后继
        Node<E> next;
        //前驱
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}


