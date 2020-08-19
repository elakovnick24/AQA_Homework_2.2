import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryCard {

    @Test
    void shoudDeliveryCard() {
        open("http://localhost:9999");
        $("[data-test-id='city'] [type=text]").setValue("Санкт-Петербург");
        $("[data-test-id=date] input").setValue("13.08.2020");
        $("[data-test-id=name] input").setValue("Николай");
        $("[data-test-id=phone] input").setValue("+79111112222");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();

        $("[data-test-id=notification]").find(withText("Успешно!")).waitUntil(visible, 15000);
    }

    @Test
    void checkValidationcity() {
        open("http://localhost:9999");
        $("[data-test-id='city'] [type=text]").setValue("Выборг");
        $("[data-test-id=date] input");
        $("[data-test-id=name] input").setValue("Николай");
        $("[data-test-id=phone] input").setValue("+79111112222");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=city] .input__sub").shouldHave(exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    void checkValidationPhone() {
        open("http://localhost:9999");
        $("[data-test-id='city'] [type=text]").setValue("Санкт-Петербург");
        $("[data-test-id=date] input").setValue("13.08.2020");
        $("[data-test-id=name] input").setValue("Николай");
        $("[data-test-id=phone] input").setValue("+791111122220000");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
}

/*    @Test
    void blockMenuCity() {
        open("http://localhost:7777");

        $("[data-test-id=city] input").setValue("Сан");
        $(".menu.input__menu").find(String.valueOf(exactText("Санкт-Петербург"))).click();
        $("[data-test-id=date] input").setValue("13.08.2020");
        $("[data-test-id=name] input").setValue("Николай");
        $("[data-test-id=phone] input").setValue("+791111122220000");
        $("[data-test-id=agreement]").click();
        $$("[tabindex=0]").find(exactText("Санкт-Петербург")).click();

        $("[data-test-id=notification]").find(withText("Успешно!")).waitUntil(visible, 15000);
    }
}*/

