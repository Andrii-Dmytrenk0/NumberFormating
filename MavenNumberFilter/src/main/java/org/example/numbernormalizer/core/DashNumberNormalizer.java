package org.example.numbernormalizer.core;

import org.example.numbernormalizer.usecase.NumberNormalizer;

public class DashNumberNormalizer implements NumberNormalizer {

    private static final int CURRENT_LENGTH = 11;
    private static final int GROUP_SIZE = 3;
    public static final String DELIMITER = "-";

    @Override
    public String normalize(String numberToFormat) {
        numberToFormat = removeWhiteSpacesBeforeAndAfterNumber(numberToFormat);
        validate(numberToFormat);
        var prefix = extractPrefix(numberToFormat);
        var rowNumber = extractRowNumber(numberToFormat);
        var dividedByThree = divideMainNumberByGroups(rowNumber);
        var dashednumber = joinWithDelimeter(dividedByThree);
        return prefix + dashednumber;
    }

    private static String joinWithDelimeter(String[] dividedByThree) {
        return String.join(DELIMITER, dividedByThree);
    }

    private static String[] divideMainNumberByGroups(String rowNumber) {
        var pattern = "(.{" + GROUP_SIZE + "})";
        return rowNumber.replaceAll(pattern, "$1 ").split(" ");
    }

    private static String extractRowNumber(String numberToFormat) {
        return numberToFormat.substring(2);
    }

    private static String removeWhiteSpacesBeforeAndAfterNumber(String numberToFormat) {
        return numberToFormat.trim();
    }

    private static String extractPrefix(String numberToFormat) {
        return numberToFormat.substring(0, 2) + "-";
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
