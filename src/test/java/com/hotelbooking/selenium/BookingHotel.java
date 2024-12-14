package com.hotelbooking.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BookingHotel {

	public static void main(String[] args) throws InterruptedException {

		// login,print welcome user name

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

		WebElement element = driver.findElement(By.xpath("//a[@class='icoTwitter mr-2 dropdown-toggle']"));
		String text = element.getText();
		System.out.println(text);

		// search hotel,select all room type

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

		WebElement slctDate = driver.findElement(By.xpath("//input[@class='form-control from hasDatepicker']"));
		slctDate.click();
		WebElement dateSlct = driver.findElement(By.xpath("(//a[@class='ui-state-default'])[5]"));
		dateSlct.click();
		WebElement chckOut = driver.findElement(By.xpath("//input[@class='form-control to hasDatepicker']"));
		chckOut.click();
		WebElement dateClk = driver.findElement(By.xpath("//a[text()='30']"));
		dateClk.click();

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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", srch);
		driver.switchTo().defaultContent();

		// select hotel,print select hotel,print all hotel name,print all hotel
		// price,select the 3rd hotel name

		WebElement element2 = driver.findElement(By.xpath("//h5[text()='Select Hotel']"));
		String text2 = element2.getText();
		System.out.println(text2);

		WebElement hotelList = driver.findElement(By.id("hotellist"));

		List<WebElement> elements = hotelList.findElements(By.tagName("h5"));
		for (WebElement name : elements) {
			String text3 = name.getText();
			System.out.println(text3);
		}

		List<WebElement> price = hotelList.findElements(By.tagName("strong"));
		for (WebElement prices : price) {

			String text4 = prices.getText();
			System.out.println(text4);
		}

		WebElement clkContinue = driver.findElement(By.xpath("(//a[text()='Continue'])[3]"));
		clkContinue.click();

		Alert al = driver.switchTo().alert();
		al.accept();

		// Book hotel,

		WebElement element3 = driver.findElement(By.xpath("//h2[@class='px-3 py-2']"));
		String text3 = element3.getText();
		System.out.println(text3);

		WebElement clkMyself = driver.findElement(By.id("own"));
		clkMyself.click();
		WebElement slctSalutn = driver.findElement(By.id("user_title"));
		Select slect = new Select(slctSalutn);
		slect.selectByValue("Mr");

		WebElement txtName = driver.findElement(By.id("first_name"));
		txtName.sendKeys("Shahul");
		WebElement txtLastName = driver.findElement(By.id("last_name"));
		txtLastName.sendKeys("Hameed");

		WebElement txtPhnNo = driver.findElement(By.id("user_phone"));
		txtPhnNo.sendKeys("8056692984");
		WebElement txtMail = driver.findElement(By.id("user_email"));
		txtMail.sendKeys("crshahul11@gmail.com");

		WebElement btnGst = driver.findElement(By.id("gst"));
		btnGst.click();

		// add gst details

		WebElement regNo = driver.findElement(By.id("gst_registration"));
		regNo.sendKeys("9043592058");
		WebElement name = driver.findElement(By.id("company_name"));
		name.sendKeys("Greens Tech OMR Branch");
		WebElement address = driver.findElement(By.id("company_address"));
		address.sendKeys("Thoraipakkam");
		WebElement clkNxt = driver.findElement(By.id("step1next"));
		clkNxt.click();

		// add special request

		WebElement txtReq = driver.findElement(By.id("other_request"));
		txtReq.sendKeys("i need large size room");
		WebElement clkNext = driver.findElement(By.id("step2next"));
		clkNext.click();

		// add payment deatails

		WebElement clkPayment = driver.findElement(By.xpath("(//div[@class='col-md-4'])[3]"));
		clkPayment.click();
		WebElement slctCardtype = driver.findElement(By.id("payment_type"));
		Select slct1 = new Select(slctCardtype);
		slct1.selectByValue("debit_card");
		WebElement slctCard = driver.findElement(By.id("card_type"));
		Select slct2 = new Select(slctCard);
		slct2.selectByValue("visa");

		WebElement cardNO = driver.findElement(By.id("card_no"));
		cardNO.sendKeys("5555555555552222");
		WebElement nameOnCard = driver.findElement(By.id("card_name"));
		nameOnCard.sendKeys("Shahul Hameed");

		WebElement slctMnth = driver.findElement(By.id("card_month"));
		Select slct3 = new Select(slctMnth);
		slct3.selectByValue("06");

		WebElement year = driver.findElement(By.id("card_year"));
		Select slct4 = new Select(year);
		slct4.selectByValue("2026");

		WebElement cvvNo = driver.findElement(By.id("cvv"));
		cvvNo.sendKeys("567");
		WebElement submt = driver.findElement(By.id("submitBtn"));
		submt.click();

		WebElement orderId = driver.findElement(By.name("booking-code"));
		String text4 = orderId.getText();
		String subStr = text4.substring(1, 11);
		System.out.println(subStr);

		WebElement textPrint = driver.findElement(By.xpath("//h2[text()=' Booking is Confirmed ']"));
		String text5 = textPrint.getText();
		String substring = text5.substring(12);
		System.out.println(substring);

		Thread.sleep(3000);
		WebElement htlName = driver.findElement(By.xpath("//strong[text()='Hyatt Regency Chennai']"));
		String text6 = htlName.getText();
		System.out.println(text6);

	}

}
