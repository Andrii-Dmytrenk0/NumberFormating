package org.example;

import org.example.numbernormalizer.core.DashNumberNormalizer;
import org.example.numbernormalizer.usecase.NumberNormalizer;

public class Main {

    public static void main(String[] args) {
        validate(args);
        NumberNormalizer normalizer = new DashNumberNormalizer();

        var input = args[0];
        var result = normalizer.normalize(input);
        System.out.println(result);
    }

    private static void validate(String[] args) {
        if(args.length != 1) {
            throw new IllegalArgumentException("Insert number to normalize via 1 argument");
        }
    }
}