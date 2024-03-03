package com.lld.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalStateTest {

    public void start() {
        testTerminalStates();
    }
    void testTerminalStates() {

        /**
         *   Terminal States
          */

        // 1. forEach
        Stream<Integer> stream = Stream.of(1,2,3);
        stream.forEach(System.out::println);

        // 2. collect
        List<Integer> list = Stream.of(1,2,3).collect(Collectors.toList());
        Set<Integer> set = Stream.of(1,2,3).collect(Collectors.toSet());
        Map<Integer, Integer> map = Stream.of(1,2,3).collect(Collectors.toMap(Integer::intValue, Integer::intValue));
        Map<Integer, Integer> concurrentMap = Stream.of(1,2,3).collect(Collectors.toConcurrentMap(Integer::intValue, Integer::intValue));
        Double average = Stream.of("1","2","3").collect(Collectors.averagingDouble(a -> Double.parseDouble(a)));
        average = Stream.of(1,2,3).collect(Collectors.averagingInt(a->a));
        average = Stream.of(1,2,3).collect(Collectors.averagingLong(a->a));
        Long size = Stream.of(1,2,3).collect(Collectors.counting());
        int ans = Stream.of(1,2,3).collect(Collectors.summingInt(a->a));
        Map<Integer, List<Integer>> res = Stream.of(1,2,3,1,1).collect(Collectors.groupingBy(Integer::intValue));
        Optional<Integer> ans1 = Stream.of(1,2,3).collect(Collectors.maxBy(Comparator.reverseOrder()));

        // 3. anyMatch, allMatch, NoneMatch
        boolean match = Stream.of(1,2,3).anyMatch(a-> a==1); // true
        match = Stream.of(1,1,1).allMatch(a-> a==1); // true
        match = Stream.of(1,2,3).noneMatch(a-> a==1); // false

        // 4. findAny, findFirst, max, min
        Optional<Integer> val1 = Stream.of(1,2,3).findAny();   // any value from list
        Optional<Integer> val2 = Stream.of(1,2,3).findFirst();  // 1
        Optional<Integer> val3 = Stream.of(1,2,3).max(Comparator.naturalOrder());   // 3
        Optional<Integer> val4 = Stream.of(1,2,3).min(Comparator.naturalOrder());  // 1

        // 5. count
        long cnt = Stream.of(1,2,3).count();  // 3

        // 6. reduce
        class User {
            int salary;
            User(int sal) {
                salary = sal;
            }
        }
        int sum1 = Stream.of(1,2,3).reduce(0, Integer::sum); //6
        Optional<Integer> sum2 = Stream.of(1,2,3).reduce(Integer::sum); //6
        int sum3 = Stream.of(new User(100),new User(200),new User(300)).reduce(0, (curr, user) -> curr +
                user.salary, Integer::sum); //600

    }
}
