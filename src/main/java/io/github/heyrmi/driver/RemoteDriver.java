package io.github.heyrmi.driver;

import com.codeborne.selenide.WebDriverProvider;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import javax.annotation.Nonnull;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static io.github.heyrmi.config.ConfigManager.configs;

public class RemoteDriver implements WebDriverProvider {

    String browser = configs().browserName();
    String plaform = configs().platform();
    String version = configs().browserVersion();
    String username = System.getenv("user") != null ? System.getenv("username") : configs().username();
    String accesskey = System.getenv("key") != null ? System.getenv("accesskey") : configs().accesskey();

    String remoteHubUrl = String.format("https://%s:%s@hub.lambdatest.com/wd/hub", username, accesskey);


    @Nonnull
    @Override
    @SneakyThrows
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        RemoteWebDriver driver = null;
        switch (browser) {
            case "chrome":
                driver = getChromeDriver();
                break;
            case "firefox":
                driver = getFirefoxDriver();
                break;
            case "edge":
                driver = getEdgeDriver();
                break;
            case "safari":
                if (plaform.contains("mac"))
                    driver = getSafariDriver();
                else
                    throw new Exception("Wrong browser and platform combination. Check config.");
            default:
                driver = getChromeDriver();
        }
        return driver;
    }


    @SneakyThrows
    RemoteWebDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPlatformName(plaform);
        chromeOptions.setBrowserVersion(version);

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accesskey);
//        ltOptions.put("geoLocation", "AU/AL");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("seCdp", true);
        ltOptions.put("network", true);
//        ltOptions.put("timezone", "GMT");
        ltOptions.put("build", "Build 1");
        ltOptions.put("project", "Project 1");
        String[] customBuildTags = {"Build Tag 1"};
        ltOptions.put("buildTags", customBuildTags);
        ltOptions.put("name", "Some Name");
        String[] customTags = {"Test Tag 1"};
        ltOptions.put("tags", customTags);
        ltOptions.put("selenium_version", "4.13.0");
//        ltOptions.put("driver_version", "121.0");
        ltOptions.put("w3c", true);
        chromeOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URI(remoteHubUrl).toURL(), chromeOptions);
    }

    @SneakyThrows
    RemoteWebDriver getFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPlatformName(plaform);
        firefoxOptions.setBrowserVersion(version);

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accesskey);
//        ltOptions.put("geoLocation", "AU/AL");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("seCdp", true);
        ltOptions.put("network", true);
//        ltOptions.put("timezone", "GMT");
        ltOptions.put("build", "Build 1");
        ltOptions.put("project", "Project 1");
        String[] customBuildTags = {"Build Tag 1"};
        ltOptions.put("buildTags", customBuildTags);
        ltOptions.put("name", "Some Name");
        String[] customTags = {"Test Tag 1"};
        ltOptions.put("tags", customTags);
        ltOptions.put("selenium_version", "4.13.0");
//        ltOptions.put("driver_version", "121.0");
        ltOptions.put("w3c", true);

        firefoxOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URI(remoteHubUrl).toURL(), firefoxOptions);
    }

    @SneakyThrows
    RemoteWebDriver getEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPlatformName(plaform);
        edgeOptions.setBrowserVersion(version);

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accesskey);
//        ltOptions.put("geoLocation", "AU/AL");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("seCdp", true);
        ltOptions.put("network", true);
//        ltOptions.put("timezone", "GMT");
        ltOptions.put("build", "Build 1");
        ltOptions.put("project", "Project 1");
        String[] customBuildTags = {"Build Tag 1"};
        ltOptions.put("buildTags", customBuildTags);
        ltOptions.put("name", "Some Name");
        String[] customTags = {"Test Tag 1"};
        ltOptions.put("tags", customTags);
        ltOptions.put("selenium_version", "4.13.0");
//        ltOptions.put("driver_version", "121.0");
        ltOptions.put("w3c", true);
        edgeOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URI(remoteHubUrl).toURL(), edgeOptions);
    }

    @SneakyThrows
    RemoteWebDriver getSafariDriver() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setPlatformName(plaform);
        safariOptions.setBrowserVersion(version);

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accesskey);
//        ltOptions.put("geoLocation", "AU/AL");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("seCdp", true);
        ltOptions.put("network", true);
//        ltOptions.put("timezone", "GMT");
        ltOptions.put("build", "Build 1");
        ltOptions.put("project", "Project 1");
        String[] customBuildTags = {"Build Tag 1"};
        ltOptions.put("buildTags", customBuildTags);
        ltOptions.put("name", "Some Name");
        String[] customTags = {"Test Tag 1"};
        ltOptions.put("tags", customTags);
        ltOptions.put("selenium_version", "4.13.0");
//        ltOptions.put("driver_version", "121.0");
        ltOptions.put("w3c", true);
        safariOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URI(remoteHubUrl).toURL(), safariOptions);
    }
}