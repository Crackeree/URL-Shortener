package com.myworld.adamant.util;

import org.apache.commons.lang3.StringUtils;

public class AppUtil {

    public static String generateUniqueId(long number) {

        long idGenerationSeed = Long.rotateLeft(number, 32);

        return StringUtils.leftPad(Long.toString(idGenerationSeed), 20, '0');
    }
}
