package com.topcoder.archive;

import java.util.Scanner;

/**
 * bbernovici
 */

public class ILike5 {

    public static void main(String[] args) {
        long[] x;
        int n, steps = 0;
        boolean isOk = false;

        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        x = new long[n];

        for(int i = 0; i < n; i++) {
            x[i] = s.nextLong();
        }

        for(int i = 0; i < n; i++) {
            if (x[i] % 2 == 0) {
                steps += 1;
            } else if (x[i] % 10 == 5) {
                isOk = true;
            }
        }

        steps = steps + (isOk || steps != 0 ? 0 : 1);

        System.out.println(steps);

    }


}
