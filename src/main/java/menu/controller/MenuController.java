package menu.controller;

import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.enums.Category;
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
        Map<Category, List<Menu>> menus = menuService.initMenus();
        OutputView.printStart();
        List<Coach> coaches = makeCoaches();
        makeHateMenus(coaches);
        List<Category> categories = recommendCategories();
        Map<Coach, List<Menu>> recommendedMenus = recommendMenus(menus, coaches, categories);
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

    private void makeHateMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            requestHateMenus(coach);
        }
    }

    private void requestHateMenus(Coach coach) {
        while (true) {
            try {
                String input = InputView.requestHateMenus(coach.getName());
                InputValidator.validateHateMenus(input);
                menuService.makeHateMenus(coach, input);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Category> recommendCategories() {
        return menuService.recommendCategories();
    }

    private Map<Coach, List<Menu>> recommendMenus(Map<Category, List<Menu>> menus, List<Coach> coaches,
                                                  List<Category> categories) {
        return menuService.recommendMenus(menus, coaches, categories);
    }
}
