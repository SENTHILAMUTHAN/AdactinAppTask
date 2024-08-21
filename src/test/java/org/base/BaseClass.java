package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static Alert alert;
	public static Select s;
	public static JavascriptExecutor jse;

//WEB DRIVER	

	public static void launchBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void closeCurrentPage() {
		driver.close();
	}

	public static void closeWebBrowser() {
		driver.quit();
	}

	public static String getTitleOfCurrentPage() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	public static String getUrlOfCurrentPage() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;
	}

//WebElement	

	public static String getTextOfWebElement(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;
	}

	public static String getAttributeOfWebElement(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		return attribute;
	}

	public static void clickWebElement(WebElement element) {
		element.click();
	}

	public static void passTextTOWebElement(WebElement element, String textValue) {
		element.sendKeys(textValue);
	}

//actions	

	public static void moveCursorToWebElement(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public static void doubleClickTheWebElement(WebElement element) {
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public static void dragAndDropToWebElement(WebElement source, WebElement target) {
		a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public static void rightClickTheWebElement(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).perform();
	}

//ALERTS	

	public static void switchToAlert() {
		alert = driver.switchTo().alert();
	}

	public static void acceptTheAlert() {
		alert.accept();
	}

	public static void dismissTheAlert() {
		alert.dismiss();
	}

	public static void passTextToAlertTextBox(String enterText) {
		alert.sendKeys(enterText);
	}

	public static String getTextFromAlert(String enterText) {
		String text = alert.getText();
		System.out.println(text);
		return text;
	}

//FRAMES

	public static void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public static void switchTOParentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void switchTODefaultContent() {
		driver.switchTo().defaultContent();
	}

//TAKESCREENSHOT

	public static void takeSS(String nameofss) throws IOException {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File source = tss.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				System.getProperty("user.dir")+"\\ScreenShot\\" + nameofss + ".png");
		FileUtils.copyFile(source, destination);
	}

//JAVA SCRIPT EXECUTOR

	public static void javaScriptSetAttribute(String enterText, WebElement element) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('value'," + "'" + enterText + "'" + ")", element);
	}

	public static void javaScriptClick(WebElement element) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", element);
	}

	public static String javaScriptGetAttribute(WebElement element) {
		jse = (JavascriptExecutor) driver;
		Object text = jse.executeScript("return arguments[0].getAttribute('value')", element);
		String s = (String) text;
		System.out.println(s);
		return s;
	}

	public static void javaScriptScrollInToView(WebElement element, boolean enterTrueOrFlase) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(" + enterTrueOrFlase + ")", element);
	}

	public static void selectByValue(String value) {
		s.selectByValue(value);
	}

	public static void selectByVisibleText(String text) {
		s.selectByVisibleText(text);
	}

	public static void selectByIndex(int index) {
		s.selectByIndex(index);
	}

	public static boolean selectIsMultiple() {
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
		return multiple;
	}

//SELECT	

	public static String SelectGetOptionsTxt(WebElement element, int i) {

		s = new Select(element);

		List<WebElement> options = s.getOptions();
		WebElement webElement = options.get(i);
		String text = webElement.getText();
		System.out.println(text);
		return text;
	}

	public static String SelectGetOptionsAttribute(WebElement element, int i) {

		s = new Select(element);

		List<WebElement> options = s.getOptions();
		WebElement webElement = options.get(i);
		String text = webElement.getAttribute("value");
		System.out.println(text);
		return text;
	}

	public static String selectGetAllSelectedOption(WebElement element, int i) {

		s = new Select(element);

		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		WebElement webElement = allSelectedOptions.get(i);
		String attribute = webElement.getAttribute("value");
		System.out.println(attribute);
		return attribute;
	}

	public static String selectGetFirstSelectedOption(WebElement element) {

		s = new Select(element);

		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String attribute = firstSelectedOption.getAttribute("value");
		System.out.println(attribute);
		return attribute;
	}

	public static void selectDeSelectByValue(WebElement element, String value) {

		s = new Select(element);

		s.deselectByValue(value);
	}

	public static void selectDeSelectByVisibleText(WebElement element, String text) {

		s = new Select(element);

		s.deselectByVisibleText(text);
	}

	public static void selectDeSelectByIndex(WebElement element, int index) {

		s = new Select(element);

		s.deselectByIndex(index);
	}

	public static void selectDeSelectAll(WebElement element) {

		s = new Select(element);

		s.deselectAll();
	}

//WINDOW HANDLING

	public static void switchToWindow(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winId = new ArrayList<String>();
		winId.addAll(windowHandles);
		driver.switchTo().window(winId.get(i));
	}

//WAITS 

	public static void threadSleep(long enterMillis) throws InterruptedException {
		Thread.sleep(enterMillis);
	}

	public static void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

//DATADRIVEN(EXCEL)	

	public static void readParticularcell(String bookName, String sheetName, int r, int c) throws IOException {
		File f = new File(System.getProperty("user.dir")+"\\workBook\\" + bookName + ".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(r);
		Cell cell = row.getCell(c);
		int cellType = cell.getCellType();
		if (cellType == 1) {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);

		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			String formated = sdf.format(dateCellValue);
			System.out.println(formated);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			String valueOf = String.valueOf(l);
			System.out.println(valueOf);
		}
	}

	public static void readAllcell(String bookName, String sheetName) throws IOException {
		File f = new File(System.getProperty("user.dir")+"\\workBook\\" + bookName + ".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet(sheetName);

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if (cellType == 1) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);

				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
					String formated = sdf.format(dateCellValue);
					System.out.println(formated);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					String valueOf = String.valueOf(l);
					System.out.println(valueOf);
				}
			}
		}
	}

	public static void readParticularRow(String bookName, String sheetName, int i) throws IOException {
		File f = new File(System.getProperty("user.dir")+"\\workBook\\" + bookName + ".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet(sheetName);

		Row row = sheet.getRow(i);
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			Cell cell = row.getCell(j);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);

			} else if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				String formated = sdf.format(dateCellValue);
				System.out.println(formated);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				String valueOf = String.valueOf(l);
				System.out.println(valueOf);
			}
		}
	}

}