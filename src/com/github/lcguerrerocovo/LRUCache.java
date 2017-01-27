package com.github.lcguerrerocovo;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luisguerrero on 1/27/17.
 */
class LRUCache {

    Map<Integer,Integer> map;
    Queue queue;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap(capacity+1,1);
        queue = new Queue(capacity);
    }

    public int get(int key) {
        //long startTime = System.nanoTime();
        Integer value = map.get(key);
        if(value == null) {
            return -1;
        }
        queue.add(key);
        //long endTime = System.nanoTime();
        //System.out.println("    time spent in put():" + (endTime - startTime));
        return value;
    }

    public void put(int key, int value) {

        //long startTime = System.nanoTime();

        int keyToRemove = queue.add(key);
        if (keyToRemove != -1 && keyToRemove != key) map.remove(keyToRemove);
        map.put(key, value);
        //long endTime = System.nanoTime();
        //System.out.println("    time spent in put():" + (endTime - startTime));
    }

    /*
    public void put(int key, int value) {

        //System.out.println("size:" + map.size());
    } */


    /*public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Integer,Integer> keyValue : map.entrySet()) {
            builder.append("(k:" + keyValue.getKey() + " v:" + keyValue.getValue() + ")");
        }
        return "cache: " + builder.toString() + " queue:" + queue.toString();
    } */

    class Queue {

        Node head;
        Node last;
        int capacity;

        Queue(int capacity) {
            this.capacity = capacity;
        }

        public int add(int key) {
            int keyToRemove = -1;
            if(head == null) {
                Node curr = new Node(key);
                head = curr;
                last = curr;
            } else {
                int currentSize = 1;
                Node curr = head;
                if (!(curr.key() == key)) {
                    while (currentSize < capacity) {
                        if (curr.key() == key) {
                            remove(curr);
                            add(curr);
                            return keyToRemove;
                        }

                        if (curr.hasPrev()) {
                            curr = curr.prev();
                            ++currentSize;
                        } else break;
                    }

                    add(new Node(key));
                    if (currentSize == capacity) {
                        lruRemove();
                    }
                }
            }
            return keyToRemove;
        }

        public void add(Node node) {
            if(head == null) {
                head = node;
                last = node;
            } else {
                head.setNext(node);
                node.setPrev(head);
                head = node;
            }
        }

        public void remove(Node node) {
            if(node.hasPrev() && node.hasNext()) {
                node.prev().setNext(node.next());
                node.next().setPrev(node.prev());
            } else if(node.hasPrev() && !node.hasNext()) {
                node.prev().setNext(null);
                head = node.prev();
            } else if(!node.hasPrev() && node.hasNext()){
                node.next().setPrev(null);
                last = node.next();
            }  else {
                head = null;
                last = null;
            }
        }

        public void lruRemove() {
            if(last != null && last != head) {
                last = last.next();
                last.setPrev(null);
            }
        }

        /*public String toString() {
            StringBuilder builder = new StringBuilder();
            Node curr = head;
            if(curr != null) {
                builder.append("head -> ");
                builder.append(curr.key() + " -> ");
                while(curr.hasPrev()) {
                    curr = curr.prev();
                    builder.append(curr.key() + " -> ");
                }
                builder.append("tail");
            }
            return builder.toString();
        } */

        class Node {

            private Node next;
            private Node prev;
            private int key;


            Node(int key) {
                this.key = key;
            }

            Node(int key, Node prev) {
                this(key);
                this.prev = prev;
            }

            public Node next() {
                return next;
            }

            public Node prev() {
                return prev;
            }

            public int key() {
                return key;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public void setPrev(Node prev) {
                this.prev = prev;
            }

            public boolean hasNext() {
                if(!(next == null)) return true;
                else return false;
            }

            public boolean hasPrev() {
                if(!(prev == null)) return true;
                else return false;
            }
        }
    }
}