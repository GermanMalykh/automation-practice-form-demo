package demo.com.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demo.com.data.ConfigData;
import demo.com.helpers.Attach;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @Description("Проверка отображения 1")
    @DisplayName("Настраиваем окружение перед запуском тестов")
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 60000;
        Configuration.browser = ConfigData.browserName;
        Configuration.browserSize = ConfigData.browserSize;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.remote = "https://"
                + ConfigData.CONFIG_LOGIN_REMOTE + ":"
                + ConfigData.CONFIG_PASSWORD_REMOTE + "@"
                + ConfigData.CONFIG_REMOTE_URL;

        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        if (ConfigData.browserVersion != null) {
            Configuration.browserVersion = ConfigData.browserVersion;
        }
        Configuration.browserCapabilities = capabilities;
    }

    @Description("Проверка отображения 2")
    @DisplayName("Добавляем \"Allure Listener\" для отображение деталей теста в отчёте")
    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Description("Проверка отображения 3")
    @DisplayName("Добавляем вложения")
    @AfterEach
    void addAttachments() {
        Attach.pageSource();
        Attach.screenshotAs("Last screenshot");
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
