package menu.service;

import static menu.enums.Category.ASIAN;
import static menu.enums.Category.CHINESE;
import static menu.enums.Category.JAPANESE;
import static menu.enums.Category.KOREAN;
import static menu.enums.Category.WESTERN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.CoachParser;
import menu.enums.Category;
import menu.enums.Menu;
import menu.repository.MenuRepository;

public class MenuService {
    public Map<Category, List<Menu>> init() {
        Map<Category, List<Menu>> menus = new HashMap<>();
        initJapanese(menus);
        initKorean(menus);
        initChinese(menus);
        initAsian(menus);
        initWestern(menus);
        return menus;
    }

    private void initJapanese(Map<Category, List<Menu>> menus) {
        List<String> japanese = new ArrayList<>(
                Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        List<Menu> japaneseMenus = japanese.stream()
                .map(Menu::new)
                .toList();
        japaneseMenus.forEach(MenuRepository::addMenu);
        menus.put(JAPANESE, japaneseMenus);
    }

    private void initKorean(Map<Category, List<Menu>> menus) {
        List<String> korean = new ArrayList<>(
                Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        List<Menu> koreanMenus = korean.stream()
                .map(Menu::new)
                .toList();
        koreanMenus.forEach(MenuRepository::addMenu);
        menus.put(KOREAN, koreanMenus);
    }

    private void initChinese(Map<Category, List<Menu>> menus) {
        List<String> chinese = new ArrayList<>(
                Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        List<Menu> chineseMenus = chinese.stream()
                .map(Menu::new)
                .toList();
        chineseMenus.forEach(MenuRepository::addMenu);
        menus.put(CHINESE, chineseMenus);
    }

    private void initAsian(Map<Category, List<Menu>> menus) {
        List<String> asian = new ArrayList<>(
                Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        List<Menu> asianMenus = asian.stream()
                .map(Menu::new)
                .toList();
        asianMenus.forEach(MenuRepository::addMenu);
        menus.put(ASIAN, asianMenus);
    }

    private void initWestern(Map<Category, List<Menu>> menus) {
        List<String> western = new ArrayList<>(
                Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
        List<Menu> westernMenus = western.stream()
                .map(Menu::new)
                .toList();
        westernMenus.forEach(MenuRepository::addMenu);
        menus.put(WESTERN, westernMenus);
    }

    public List<Coach> makeCoaches(String input) {
        return CoachParser.stringToCoachList(input);
    }

    public void makeHateMenus(Coach coach, String input) {
        if (input == null || input.isBlank()) {
            return;
        }
        List<String> menus = Arrays.asList(input.split(",", -1));
        menus.forEach(MenuRepository::findByName);
        for (String menu : menus) {
            coach.addHateMenu(menu);
            System.out.println(menu);
        }
    }
}
