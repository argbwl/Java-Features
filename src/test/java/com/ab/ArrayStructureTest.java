package com.ab;

import com.jf.dsa.ab.structure.ArrayStructure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Java-Features
 * anuragbaranwal
 * 17/09/22
 **/

@DisplayName("Test Cases for ArrayStructure")
public class ArrayStructureTest {

    ArrayStructure arrayStructure = null;
    String[] strArr1D;

    @BeforeEach
    void initializeValue(){
        arrayStructure = new ArrayStructure();
        strArr1D=arrayStructure.createString1DArrayWithSize(2);
    }


    @DisplayName("Should throw IllegalArgumentException if index > arr size")
    @Test
    void throw_AddValueToIndexInArrayTest(){
        assertThrows(IllegalArgumentException.class,()->{
            arrayStructure.addValueToIndexInArray(strArr1D,strArr1D.length+1,"Extra space");
        });
    }

    @DisplayName("Should throw IllegalArgumentException if index > arr size for all given param")
    @ParameterizedTest(name = "Index {0} not available in array")
    @ValueSource(ints = {5,6,9,-1})
    @NullSource
    void throw_param_AddValueToIndexInArrayTest(Integer index){
        strArr1D=arrayStructure.createString1DArrayWithSize(5);
        assertThrows(IllegalArgumentException.class,()->{
            arrayStructure.addValueToIndexInArray(strArr1D,index,"Extra space");
        });
    }


    @AfterEach
    void cleanUpValue(){
        arrayStructure = null;
        strArr1D=null;
    }

}
