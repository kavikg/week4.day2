package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(drag, 90, 30).perform();
		System.out.println("Dragged");
		driver.switchTo().defaultContent();

		driver.get("https://jqueryui.com/droppable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement dragelement = driver.findElement(By.id("draggable"));
		WebElement dropelement = driver.findElement(By.id("droppable"));
		Actions action1 = new Actions(driver);
		action1.dragAndDrop(dragelement, dropelement);
		System.out.println("Dragged & Dropped");
		driver.switchTo().defaultContent();

		driver.get("https://jqueryui.com/resizable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement resizeelement = driver.findElement(
				By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Actions action2 = new Actions(driver);
		action2.clickAndHold(resizeelement).dragAndDropBy(resizeelement, 250, 250).perform();
		System.out.println("Resized");
		driver.switchTo().defaultContent();

		driver.get("https://jqueryui.com/selectable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement selectableelement = driver.findElement(By.xpath("//ol[@id='selectable']/li[3]"));
		Actions action3 = new Actions(driver);
		action3.moveToElement(selectableelement).click().perform();
		System.out.println("Selected");
		driver.switchTo().defaultContent();

		driver.get("https://jqueryui.com/sortable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement Item3 = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]"));
		WebElement Item6 = driver.findElement(By.xpath("//ul[@id='sortable']/li[6]"));
		Actions action4 = new Actions(driver);
		Point location = Item6.getLocation();
		int x = location.getX();
		int y = location.getY();
		action4.dragAndDropBy(Item3, x, y).perform();
		System.out.println("Sorted");

	}

}
