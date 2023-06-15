package login_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_test {

	/**
	 * this test script verifys signin functionality
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void signinWithValidCredentials() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.simpleenergy.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Ok, I understand']")).click();
		driver.findElement(By.xpath("//img[@src='https://d2x53dqaws7j7d.cloudfront.net/ic_user.png']")).click();

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("rajanikanth355@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Vijayfan123@143");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	/**
	 * This testscript verifies signIn with invalid credentials
	 * 
	 * @throws InterruptedException
	 */

	@Test(enabled = false)

	public void signinWithInValidCredentials() throws InterruptedException

	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.simpleenergy.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Ok, I understand']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='https://d2x53dqaws7j7d.cloudfront.net/ic_user.png']")).click();

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("rajanikanth355@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Vijayfan123@14");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		// verifying the error message
		String expected_error_message = "invalid email address";
		String actual_message = driver.findElement(By.xpath("//p[text()='invalid email address']")).getText();

		System.out.println("error message is" + " " + actual_message);
		Assert.assertEquals(actual_message, expected_error_message);
		driver.quit();
	}

	/**
	 * this testscript verifies prebook feature
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void prebook() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.simpleenergy.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Ok, I understand']")).click();

		driver.findElement(By.xpath("//img[@src='https://d2x53dqaws7j7d.cloudfront.net/ic_user.png']")).click();

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("rajanikanth355@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Vijayfan123@143");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Pre-Book']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Namma Red']")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//img[@src='https://d2x53dqaws7j7d.cloudfront.net/ic_right_color_selection_white.png']"))
				.click();

		WebElement element = driver.findElement(By.name("state"));
		Select select = new Select(element);

		select.selectByVisibleText("Karnataka");

		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bengaluru");

		driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("560086");
		driver.findElement(By.xpath("//span[text()='Proceed and Pay for Booking']")).click();

	}

	/**
	 * this testscript verifies colour-change during prebook
	 * 
	 * @throws InterruptedException
	 * 
	 */

	@Test

	public void colour_selection() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Login_test login = new Login_test();
		login.signinWithValidCredentials();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Pre-Book']")).click();
		driver.findElement(By.xpath("//span[text()='Namma Red']")).click();
		driver.findElement(By.xpath("//span[text()='Azure Blue']")).click();
		driver.findElement(By.xpath("//span[text()='Grace White']")).click();
				
	}

}
