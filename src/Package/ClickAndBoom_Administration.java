
package Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus; 

public class ClickAndBoom_Administration  extends ClickAndBoom_Base {


	@Test(priority=1)
	public void LogInPageTest() throws Exception{

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
		driver.findElement(By.xpath("//*[@id=\"body\"]/section[2]/div[1]/table/tbody/tr[1]/td[3]/div/a/div/span[2]")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title, (prop.getProperty("AdministarionTitle")));
		logger.log(LogStatus.PASS, "AdministraionPage Loaded properly");
		Thread.sleep(2000);
	}

	@Test(priority=2)
	public void GeofencePageTest() throws Exception{
		logger = extent.startTest("GeofencePageTest");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContentPlaceHolder_adminControl_skyWizard_SideBarContainer_SideBarList_ctl01_SideBarButton\"]")).click();

		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Geofences");
		logger.log(LogStatus.PASS, "Geofences Loaded properly");
		//*[@id="nav"]/nav/span/a[2]

		Thread.sleep(2000);
	}

	@Test(priority=3)
	public void HardwareProfilePageTest() throws Exception{
		logger = extent.startTest("HardwareProfilePageTest");
		driver.findElement(By.xpath("//*[@id=\"nav\"]/nav/span/a[2]")).click();
		driver.findElement(By.id("ctl00_MainContentPlaceHolder_adminControl_skyWizard_SideBarContainer_SideBarList_ctl03_SideBarButton")).click();

		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title,"Hardware Profiles");
		logger.log(LogStatus.PASS, "HardwareProfiles Loaded properly");
		//*[@id="nav"]/nav/span/a[2]

		Thread.sleep(2000);
	}

	@Test(priority=4)
	public void DVITextMessagesPageTest() throws Exception{
		logger = extent.startTest("DVITextMessagesPageTest");
		driver.findElement(By.xpath("//*[@id=\"nav\"]/nav/span/a[2]")).click();
		driver.findElement(By.id("ctl00_MainContentPlaceHolder_adminControl_skyWizard_SideBarContainer_SideBarList_ctl04_SideBarButton")).click();

		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title,"DVI Text Messages");
		logger.log(LogStatus.PASS, "DVITextMessages Loaded properly");
		//*[@id="nav"]/nav/span/a[2]

		Thread.sleep(2000);
	}

	@Test(priority=5)
	public void DVIPhonenumbersPageTest() throws Exception{
		logger = extent.startTest("DVIPhonenumbersPageTest");
		driver.findElement(By.xpath("//*[@id=\"nav\"]/nav/span/a[2]")).click();
		driver.findElement(By.id("ctl00_MainContentPlaceHolder_adminControl_skyWizard_SideBarContainer_SideBarList_ctl05_SideBarButton")).click();

		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title,"DVI Phone Numbers");
		logger.log(LogStatus.PASS, "DVIPhonenumbersPage Loaded properly");
		//*[@id="nav"]/nav/span/a[2]

		Thread.sleep(2000);
	}

	@Test(priority=6)
	public void OverdueNotificationPageTest() throws Exception{
		logger = extent.startTest("OverdueNotificationPageTest");
		driver.findElement(By.xpath("//*[@id=\"nav\"]/nav/span/a[2]")).click();
		driver.findElement(By.id("ctl00_MainContentPlaceHolder_adminControl_skyWizard_SideBarContainer_SideBarList_ctl06_SideBarButton")).click();

		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title,"Overdue Notifications");
		logger.log(LogStatus.PASS, "OverdueNotificationPageTest Loaded properly");
		//*[@id="nav"]/nav/span/a[2]

		Thread.sleep(2000);
	}

	@Test(priority=7)
	public void ReportingRegionPageTest() throws Exception{
		logger = extent.startTest("ReportingRegionPageTest");
		driver.findElement(By.xpath("//*[@id=\"nav\"]/nav/span/a[2]")).click();
		driver.findElement(By.id("ctl00_MainContentPlaceHolder_adminControl_skyWizard_SideBarContainer_SideBarList_ctl07_SideBarButton")).click();

		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title,"Reporting Regions");
		logger.log(LogStatus.PASS, "ReportingRegionPage Loaded properly");
		//*[@id="nav"]/nav/span/a[2]

		Thread.sleep(2000);
	}

	@Test(priority=8)
	public void SecuritySettingsPageTest() throws Exception{
		logger = extent.startTest("SecuritySettingsPageTest");
		driver.findElement(By.xpath("//*[@id=\"nav\"]/nav/span/a[2]")).click();
		driver.findElement(By.id("ctl00_MainContentPlaceHolder_adminControl_skyWizard_SideBarContainer_SideBarList_ctl08_SideBarButton")).click();

		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title,"Security Settings");
		logger.log(LogStatus.PASS, "SecuritySettingsPage Loaded properly");
		//*[@id="nav"]/nav/span/a[2]

		Thread.sleep(2000);
	}
}
