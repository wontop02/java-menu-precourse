package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final int MIN_NAME = 2;
    private static final int MAX_NAME = 4;

    private static final String INVALID_NAME_LENGTH = String.format(
            "이름은 %d글자 이상, %d글자 이하여야 합니다.",
            MIN_NAME, MAX_NAME
    );

    private final String name;
    private final List<Menu> hateMenus = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME || name.length() > MAX_NAME) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public void addHateMenu(Menu menu) {
        hateMenus.add(menu);
    }

    public List<Menu> hateMenus() {
        return List.copyOf(hateMenus);
    }
}
