package org.example.numbernormalizer.core;

import org.example.numbernormalizer.usecase.NumberNormalizer;

public class DashNumberNormalizer implements NumberNormalizer {

    private static final int CURRENT_LENGTH = 11;

    @Override
    public String normalize(String numberToFormat) {
        numberToFormat = numberToFormat.trim();
        validate(numberToFormat);
        var prefix = numberToFormat.substring(0,2) + "-";
        var rowNumber = numberToFormat.substring(2);
        var dividedByThree = rowNumber.replaceAll("(.{3})","$1 ").split(" ");
        var dashednumber = String.join("-", dividedByThree);
        return prefix + dashednumber;
    }

    private void validate(String numberToFormat) {
        if(!hasCorrectLength(numberToFormat) || !isNumber(numberToFormat)) {
            throw new IllegalArgumentException("Given input: " + numberToFormat + " is incorect, insert 11 digit number");
        }
    }

    private static boolean hasCorrectLength(String numberToFormat) {
        return numberToFormat.length() == CURRENT_LENGTH;
    }

    private boolean isNumber(String numberToFormat) {
        try {
            Long.parseLong(numberToFormat);
        } catch (Exception i) {
            return false;
        }

        return true;
    }


}
