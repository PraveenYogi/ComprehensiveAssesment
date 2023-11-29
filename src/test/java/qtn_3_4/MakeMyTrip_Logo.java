package qtn_3_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MakeMyTrip_Logo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		JavascriptExecutor j = driver;
		if (j.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page has loaded");
		}
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
		Assert.assertTrue(logo.isDisplayed(), "Logo is NOT displayed");
		System.out.println("Make My Trip Logo displayed successfully");
	}
}
