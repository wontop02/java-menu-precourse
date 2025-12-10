package menu.domain;

import java.util.List;

public class MenuParser {
    private MenuParser() {
    }

    public static List<String> menuListToString(List<Menu> menus) {
        return menus.stream()
                .map(Menu::getName)
                .toList();
    }
}
