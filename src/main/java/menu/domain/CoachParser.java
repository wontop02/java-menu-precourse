package menu.domain;

import java.util.Arrays;
import java.util.List;

public class CoachParser {
    private CoachParser() {
    }

    public static List<Coach> stringToCoachList(String input) {
        List<String> inputs = Arrays.asList(input.split(",", -1));
        return inputs.stream()
                .map(Coach::new)
                .toList();
    }
}
