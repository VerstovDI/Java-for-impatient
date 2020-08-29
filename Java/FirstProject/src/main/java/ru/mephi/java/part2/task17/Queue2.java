package ru.mephi.java.part2.task17;

public class Queue2 {
    private Node firstNode;

    private static class Node {
        private Node nextNode;
        private String str;

        private Node() {
            this.str = "";
        }

        private Node(String str) {
            this.str = str;
        }

        private String getStr() {
            return this.str;
        }

        private Node setStr(String str) {
            this.str = str;
            return this;
        }

        private Node getNode() {
            return this;
        }

        private void printNode() {
            System.out.format("%s%n", getStr());
        }
    }

    public Queue2() {
        firstNode = null;
    }

    public void printQueue() {
        Queue2.Node curr = this.firstNode;
        while (curr != null) {
            curr.printNode();
            curr = curr.nextNode;
        }
    }

    public Node getFirstNode() {
        return this.firstNode;
    }

    public void add(String addStr) {
        Node n = new Node(addStr);
        n.nextNode = null;
        if (firstNode == null) {
            firstNode = n;
        } else {
            Node curr = firstNode;
            while (curr.nextNode != null) {
                curr = curr.nextNode;
            }
            curr.nextNode = n;
        }
    }

    public void remove() {
        if (firstNode != null) {
            firstNode = firstNode.nextNode;
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }

    public class Iterator {
        private Node currNode;

        private Iterator(){
            this.currNode = null;
        }

        public String next() {
            if (this.currNode == null) {
                this.currNode = getFirstNode();
            } else {
                this.currNode = this.currNode.nextNode;
            }
            return this.currNode.getStr();
        }

        public boolean hasNext() {
            if (this.currNode == null) {
                return getFirstNode() != null;
            }
            return this.currNode.nextNode != null;
        }
    }
}
