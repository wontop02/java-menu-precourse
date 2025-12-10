package menu.controller;

import menu.service.MenuService;
import menu.view.OutputView;

public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void start() {
        OutputView.printStart();
    }
}
