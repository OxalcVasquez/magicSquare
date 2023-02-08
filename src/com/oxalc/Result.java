package com.oxalc;

import java.util.*;
import java.util.ArrayList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */


    public static Set<List<Integer>> solutions = new HashSet<>();

    public static List<Integer> listStringToInt(List<String> myList ){

        List<Integer> intList = new ArrayList<>();
        for (String s : myList) {
            intList.add(Integer.parseInt(s));
        }

        return intList;
    }

    public static void permute(String str, String ans) {

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i); //"1"

            String ros = str.substring(0, i) + str.substring(i + 1); //"" + "23456789"
            String newString = ros + ans + ch; //234567891

            List<String> myList = new ArrayList<String>(Arrays.asList(newString.split("")));

            //System.out.println(newString);

            if(isMagicSquare(listStringToInt(myList))){
                solutions.add(listStringToInt(myList));
            }
            // Recursive call
            if(solutions.size() < 9){
                permute(ros,ans + ch); //23456789, "1"
            }
        }
    }


    // public static List<List<Integer>> generateAllPermutation() {
    //     List<Integer> test = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    // }

    public static boolean isMagicSquare(List<Integer> ms){
        int magicConstant = 15; // (3(3^2+1)/2)
        int rowSum = 0;
        int columnSum = 0;
        int diagonalSumRight = ms.get(0) + ms.get(4) + ms.get(8);
        int diagonalSumLeft  = ms.get(2) + ms.get(4) + ms.get(6);

        //Diagonal
        if (diagonalSumRight != magicConstant || diagonalSumLeft != magicConstant) {
            return false;
        }


        //Rows
        for (int i = 0; i < ms.size(); i += 3) {
            //Row sum
            rowSum = ms.get(i) + ms.get(i+1) + ms.get(i+2);

            if(rowSum != magicConstant){
                return false;
            }

            rowSum = 0; // next row; rowSum = 0

        }

        //Columns
        for (int i = 0; i < 3; i++) {
            //column sum
            columnSum = ms.get(i) + ms.get(i+3) + ms.get(i+6);

            if(columnSum != magicConstant){
                return false;
            }

            columnSum = 0; // next row; rowSum = 0

        }

        return true;
    }


    public static int calculateCost(List<Integer> s, List<Integer> newMs){
        int totalCost = 0;
        for (int i = 0; i < s.size(); i++) {
            totalCost += Math.abs(s.get(i) - newMs.get(i));
            //if (costReplacement > 0){ } if i need to now the number of replacemente
        }
        return totalCost;
    }


    public static int formingMagicSquare(List<List<Integer>> s) {

        List<Integer> oneDimension = new ArrayList<>();

        for (int i = 0; i < s.size(); i++) {
            List<Integer> row = s.get(i);
            for (int j = 0; j < s.size(); j++) {
                oneDimension.add(row.get(j)); // Two dimensional -> to one dimension

            }
        }

        //List<Integer> test = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        permute("123456789","");
        List<Integer> solutionMinCost = new ArrayList<>();

        int minCost = Integer.MAX_VALUE;

        for (List<Integer> solution : solutions) {
            //System.out.println(solution);
            int cost = calculateCost(oneDimension, solution);
            if(cost < minCost) {
                minCost = cost;
                solutionMinCost = solution;
            };
        }



        //List<Integer> test = new ArrayList<>(Arrays.asList(8,3,4,1,5,9,6,7,2));
        //List<Integer> test = new ArrayList<>(oneDimension);
        //if (isMagicSquare(test)) {System.out.println("Es magico");}
        System.out.println("Solucion con mínimo costo: "+ solutionMinCost + " Min costo : " + minCost);
        return minCost;
    }

}

