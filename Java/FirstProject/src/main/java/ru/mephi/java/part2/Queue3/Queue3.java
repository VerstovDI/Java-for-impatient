package ru.mephi.java.part2.Queue3;


public class Queue3 {
    private String[] nodeArr;
    private int size;
    private int capacity;
    final private static short INIT_CAPACITY = 10;
    final private static short CUT_RATE = 5;

    public Queue3() {
        this.nodeArr = new String[INIT_CAPACITY];
        this.capacity = INIT_CAPACITY;
        this.size = 0;
    }

    public Queue3(int initialCapacity) {
        this.nodeArr = new String[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public void printQueue() {
        StringBuilder strB = new StringBuilder();
        for (String node : this.nodeArr) {
            if (node != null) {
                strB.append(node).append(" ");
            } else {
                break;
            }
        }
        System.out.format("%s%n", strB);
    }

    public void add(String addedStr) {
        if (this.capacity == this.size) {
            resize(nodeArr.length << 1);
        }
        nodeArr[this.size++] = addedStr;
    }

    private void resize(int newLength) {
        String[] newNodeArr = new String[newLength];
        System.arraycopy(this.nodeArr, 0, newNodeArr, 0, this.size);
        nodeArr = newNodeArr;
        this.capacity = newLength;
    }

    public String remove() {
        String tmp;
        if (this.nodeArr != null) {
            tmp = nodeArr[0];
            if (this.size >= 0) System.arraycopy(this.nodeArr, 1, this.nodeArr, 0, this.size);
            this.size--;

        } else {
            String removeExceptionMsg = "Queue is empty! Nothing to remove.";
            throw new IllegalArgumentException(removeExceptionMsg);
        }
        if ((this.capacity > INIT_CAPACITY)  && (this.capacity > this.size * CUT_RATE)) {
            resize(nodeArr.length >> 1);
        }
        return tmp;
    }
}
