package com.jf.dsa.ab.structure;

import com.jf.dsa.ab.ds.Node;

/**
 *
 */



public class LinkedListStructure {

    private Node head;
    private int size;

    public void setData(String data) {
        head.setData(data);
    }

    public void setNext(Node next) {
        head.setNext(next);
    }

    public Node getNext() {
        return head.getNext();
    }

    public String getData() {
        return head.getData();
    }

    public LinkedListStructure(){
        size=0;
    }

    public void addFirstNode(String data){
        Node newNode = new Node(data);
        if (data == null) {
            return;
        }
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head=newNode;
    }

    public void insert(String data){
        Node newNode = new Node(data);
        Node currentHeadNode = head;
        size++;
        if (head==null){
            head = newNode;
            return;
        }

        while (currentHeadNode.getNext() !=null){
            currentHeadNode = currentHeadNode.getNext();
        }
        currentHeadNode.setNext(newNode);
    }

    public void printLinkedStructureList(){
        Node currentNode = head;
        if(currentNode==null){
            System.out.println("head is null");
            return;
        }
        while (currentNode!=null){
            System.out.print(currentNode.getData()+" -> ");
            currentNode=currentNode.getNext();
        }
        System.out.println("null");
    }

    public void printGivenNodeLinkedStructureList(Node node){
        Node currentNode = node;
        if(currentNode==null){
            System.out.println("head is null");
            return;
        }
        while (currentNode!=null){
            System.out.print(currentNode.getData()+" -> ");
            currentNode=currentNode.getNext();
        }
        System.out.println("null");
    }

    public void deleteFirstElement(){
        Node currentNode = head;
        if(head==null){
            System.out.println("head is empty");
            return;
        }
        size--;
        head=head.getNext();
    }

    public void deleteLastElement(){
        Node currentNode = head;
        if (head == null) {
            System.out.println("head is null");
            return;
        }
        size--;
        if(head.getNext()==null){
            head=null;
            return;
        }

        Node lastNode = head.getNext();
        Node secondLastNode = head;

        while (lastNode.getNext()!=null){
            lastNode=lastNode.getNext();
            secondLastNode=secondLastNode.getNext();
        }
        secondLastNode.setNext(null);
    }

    /**
     *
     * @param data
     * @param position
     *
     * <pre> this method is used to insert element in between of linkedlist as specified position</pre>
     *
     */
    public void insertElementInBetween(String data, int position){
        if (position < 0) {
            System.out.println("invalid argument");
            return;
        }

        if(position-1 > getSize()){
            System.out.println("position is greater than list size");
            return;
        }

        if(head==null){
            System.out.println("[insertion failed] index not available for list size : "+getSize()+", index : "+position);
            return;
        }

        if(position == 1 ){
            addFirstNode(data);
        }else {
            Node currentHead = head;
            int i = 0;
            Node newNode = new Node(data);
            while(position-- != 0){
                if(position == 1 && null!=currentHead){
                    size++;
                    newNode.setNext(currentHead.getNext());
                    currentHead.setNext(newNode);
                    break;
                }
                currentHead=currentHead.getNext();
            }
        }
    }

    public void removeElementInBetween(int position){
        if (position < 0) {
            System.out.println("invalid argument");
            return;
        }

        if(position-1 > getSize()){
            System.out.println("position is greater than list size");
            return;
        }

        if(head==null){
            System.out.println("[insertion failed] index not available for list size : "+getSize()+", index : "+position);
            return;
        }

        if(position == 1 ){
            deleteFirstElement();
        }else {
            Node currentHead = head;
            int i = 0;
            while(position-- != 0){
                if(position == 1 && null!=currentHead){
                    size--;
                    Node removingNode = currentHead.getNext();
                    currentHead.setNext(removingNode.getNext());
                    break;
                }
                currentHead=currentHead.getNext();
            }
        }
    }

    public int getSize(){
        return head==null? 0 : size;
    }

    public static void main(String[] args) {
        LinkedListStructure linkedListStructure = new LinkedListStructure();
        linkedListStructure.addFirstNode("F4");
        linkedListStructure.addFirstNode("F3");
        linkedListStructure.addFirstNode("F1");
        linkedListStructure.insert("last");
        linkedListStructure.insert("last1");
        linkedListStructure.insert("last2");
        linkedListStructure.addFirstNode("F5");
        linkedListStructure.printLinkedStructureList();
        linkedListStructure.insertElementInBetween("B2",7);
        linkedListStructure.insertElementInBetween("B5",1);
        linkedListStructure.printLinkedStructureList();
        linkedListStructure.deleteFirstElement();
        linkedListStructure.deleteLastElement();
        linkedListStructure.insertElementInBetween("B7",7);
        linkedListStructure.insertElementInBetween("B8",9);
        linkedListStructure.insertElementInBetween("B10",11);
        linkedListStructure.printLinkedStructureList();
        linkedListStructure.removeElementInBetween(2);
        linkedListStructure.printLinkedStructureList();
        System.out.println(linkedListStructure.getSize());

    }
}
