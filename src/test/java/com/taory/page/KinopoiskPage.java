package com.taory.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class KinopoiskPage {

    public static final String URL = "https://www.kinopoisk.ru/";
    private SelenideElement searchInput = $(".kinopoisk-header-search-form-input__input");

    public KinopoiskResultsPage doSearch(String searchQuery) {
        searchInput.setValue(searchQuery).pressEnter();
        return new KinopoiskResultsPage();
    }
}


