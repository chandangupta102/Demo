package com.lld.java8;

import java.util.function.*;

interface Sum<T,K, R> {
    R add(T a,K b);
}

public class FunctionalInterfaceClass {
    public void start() {
        System.out.println("Functional Interfaces");
        test();
    }

    private void test() {
        // 1. Supplier
        Supplier<Integer> supplier = () -> 10;
        System.out.println(supplier.get());

        // 2. Predicate
        Predicate<Integer> predicate = (a) -> a%2==0;
        System.out.println(predicate.test(10));
        System.out.println(predicate.test(5));

        // 3. Consumer
        Consumer<Integer> consumer = (a) -> System.out.println(a);
        consumer.accept(100);

        // 4. Function
        Function<Integer, String> function = (x) -> String.valueOf(x);
        System.out.println(function.apply(10));

        // 5. BiFunction
        BiFunction<Integer, Integer, String> biFunction = (x, y) -> String.valueOf(x + y);
        System.out.println(biFunction.apply(10, 20));

        // 6. UnaryOperator extends Function Interface
        UnaryOperator<Integer> unaryOperator = (x) -> x;
        System.out.println(unaryOperator.apply(10));

        // 7. BinaryOperator extends BiFunction Interface
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        System.out.println(binaryOperator.apply(10, 20));

        // 8. Custom
        Sum<Integer, String, String> sum = (a,b) -> a + b;
        System.out.println(sum.add(2, " two"));

    }
}
