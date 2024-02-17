package com.class1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Day6 {

    public static class Student {
        private final String name;
        private final int id;
        private final int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public int getAge() {
            return age;
        }
    }

    public static void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /**
     * 谁id小，谁排在前面
     */
    public static class IdComparator implements Comparator<Student> {
        //如果返回负数，认为第一个参数(o1)应该排在前面
        //如果返回正数，认为第二个参数(o2)应该排在前面
        //如果返回0，认为第一个参数和第二个参数相等
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.id, o2.id);
        }
    }

    public static class MyComparator implements Comparator<Integer> {
        //如果返回负数，认为第一个参数(o1)应该排在前面
        //如果返回正数，认为第二个参数(o2)应该排在前面
        //如果返回0，认为第一个参数和第二个参数相等
        @Override
        public int compare(Integer o1, Integer o2) {
            /*if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }*/
            return o2.compareTo(o1);
        }
    }

    public static void printStudent(Student[] students) {
        for (Student student : students) {
            System.out.println(student.getId() + ", " + student.getName());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*int[] arr = {8, 2, 3, 4, 7, 20};
        print(arr);
        Arrays.sort(arr);
        print(arr);

        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("张二", 3, 21);
        Student s3 = new Student("张一", 2, 19);
        Student s4 = new Student("张四", 4, 28);
        Student s5 = new Student("张五", 1, 30);

        Student[] students = {s1, s2, s3, s4, s5};
        printStudent(students);
        Arrays.sort(students, new IdComparator());
        printStudent(students);*/

        //优先队列
        /*PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComparator());
        heap.add(6);
        heap.add(8);
        heap.add(3);
        heap.add(1);
        heap.add(9);
        heap.add(4);
        System.out.println(heap.peek());
        System.out.println("=====================");
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }*/

        /*Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("张二", 3, 21);
        Student s3 = new Student("张一", 2, 19);
        Student s4 = new Student("张四", 4, 28);
        Student s5 = new Student("张五", 1, 30);

        PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        System.out.println(heap.peek());
        System.out.println("=====================");
        while (!heap.isEmpty()) {
            Student poll = heap.poll();
            System.out.println(poll.id + "," + poll.name);
        }

        TreeSet<Student> treeSet = new TreeSet<>(new IdComparator());*/

        String str1 = "abc";
        String str2 = "acb";
        System.out.println(str1.compareTo(str2));
    }
}
