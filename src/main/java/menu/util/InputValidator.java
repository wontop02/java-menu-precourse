package menu.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidator {
    private static final int MIN_NUMBER_OF_COACHES = 2;
    private static final int MAX_NUMBER_OF_COACHES = 5;
    private static final int MAX_HATE_MENU_SIZE = 2;
    private static final String KOREAN_AND_COMMA_ONLY_REGEX = "^[가-힣,]+$";

    private static final String BLANK_INPUT = "빈 문자열은 허용하지 않습니다.";
    private static final String NOT_KOREAN_AND_COMMA_ONLY = "한글(자음 + 모음)과 쉼표(,)를 제외한 문자가 포함되어 있습니다.";
    private static final String DUPLICATED = "중복된 입력은 허용하지 않습니다.";
    private static final String INVALID_NUMBER_OF_COACHES = String.format(
            "코치 수는 %d명 이상, %d명 이하여야 합니다.",
            MIN_NUMBER_OF_COACHES, MAX_NUMBER_OF_COACHES
    );
    private static final String INVALID_HATE_MENU_SIZE = " 못 먹는 메뉴는 최대 2개까지 입력 가능합니다.";

    private InputValidator() {
    }

    public static void validateCoachNames(String input) {
        validateNotBlank(input);
        validateKoreanAndCommaOnly(input);
        List<String> inputs = Arrays.asList(input.split(",", -1));
        validateNotDuplicate(inputs);
        validateNumberOfCoaches(inputs);
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }

    private static void validateKoreanAndCommaOnly(String input) {
        if (!input.matches(KOREAN_AND_COMMA_ONLY_REGEX)) {
            throw new IllegalArgumentException(NOT_KOREAN_AND_COMMA_ONLY);
        }
    }

    private static void validateNotDuplicate(List<String> inputs) {
        if (new HashSet<>(inputs).size() != inputs.size()) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    private static void validateNumberOfCoaches(List<String> inputs) {
        if (inputs.size() < MIN_NUMBER_OF_COACHES || inputs.size() > MAX_NUMBER_OF_COACHES) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_COACHES);
        }
    }

    public static void validateHateMenus(String input) {
        if (input == null || input.isBlank()) {
            return;
        }
        validateKoreanAndCommaOnly(input);
        List<String> inputs = Arrays.asList(input.split(",", -1));
        validateHateMenuSize(inputs);
        validateNotDuplicate(inputs);
    }

    private static void validateHateMenuSize(List<String> inputs) {
        if (inputs.size() > MAX_HATE_MENU_SIZE) {
            throw new IllegalArgumentException(INVALID_HATE_MENU_SIZE);
        }
    }
}
