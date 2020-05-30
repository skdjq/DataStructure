package com.zy.StackDemo;

public class StackDemo1 {
    public static void main(String[] args) {
        Stack stack = new Stack(new Node(),new Node());
        stack.StackBottom = stack.StackTop;
        stack.StackTop = null;
        stack.pushStack(1,stack);
        stack.pushStack(2,stack);
        stack.pushStack(3,stack);
        stack.pushStack(4,stack);
        stack.traverse(stack);
    }
}
//定义结点
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
    }
    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
    public Node(){

    }
}
//定义栈
class Stack{
    Node StackTop;
    Node StackBottom;
    public Stack(){

    }
    public Stack(Node StackTop,Node StackBottom){
        this.StackTop = StackTop;
        this.StackBottom = StackBottom;
    }
    //入栈
    public static void pushStack(int data,Stack stack){
        Node newNode = new Node(data);
        newNode.next = stack.StackTop;
        stack.StackTop = newNode;
    }
    public static void traverse(Stack stack){
        Node tmp = stack.StackTop;
        while(tmp != stack.StackBottom){
            if(tmp == null){
                return;
            }
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}

