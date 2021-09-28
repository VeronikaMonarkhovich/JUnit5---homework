package com.taory.page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class KinopoiskResultsPage {

    private ElementsCollection results = $$(".search_results");

    public void checkResults(String expected) {
        results.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .get(1)
                .shouldHave(text(expected));
    }

    public KinopoiskResultsPage switchToMenuItem(MenuItems menuItem) {
        if (menuItem == MenuItems.INDETAIL) ;
        $(".links").find(byText(menuItem.getDesc())).click();
        if (menuItem == MenuItems.BRIEFLY) ;
        $(".links").find(byText(menuItem.getDesc())).click();
        return this;
    }

    public void clickResult(String searchQuery) {
        $(".name").find(byText(searchQuery)).click();

    }

    public KinopoiskResultsPage checkParams(String name, String year, String director) {
        $($("[itemprop='name']")).shouldHave(text(name));
        $(byText("Год производства")).sibling(0).shouldHave(text(year));
        $(byText("Режиссер")).sibling(0).shouldHave(text(director));
        return this;
    }
}

