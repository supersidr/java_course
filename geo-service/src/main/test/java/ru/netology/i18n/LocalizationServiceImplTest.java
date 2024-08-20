import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test
    void localeTest() {
        String result = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @EnumSource(Country.class)
    void localeTestNotNull(Country country) {
        String result = localizationService.locale(country);

        assertNotNull(result);
    }

    @ParameterizedTest
    @EnumSource(mode = EXCLUDE, names = {"RUSSIA"})
    void localeTestNotRussia(Country country) {
        String result = localizationService.locale(country);
        String expected = "Welcome";

        assertEquals(expected, result);
    }
}
