import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {
    private final String field = RandomStringUtils.randomAlphabetic(10);

    public String getRandomEmail() {
        return field + "@yandex.ru";
    }

}
