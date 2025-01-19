package org.reusablecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	Select select;
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	Alert alert;
	Actions actions;
	TakesScreenshot screenshot = (TakesScreenshot) driver;

	public static void browserLaunch(String browserType) {

//1,2,3,4
		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

//5
	public static void enterApplUrl(String url) {
		driver.get(url);
	}

//6
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

//7
	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

//8
	public void elementClick(WebElement element) {
		element.click();
	}

//9
	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

//10
	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

//11
	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

//12
	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

//13
	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

//14
	public WebElement findLocatorByXpath(String exp) {
		WebElement element = driver.findElement(By.xpath(exp));
		return element;
	}

//15
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

//16
	public String elementGetAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

//16
	public String elementGetAttributeValue(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

//17
	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

//18
	public boolean elementIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

//19
	public boolean elementIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

//20
	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

//20
	public void implicityWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

//21
	public static void closeWindow() {
		driver.close();
	}

//22
	public void selectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

//23
	public void selectOptionByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

//24
	public void selectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
//25	

	public List<String> getAllDropDownOptions(WebElement element) {
		List<String> allOptionsText = new ArrayList<>();
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			allOptionsText.add(webElement.getText());

		}
		return allOptionsText;

	}

//26
	public void switchToChildWindow() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String eachWindowId : windowHandles) {
			if (!windowHandle.equals(eachWindowId)) {
				driver.switchTo().window(eachWindowId);

			}

		}
	}

//27
	public void scroll(WebElement element) {
		executor.executeScript("arguments[0].scrollIntoView()", element);

	}

//28
	public void elementSendKeysJs(WebElement element, String data) {
		
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

//29
	public void elementSendKeysEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	}

//30
	public void elementSendKeys1(WebElement element, String data) {
		element.sendKeys(data);

	}

//31
	public void clikOkAlert() {
		alert = driver.switchTo().alert();
		alert.accept();

	}

//32
	public void clickCancelalert() {
		alert = driver.switchTo().alert();
		alert.dismiss();

	}

//33
	public void elementClickJs(WebElement element) {
		executor.executeScript("arguments[0].click()", element);

	}

//34

	public void switchFrameIndex(int index) {
		driver.switchTo().frame(index);

	}
//35

	public void switchFrameId(String id) {
		driver.switchTo().frame(id);

	}

//36
	public void switchFrameName(String name) {
		driver.switchTo().frame(name);

	}

//37
	public void switchFrameWebElement(WebElement element) {
		driver.switchTo().frame(element);

	}

//38
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void navigateForward() {

		driver.navigate().forward();

	}

	public void navigateBack() {

		driver.navigate().back();

	}

	public void navigateRefresh() {

		driver.navigate().refresh();

	}

//39
	public void doubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}

//40
	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

//41
	public void dragandDrop(WebElement s) {

	}
//42

	public void mouseOverActions(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

//43
	public void takeScreenShot(String sName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("file path" + sName + ".png"));

	}

//44
	public void takeScreenshotElement(String sName, WebElement element) throws IOException {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("file path" + sName + ".png"));

	}

//45
	public void clearValues(WebElement element) {

		element.clear();
	}

//46
	public void deSelectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.deselectByIndex(index);

	}

//47
	public void deSelectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.deselectByVisibleText(text);

	}

//48
	public void deSelectOptionByValue(WebElement element, String value) {
		select = new Select(element);
		select.deselectByValue(value);

	}

//49
	public void deSelectedAllSelectedOption(WebElement element) {
		select = new Select(element);
		select.deselectAll();

	}

//50
	public WebElement webDriverWait(WebElement element, int seconds, String attributevalue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(attributevalue)));

		return element1;

	}
//51

	public Object fluentWait(Object object, String attributevalue, int seconds) {
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
				.ignoring(Exception.class);
		Object object2 = w.until(ExpectedConditions.visibilityOfElementLocated(By.id(attributevalue)));
		return object2;

	}

//52
	public boolean dropDownIsMultipleSelectedorNot(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;

	}

//53
	public String getfirstSelectedOption(WebElement element) {
		select = new Select(element);
		WebElement element1 = select.getFirstSelectedOption();

		String text = element1.getText();
		return text;

	}

//54
	public List<String> getAllOptionText(WebElement element) {
		List<String> alloptions = new ArrayList<String>();
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			WebElement options = allSelectedOptions.get(i);
			String text = options.getText();
			alloptions.add(text);

		}
		return alloptions;
	}

//55
	public void createCellAndSetData(String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\FrameWork\\\\Excell\\\\Omr.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

//56
	public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {
		File file = new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameworkClass930AM\\Excel Sheet\\TestData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

//57
	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
		String res = null;

		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FrameWork\\Excell\\Omr.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					res = String.valueOf(round);
				} else {
					res = String.valueOf(numericCellValue);
				}

			}

			break;

		default:
			break;
		}
		return res;
	}
//58

	public void deleteCookies() {
		driver.manage().deleteAllCookies();

	}
//59	

	public byte[] takesScreenShot() {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;

	}

}

