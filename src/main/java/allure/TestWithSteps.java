package allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;


public class TestWithSteps {
    private static final String repository = "eroshenkoam/allure-example";
    public static final int number = 68;

    @Test
    public void lambdaStepTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозитори" + repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            $(".header-search-input").submit();
        });
        step("Переходим в репозитори" + repository, () -> {
            $(linkText(repository)).click();
        });
        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем наличие Issue с номером" + number, () -> {
            $(withText("#" + number)).should(Condition.visible);
        });

    }
}
