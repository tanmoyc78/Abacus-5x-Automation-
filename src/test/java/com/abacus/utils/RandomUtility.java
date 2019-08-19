package com.abacus.utils;

import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class RandomUtility {

    public static String getRandomString(String stringElements, Integer stringLength) throws IllegalArgumentException {
        try {
            stringElements.equals(null);
            try {
                stringLength.equals(null);
                if (stringElements.length() == 0) {
                    throw new IllegalArgumentException("String Elements cannot be of length 0.");
                }
                else if (stringElements.length() > 4) {
                    throw new IllegalArgumentException("String Elements can be maximum of length 4.");
                }
                else if (stringLength <= 0) {
                    throw new IllegalArgumentException("String Length must be greater than 0.");
                }
                else if (!StringUtils.containsOnly(stringElements, "Aa0!")) {
                    throw new IllegalArgumentException("String Elements contain unacceptable characters.");
                }
                else {
                    String[] characterSets = new String[] {
                            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                            "abcdefghijklmnopqrstuvwxyz",
                            "0123456789",
                            "˜`!@#$%ˆ&*(){}[]_-+=|\\:;\"\'<>,.?/"
                    };
                    StringBuilder stringBuilder = new StringBuilder();
                    while (stringBuilder.length() < stringLength) {
                        for (int i = 0; i < stringElements.length(); i++) {
                            switch (stringElements.charAt(i)) {
                                case 'A': {
                                    int characterIndex = new Random().nextInt(characterSets[0].length());
                                    stringBuilder.append(characterSets[0].charAt(characterIndex));
                                    break;
                                }
                                case 'a': {
                                    int characterIndex = new Random().nextInt(characterSets[1].length());
                                    stringBuilder.append(characterSets[1].charAt(characterIndex));
                                    break;
                                }
                                case '0': {
                                    int characterIndex = new Random().nextInt(characterSets[2].length());
                                    stringBuilder.append(characterSets[2].charAt(characterIndex));
                                    break;
                                }
                                case '!': {
                                    int characterIndex = new Random().nextInt(characterSets[3].length());
                                    stringBuilder.append(characterSets[3].charAt(characterIndex));
                                    break;
                                }
                            }
                            if (stringBuilder.length() == stringLength) {
                                break;
                            }
                        }
                    }
                    return stringBuilder.toString();
                }
            }
            catch (NullPointerException e) {
                throw new IllegalArgumentException("String Length cannot be null.");
            }
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException("String Elements cannot be null.");
        }
    }

}
