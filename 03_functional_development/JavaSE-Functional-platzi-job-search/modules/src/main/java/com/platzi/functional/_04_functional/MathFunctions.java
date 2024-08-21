package com.platzi.functional._04_functional;

import org.w3c.dom.ls.LSOutput;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        System.out.println(square.apply(5));
        System.out.println(square.apply(25));

        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println(isOdd.apply(2));
        System.out.println(isEven.test(2));

        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6;

        Student student = new Student(5.9);
        System.out.println(isApproved.test(student));
    }

    static class Student {
        private double calificacion;

        public Student(double calificacion) {
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }

        public void setCalificacion(double calificacion) {
            this.calificacion = calificacion;
        }
    }

}