package com.mentor.training.codingpractise.LinkedLists;

import java.io.IOException;
import java.util.Scanner;
public class ReverseUsingRecursion {
    static class Node {
        public int data;
        public Node next;
        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static class LinkedList {
        public Node head;
        public LinkedList() {
            this.head = null;
        }
        public void insertNode(int nodeData) {
            Node node = new Node(nodeData);
            if (this.head != null) {
                node.next = head;
            }
            this.head = node;
        }
    }

    public static void printSinglyLinkedList(Node node,
                                             String sep) throws IOException {
        while (node != null) {
            System.out.print(   node.data+ sep);
            node = node.next;
        }
    }
    // Complete the reverse function below.
    static Node reverse(Node head) {
        Node next = head.next;
        if (next != null) {
            Node subHead = reverse(next);
            addAtEnd(subHead,head);
            head.next=null;
            return subHead;
        }
        return head;
    }

    private static void addAtEnd(Node subHead, Node head) {
        Node nextOfSubHead=subHead.next;
        while(nextOfSubHead!=null)
        {
            subHead=subHead.next;
            nextOfSubHead=nextOfSubHead.next;
        }
        subHead.next=head;
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        LinkedList llist = new LinkedList();
        llist.insertNode(20);
        llist.insertNode(4);
        llist.insertNode(15);
        llist.insertNode(85);
        System.out.println(llist.head.data);
        Node llist1 = reverse(llist.head);
        printSinglyLinkedList(llist1, " ");
        scanner.close();
    }
}