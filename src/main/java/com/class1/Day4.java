package com.class1;

public class Day4 {

    public static class MyQueue<V> {
        private Node<V> head;

        private Node<V> tail;

        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void offer(V value) {
            Node<V> cur = new Node<>(value);
            if (head == null) {
                head = cur;
            } else {
                tail.next = cur;
            }
            tail = cur;
            size++;
        }

        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return ans;
        }

        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }

    /**
     * 单链表
     * @param <V>
     */
    public static class Node<V> {
        private final V value;
        public Node<V> next;

        public Node(V v) {
            value = v;
        }
    }

    /**
     * 双链表
     * @param <V>
     */
    public static class DoubleNode<V> {
        private final V value;
        private DoubleNode<V> last;
        private DoubleNode<V> next;

        public DoubleNode(V data) {
            value = data;
        }
    }

    /**
     * 单链表翻转
     * @param head head
     * @return 头节点
     */
    public static Node<Integer> revereList(Node<Integer> head) {
        Node<Integer> pre = null;
        Node<Integer> next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双链表
     * @param head head
     * @return
     */
    public static DoubleNode<Integer> reverseDoubleList(DoubleNode<Integer> head) {
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void print(Node<Integer> node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void print2(DoubleNode<Integer> node) {
        while (node != null) {
            System.out.println("v: " + node.value + ", l: " + (node.last == null ? null : node.last.value) + ", n: " + (node.next == null ? null : node.next.value));
            node = node.next;
        }
    }

    public static void main(String[] args) {
        /*Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        n1.next = n2;
        n2.next = n3;

        print(n1);
        n1 = revereList(n1);
        print(n1);*/

        DoubleNode<Integer> n1 = new DoubleNode<>(1);
        DoubleNode<Integer> n2 = new DoubleNode<>(2);
        DoubleNode<Integer> n3 = new DoubleNode<>(3);
        n1.next = n2;
        n2.last = n1;
        n2.next = n3;
        n3.last = n2;

        print2(n1);
        System.out.println();
        n1 = reverseDoubleList(n1);
        print2(n1);
    }


    public static class ListNode {
        public int val;
        public ListNode next;
    }



}
