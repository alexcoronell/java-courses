package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.NameUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> courseList = NameUtils.getList("Java", "Frontend", "Backend", "Fullstack");

        for (String course : courseList) {
            System.out.println("Platzi: " + course);
        }

        Stream<String> courseStream = Stream.of("Java", "Frontend", "Backend", "Fullstack");

        //Stream<Integer> courseStreamLength = courseStream.map(course -> course.length());

        //Optional<Integer> longest = courseStreamLength.max((x, y ) -> y - x);

        Stream<String> emphasisCourses = courseStream.map(course -> course + "!");
        //emphasisCourses.forEach(System.out::println);
        Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java"));
        justJavaCourses.forEach(System.out::println);

        Stream<String> coursesStream2 = courseList.stream();

        /*coursesStream2.map(course -> course + "!!")
                .filter(course -> course.contains("Java"))
                .forEach(System.out::println);*/

        addOperator(coursesStream2.map(course -> course + "!!")
                .filter(course -> course.contains("Java"))).forEach(System.out::println);

    }

    static <T>Stream<T> addOperator(Stream<T> stream){
        return stream.peek(data -> System.out.println("Data: " + data));
    }
}
