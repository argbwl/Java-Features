package com.jf.dsa.ab.structure;

import java.util.Arrays;

public class ArrayStructure {

    public int[] createInt1DArrayWithSize(int size){
        return new int[size];
    }

    public String[] createString1DArrayWithSize(int size){
        return new String[size];
    }

    public Object searchIndexValueFromArray(Object[] obj, int key) {
        Object result = -1;
        for (int i = 0; i < obj.length; i++) {
            if (i == key) {
                result = obj[i];
                break;
            }
        }
        return result;
    }

    public void addValueToIndexInArray(Object[] obj, Integer index, Object value) {
        if (null==obj || index==null || obj.length < 0 || index < 0 || index >= obj.length) {
            throw new IllegalArgumentException("Invalid Index");
        } else {
            obj[index] = value;
        }
    }

    public void print1DArrValue(Object[] obj){
        for (int i=0; i < obj.length ; i++){
            System.out.print(obj[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStructure arrayStructure = new ArrayStructure();
        String[] strArr = arrayStructure.createString1DArrayWithSize(5);
        //strArr[4]="Val6";

        arrayStructure.addValueToIndexInArray(strArr,5,"Val4");

        Arrays.asList(strArr).forEach(System.out::println);
    }

}
