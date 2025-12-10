package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultParser {
    private ResultParser() {
    }

    public static Map<String, List<String>> toStringMap(Map<Coach, List<Menu>> menus) {
        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<Coach, List<Menu>> entry : menus.entrySet()) {
            List<String> parsedMenus = MenuParser.menuListToString(entry.getValue());
            result.put(entry.getKey().getName(), parsedMenus);
        }
        return result;
    }
}
