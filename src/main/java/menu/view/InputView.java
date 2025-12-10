package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String REQUEST_HATE_MENUS = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    private InputView() {
    }

    public static String requestNames() {
        System.out.println(REQUEST_NAMES);
        return Console.readLine();
    }

    public static String requestHateMenus(String name) {
        System.out.printf(REQUEST_HATE_MENUS, name);
        System.out.println();
        return Console.readLine();
    }
}
