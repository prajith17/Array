package Org.archa;


	//package org.stepdefinition;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;
	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Bacl {
		// WebDriver Methods
		public static WebDriver driver;

		public static void launchBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	public static void closeentireBrowser() {
		driver.close();
	}
		public static void launchUrl(String url) {
			driver.get(url);
		}

		public static void windowmaxi() {
			driver.manage().window().maximize();
		
		}

		public static String title() {
			String title = driver.getTitle();
			return title;
			// System.out.println(title);
		}

		public static String currentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
			// System.out.println(currentUrl);
		}

		public static void crunt_tab() {
			driver.close();
		}

		public static void all_tab() {
			driver.quit();
		}

		public static void passText(String txt, WebElement e) {
			e.sendKeys(txt);
			}
		

		// WebElement Methods
		public static void click(WebElement e) {
			e.click();
		}

		public static void value(WebElement e, String v) {
			e.sendKeys(v);
		}

		public static void clear(WebElement e) {
			e.clear();
		}

		public static void text(WebElement e) {
			String text = e.getText();
			System.out.println(text);
		}

		public static void tagName(WebElement e) {
			String tagName = e.getTagName();
			System.out.println(tagName);

		}

		public static void atb_Name(WebElement e, String att) {
			String attribute = e.getAttribute(att);
			System.out.println(attribute);
		}

		// Select Methods

		public static void select_index(WebElement e, int i, String v) {
			Select s = new Select(e);
			s.selectByIndex(i);
			s.selectByValue(v);
			s.selectByVisibleText(v);
			s.deselectByIndex(i);
			s.deselectByValue(v);
			s.deselectByVisibleText(v);
		}

		public static void options(WebElement e) {
			Select s = new Select(e);
			List<WebElement> all_opt = s.getAllSelectedOptions();
			for (WebElement opt : all_opt) {
				System.out.println(opt.getText());
			}
		}

		public static void de_options(WebElement e) {
			Select s = new Select(e);
			s.deselectAll();
		}

		// Actions
		public static void moveTo(WebDriver d, WebElement e) {
			Actions a = new Actions(d);
			a.moveToElement(e).build().perform();
		}

		public static void click(WebDriver d, WebElement e) {
			Actions a = new Actions(d);
			a.click(e).build().perform();
		}

		public static void right_Click(WebDriver d, WebElement e) {
			Actions a = new Actions(d);
			a.contextClick(e).build().perform();
		}

		public static void double_click(WebDriver d, WebElement e) {
			Actions a = new Actions(d);
			a.doubleClick(e).build().perform();
		}

		// Robot
		public static void tab() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}

		public static void up() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);

		}

		public static void down() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}

		public static void right() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
		}

		public static void left() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);
		}

		public static void enter() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

		// JavascriptExecutor
		public static void js_click(WebElement e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", e);

		}

		public static void scroll_page(WebElement e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoview()", e);
		}
		public static void clickBtn(WebElement ele) {
			ele.click();
		}
		public static String pagetitle() {
			String title = driver.getTitle();
			return title;
		}
		public static String pageUrl() {
			String Url = driver.getCurrentUrl();
			return Url;
		}
		
		

		// TakeScreenshot
		public static void screenshot(String path) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(path);
			FileUtils.copyFile(source, dest);
		}

		// write data to excel file
		public static void write_excel() throws IOException {
			File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Baseclass\\Excel\\data.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet newSheet = w.createSheet("Sheet1");
			Row newRow = newSheet.createRow(0);
			Cell newCell = newRow.createCell(0);
			newCell.setCellValue("");
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);

		}

		public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
			File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Baseclass\\Excel\\data.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet mysheet = wb.getSheet("sheet1");
			Row r = mysheet.getRow(rowNum);
			Cell c = r.getCell(cellNum);
			int cellType = c.getCellType();
			if (cellType == 1) {
			} else if (DateUtil.isCellDateFormatted(c)) {
				Date dd = c.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yy");
				String value1 = s.format(dd);
				System.out.println(value1);
			} else {
				double d = c.getNumericCellValue();
				long l = (long) d;
				String valueOf = String.valueOf(l);
				System.out.println(valueOf);
			}
		}

		public static void createnewexcellfile(int rowNum, int cellNum, String writeData) throws IOException {
			File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Baseclass\\Excel\\data.xlsx");
			Workbook wb = new XSSFWorkbook();
			Sheet mySheet1 = wb.createSheet("sheet1");
			Row createRow = mySheet1.createRow(rowNum);
			Cell createCell = createRow.createCell(cellNum);
			createCell.setCellValue(writeData);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}

		public static void createcell(int getrow, int crecell, String newData) throws IOException {
			File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Baseclass\\Excel\\data.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet mySheet1 = wb.getSheet("sheet1");
			Row r = mySheet1.getRow(getrow);
			Cell c = r.createCell(crecell);
			c.setCellValue(newData);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}

		public static void createRow(int crerow, int crecell, String newData) throws IOException {
			File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Baseclass\\Excel\\data.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet mySheet1 = wb.getSheet("sheet1");
			Row r = mySheet1.createRow(crerow);
			Cell c = r.createCell(crecell);
			c.setCellValue(newData);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}

		public static void updateDataToParticularCell1(int getTheRow, int getTheCell, String exisitingData,
				String writenewData) throws IOException {
			File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Baseclass\\Excel\\data.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet mySheet1 = wb.getSheet("sheet1");
			Row r = mySheet1.getRow(getTheRow);
			Cell c = r.getCell(getTheCell);
			String stringCellValue = c.getStringCellValue();
			if (stringCellValue.equals(exisitingData)) {
				c.setCellValue(writenewData);
			}
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		

			
	}


}
