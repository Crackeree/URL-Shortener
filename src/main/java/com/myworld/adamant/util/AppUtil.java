package com.myworld.adamant.util;

import org.apache.commons.lang3.StringUtils;

public class AppUtil {

    public static String generateUniqueId(long number) {

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

            chars[i] = Constant.UNIQUE_ID_RANDOMIZER.get(chars[i]);
        }

        return new String(chars);
    }
}
