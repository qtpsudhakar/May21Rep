package com.wd.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	public static WebDriver getDriverFor(String brName) {

		WebDriver driver;
		switch (brName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");

			ChromeOptions co = new ChromeOptions();
			co.addArguments("--disable-notifications");
			driver = new ChromeDriver(co);
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\geckodriver.exe");

			FirefoxProfile p = new FirefoxProfile();
			p.setPreference("dom.webnotifications.enabled", false);

			FirefoxOptions fo = new FirefoxOptions();
			fo.setProfile(p);

			driver = new FirefoxDriver(fo);
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			break;
		}

		return driver;
	}

	public static RemoteWebDriver getRemoteDriver(String brName, String OSName) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(brName);

		switch (OSName.toLowerCase()) {
		case "windows":
			cap.setPlatform(Platform.WINDOWS);
			break;
		case "win10":
			cap.setPlatform(Platform.WIN10);
			break;
		case "win8":
			cap.setPlatform(Platform.WIN8);
			break;
		case "win81":
			cap.setPlatform(Platform.WIN8_1);
			break;
		case "mac":
			cap.setPlatform(Platform.MAC);
			break;
		default:
			cap.setPlatform(Platform.WINDOWS);
			break;
		}

		return new RemoteWebDriver(new URL("http://192.168.211.1:4444/wd/hub"), cap);

	}
}
