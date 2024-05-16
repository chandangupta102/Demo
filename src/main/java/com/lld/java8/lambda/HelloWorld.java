package com.lld.java8.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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


        //11. anagram program



    }
}
