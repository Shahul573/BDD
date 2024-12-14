package com.hotelbooking.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelnameReverse {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("crshahul11@gmail.com");

		WebElement txtPass = driver.findElement(By.id("pass"));
		txtPass.sendKeys("shahuL@1991");

		WebElement loginClk = driver.findElement(By.xpath("//button[text()='Login']"));
		loginClk.click();
		WebElement clkHtl = driver.findElement(By.xpath("(//h3[@class='mt-4'])[2]"));
		clkHtl.click();

		WebElement Slctstate = driver.findElement(By.id("state"));
		Select select = new Select(Slctstate);
		select.selectByValue("Tamil Nadu");

		WebElement slctCity = driver.findElement(By.id("city"));
		Select select2 = new Select(slctCity);
		select2.selectByValue("Chennai");

		WebElement slctRT = driver.findElement(By.id("room_type"));
		Select select3 = new Select(slctRT);
		List<WebElement> options = select3.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement option = options.get(i);
			option.click();
		}

		WebElement setDate = driver.findElement(By.name("check_in"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','2025-01-06')", setDate);

		WebElement date = driver.findElement(By.name("check_out"));
		js.executeScript("arguments[0].setAttribute('value','2025-01-16')", date);

		WebElement noOfRooms = driver.findElement(By.id("no_rooms"));
		Select select4 = new Select(noOfRooms);
		select4.selectByValue("1");

		WebElement noOfAdults = driver.findElement(By.id("no_adults"));
		Select select5 = new Select(noOfAdults);
		select5.selectByValue("2");

		WebElement noOfChild = driver.findElement(By.id("no_child"));
		noOfChild.sendKeys("2");

		driver.switchTo().frame("hotelsearch_iframe");
		WebElement srch = driver.findElement(By.id("searchBtn"));

		js.executeScript("arguments[0].click()", srch);
		driver.switchTo().defaultContent();

		WebElement element = driver.findElement(By.xpath("//label[@for='value_ndesc']"));
		element.click();
		
		Thread.sleep(5000);
		List<Integer> dev = new ArrayList<Integer>();
		List<Integer> qa = new ArrayList<Integer>();

		WebElement hotelList = driver.findElement(By.id("hotellist"));
		List<WebElement> htlName = hotelList.findElements(By.tagName("h5"));
		
		Collections.reverse(htlName);
		for (WebElement name : htlName) {
			
			System.out.println(name.getText());

		}

	}

}
