package demo.com.data;

public class ConfigData {

    public static final String
            browserName = System.getProperty("browser_name", "chrome"),
            browserVersion = System.getProperty("browser_version"),
            browserSize = System.getProperty("browser_size", "1920x1080"),
            CONFIG_REMOTE_URL = "selenoid.autotests.cloud/wd/hub",
            CONFIG_REMOTE_URL_VIDEO = "https://selenoid.autotests.cloud/video/",
            CONFIG_LOGIN_REMOTE = "user1",
            CONFIG_PASSWORD_REMOTE = "1234";
}
