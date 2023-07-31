package com.yanzhuang.test;

public class Node {
    public int value;
    public Node nextNode;
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value + "-->" + (nextNode != null ? nextNode.toString() : "null");
    }
}
