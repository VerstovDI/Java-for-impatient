package ru.mephi.java.part2.task16;

public class Queue1 {
    private Node firstNode;

    private static class Node {
        private Node nextNode;
        private String str;

        public Node() {
            this.str = "";
        }

        public Node(String str) {
            this.str = str;
        }

        public String getStr() {
            return this.str;
        }

        public Node setStr(String str) {
            this.str = str;
            return this;
        }

        public void printNode() {
            System.out.format("%s%n", getStr());
        }
    }

    public Queue1() {
        firstNode = null;
    }

    public String printQueue() {
        Node curr = this.firstNode;
        StringBuilder strB = new StringBuilder();
        while (curr != null) {
            strB.append(curr.getStr()).append(" ");
            curr = curr.nextNode;
        }
        //System.out.format("%s%n", strB);
        return strB.toString();
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

    public String remove() {
        Node n = this.firstNode;
        firstNode = firstNode.nextNode;
        return n.getStr();
    }
}
