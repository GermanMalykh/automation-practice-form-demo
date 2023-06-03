package demo.com.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demo.com.data.ConfigData;
import demo.com.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 60000;
        Configuration.browser = ConfigData.CONFIG_BROWSER_NAME;
        Configuration.browserSize = ConfigData.CONFIG_BROWSER_SIZE;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.remote = "https://"
                + ConfigData.CONFIG_LOGIN_REMOTE + ":"
                + ConfigData.CONFIG_PASSWORD_REMOTE + "@"
                + ConfigData.CONFIG_REMOTE_URL;

        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        if (ConfigData.CONFIG_BROWSER_VERSION != null) {
            Configuration.browserVersion = ConfigData.CONFIG_BROWSER_VERSION;
        }
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.pageSource();
        Attach.screenshotAs("Last screenshot");
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
