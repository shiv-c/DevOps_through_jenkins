package loginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoFrontAcc {
	WebDriver driver;
	@BeforeTest
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterTest
	public void aftertest() throws Exception{
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void doLogin() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.frontaccounting.eu/index.php");
		driver.findElement(By.name("user_name_entry_field")).clear();
		driver.findElement(By.name("user_name_entry_field")).sendKeys("admin");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("SubmitUser")).click();
		String x=driver.findElement(By.xpath("//b[normalize-space()='Incorrect Password']")).getText();
	    Assert.assertEquals("Incorrect Password", x);
}
}
