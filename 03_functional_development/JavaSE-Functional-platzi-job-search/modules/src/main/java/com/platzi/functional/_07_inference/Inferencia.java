package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NameUtils;

import java.util.List;
import java.util.function.Function;

public class Inferencia {
    public static void main(String[] args) {
        Function<Integer, String> funcionConvertidora = x -> "Al doble: " + (x * 2);

        List<String> alumnos = NameUtils.getList("Hugo", "Paco", "Luis");

        alumnos.forEach((String name) -> System.out.println(name));
        System.out.println("*****");
        alumnos.forEach(name -> System.out.println(name));
    }
}
