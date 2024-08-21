package com.platzi.functional._08_lambda;

import com.platzi.functional._06_reference_operator.NameUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {
    public static void main(String[] args) {
        List<String> cursos = NameUtils.getList("Java", "Functional");

        cursos.forEach(curso -> System.out.println(curso));

        //BiFunction<Integer, Integer, Integer> s = (x, y) -> x * y;

        useZero(() -> 2);

        usePredicate(text -> text.isEmpty());

        useBiFunction((x, y) -> x * y);

        useBiFunction((x, y) -> {
            System.out.println("X: " + x + ", Y: " + y);
            return x - y;
        });

        useNothing(() -> {});

        useNothing(() -> {
            System.out.println("Hello student");
        });

        useBiFunction((Integer x, Integer y) -> x * y);
    }

    static void useZero(ZeroArguments zeroArguments) {}

    static void usePredicate(Predicate<String> predicate){}

    static void useBiFunction(BiFunction<Integer, Integer, Integer> operation) {}

    static void useNothing(OperateNothing operateNothing){}

    @FunctionalInterface
    interface ZeroArguments {
        int get();
    }

    @FunctionalInterface
    interface OperateNothing {
        void nothing();
    }
}
