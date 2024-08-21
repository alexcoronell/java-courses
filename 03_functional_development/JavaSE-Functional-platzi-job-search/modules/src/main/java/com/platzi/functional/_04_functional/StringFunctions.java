package com.platzi.functional._04_functional;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!";
        System.out.println(quote.apply("Hello Platzi Student"));
        System.out.println(addMark.apply("Hello Platzi Student"));

        BiFunction<Integer, Integer, Integer> multiplicacion = (x,y) -> x * y; // Se definen los tipos de todos los paramentros y salida
        System.out.println(multiplicacion.apply(3,5));

        BinaryOperator<Integer> multiplicacion2 = (x, y) -> x * y; //  Se define un solo tipo que corresponde a argumentos y salida
        System.out.println(multiplicacion2.apply(3,2));

        BiFunction<String, Integer, String> leftPad = (text, number) -> String.format("%" + number + "s", text);

        System.out.println(leftPad.apply("Java", 10));
    }
}
