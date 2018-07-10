package day3.retention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface FildInfo {
    int[] value();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodInfo {
    String name() default "hxh";

    String data();

    int age() default 27;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ClassInfo {
    String value();
}
