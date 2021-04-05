package net.angelco.task2.utils;

import org.apache.commons.lang3.StringUtils;
import com.github.javafaker.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.join;

// https://github.com/DiUS/java-faker/blob/master/src/main/java/com/github/javafaker/Lorem.java

public class Lorem {
    private final Faker faker;

    public Lorem() {
        this.faker = new Faker();
    }

    public char character() {
        return character(false);
    }

    public char character(boolean includeUppercase) {
        return characters(1, includeUppercase).charAt(0);
    }

    public String characters() {
        return characters(255, false);
    }

    public String characters(boolean includeUppercase) {
        return characters(255, includeUppercase);
    }

    public String characters(int minimumLength, int maximumLength) {
        return characters(faker.random().nextInt(maximumLength - minimumLength) + minimumLength, false);
    }

    public String characters(int minimumLength, int maximumLength, boolean includeUppercase) {
        return characters(faker.random().nextInt(maximumLength - minimumLength) + minimumLength, includeUppercase);
    }

    public String characters(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeDigit) {
        return characters(faker.random().nextInt(maximumLength - minimumLength) + minimumLength, includeUppercase,
                includeDigit);
    }

    public String characters(int fixedNumberOfCharacters) {
        return characters(fixedNumberOfCharacters, false);
    }

    public String characters(int fixedNumberOfCharacters, boolean includeUppercase) {
        return characters(fixedNumberOfCharacters, includeUppercase, true);
    }

    public String characters(int fixedNumberOfCharacters, boolean includeUppercase, boolean includeDigit) {
        if (fixedNumberOfCharacters < 1) {
            return "";
        }
        char[] buffer = new char[fixedNumberOfCharacters];
        for (int i = 0; i < buffer.length; i++) {
            char randomCharacter;

            if (includeDigit) {
                randomCharacter = characters[faker.random().nextInt(characters.length)];
            } else {
                randomCharacter = letters[faker.random().nextInt(letters.length)];
            }

            if (includeUppercase && faker.bool().bool()) {
                randomCharacter = Character.toUpperCase(randomCharacter);
            }
            buffer[i] = randomCharacter;
        }
        return new String(buffer);
    }

    static {
        StringBuilder builder = new StringBuilder(36);
        for (char character = 'a'; character <= 'z'; character++) {
            builder.append(character);
        }
        letters = builder.toString().toCharArray();
        for (char number = '0'; number <= '9'; number++) {
            builder.append(number);
        }
        characters = builder.toString().toCharArray();
    }

    private static final char[] letters;
    private static final char[] characters;
}