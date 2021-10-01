package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro", Keys.ENTER);
		String Price = driver.findElement(By.xpath(
				"(//div[@class='a-section a-spacing-medium']//div[@class='a-row a-size-base a-color-base']//a//span[1])[1]"))
				.getText();
		System.out.println("Price of first Product: " + Price);
		String Pricevalue = Price.substring(1);
		System.out.println("Truncated Price of first Product: " + Pricevalue);
		String Rating = driver.findElement(By.xpath(
				"(//div[@class='a-section a-spacing-medium']//div[@class='a-section a-spacing-none a-spacing-top-micro']//span[2])[1]"))
				.getText();
		System.out.println("Number of Customer Ratings: " + Rating);
		WebElement Stars = driver.findElement(By.xpath(
				"(//div[@class='a-section a-spacing-medium']//div[@class='a-section a-spacing-none a-spacing-top-micro']//span//i)[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(Stars).click().perform();
/*		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='a-popover-wrapper']//table[@id='histogramTable']//tr//td[3]//span[2])[1]")));
*/		
		String fivestarpercent = driver.findElement(By.xpath("(//div[@class='a-popover-wrapper']//table[@id='histogramTable']//tr//td[3]//span[2])[1]"))
				.getText();
		System.out.println("Percentage of 5Star rating: " + fivestarpercent);
		driver.findElement(By.xpath(
				"(//div[@class='a-section a-spacing-medium']//div[@class='a-section a-spacing-none']//h2//a)[1]"))
				.click();
		Thread.sleep(6000);
		Set<String> win = driver.getWindowHandles();
		List<String> winlist = new ArrayList<String>(win);
		driver.switchTo().window(winlist.get(1));
		/*File scr1 = driver.getScreenshotAs(OutputType.FILE);

		File dst = new File("./snaps/Amazon.png");

		FileUtils.copyFile(scr1, dst);*/

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		String subtotal = driver.findElement(By.xpath(
				"//div[@id='attach-desktop-sideSheet']//div[@class='a-column a-span11 a-text-left a-spacing-top-large']//span[2]"))
				.getText();
		
		System.out.println("Cart Subtotal: " +subtotal);
		driver.close();

	}

}
