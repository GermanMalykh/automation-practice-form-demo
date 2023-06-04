package demo.com.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class ProjectConfiguration {
//    private final WebConfig webConfig;
//
//    public ProjectConfiguration(WebConfig webConfig) {
//        this.webConfig = webConfig;
//    }
//
//    public void webConfig() {
//        Configuration.browser = webConfig.browser();
//        Configuration.browserVersion = webConfig.browserVersion();
//        Configuration.browserSize = webConfig.browserSize();
//        Configuration.pageLoadTimeout = 60000;
//        Configuration.baseUrl = webConfig.baseUrl();
//        if (webConfig.isRemote()) {
//            Configuration.remote = webConfig.remoteUrl();
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                    "enableVNC", true,
//                    "enableVideo", true
//            ));
//            Configuration.browserCapabilities = capabilities;
//        }
//    }
}
