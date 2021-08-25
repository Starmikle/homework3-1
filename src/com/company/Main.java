package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        int[] array1 = {1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0};
        printArray1("1. Before:\t", array1);
        change(array1);
        printArray1("1. After:\t", array1);

        System.out.println("**********");


        int[] array2 = new int[100];
        fillIn(array2);
        printArray1("2. Filled with cycle:\t", array2);

        System.out.println("**********");


        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray1("3. Before:\t", array3);
        doubling(array3);
        printArray1("3. After:\t", array3);

        System.out.println("**********");


        int side = 10;
        int[][] array4 = new int[side][side];
        crossFill(array4);
        printArray2("4. Result fill diagonals", array4);


        int[] returnArrayFromMethod = returnArray(10, 999);
        printArray1("5. Array from method", returnArrayFromMethod);


        printArray1("6. Find min & max in array\t", array3);
        System.out.println("6. Minimum: " + findMin(array3));
        System.out.println("6. Maximum: " + findMax(array3));


        int[] balance = {1, 1, 1, 1, 1, 1, 6};
        System.out.print("6. Is the " + Arrays.toString(balance) + " balanced? ");
        System.out.println(checkBalance(balance));


        int[] shiftArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArray1("7. Array for shift", shiftArray);
        shifter(shiftArray, -3);
        printArray1("shift <<< (-3)", shiftArray);
        shifter(shiftArray, 6);
        printArray1("shift >>> (+6)", shiftArray);
    }


    public static void printArray1(String msg, int[] inputArray) {
        System.out.print(msg + ": ");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }


    public static void printArray2(String msg, int[][] inputArray) {
        System.out.println(msg);
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void change(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }

    }

    public static void fillIn(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
    }

    public static void doubling(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6)
                array[i] *= 2;
    }

    public static void crossFill(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
    }

    public static int[] returnArray(int len, int initValue) {
        int[] tempArray = new int[len];

        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = initValue;
        }

        return tempArray;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static boolean checkBalance(int[] array) {
        int right = 0, left = 0;
        for (int i = 0; i < array.length - 1; i++) {
            left += array[i];
            for (int j = i + 1; j < array.length; j++)
                right += array[j];
            if (left == right) return true;
            right = 0;
        }
        return false;
    }

    private static void shifter(int[] array, int value) {
        boolean direction;
        if (value < 0) {
            direction = true;
            value = -value;
        } else {
            direction = false;
        }
        value %= array.length;
        int lastIndex = array.length - 1;
        for (int i = 0; i < value; i++) {
            int temp = (direction) ? array[0] : array[lastIndex];
            for (int j = 0; j < lastIndex; j++) {
                if (direction)
                    array[j] = array[j + 1];
                else
                    array[lastIndex - j] = array[lastIndex - j - 1];
            }
            if (direction)
                array[lastIndex] = temp;
            else
                array[0] = temp;
        }
    }
}
