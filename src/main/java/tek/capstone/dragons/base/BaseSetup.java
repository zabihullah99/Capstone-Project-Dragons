package tek.capstone.dragons.base;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.capstone.dragons.config.Browser;
import tek.capstone.dragons.config.ChromeBrowser;
import tek.capstone.dragons.config.ChromeHeadless;
import tek.capstone.dragons.config.EdgeBrowser;
import tek.capstone.dragons.config.FireFoxBrowser;
import tek.capstone.dragons.utilities.ReadYamlFiles;

public class BaseSetup {
	//declare webdriver,declare the instance of readYamlfile,
	//and create logger as  refrance to log our test steps
	private static WebDriver webDriver;
	private final ReadYamlFiles environmentVariables;
	public static Logger logger;
	
	//create constractor for Basesetup class
	public BaseSetup() {
		//we need to get tyhe [path to env_config and log4j files 
		//and srore them as String
		String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
		String log4jPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
		try {
			environmentVariables = ReadYamlFiles.getIntance(filePath);
		} catch (Exception e) {
			System.out.println("Failed to load env_comfig property. check your filePath");
			throw new RuntimeException("Fail to load env_config file: " + e.getMessage());
		}
		
		logger = logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4jPath);
	}
	public WebDriver getDriver() {
		return webDriver;		
	}
	public void setupBrowser() {
		HashMap uiProperty = environmentVariables.getYamlProperty("ui"); //we store in hasmap as key and vlaue
		String url = uiProperty.get("url").toString().toLowerCase();
		Browser browser; // use browser interface as refrence to create the object of each classes
		
		switch (uiProperty.get("browser").toString().toLowerCase()) {
		case "chrome":
			if((boolean)uiProperty.get("headless")) {
				browser = new ChromeHeadless();
			}else {
				browser = new ChromeBrowser();
			}
			webDriver = browser.openBrowser(url);			
			break;
		case "firefox":
			browser = new FireFoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge":
			browser = new EdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;		
		default:
			throw new RuntimeException("Browser name in config file dosenot match any of the cases.");
			
		}
	}
	
	public void quitBrowser() {
		if (webDriver != null) {					
		webDriver.quit();
	}
		
	}
}