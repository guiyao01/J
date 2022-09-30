package com.gy.DataStructure.SparseArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class demo_n1 {
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[11][11];
        arr[1][2] = 4;
        arr[2][3] = 7;

        for (int[] d1 : arr) {
            for (int d2 : d1) {
                System.out.print("\t"+d2);
            }
            System.out.println();
        }

        System.out.println("==================");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);

        //创建对应稀疏数组
        int[][] sparseArr = new int[sum + 1][3];

        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] =arr[i][j];
                    count++;
                }
            }
        }
//        for (int[] d1 : sparseArr) {
//            for (int d2 : d1) {
//                System.out.print(d2+"\t");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        //恢复原始二位数组
        int[][] recover = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            recover[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int[] ints : recover) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        //写入内存
        String url = "/Users/victorli/Documents/projectMaterial/map.txt";
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(url, true));
//        for (int[] ints : sparseArr) {
//            for (int anInt : ints) {
//                bufferedWriter.write(anInt+"\t");
//            }
//            bufferedWriter.write("\n");
//        }
//        bufferedWriter.close();

        String line = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
            String[] s = line.split(" ");
            for (String s1 : s) {
                System.out.print(s1+"\t");
            }
        }


        bufferedReader.close();
    }
}
