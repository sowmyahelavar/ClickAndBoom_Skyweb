package Package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ClickAndBoom_Reports extends ClickAndBoom_Base{

	
	@Test(priority=1)
	public void ReportsPageTest() throws Exception{

		
		
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
		driver.findElement(By.partialLinkText("REPORTS")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Reports");
		logger.log(LogStatus.PASS, "Reports page is Loaded sucessfully");
		Thread.sleep(2000);
		
		//1. To find all the links and images on this page
		
		List <WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of full links and images---->"+ linksList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		
		//2. iterate linksList
		for(int i=0; i<linksList.size(); i++) {
			System.out.println(linksList.get(i).getAttribute("href"));
			if(linksList.get(i).getAttribute("href") !=null) {
				activeLinks.add(linksList.get(i));
			}
		}
	    
	    //get the size of active links list
		
		System.out.println("size of active links and images---->"+ activeLinks.size());

		
		//3. check the href url, with httpconnection api
		for(int j=0; j<activeLinks.size(); j++) {
			
		
 HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
	
 connection.connect();
 String response = connection.getResponseMessage();
 connection.disconnect();
 System.out.println(activeLinks.get(j).getAttribute("href") +"--->"+response);

} 
	}
}

