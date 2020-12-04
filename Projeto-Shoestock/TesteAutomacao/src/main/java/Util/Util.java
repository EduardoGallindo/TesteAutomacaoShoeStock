package Util;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	WebDriver driver;
	WebDriverWait wait;

	public void clickJS(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement elemento = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", elemento);
	}

	public void click(WebDriver driver, By locator) throws InterruptedException {
		wait = new WebDriverWait(driver, 3);
		for (int j = 0; j < 2; j++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				WebElement elemento = driver.findElement(locator);
				elemento.click();
				j=2;
			} catch (NoSuchElementException e) {
				System.out.println("Erro na ação de click");
				Thread.sleep(3000);
			} catch (StaleElementReferenceException s) {
				System.out.println("Erro na ação de click");
				Thread.sleep(3000);
			}
		}
	}
	public void preencheCampo(WebDriver driver, By locator, String dado) throws InterruptedException {
		wait = new WebDriverWait(driver, 3);
		for (int j = 0; j < 2; j++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				WebElement elemento = driver.findElement(locator);
				elemento.click();
				elemento.clear();
		        String[] output = dado.split(Pattern.quote(""));
				for (String s : output) {
					elemento.sendKeys(s);
				}
				j=2;
			} catch (NoSuchElementException e) {
				System.out.println("Erro na ação de input");
				Thread.sleep(3000);
			} catch (StaleElementReferenceException s) {
				System.out.println("Erro na ação de input");
				Thread.sleep(3000);
			}
		}
	}

}
