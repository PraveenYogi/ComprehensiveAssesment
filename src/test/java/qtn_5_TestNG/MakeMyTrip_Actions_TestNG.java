package qtn_5_TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class MakeMyTrip_Actions_TestNG {

	static WebDriver driver;

	@BeforeMethod
	public void launch_MakeMyTrip_Webpage() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void validate_MMT_Logo() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
		Assert.assertTrue(logo.isDisplayed(), "Logo is NOT displayed");
		System.out.println("Make My Trip Logo displayed successfully");
	}

	@Test
	public void validate_From_To() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		if (j.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page has loaded ");
		}

		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		driver.findElement(
				By.xpath("//span[text()='Flights' and " + "@class='headerIconTextAlignment chNavText darkGreyText']"))
				.click();
		driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']" + "//span[@class='tabsCircle appendRight5'] "))
				.click();
		driver.findElement(By.xpath("//input[@placeholder='From']"));
		driver.findElement(By.xpath("//input[@placeholder='To']"));
		System.out.println("Located all the webelements");
	}

	@AfterMethod

	public void closeBrowser() {
		driver.close();
	}
}
