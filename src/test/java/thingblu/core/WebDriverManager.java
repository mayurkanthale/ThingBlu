package thingblu.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverManager {

	/**
	 * 
	 * @param browser
	 *            This method is used to pass the browser name & for that it create
	 *            WebDriver instance.
	 * @return browser instance
	 */
	public static WebDriver getInstance(String browser) {
		WebDriver driver = null;

		if (Constants.USE_GRID) {
			if (browser.equalsIgnoreCase("chrome")) {
				DesiredCapabilities dCap = DesiredCapabilities.chrome();
				dCap.setBrowserName(browser);
				dCap.setPlatform(Platform.WINDOWS);
				URL url;
				try {
					url = new URL(Constants.NODE2_URL);
					driver = new RemoteWebDriver(url, dCap);
				} catch (MalformedURLException e) {
					System.out.println("Chrome remote driver exception :" +e.getMessage() );
				}

			} else if (browser.equalsIgnoreCase("firefox")) {
				DesiredCapabilities dCap = DesiredCapabilities.chrome();
				dCap.setBrowserName(browser);
				dCap.setPlatform(Platform.WINDOWS);
				URL url;
				try {
					url = new URL(Constants.NODE1_URL);
					driver = new RemoteWebDriver(url, dCap);
				} catch (MalformedURLException e) {
					System.out.println("firefox remote driver exception :" +e.getMessage() );
				}

			} else if (browser.equalsIgnoreCase("safari")) {
				DesiredCapabilities dCap = DesiredCapabilities.chrome();
				dCap.setBrowserName(browser);
				dCap.setPlatform(Platform.MAC);
				URL url;
				try {
					url = new URL(Constants.NODE1_URL);
					driver = new RemoteWebDriver(url, dCap);
				} catch (MalformedURLException e) {
					System.out.println(" safari remote driver exception :" +e.getMessage() );
				}

			}
			else {
				System.out.println("No remote driver found");
			}
		}

		else {

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("disable-infobars");
				options.addArguments("--disable-extensions");
				options.addArguments("--test-type");
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("disable-infobars");
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.driver ", Constants.firefoxDriverPath);
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("safari")) {
				System.setProperty("", "");
				driver = new SafariDriver();
			} 
			
			else {
				System.out.println("No driver found");
			}

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
