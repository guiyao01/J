package com.gy.DataStructure.SparseArray;

import java.io.*;

public class demo {
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[4][5] = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"  ");
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        //打印稀疏数组
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }
        System.out.println("将稀疏数组写入磁盘");
        File file = new File("D:\\temp\\map.data");
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"utf-8");
        for (int i = 0; i < sparseArr.length; i++) {
            if (i == sparseArr.length - 1) {
                outputStreamWriter.write(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2]);
            } else {
                outputStreamWriter.write(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2]+",");
            }
        }
        outputStreamWriter.close();
        outputStream.close();
        System.out.println("写入成功");

        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        StringBuffer stringBuffer = new StringBuffer();
        while (inputStreamReader.ready()) {
            stringBuffer.append((char) inputStreamReader.read());
        }
        System.out.println("读出的子文件\n" + stringBuffer.toString());
        inputStreamReader.close();
        fileInputStream.close();
        String[] readArr = stringBuffer.toString().split(",");
        int[][] getArr = new int[readArr.length/3][3];
        int temp = 0;
//        for (int i = 0; i < getArr.length; i++) {
//            getArr[i][0] = Integer.parseInt(readArr[temp++]);
//            getArr[i][1] = Integer.parseInt(readArr[temp++]);
//            getArr[i][2] = Integer.parseInt(readArr[temp++]);
//        }
        for (String s : readArr) {
            System.out.println(temp % 3);
            getArr[temp / 3][temp % 3] = Integer.parseInt(s);
            temp++;
        }
        System.out.println("========================");
        for (int[] ints : getArr) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println();
        }

        //还原稀疏数组：
        int originArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            originArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("==============================");
        for (int[] ints : originArr) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t\n",
                    ints[0],ints[1],ints[2],ints[3],ints[4],ints[5],ints[6],ints[7],ints[8],ints[9],ints[10]);
        }
    }
}
