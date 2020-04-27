package Package;


	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.relevantcodes.extentreports.LogStatus; 

	public class ClickAndBoom_HMC  extends ClickAndBoom_Base {


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
			driver.findElement(By.partialLinkText("HARDWARE MANAGEMENT")).click();
			Thread.sleep(3000);
			String title = driver.getTitle();
			Assert.assertEquals(title, "Hardware Management");
			logger.log(LogStatus.PASS, "HardwareManagement is Loaded sucessfully");
			Thread.sleep(2000);
		}

		@Test(priority=2)
		public void HMCPageTest() throws Exception{
			logger = extent.startTest("HMCPageTest");
			driver.findElement(By.partialLinkText("HARDWARE CONFIGURATION")).click();

			Thread.sleep(3000);
			String title = driver.getTitle();
			Assert.assertEquals(title, "Hardware Configuration");
			logger.log(LogStatus.PASS, "HARDWARE CONFIGURATION is Loaded sucessfully");
			//*[@id="nav"]/nav/span/a[2]
			Thread.sleep(2000);
		}
		
		@Test(priority=3)
		public void HardwareConfigurationReportPageTest() throws Exception{
			logger = extent.startTest("HardwareConfigurationReportPageTest");
			
			driver.navigate().back();
			driver.findElement(By.partialLinkText("HARDWARE CONFIGURATION REPORT")).click();

			Thread.sleep(3000);
			String title = driver.getTitle();
			Assert.assertEquals(title,"Hardware Configuration Report");
			logger.log(LogStatus.PASS, "Hardware Configuration Report page is Loaded sucessfully");
			Thread.sleep(2000);
}
		
		@Test(priority=4)
		public void RADARTrackingConfigurationPageTest() throws Exception{
			logger = extent.startTest("ADS-B/RADAR TRACKING CONFIGURATIONPageTest");
			
			driver.navigate().back();
			driver.findElement(By.partialLinkText("ADS-B/RADAR TRACKING CONFIGURATION")).click();

			Thread.sleep(3000);
			String title = driver.getTitle();
			Assert.assertEquals(title,"ADS-B/Radar Tracking Configuration");
			logger.log(LogStatus.PASS, "ADS-B/RADAR TRACKING CONFIGURATION page is Loaded sucessfully");
			Thread.sleep(2000);
		}
			
	}
