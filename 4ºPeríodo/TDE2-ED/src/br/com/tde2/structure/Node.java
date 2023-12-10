package br.com.tde2.structure;

class Node {
    private int data;
    private Node next;

    protected Node(int data) {
        this.data = data;
        this.next = null;
    }

    protected int getData() {
        return data;
    }

    protected void setData(int data) {
        this.data = data;
    }

    protected Node getNext() {
        return next;
    }

    protected void setNext(Node next) {
        this.next = next;
    }
}
