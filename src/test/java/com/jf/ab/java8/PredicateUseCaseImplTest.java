package com.jf.ab.java8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Java-Features
 * argbwl
 * 16/10/22
 **/

@DisplayName("Check if Given Password is Strong")
class PredicateUseCaseImplTest {

    PredicateUseCaseImpl predicateUseCase;

    @BeforeEach
    void initializeValue(){
        predicateUseCase = new PredicateUseCaseImpl();
    }

    @Test
    void checkPasswordComplexityIfStrongTrueTest() {
        boolean strongPwdStatus = predicateUseCase.checkPasswordComplexityIfStrong( new StrongPasswordCheckPredicateImpl<>(), "*#JSNDJ33923jndj");
        assertTrue(strongPwdStatus);
    }

    @Test
    void checkPasswordComplexityIfStrongFalseTest() {
        boolean strongPwdStatus = predicateUseCase.checkPasswordComplexityIfStrong( new StrongPasswordCheckPredicateImpl<>(), "1234");
        assertFalse(strongPwdStatus);
    }

    @DisplayName("[Expected True] : Param must strong password for all values")
    @ParameterizedTest(name = "Data {0} is Strong Password")
    @ValueSource(strings = {"27@#dedhGYDY","238njdje#@Hue","12#$erERT","222ee#Uie33","12ER@@uio"})
    void checkPasswordComplexityIfStrongParamTrueTest(String pwd) {
        boolean strongPwdStatus = predicateUseCase.checkPasswordComplexityIfStrong( new StrongPasswordCheckPredicateImpl<>(), pwd);
        assertTrue(strongPwdStatus);
    }

    @DisplayName("[Expected False] : Param must not be strong password for all values")
    @ParameterizedTest(name = "Data {0} is not Strong Password")
    @ValueSource(strings = {"1343","737&@*gdhdghhd"})
    @NullAndEmptySource
    void checkPasswordComplexityIfStrongParamFalseTest(String pwd) {
        boolean strongPwdStatus = predicateUseCase.checkPasswordComplexityIfStrong( new StrongPasswordCheckPredicateImpl<>(), pwd);
        assertFalse(strongPwdStatus);
    }

    @AfterEach
    void cleanUpValue(){
        predicateUseCase=null;
    }
}