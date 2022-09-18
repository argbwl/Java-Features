package com.jf.dsa.ab.structure;

/**
 * to find next greater element
 */
public class NextGreaterElement {

    public void findNGEFormArray(int... intArr){
        int size = intArr.length;

        int next;
        for (int i = 0; i < size; i++) {
            next = -1;
            for(int j = i+1; j < size ; j++){
                if(intArr[i]<intArr[j]){
                    next=intArr[j];
                    break;
                }
            }
            System.out.println(intArr[i] +" --> "+next);
        }
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] intArr = {1,2,7,3,4,5};
        nge.findNGEFormArray(intArr);
    }

}
