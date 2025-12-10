package menu.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PRINT_START = "점심 메뉴 추천을 시작합니다.";

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
        System.out.println();
    }

    public static void printStart() {
        System.out.println(PRINT_START);
        System.out.println();
    }
}
