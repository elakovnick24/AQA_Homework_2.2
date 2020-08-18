import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryCard {

    @Test
    void shoudDeliveryCard() {
        open("http://localhost:7777");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=city] input").setValue("Санкт-Петербург");
        form.$("[data-test-id=date] input").setValue("13.08.2020");
        form.$("[data-test-id=name] input").setValue("Николай");
        form.$("[data-test-id=phone] input").setValue("+79111112222");
        form.$("[data-test-id=agreement]").click();
        form.$$("button").find(exactText("Забронировать")).click();

        $("[data-test-id=notification]").find(withText("Успешно!")).waitUntil(visible, 15000);
    }

    @Test
    void checkValidationcity() {
        open("http://localhost:7777");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=city] input").setValue("Выборг");
        form.$("[data-test-id=date] input").setValue("21.08.2020");
        form.$("[data-test-id=name] input").setValue("Николай");
        form.$("[data-test-id=phone] input").setValue("+79111112222");
        form.$("[data-test-id=agreement]").click();
        form.$$("button").find(exactText("Забронировать")).click();

        $("[data-test-id=notification]").find(withText("Успешно!")).waitUntil(visible, 15000);
    }

    @Test
    void checkValidationDate() {
        open("http://localhost:7777");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=city] input").setValue("Санкт-Петербург");
        form.$("[data-test-id=date] input").setValue("20.08.2020");
        form.$("[data-test-id=name] input").setValue("Николай");
        form.$("[data-test-id=phone] input").setValue("+79111112222");
        form.$("[data-test-id=agreement]").click();
        form.$$("button").find(exactText("Забронировать")).click();

        $("[data-test-id=notification]").find(withText("Успешно!")).waitUntil(visible, 15000);
    }

    @Test
    void checkValidationDate1() {
        open("http://localhost:7777");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=city] input").setValue("Санкт-Петербург");
        form.$("[data-test-id=date] input").setValue("22.08.2020");
        form.$("[data-test-id=name] input").setValue("Николай");
        form.$("[data-test-id=phone] input").setValue("+79111112222");
        form.$("[data-test-id=agreement]").click();
        form.$$("button").find(exactText("Забронировать")).click();

        $("[data-test-id=notification]").find(withText("Успешно!")).waitUntil(visible, 15000);
    }
    @Test
    void checkValidationPhone() {
        open("http://localhost:7777");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=city] input").setValue("Санкт-Петербург");
        form.$("[data-test-id=date] input").setValue("13.08.2020");
        form.$("[data-test-id=name] input").setValue("Николай");
        form.$("[data-test-id=phone] input").setValue("+791111122220000");
        form.$("[data-test-id=agreement]").click();
        form.$$("button").find(exactText("Забронировать")).click();

        $("[data-test-id=notification]").find(withText("Успешно!")).waitUntil(visible, 15000);
    }

/*    @Test
    void blockMenuCity() {
        open("http://localhost:7777");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=city] input").setValue("Сан");
        form.$(".menu.input__menu").find(String.valueOf(exactText("Санкт-Петербург"))).click();
        form.$("[data-test-id=date] input").setValue("13.08.2020");
        form.$("[data-test-id=name] input").setValue("Николай");
        form.$("[data-test-id=phone] input").setValue("+791111122220000");
        form.$("[data-test-id=agreement]").click();
        form.$$("[tabindex=0]").find(exactText("Санкт-Петербург")).click();

        $("[data-test-id=notification]").find(withText("Успешно!")).waitUntil(visible, 15000);
    }
}*/

