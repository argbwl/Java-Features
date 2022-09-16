package com.ab.annotation.uc;


import com.ab.annotation.SetValue;

public class AnnotationUseCaseMethodLevel {

    private final SetValue setValue = AnnotationUseCaseMethodLevel.class
                                                 .getMethod("loadAnnotationValues")
                                                 .getAnnotation(SetValue.class);

    public AnnotationUseCaseMethodLevel() throws NoSuchMethodException {
    }

    public String getDetails() {
        return this.setValue.details();
    }

    public int getValues() throws NoSuchMethodException {
        return this.setValue.value();
    }

    @SetValue(details = "keyboard", value = 100)
    public void loadAnnotationValues() throws NoSuchMethodException {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnotationUseCaseMethodLevel auc = new AnnotationUseCaseMethodLevel();
        System.out.println(auc.getDetails()+", "+auc.getValues());
    }

}
