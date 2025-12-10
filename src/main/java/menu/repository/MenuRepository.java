package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Menu;

public class MenuRepository {
    private static final String NOT_FOUND_MENU = "메뉴를 찾을 수 없습니다.";
    private static final List<Menu> menus = new ArrayList<>();

    public static List<Menu> menus() {
        return List.copyOf(menus);
    }

    public static void addMenu(Menu menu) {
        menus.add(menu);
    }

    public static Menu findByName(String name) {
        return menus.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MENU));
    }
}
