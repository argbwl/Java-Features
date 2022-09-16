package com.jf.ab.annotation.uc;

import com.jf.ab.annotation.ShowThis;
import com.jf.ab.annotation.ShowThisStatus;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ShowThisStatus(showStatus = true)
public class AnnotationUseCaseShowThis {

    private final Field[] fields = AnnotationUseCaseShowThis.class.getDeclaredFields();

    @Setter
    @ShowThis
    private String data;

    @Setter
//    @ShowThis
    private int value;

    @Setter
    @ShowThis
    private String content;

    private boolean getShowThisStatus(){
        ShowThisStatus showThisStatus = AnnotationUseCaseShowThis.class.getAnnotation(ShowThisStatus.class);
        return showThisStatus.showStatus();
    }

    public List<Object> showValue() throws IllegalAccessException {
        return Arrays.stream(fields).filter(field -> field.isAnnotationPresent(ShowThis.class) && getShowThisStatus())
                .map(matchField -> {
                    try {
                        return matchField.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IllegalAccessException {
        AnnotationUseCaseShowThis showThisCase = new AnnotationUseCaseShowThis();
        showThisCase.setData("Speaker");
        showThisCase.setValue(1035);
        showThisCase.setContent("Sound");



        showThisCase.showValue().forEach(System.out::println);
    }

}
