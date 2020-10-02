package Academy.Demoproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{ 
	public WebDriver driver;
	public WebDriver initialiseDriver() throws IOException
	{
	Properties	prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\meera\\eclipse-workspace\\Demoproject\\src\\main\\java\\data.properties");
	prop.load(fis);
	String browsername=prop.getProperty("browser");
	System.out.println(browsername);
	if(browsername.equals("chrome"))
	{
		System.out.println("reached1");
		System.setProperty("webdriver.chrome.driver","C:\\Meera\\WebDrivers\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	 else if(browsername.equals("firefox"))
	 {
		 System.out.println("reached2");
		 System.setProperty("webdriver.gecko.driver","C:\\Meera\\WebDrivers\\geckodriver.exe"); 
		 driver=new FirefoxDriver();
	 }
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     return driver;
	}

}
