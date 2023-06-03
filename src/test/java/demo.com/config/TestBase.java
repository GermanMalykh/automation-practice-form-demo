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

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 60000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = "100.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        if (ConfigData.CONFIG_REMOTE == null || ConfigData.CONFIG_REMOTE.equals("")) {
//        } else {
//            Configuration.remote = "https://"
//                    + ConfigData.CONFIG_LOGIN_REMOTE + ":"
//                    + ConfigData.CONFIG_PASSWORD_REMOTE + "@"
//                    + ConfigData.CONFIG_REMOTE;

            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
//        }

        Configuration.browserCapabilities = capabilities;

//        if (ConfigData.CONFIG_BROWSER_VERSION != null) {
//            Configuration.browserVersion = ConfigData.CONFIG_BROWSER_VERSION;
//        }
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

//        if (ConfigData.CONFIG_REMOTE == null || ConfigData.CONFIG_REMOTE.equals("")) {
//        } else {
            Attach.addVideo();
//        }
    }
}
