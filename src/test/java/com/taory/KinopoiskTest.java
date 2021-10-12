package com.taory;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.taory.page.KinopoiskResultsPage;
import com.taory.page.MenuItems;
import com.taory.page.KinopoiskPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class KinopoiskTest extends TestBase {

    private KinopoiskPage page = new KinopoiskPage();
    private KinopoiskResultsPage film = new KinopoiskResultsPage();

    @EnumSource(MenuItems.class)
    @ParameterizedTest(name = "Check  search result  for menu items {0}")
    public void checkSearchResultForSeveralMenuItems(MenuItems menuItem) {
        Configuration.startMaximized = true;
        Selenide.open(KinopoiskPage.URL);
        page.doSearch("Бойцовский клуб")
                .switchToMenuItem(menuItem).checkResults("Бойцовский клуб");
    }

    @CsvSource({
            "Американский пирог",
            "Господин Никто"
    })

    @ParameterizedTest(name = "Check search results for input string: {0}")
    void testWithName(String searchQuery) {
        Configuration.startMaximized = true;
        Selenide.open(KinopoiskPage.URL);
        page.doSearch(searchQuery).checkResults(searchQuery);
    }

    static Stream<Arguments> checkResultParams() {
        return Stream.of(
                Arguments.of(
                        "Господин Никто", "2009", "Жако ван Дормель"
                ),
                Arguments.of(
                        "Американский пирог", "1999", "Пол Вайц, Крис Вайц"
                )
        );
    }

    @MethodSource("checkResultParams")
    @ParameterizedTest(name = "Check result params of films")
    void checkResultParams(String name, String year, String director) {
        Configuration.startMaximized = true;
        Selenide.open(KinopoiskPage.URL);
        page.doSearch(name).clickResult(name);
        film.checkParams(name, year, director);
    }
}
