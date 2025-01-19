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

public class PriceLowToHigh {

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
		//WebElement clkHtl = driver.findElement(By.xpath("(//h3[@class='mt-4'])[2]"));
		//clkHtl.click();
		List<WebElement> clkHtl = driver.findElements(By.xpath("//h3[@class='mt-4']"));
		WebElement htl = clkHtl.get(1);
		htl.click();
		

		WebElement Slctstate = driver.findElement(By.id("state"));
		Select select = new Select(Slctstate);
		select.selectByVisibleText("Tamil Nadu");

		WebElement slctCity = driver.findElement(By.id("city"));
		Select select2 = new Select(slctCity);
		select2.selectByVisibleText("Chennai");

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
		select4.selectByVisibleText("1-One");

		WebElement noOfAdults = driver.findElement(By.id("no_adults"));
		Select select5 = new Select(noOfAdults);
		select5.selectByVisibleText("2-Two");

		WebElement noOfChild = driver.findElement(By.id("no_child"));
		noOfChild.sendKeys("2");

		driver.switchTo().frame("hotelsearch_iframe");
		WebElement srch = driver.findElement(By.id("searchBtn"));

		// js.executeScript("arguments[0].click()", srch);
		srch.click();
		driver.switchTo().defaultContent();

		WebElement element = driver.findElement(By.xpath("//label[@for='value_pltoh']"));
		element.click();
		Thread.sleep(5000);

		List<Integer> dev = new ArrayList<Integer>();
		List<Integer> qa = new ArrayList<Integer>();

		WebElement hotelList = driver.findElement(By.id("hotellist"));
		List<WebElement> price = hotelList.findElements(By.tagName("strong"));
		for (WebElement prices : price) {

			dev.add(Integer.parseInt(prices.getText().substring(2).replace(",", "")));

		}

		qa.addAll(dev);
		Collections.sort(qa);

		for (Integer a : qa) {
			System.out.println(a);
		}

		for (int i = 0; i < qa.size(); i++) {

			System.out.println("dev:" + "  " + dev.get(i) + "  " + "qa:" + "   " + qa.get(i));

			
		}

		if (dev.equals(qa)) {
			System.out.println("true");
			
		} else {

			System.out.println("false");
		}

		
		
	}

}
