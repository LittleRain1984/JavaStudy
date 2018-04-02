package org.edward.javastudy.algorithm;

public class LCSTEST {
    public static void main(String[] args) {
        String s1 = "www.baidu.com";
        String s2 = "abc.baidu.c";
        LCSTEST.LCS(s1, s2);
    }

    public static String LCS(String s1, String s2) {


        if (s1.length() == 0 || s2.length() == 0) {
            System.out.println("none LCS.");
        }

        char[] charStr1 = s1.toCharArray();
        char[] charStr2 = s2.toCharArray();

        int[][] result = new int[charStr1.length][charStr2.length];

        for (int i = 0; i < charStr1.length; i++) {
            if (charStr1[i] == charStr2[0]) {
                result[i][0] = 1;
            }
        }

        for (int i = 0; i < charStr2.length; i++) {
            if (charStr2[i] == charStr1[0]) {
                result[0][i] = 1;
            }
        }

        int length = 0;
        int endX = 0;
        int endY = 0;
        for (int i = 1; i < charStr1.length; i++) {

            for (int j = 1; j < charStr2.length; j++) {
                if (charStr1[i] == charStr2[j]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = 0;
                }

                if (result[i][j] > length) {
                    length = result[i][j];
                    endX = i;
                    endY = j;
                }
            }
        }

        String resultString = s2.substring(endY - length + 1, endY + 1);


        System.out.println("LCS string is: " + resultString);

        return resultString;
    }
}
