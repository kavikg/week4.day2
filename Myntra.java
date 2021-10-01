package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		WebElement Jackets = driver.findElement(By.xpath("(//a[text()='Jackets'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(Men).perform();
		action.moveToElement(Jackets).click().perform();
		Thread.sleep(5000);
		String Noofitems = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total No. of Jackets:" + Noofitems);
		String total = Noofitems.substring(3, 7);
		int items = Integer.parseInt(total);
		System.out.println("Total Items:" + items);
		String Filter1 = driver
				.findElement(By.xpath("//label[@class='common-customCheckbox vertical-filters-label']//span"))
				.getText();
		System.out.println("Text in Filter1: " + Filter1);
		String f1 = Filter1.substring(1, 5);
		int p1 = Integer.parseInt(f1);
		System.out.println("Jackets:" + p1);
		String Filter2 = driver
				.findElement(By.xpath("(//label[@class='common-customCheckbox vertical-filters-label']//span)[2]"))
				.getText();
		System.out.println("Text in Filter2:" + Filter2);
		String f2 = Filter2.substring(1, 3);
		System.out.println(f2);
		int p2 = Integer.parseInt(f2);
		System.out.println("Rain Jacket:" + p2);
		int Sum = p1 + p2;
		System.out.println("Total of categories:" + Sum);
		if (Sum == items) {
			System.out.println("Total matches with the sum of the categories");
		} else
			System.out.println("Total does not matches with the sum of the categories");
		driver.findElement(By.xpath("(//label[@class='common-customCheckbox vertical-filters-label']//div)[1]"))
				.click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//ul[@class='FilterDirectory-list']/li[2]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		Thread.sleep(5000);
		List<WebElement> Dukelist = driver.findElements(By.xpath("//ul[@class='results-base']"));
		for (WebElement webElement : Dukelist) {
			String s = webElement.getText();
			System.out.println(s);
			if (s.contains("Duke")) {
				System.out.println("All the items are displayed with Duke brand as expected");
			} else
				System.out.println("All the items are not displayed with Duke brand");
		}

		WebElement sortby = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		WebElement Better = driver.findElement(By.xpath("//ul[@class='sort-list']/li[3]"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(sortby).perform();
		action1.moveToElement(Better).click().perform();		
		Thread.sleep(3000);
		String price = driver
				.findElement(By.xpath("//ul[@class='results-base']//li[1]//div[@class='product-price']//span//span[1]"))
				.getText();
		System.out.println("Price of the first product: " + price);
		driver.findElement(By.xpath("//ul[@class='results-base']//li[1]//picture")).click();
		File scr1 = driver.getScreenshotAs(OutputType.FILE);

		File dst = new File("./snaps/Myntra.png");

		FileUtils.copyFile(scr1, dst);

		driver.close();

	}

}
