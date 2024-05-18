package com.lld.java8.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class HelloWorld {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);

        //1. find even and odd numbers
        Map<Boolean, List<Integer>> res = list.stream().collect(Collectors.partitioningBy(a->a%2==0));
        System.out.println(res);


        //2. remove duplicate from the list
        list.stream().distinct().forEach(System.out::print);

        //3. frequency of each character in string
        String imput = "testbytest";
        Map<Character, Long> uniqueRes = imput.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));       System.out.println("\n" + uniqueRes);


        //4. frequency of each element in Array
        Map<Integer, Long> uniqueListRes = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("\n" + uniqueListRes);


        //5. Sort the list in reversed Order
        List<Integer> sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("\n" + sortedList);

        //6. Join list of String with Prefix,Suffix,delimeter
        List<String> strList = Arrays.asList("sd", "cd", "bd");
        String resStr = strList.stream().collect(Collectors.joining("$", "Prefix", "suffix"));
        System.out.println("\n" + resStr);


        //7. print multiples of 5 from the list
        list.add(15);
        list.stream().filter(a-> a%5 == 0).forEach(System.out::print);

        //8. max from the list
        Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
        System.out.println("\n" + max.get());

        //9. min from the list
        Optional<Integer> min = list.stream().min(Comparator.naturalOrder());
        System.out.println("\n" + min.get());

        //10. merge two unsorted array to single sorted array
        List<Integer> list1 = Arrays.asList(2,1,4,3);
        List<Integer> list2 = Arrays.asList(5,7,8,6);
        List<Integer> mergeSortedList = Arrays.asList(list1, list2).stream()
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("\n" + mergeSortedList);


        //11. total sum of digits

        int total = Stream.of(String.valueOf(1234).split(""))
                .collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("\n" + total);


        //12. second largest number

        int large = Stream.of(1,5,4,3,2)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("\nLarge : " + large);

        //13 Reverse each of word of a string
        String reverseStrWords = Arrays.stream(new String("Hello World Test").split(" "))
                .map((str)-> new StringBuffer(str).reverse().toString())
                .collect(Collectors.joining(" "));

        System.out.println("\nStr words : " + reverseStrWords);

        //14 Sum of first 10 natural number
        int rangeSum = IntStream.rangeClosed(1,10).sum();
        System.out.println("\nSum : " + rangeSum);


        //15 Fib series
        List<Integer> reStream = Stream.iterate(new int[]{0,1}, (f)-> new int[] {f[1], f[0] + f[1]})
                .limit(10)
                .map(f-> f[0])
                .collect(Collectors.toList());

        System.out.println("\nreStream : " + reStream);

        //16. reverse an integer array
        int[] inp = {2,1,4,5};
        IntStream.rangeClosed(0, inp.length-1)
                .map(i-> inp[inp.length-i-1])
                .toArray();


        // 17. palindrome String
        String sample = "NEEN";
        Boolean isPalin = IntStream.range(0, sample.length()/2)
                .allMatch(index -> sample.charAt(index) == sample.charAt(sample.length()-1-index));
        System.out.println("\nisPalin : " + isPalin);


    }
}
