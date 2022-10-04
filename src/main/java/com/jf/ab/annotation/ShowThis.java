package com.jf.ab.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * <pre>@author argbwl</pre>
 *
 * <pre>
 * This annotation can be use for to show data applied on fields level
 * To show status for fields annotated with can be enabled or disabled by {@link ShowThisStatus}
 * </pre>
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ShowThis {

}
