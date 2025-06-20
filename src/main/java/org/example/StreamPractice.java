package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String [] args){
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(3);
        li.add(8);
        li.add(89);
        li.add(56);

        List<Integer> li2 = li.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.println(li2);
        List<Integer> li3 = li.stream().map(i -> i+1).collect(Collectors.toList());
        System.out.println(li3);
        List<Integer> li4 = (List<Integer>) li.stream().sorted();
    }
}
