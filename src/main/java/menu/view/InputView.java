package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";

    private InputView() {
    }

    public static String requestNames() {
        System.out.println(REQUEST_NAMES);
        return Console.readLine();
    }
}
