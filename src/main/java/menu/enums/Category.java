package menu.enums;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private static final String INVALID_CATEGORY = "카테고리를 찾을 수 없습니다.";

    private final String category;
    private final int number;

    Category(String category, int number) {
        this.category = category;
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }

    public static Category valueOfCategory(int number) {
        return Arrays.stream(values())
                .filter(c -> c.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(INVALID_CATEGORY));
    }
}
