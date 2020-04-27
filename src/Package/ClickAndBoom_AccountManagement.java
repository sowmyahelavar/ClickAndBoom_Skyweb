package Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ClickAndBoom_AccountManagement extends ClickAndBoom_Base{

	
	@Test(priority=1)
	public void HardwareManagementPageTest() throws Exception{

		logger = extent.startTest("LogInPageTest");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://skyweb15.skytrac.ca/");
		driver.findElement(By.name("ctl00$MainContentPlaceHolder$skyWebLogin$UserName")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("ctl00$MainContentPlaceHolder$skyWebLogin$Password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("ctl00$MainContentPlaceHolder$skyWebLogin$LoginButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("ACCOUNT MANAGEMENT")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Account Management");
		logger.log(LogStatus.PASS, "Account Management page is Loaded sucessfully");
		Thread.sleep(2000);
	}
}
