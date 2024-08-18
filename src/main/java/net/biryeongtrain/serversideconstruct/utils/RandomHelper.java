package net.biryeongtrain.serversideconstruct.utils;

import java.util.Random;

public class RandomHelper {
    private static final Random random = new Random();

    public static int getRandom(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
