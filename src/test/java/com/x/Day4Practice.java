package com.x;

public class Day4Practice {

    public static class Node<V> {
        private V value;

        private Node<V> next;

        public Node(V data) {
            value = data;
        }
    }

    public static class DoubleNode<V> {
        private V value;

        public DoubleNode<V> last;
        public DoubleNode<V> next;

        public DoubleNode(V data) {
            value = data;
        }
    }


    /**
     * 反转单链表
     * @param head
     */
    public static Node<Integer> reverseList(Node<Integer> head) {

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
     * @param doubleNode
     * @return
     */
    public static DoubleNode<Integer> reverseDoubleList(DoubleNode<Integer> doubleNode) {
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> next;
        while (doubleNode != null) {
            next = doubleNode.next;
            doubleNode.last = next;
            doubleNode.next = pre;
            pre = doubleNode;
            doubleNode = next;
        }

        return pre;
    }


    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        n1.next = n2;
        n2.next = n3;

        DoubleNode<Integer> d1 = new DoubleNode<>(1);
        DoubleNode<Integer> d2 = new DoubleNode<>(2);
        DoubleNode<Integer> d3 = new DoubleNode<>(3);
        d1.next = d2;
        d2.last = d1;
        d2.next = d3;
        d3.last = d2;

        print2(d1);
        //n1 = reverseList(n1);
        d1 = reverseDoubleList(d1);
        print2(d1);
    }

    public static void print(Node<Integer> node) {
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
        }
        System.out.println();
    }

    public static void print2(DoubleNode<Integer> node) {
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
        }
        System.out.println();
    }

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


        public void offer(V data) {
            Node<V> cur = new Node<>(data);
            if (head == null) {
                head = cur;
            } else {
                tail.next = cur;
            }
            tail = cur;
        }

        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
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

    public static class Node2<V> {
        private Node2<V> last;
        private Node2<V> next;
        private V value;

        public Node2(V data) {
            value = data;
            last = null;
            next = null;
        }
    }

    public static class MyDeque<V> {
        private Node2<V> head;

        private Node2<V> tail;

        private int size;

        public MyDeque() {
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

        public void offerHead(V data) {
            Node2<V> cur = new Node2<>(data);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                head.last = cur;
                cur.next = head;
                head = cur;
            }
            size++;
        }

        public void offerTail(V data) {
            Node2<V> cur = new Node2<>(data);
            if (head == null) {
                head = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
            }
            tail = cur;
            size++;
        }

        public V pollHead() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        public V pollTail() {
            V ans = null;
            if (tail == null) {
                return ans;
            }
            size--;
            ans = tail.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        public V peekHead() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

        public V peekTail() {
            V ans = null;
            if (tail != null) {
                ans = tail.value;
            }
            return ans;
        }
    }

}
