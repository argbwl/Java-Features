package com.jf.ab.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * this annotation can be use for enable or disable
 * to show status for fields annotated with {@link ShowThis}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ShowThisStatus {
    boolean showStatus() default true;
}
