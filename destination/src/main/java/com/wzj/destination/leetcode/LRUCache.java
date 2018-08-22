package com.wzj.destination.leetcode;

import java.util.HashMap;

/**
 * Created by WZJ on 2018/8/13.
 */

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap();
    Node head = new Node(-1, -1);
    Node rear = head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node res = map.get(key);
        moveToTail(res);
        return res.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node =  map.get(key);
            node.val = value;
            moveToTail(node);
        }else{
            Node node =  new Node(key, value);
            rear.next = node;
            node.pre = rear;
            rear = node;
            map.put(key, node);
            ensureCapacity();
        }

    }

    public void moveToTail(Node node){
        if(node == rear) return;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        rear.next = node;
        node.pre = rear;
        rear = node;
    }

    public void ensureCapacity(){
        if(map.size() > capacity){
            Node next = head.next.next;
            map.remove(head.next.key);
            head.next.next = null;
            head.next.pre = null;
            head.next = next;
            head.next.pre = head;
        }
    }

    public static class Node{
        int val;
        int key;
        Node next;
        Node pre;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        lruCache.get(2);
        lruCache.put(1,1);

        lruCache.put(4,1);
        lruCache.put(2,1);
        lruCache.put(4,1);
        lruCache.put(3,1);
        lruCache.get(2);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */