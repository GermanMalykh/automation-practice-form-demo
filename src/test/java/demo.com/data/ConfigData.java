package demo.com.data;

public class ConfigData {

    public static final String
            browserName = System.getProperty("browser_name", "chrome"),
            browserVersion = System.getProperty("browser_version"),
            browserSize = System.getProperty("browser_size", "1920x1080"),
            CONFIG_REMOTE_URL = "http://95.216.214.178:8080/wd/hub",
            CONFIG_REMOTE_URL_VIDEO = "http://95.216.214.178:8080/video/";
//            CONFIG_REMOTE_URL = "https://selenoid.autotests.cloud/wd/hub",
//            CONFIG_REMOTE_URL_VIDEO = "https://selenoid.autotests.cloud/video/",
//            CONFIG_LOGIN_REMOTE = "user1",
//            CONFIG_PASSWORD_REMOTE = "1234";
}
