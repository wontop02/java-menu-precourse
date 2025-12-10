package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.service.MenuService;
import menu.util.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void start() {
        menuService.init();
        OutputView.printStart();
        List<Coach> coaches = makeCoaches();
    }

    private List<Coach> makeCoaches() {
        while (true) {
            try {
                String input = InputView.requestNames();
                InputValidator.validateCoachNames(input);
                return menuService.makeCoaches(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
