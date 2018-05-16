package com.example.libentity.day02;

import com.example.libentity.Entity;
import com.example.libentity.Field;
import com.example.libentity.MyRetentionPolicy;
import com.example.libentity.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class clazz = Persons.class;
        Entity entity = (Entity) clazz.getAnnotation(Entity.class);
        System.out.println(entity.value());
        Class clazzTest = Test.class;
        Method method = clazzTest.getMethod("method1");
        Entity entityMethod = (Entity) method
                .getAnnotation(Entity.class);
        System.out.println(entityMethod.value());

    }
    @Entity(retention = MyRetentionPolicy.CLASS, str = { "1" }, value = "1")
    public static void method1() {

    }

}
