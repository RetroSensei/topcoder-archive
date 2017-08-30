package com.topcoder.archive;

import java.util.ArrayList;

/**
 * RetroSensei
 * https://community.topcoder.com/stat?c=problem_statement&pm=14416&rd=16821
 */

public class XMarksTheSpot {

    static class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        String[] map = {
                "?.",
                ".O"
        };

        String[] map2 = {"OOOOOOO", "OOOOO.?", "OO.OOOO", ".OO?OOO", "OOO.OOO", "OOOOOOO", "OOOO?.O", "O?OO?OO", "O?OO?O.", "O?O...O", "OOO.OO?", "OOO?O.O", "O.OOO.O", "O..O.OO", "O.OOOOO", "OO.OOO.", "..?.OO?", "OO?OOOO", "?OO?OO.", "?.OOOOO", "O.OOO.?", "O.OOOOO"};

        String[] map3 = {"OOOO.OOOOOOO..O.O..O?OOOOOO...", "OO...O...OOOO.O.?OOOOOOOOOO?OO", ".O.OO.O..OO.OOOOOOOOOO.OOO.OOO", "O.OOOOO.O.O.?OOOO..OO.OO.O.OOO", "OOO...O..OO.OO?..O..OOOO.OOO.O", "OOO.O?OOOOO.OO.OO.OOOO.OOOO?.O", "..O.O..O.OO.OOOO.OO.O..OO.OO.O", "OOOOOOO.O.OO...OOOOO.OOOOO.OOO", "OO.OOOO?O?.OOOO..O.OO..?OO.OO.", "OO.OOOO..?OO.OOOOOOOO?OO...OOO", "..?O.OOO.OOOOOOOOO?OO.O...OOOO", ".OOOOOOO.O.O.O.O..OOOO..O...OO", "O.OOOO.O...?O.O..OOOOOOOOOOO.O", "OOO.OO.OOO..OOOOOOO.O.OOOOOOOO", "OOOOO..O.OOOOOOOOO.O..OOOOO?O."};

        System.out.println(countArea(map));
        System.out.println(countArea(map2));
        System.out.println(countArea(map3));
    }

    public static int countArea(String[] board) {
        int noq = 0, noo = 0, nos = 0;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
        ArrayList<Point> points = new ArrayList<Point>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == '?') {
                    points.add(new Point(i, j));
                }
                if (board[i].charAt(j) == 'O') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        int result = 0;
        // left bitshift for 2^size
        for (int block = 0; block < 1 << points.size(); block++) {
            int blockMinX = minX;
            int blockMinY = minY;
            int blockMaxX = maxX;
            int blockMaxY = maxY;
            for (int i = 0; i < points.size(); i++) {
                if ((block & (1 << i)) != 0) {
                    blockMinX = Math.min(blockMinX, points.get(i).x);
                    blockMinY = Math.min(blockMinY, points.get(i).y);
                    blockMaxX = Math.max(blockMaxX, points.get(i).x);
                    blockMaxY = Math.max(blockMaxY, points.get(i).y);
                }
            }
            result += (blockMaxX - blockMinX + 1) * (blockMaxY - blockMinY + 1);
        }
        return result;
    }
}
