package com.myworld.adamant.util;

import java.util.HashMap;
import java.util.Map;

public interface Constant {

    String UNIQUE_ID_GENERATION_COUNTER_KEY = "UNIQUE_ID_GENERATION_COUNTER_KEY";

    Map<Character, Character> UNIQUE_ID_RANDOMIZER = new HashMap<>() {{
        put('0', '6');
        put('1', '0');
        put('2', '7');
        put('3', '9');
        put('4', '1');
        put('5', '3');
        put('6', '2');
        put('7', '4');
        put('8', '5');
        put('9', '8');
        put('-', '9');
    }};


}
