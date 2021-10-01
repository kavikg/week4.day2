package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nyka {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		action.moveToElement(brand).perform();
		WebElement loreal = driver.findElement(By.xpath("//div[@class='Brand-Content']//li[5]//img"));
		action.moveToElement(loreal).click().perform();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("Title:" + title);
		driver.findElement(By.xpath("//div[@class='sort-wrapper closed']")).click();
		
		WebElement sortby = driver.findElement(By.xpath("//div[@class='sort-wrapper opened']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(sortby));
		driver.findElement(By.xpath("//div[@class='sort-container show-sort']//div[4]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Category')]")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='filter-categories-list']")));
		driver.findElement(By.xpath("//span[contains(text(),'Hair')]")).click();
		//wait.until(ExpectedConditions
			//	.visibilityOfElementLocated(By.xpath("(//div[@class='filter-categories-child'])[1]")));
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='filter-categories-child'])[2]")));
		driver.findElement(By.xpath("(//span[contains(text(),'Shampoo')])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='filter-sidebar__filter-title pull-left'])[1]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Concern')]")).click();
		//wait.until(ExpectedConditions
			//	.visibilityOfElementLocated(By.id("(//div[@class='filter-options-list active'])[6]")));
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(text(),'Concern')]")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='filter-row']")));
		/*String appliedtext = driver.findElement(By.xpath("//li[contains(text(),'Shampoo')]")).getAttribute("text");
		System.out.println(appliedtext);*/
		driver.findElement(By.xpath("(//div[@class='card-img'])[1]")).click();
		Set<String> win = driver.getWindowHandles();
		List<String> winlist = new ArrayList<String>(win);
		driver.switchTo().window(winlist.get(1));
		driver.findElement(By.xpath("//span[contains(text(),'175')]")).click();
		String MRP = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
		System.out.println("MRP: Rs. "+MRP);
		driver.findElement(By.xpath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		String Total = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println(Total);
		driver.findElement(By.xpath("//span[contains(text(),'Proceed')]")).click();
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		String Grandtotal = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		System.out.println(Grandtotal);
		if(Total==Grandtotal) {
			System.out.println("Total amount is displayed as expected");
		}
		else
			System.out.println("Total amount is not displayed as expected");
		

	}

}
