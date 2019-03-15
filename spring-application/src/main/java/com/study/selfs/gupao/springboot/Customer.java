package com.study.selfs.gupao.springboot;

import com.study.selfs.gupao.springapplication.aano.UserTag;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@UserTag("21222")
public class Customer {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        AnnotatedElement annotatedElement = Customer.class;
        Annotation[] declaredAnnotations = annotatedElement.getAnnotations();
        for(Annotation annotation : declaredAnnotations){
            Class<? extends Annotation> annotationType = annotation.annotationType();
            Method value = null;
            try {
                value = annotationType.getMethod("value");
                Object invoke = value.invoke(annotation, null);
                System.out.println(invoke);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println(declaredAnnotations[0]);
    }

}
