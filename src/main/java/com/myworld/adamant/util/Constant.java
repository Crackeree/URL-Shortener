package com.myworld.adamant.util;

import java.util.HashMap;
import java.util.Map;

public interface Constant {

    String UNIQUE_ID_GENERATION_COUNTER_KEY = "UNIQUE_ID_GENERATION_COUNTER_KEY";
    String URL_SHORTENER_UNIQUE_ID_GENERATION_COUNTER_KEY = "URL_SHORTENER_UNIQUE_ID_GENERATION_COUNTER_KEY";

    Map<Character, Character> NUMERIC_UNIQUE_ID_RANDOMIZER = new HashMap<>() {{
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


    Map<String, String> ALPHANUMERIC_UNIQUE_ID_RANDOMIZER = new HashMap<>() {{
        put("0", "3");
        put("1", "8");
        put("2", "s");
        put("3", "N");
        put("4", "l");
        put("5", "b");
        put("6", "2");
        put("7", "0");
        put("8", "P");
        put("9", "c");
        put("10", "5");
        put("11", "d");
        put("12", "g");
        put("13", "J");
        put("14", "m");
        put("15", "H");
        put("16", "h");
        put("17", "F");
        put("18", "j");
        put("19", "K");
        put("20", "f");
        put("21", "L");
        put("22", "e");
        put("23", "R");
        put("24", "r");
        put("25", "E");
        put("26", "i");
        put("27", "U");
        put("28", "1");
        put("29", "I");
        put("30", "4");
        put("31", "X");
        put("32", "a");
        put("33", "W");
        put("34", "t");
        put("35", "Z");
        put("36", "9");
        put("37", "V");
        put("38", "n");
        put("39", "C");
        put("40", "o");
        put("41", "A");
        put("42", "Y");
        put("43", "u");
        put("44", "6");
        put("45", "B");
        put("46", "v");
        put("47", "M");
        put("48", "w");
        put("49", "Q");
        put("50", "k");
        put("51", "D");
        put("52", "y");
        put("53", "7");
        put("54", "O");
        put("55", "z");
        put("56", "T");
        put("57", "x");
        put("58", "G");
        put("59", "q");
        put("60", "S");
        put("61", "p");
    }};
}
