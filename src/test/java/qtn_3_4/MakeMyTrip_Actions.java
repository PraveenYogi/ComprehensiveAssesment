package qtn_3_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MakeMyTrip_Actions {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public void launch_MakeMyTrip_Webpage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}

	public static void main(String[] args) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		if (j.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page has loaded");
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

	public void closeBrowser() {
		driver.close();
	}
}
