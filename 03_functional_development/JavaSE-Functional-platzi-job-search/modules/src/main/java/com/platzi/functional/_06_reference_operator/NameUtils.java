package com.platzi.functional._06_reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NameUtils {

    public static void main(String[] args) {
        List<String> teachers = getList("Pepe", "Manolo");
        Consumer<String> printer = text -> System.out.println(text);
        teachers.forEach(printer);
        System.out.println("*****");
        teachers.forEach(System.out::println); // Debe ser una funcion que reciba String y no tenga retorno de valor (void)
    }

    public static <T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }
}
