package com.twomonth.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class clazzStudent = Student.class;

        Object o = clazzStudent.newInstance();
        Student student  = (Student)o;
        student.say();
        Field[] fields = clazzStudent.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("======================================");
        Method[] declaredMethods = clazzStudent.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("======================================");
        Method sum = clazzStudent.getMethod("sum", int.class, int.class);
        Object invoke = sum.invoke(student, 1, 2);
        System.out.println(invoke);

        Method sum1 = clazzStudent.getMethod("sum", int.class, int.class);
        MyAnnotation annotation = sum1.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());

    }
}
