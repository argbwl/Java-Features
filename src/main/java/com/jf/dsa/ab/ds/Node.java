package com.jf.dsa.ab.ds;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

