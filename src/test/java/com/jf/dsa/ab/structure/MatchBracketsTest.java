package com.jf.dsa.ab.structure;

import com.jf.ab.JavaFeaturesApplication;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Java-Features
 * anuragbaranwal
 * 17/09/22
 **/
@SpringBootTest(classes = JavaFeaturesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Test Cases for Bracket Matching")
class MatchBracketsTest {


    MatchBrackets mb = null;

    @BeforeAll
    static void beforeAll(){

    }

    @BeforeEach
    void setUp() {
        mb = new MatchBrackets();
    }

    @DisplayName("[Expected False] : Given Brackets are not in forms")
    @Test
    void isBracketsMatching() {
        String data = "[cec{((cece(cecec)ceec)cece}ce]";
        assertFalse(mb.isBracketsMatching(data));
    }

    @DisplayName("[Expected True] : Given Brackets are in correct forms")
    @Test
    void isBracketsMatchingCase1() {
        String data = "[cec{(cece(cecec)ceec)cece}ce]";
        assertTrue(mb.isBracketsMatching(data));
    }

    @DisplayName("[Expected True] : Param in correct forms for all values")
    @ParameterizedTest(name = "Data {0} is with correct form of brackets")
    @ValueSource(strings = {"[cec{(cece(cecec)ceec)cece}ce]","[]","[{()}]"})
    @NullAndEmptySource
    void isParamBracketsMatchingCase(String data) {
        //String data = "[cec{(cece(cecec)ceec)cece}ce]";
        assertTrue(mb.isBracketsMatching(data));
    }

    @AfterEach
    void tearDown() {
        mb=null;
    }

    @AfterAll
    static void afterAll(){

    }



}