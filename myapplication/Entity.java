package com.example.libentity.day02;

import com.example.libentity.MyRetentionPolicy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Entity {

    String value();

    int pid() default 2;
    MyRetentionPolicy retention();
    String[] str();


}
