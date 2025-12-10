package menu.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PRINT_START = "점심 메뉴 추천을 시작합니다.";
    private static final String PRINT_DAY = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String PRINT_FORMAT = "[ %s ]\n";
    private static final String PRINT_RESULT = "\n메뉴 추천 결과입니다.";
    private static final String PRINT_COMPLETE = "\n추천을 완료했습니다.";

    private static final String SEPARATOR = " | ";
    private static final String CATEGORY = "카테고리";

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printStart() {
        System.out.println(PRINT_START);
        System.out.println();
    }

    public static void printResult(List<String> categories, List<String> coaches, Map<String, List<String>> menus) {
        System.out.println(PRINT_RESULT);
        System.out.println(PRINT_DAY);
        String category = String.join(SEPARATOR, categories);
        System.out.printf(PRINT_FORMAT, CATEGORY + SEPARATOR + category);
        for (String coach : coaches) {
            String menuNames = String.join(SEPARATOR, menus.get(coach));
            System.out.printf(PRINT_FORMAT, coach + SEPARATOR + menuNames);
        }
        System.out.println(PRINT_COMPLETE);
    }
}
