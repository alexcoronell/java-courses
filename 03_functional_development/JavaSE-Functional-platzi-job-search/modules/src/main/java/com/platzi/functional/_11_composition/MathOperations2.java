package com.platzi.functional._11_composition;

import com.sun.org.apache.xpath.internal.functions.FuncCeiling;

import java.util.function.Function;

public class MathOperations2 {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByThree = x -> {
            System.out.println("Multiply x: " + x + " by 3");
            return x * 3;
        };

        Function<Integer, Integer> add1MultiplyByThree = multiplyByThree.compose(y -> {
            System.out.println("Add 1 to " + y);
            return y + 1;
        });

        Function<Integer, Integer> andSquare = add1MultiplyByThree.andThen(x -> {
            System.out.println("Estoy elevando " + x + " al cuadrado");
            return x * x;
        });

        System.out.println(add1MultiplyByThree.apply(5));

        System.out.println(andSquare.apply(3));
    }
}
