package com.hotelbooking.selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeAndCancelBooking {
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
		
		//update booking

		WebElement clkWel = driver.findElement(By.xpath("//a[@class='icoTwitter mr-2 dropdown-toggle']"));
		clkWel.click();

		
		WebElement myaccount = driver.findElement(By.xpath("//a[text()='My Account']"));
		myaccount.click();

		List<WebElement> orderID = driver.findElements(By.xpath("//div[@class='room-code']"));
		WebElement iD = orderID.get(1);
		

		WebElement search = driver.findElement(By.name("search"));
		search.sendKeys(iD.getText().substring(1), Keys.ENTER);
		
		WebElement roomcode = driver.findElement(By.xpath("//div[@class='room-code']"));
		String rcode = roomcode.getText();
		String rcode1 = rcode.substring(1, 10);
		System.out.println(rcode1);

		WebElement hotelname1 = driver.findElement(By.xpath("//a[@target='_blank']/h5"));
		String hname = hotelname1.getText();
		System.out.println(hname);

		Thread.sleep(5000);
		WebElement prize = driver.findElement(By.className("total-prize"));
		String totalprice = prize.getText();
		String totalprice1 = totalprice.substring(3);
		System.out.println(totalprice1);

		WebElement editbooking = driver.findElement(By.xpath("//button[@class='edit btn filter_btn']"));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click()", editbooking);

		WebElement datechange = driver.findElement(By.xpath("//input[@name='check_in']"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].setAttribute('value','28-12-2024')", datechange);

		WebElement confirm = driver.findElement(By.xpath("//button[text()='Confirm']"));
		confirm.click();

		WebElement updated = driver.findElement(By.xpath("//li[@class='alertMsg']"));
		String updatedmsg = updated.getText();
		System.out.println(updatedmsg);

		// cancel booking
		WebElement clkWelm = driver.findElement(By.xpath("//a[@class='icoTwitter mr-2 dropdown-toggle']"));
		clkWelm.click();

		WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount.click();

		List<WebElement> orderiD = driver.findElements(By.xpath("//div[@class='room-code']"));
		WebElement id = orderiD.get(1);
		
		WebElement srch = driver.findElement(By.name("search"));
		srch.sendKeys(id.getText().substring(1), Keys.ENTER);
		WebElement rmcode = driver.findElement(By.xpath("//div[@class='room-code']"));
		String rcde = rmcode.getText();
		String rcodes1 = rcde.substring(1, 10);
		System.out.println(rcodes1);

		WebElement hotelName1 = driver.findElement(By.xpath("//a[@target='_blank']/h5"));
		String hName = hotelName1.getText();
		System.out.println(hName);

		Thread.sleep(5000);
		WebElement prizes = driver.findElement(By.className("total-prize"));
		String totalPrice = prizes.getText();
		String totalPrice1 = totalPrice.substring(3);
		System.out.println(totalPrice1);

		WebElement cancel = driver.findElement(By.xpath("(//a[@class='cancle btn filter_btn'])[1]"));
		cancel.click();
		Alert al1 = driver.switchTo().alert();
		al1.accept();

		WebElement cancelled = driver.findElement(By.xpath("//li[@class='alertMsg']"));
		String cancelledmsg = cancelled.getText();
		System.out.println(cancelledmsg);

	}

}
