package com.topcoder.archive;

/**
 * RetroSensei
 * https://community.topcoder.com/stat?c=problem_statement&pm=14601
 */

public class EllysBottle {

    public static void main(String[] args) {
        double[] bottles = {42, 13, 17, 7, 22};
        System.out.println(getVolume(bottles, 8));
    }

    public static double getVolume(double[] bottles, int k) {
        double volume = 0;
        for(int i = 0; i < k; i++) {
            double max = 0, min = Double.MAX_VALUE;
            int indexMin = 0, indexMax = 0;
            for(int j = 0; j < bottles.length; j++) {
                if(bottles[j]>max) {
                    max = bottles[j];
                    indexMax = j;
                }
                if(bottles[j]<min) {
                    min = bottles[j];
                    volume = min;
                    indexMin = j;
                }
            }
            bottles[indexMin] = (bottles[indexMin] + bottles[indexMax])/2;
            bottles[indexMax] = bottles[indexMin];
        }
        return volume;
    }
}
