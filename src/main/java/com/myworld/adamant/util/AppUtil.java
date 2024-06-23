package com.myworld.adamant.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;

public class AppUtil {

    public static String generateNumericUniqueId(long number) {

        long idGenerationSeed = Long.rotateLeft(number, 59);

        String formatedUniqueId;

        if (idGenerationSeed >= 0) {

            formatedUniqueId = StringUtils.leftPad(Long.toString(idGenerationSeed), 20, '0');
        } else {

            formatedUniqueId = StringUtils.leftPad(Long.toString(-idGenerationSeed), 19, '0');
            formatedUniqueId = "-".concat(formatedUniqueId);
        }

        char[] chars = formatedUniqueId.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            chars[i] = Constant.NUMERIC_UNIQUE_ID_RANDOMIZER.get(chars[i]);
        }

        return new String(chars);
    }

    public static String numericToAlphanumeric(String numericUniqueId) {

        BigInteger bigInteger = new BigInteger(numericUniqueId);

        return convertToBase62(bigInteger);
    }

    private static String convertToBase62(BigInteger bigInteger) {

        StringBuilder stringBuilder = new StringBuilder();

        if (bigInteger.compareTo(BigInteger.ZERO) == 0) {

            stringBuilder.append(Constant.ALPHANUMERIC_UNIQUE_ID_RANDOMIZER.get("0"));

        } else {

            while (bigInteger.compareTo(BigInteger.ZERO) > 0) {

                BigInteger reminder = bigInteger.mod(BigInteger.valueOf(62L));
                bigInteger = bigInteger.divide(BigInteger.valueOf(62L));

                stringBuilder.append(Constant.ALPHANUMERIC_UNIQUE_ID_RANDOMIZER.get(reminder.toString()));
            }
        }

        stringBuilder.reverse();

        String base62Number = stringBuilder.toString();

        return StringUtils.leftPad(base62Number, 12, Constant.ALPHANUMERIC_UNIQUE_ID_RANDOMIZER.get("0"));
    }
}
