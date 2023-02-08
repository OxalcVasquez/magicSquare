package com.oxalc;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) throws IOException {

        List<List<Integer>> testList = new ArrayList<>();
        List<Integer> column1 = new ArrayList<>(Arrays.asList(5,3,4));
        List<Integer> column2 = new ArrayList<>(Arrays.asList(1,5,8));
        List<Integer> column3 = new ArrayList<>(Arrays.asList(6,4,2));

        //5 3 4
        //1 5 8
        //6 4 2
        testList.add(column1);
        testList.add(column2);
        testList.add(column3);

        Result.formingMagicSquare(testList);
    }
}
