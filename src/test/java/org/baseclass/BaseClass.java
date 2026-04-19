package org.baseclass;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;
	Actions actions;

	public void browserLaunch() {

		driver = new ChromeDriver();

	}

	public void enterAppUrl(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendkeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	public void elementSendkeysAndEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	}

	public void elementClick(WebElement element) {
		element.click();
	}

	public static void elementClear(WebElement element) {
		element.clear();

	}

	public static long executionTime() {
		long timeMillis = System.currentTimeMillis();
		return timeMillis;

	}

	public String getAppTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String getAppUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void closeBrowser() {
		driver.quit();
	}

	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// fix value
	public static String elementgetProperty(WebElement element) {
		String domProperty = element.getDomProperty("value");
		return domProperty;
	}

	public String elementgetProperty(WebElement element, String value) {
		String domProperty = element.getDomProperty(value);
		return domProperty;
	}

	public void elementSendKeysJs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value',' " + data + " ')", element);
	}

	public void elementClickJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean elementIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public boolean elementIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	public void elementMouserOver(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void elementDragAndDrop(WebElement source, WebElement destination) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();
	}

	public void elementRightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void elementDoubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void alertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByContainsVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement ele : options) {
			System.out.println(elementGetText(ele));
		}
		return options;
	}

	public WebElement getFirstSelOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public List<WebElement> getAllSelOption(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public void switchToWindow() {
		String parWind = driver.getWindowHandle();
		Set<String> allWind = driver.getWindowHandles();
		for (String eachWind : allWind) {
			if (!parWind.equals(eachWind)) {
				driver.switchTo().window(eachWind);
			}
		}
	}

	public void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void frameByIdOrName(String value) {
		driver.switchTo().frame(value);
	}

	public void frameByWebElmentRef(WebElement element) {
		driver.switchTo().frame(element);

	}

}
