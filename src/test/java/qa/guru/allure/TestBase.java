package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    public static void setUp(){

        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
    }

    @Test
    void checkAccountLinks() {

        $(byText("Sign in")).click();
        $("#login_field").setValue("kradavnat@gmail.com");
        $("#password").setValue("Kradavnat1234");
        $(".js-sign-in-button").click();

        $(withText("Issues")).should(exist);
        $(withText("Codespaces")).should(exist);
        $(withText("Marketplace")).should(exist);
    }
}
