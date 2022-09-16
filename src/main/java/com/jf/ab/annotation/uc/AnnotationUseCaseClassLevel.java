package com.jf.ab.annotation.uc;

import com.jf.ab.annotation.SetValue;

@SetValue(
        details = "TV",
        value = 1000
)
public class AnnotationUseCaseClassLevel {

    private final SetValue setValue = AnnotationUseCaseClassLevel.class
                                                                 .getAnnotation(SetValue.class);

    public String getDetails() {
        return this.setValue.details();
    }

    public int getValues() throws NoSuchMethodException {
        return this.setValue.value();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnotationUseCaseClassLevel classLevel = new AnnotationUseCaseClassLevel();
        System.out.println(classLevel.getDetails()+", "+classLevel.getValues());
    }



}
