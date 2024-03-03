package com.lld.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class StreamIntermediateStateTest {

    public void start() {
        test();
    }

    private void test() {

        //1. map, filter, peek, distinct, limit, sorted, skip
        System.out.println("Intermediate States");
        Long res = Stream.of(1,4,1,2,3)
                .map(a-> a * 2)
                .filter(a -> a%2==0)
                .peek(a-> System.out.print(a + ","))
                .distinct()
                .limit(10)
                .sorted()
                .peek(a-> System.out.print(a + ","))
                .skip(1)
                .peek(a-> System.out.print(a + ","))
                .count();

        // 2. flatMap
        List<List<Integer>> number = new ArrayList<>();
        number.add(Arrays.asList(1, 2));
        number.add(Arrays.asList(3, 4));
        number.add(Arrays.asList(5, 6));
        number.add(Arrays.asList(7, 8));
        System.out.println("List of list-" + number);
        List<Integer> flatList
                = number.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("List generate by flatMap-" + flatList);


        //3. MapToInt, MapToDouble, mapToLong
        Stream.of("1.2", "2.4", "6", "0.1", "2.0")
                .mapToDouble(Double::parseDouble)
                .forEach(a-> System.out.print(a + ","));
        System.out.println();
        Stream.of("1", "2", "6", "0", "2")
                .mapToInt(Integer::parseInt)
                .forEach(a-> System.out.print(a + ","));
        System.out.println();
        Stream.of("1", "2", "6")
                .mapToLong(Long::parseLong)
                .forEach(a-> System.out.print(a + ","));


        //4. flatMapToInt, flatMapToDouble, flatMapToLong
        Stream.of("1.2", "2.4", "6", "0.1", "2.0")
                .flatMapToDouble(a->DoubleStream.of(Double.parseDouble(a)))
                .forEach(a-> System.out.print(a + ","));
        System.out.println();
        Stream.of("1", "2", "6", "0", "2")
                .flatMapToInt(s->IntStream.of(Integer.parseInt(s)))
                .forEach(a-> System.out.print(a + ","));
        System.out.println();
        Stream.of("1", "2", "6")
                .flatMapToLong(a->LongStream.of(Long.parseLong(a)))
                .forEach(a-> System.out.print(a + ","));

    }
}
