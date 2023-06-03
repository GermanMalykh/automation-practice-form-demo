package demo.com.data;

public class ConfigData {

    public static final String
            CONFIG_BROWSER_NAME = System.getProperty("browser_name", "chrome"),
            CONFIG_BROWSER_VERSION = System.getProperty("browser_version"),
            CONFIG_BROWSER_SIZE = System.getProperty("browser_size", "1920x1080"),
            CONFIG_REMOTE_URL = "selenoid.autotests.cloud/wd/hub",
            CONFIG_REMOTE_URL_VIDEO = "https://selenoid.autotests.cloud/video/",
            CONFIG_LOGIN_REMOTE = "user1",
            CONFIG_PASSWORD_REMOTE = "1234";
}
