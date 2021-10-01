package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.snapdeal.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement Mens = driver.findElement(By.xpath("(//ul[@class='nav smallNav']/li)[7]"));
		Actions action = new Actions(driver);
		action.moveToElement(Mens).perform();
		WebElement sportshoe = driver.findElement(By.xpath("(//span[contains(text(),'Sports Shoes')])[1]"));
		action.moveToElement(sportshoe).click().perform();
		Thread.sleep(5000);
		String Total = driver.findElement(By.xpath("//span[@class='category-count']")).getText();
		System.out.println(Total);
		String TotalItems = Total.substring(2, 12);
		System.out.println(TotalItems);
		driver.findElement(By.xpath("//div[contains(text(),'Training Shoes')]")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		/*WebElement D= driver.findElement(By.xpath("//ul[@class='sort-value']"));
		Select D1 = new Select(D);
		D1.selectByIndex(1);*/
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']/i")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		Thread.sleep(5000);
		/*List<WebElement> Price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for (WebElement webElement : Price) {
			String p = webElement.getAttribute("display-price");
			int i = Integer.parseInt(p);
			
		}*/
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(5000);
		String filter1 = driver.findElement(By.xpath("(//div[@class='navFiltersPill']/a)[1]")).getText();
		String filter2 = driver.findElement(By.xpath("(//div[@class='navFiltersPill']/a)[2]")).getText();
		if(filter1.contains("Rs. 900")) {
			System.out.println("Price Range is applied correctly");
		}
		if(filter2.contains("Navy")) {
			System.out.println("Color filter is applied correctly");
		}
		else System.out.println("Filters are not applied corretly");
		WebElement first = driver.findElement(By.xpath("//div[@class='product-tuple-image ']//img"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(first).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement quick = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		wait.until(ExpectedConditions.elementToBeClickable(quick));
		quick.click();
		/*Set<String> win = driver.getWindowHandles();
		List<String> winlist = new ArrayList<String>(win);
		driver.switchTo().window(winlist.get(1));*/
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Price of the clicked Product:" +price);
		System.out.println("Discount of the product:" +discount);
		File scr1=driver.getScreenshotAs(OutputType.FILE);
		
		File dst=new File ("./snaps/shoe.png");
		
		FileUtils.copyFile(scr1, dst);
		
		driver.close();
		
	
	}

}
