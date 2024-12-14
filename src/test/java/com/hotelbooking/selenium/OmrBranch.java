package com.hotelbooking.selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OmrBranch {

	public static void main(String[] args) {
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
		driver.switchTo().frame("hotelsearch_iframe");
		WebElement srch = driver.findElement(By.id("searchBtn"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", srch);
		driver.switchTo().defaultContent();

		WebElement inValidState = driver.findElement(By.id("invalid-state"));
		WebElement inValidCity = driver.findElement(By.id("invalid-city"));
		WebElement inValidCheckIn = driver.findElement(By.id("invalid-check_in"));
		WebElement inValidCheckOut = driver.findElement(By.id("invalid-check_out"));
		WebElement inValidRooms = driver.findElement(By.id("invalid-no_rooms"));
		WebElement inValidAdult = driver.findElement(By.id("invalid-no_adults"));

		List<String> errorList = Arrays.asList(inValidState.getText(),inValidCity.getText(),inValidCheckIn.getText(),inValidCheckOut.getText(),
				inValidRooms.getText(),inValidAdult.getText());
		for (String errorMsg : errorList) {

			System.out.println(errorMsg);
		}

	}

}
