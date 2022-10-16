package com.jf.ab.java8;

import com.jf.printer.SystemPrinter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Java-Features
 * argbwl
 * 10/10/22
 **/

public class PredicateUseCaseImpl{


    public boolean checkPasswordComplexityIfStrong(Predicate<String> stringPredicate, String password){
        return stringPredicate.test(password);
    }

    public static void main(String[] args) {
        PredicateUseCaseImpl predicateUseCase = new PredicateUseCaseImpl();
        SystemPrinter.info(predicateUseCase.checkPasswordComplexityIfStrong(new StrongPasswordCheckPredicateImpl<>(), "238njdje#@hue"));
    }

}

final class StrongPasswordCheckPredicateImpl<T1> implements Predicate<T1> {

    Set<Character> specialCharSet = new HashSet<>(
            Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+')
    );

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param string the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    @Override
    public boolean test(T1 string) {
        boolean isLowerCaseAvailable = false;
        boolean isUpperCaseAvailable = false;
        boolean isNumberDigitAvailable = false;
        boolean isSpecialCharAvailable = false;
        if ((string instanceof String) && ((String) string).length() > 8) {
            String pwrd = (String) string;
            for (char c : pwrd.toCharArray()) {
                if (Character.isLowerCase(c))
                    isLowerCaseAvailable = true;
                else if (Character.isUpperCase(c))
                    isUpperCaseAvailable = true;
                else if (Character.isDigit(c))
                    isNumberDigitAvailable = true;
                else if (specialCharSet.contains(c))
                    isSpecialCharAvailable = true;
            }
        }
        return isLowerCaseAvailable && isUpperCaseAvailable && isNumberDigitAvailable && isSpecialCharAvailable;
    }
}



