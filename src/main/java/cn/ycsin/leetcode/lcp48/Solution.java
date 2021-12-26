package cn.ycsin.leetcode.lcp48;

import java.util.Arrays;

public class Solution {
    private static final int Y = 1;
    private static final int X = 0;

    public String gobang(int[][] pieces) {
        _print(pieces);
        return "";
    }

    private void _print(int[][] pieces) {
        int ySize = Integer.MIN_VALUE, xSize = Integer.MIN_VALUE;

        for (int i = 0; i < pieces.length; i++) {
            ySize = Integer.max(xSize, pieces[i][Y]);
            xSize = Integer.max(xSize, pieces[i][X]);
        }

        System.out.println(xSize + ":" + ySize);

        int gard = 0;
        for (int i = 1; i <= ySize; i++) {
            for (int j = 1; j <= xSize; j++) {
                if (pieces[gard][X] == i && pieces[gard][Y] == j) {
                    System.out.print(pieces[gard][2] == 0 ? 'x' : 'o');
                    gard++;
                } else {
                    System.out.print('-');
                }
            }
            System.out.println();
        }
    }


}