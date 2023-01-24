package com.example.algo_0.f2;

public class NB3_2023 {

    private static class Node_{
        public String data;
        public Node_ next;
    }

    public static void main(String[] args) {
        Node_ headNode;
        Node_ node1 = new Node_();
        Node_ node2 = new Node_();
        Node_ node4 = new Node_();
        Node_ node5 = new Node_();
        // Initiate the data into the nodes
        node1.data = "Gilgamesh";
        node2.data = "löper";
        node4.data = "på";
        node5.data = "släppen";
        // Link the nodes to gather
        node1.next = node2;
        node2.next = node4;
        node4.next = node5;
        node5.next = null;

        headNode = node1;
        /**Creates a LinkedList with 4 nodes*/
        StringBuilder result = new StringBuilder();
        while (headNode != null) {
            result.append(headNode.data);
            if (headNode.next != null)
                result.append(" ==> ");
            headNode = headNode.next;
        }
        System.out.println(result.toString());

        headNode = node1;
        /**Removes node4 from the list by giving its node1 to that one that precedes it (node2)*/
        node2.next = node4.next;
        result = new StringBuilder();
        while (headNode != null) {
            result.append(headNode.data);
            if (headNode.next != null)
                result.append(" ==> ");
            headNode = headNode.next;
        }
        System.out.println(result.toString());

        /**Adds a new node1 to the list with position between node3 and node4*/
        headNode = node1;
        Node_ node3 = new Node_();
        node3.data = "själv";
        node2.next = node3;
        node3.next = node4;
        result = new StringBuilder();
        while (headNode != null) {
            result.append(headNode.data);
            if (headNode.next != null)
                result.append(" ==> ");
            headNode = headNode.next;
        }
        System.out.println(result.toString());


        Node_ nodeA = new Node_();
        Node_ nodeB = new Node_();
        Node_ nodeC = new Node_();
        Node_ nodeD = new Node_();
        nodeA.data = "It's friday then";
        nodeB.data = "there's";
        nodeC.data = "Saturday";
        nodeD.data = "Sunday WHATT??";
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = node1;

        /**Sets two lists together starting with nodeA and ending at node4 */
        headNode = nodeA;
        result = new StringBuilder();
        while (headNode != null) {
            result.append(headNode.data);
            if (headNode.next != null)
                result.append(" ==> ");
            headNode = headNode.next;
        }
        System.out.println(result.toString());
    }
}
