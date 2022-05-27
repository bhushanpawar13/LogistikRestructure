/**
 * 
 */
package com.mystore.actiondriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actioninterface.ActionInterface;
import com.mystore.basepackage.BaseClass;

/**
 * @author Bhushan.Pawar
 *
 */
public class Action extends BaseClass {

	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
		public void click(WebDriver driver, WebElement ele) {
			Actions act = new Actions(driver);
			act.moveToElement(ele).click().build().perform();
			
		}
			public boolean findElement(WebDriver driver, WebElement ele) {
				boolean flag = false;
				try {
					ele.isDisplayed();
					flag = true;
				} catch (Exception e) {
					// System.out.println("Location not found: "+locatorName);
					flag = false;
				} finally {
					if (flag) {
						System.out.println("Successfully Found element at");

					} else {
						System.out.println("Unable to locate element at");
					}
				}
				return flag;
			}
			
			public boolean isDisplayed(WebDriver driver, WebElement ele) {
				boolean flag = false;
				flag = findElement(driver, ele);
				if (flag) {
					flag = ele.isDisplayed();
					if (flag) {
						System.out.println("The element is Displayed");
					} else {
						System.out.println("The element is not Displayed");
					}
				} else {
					System.out.println("Not displayed ");
				}
				return flag;
			}

			public boolean isSelected(WebDriver driver, WebElement ele) {
				boolean flag = false;
				flag = findElement(driver, ele);
				if (flag) {
					flag = ele.isSelected();
					if (flag) {
						System.out.println("The element is Selected");
					} else {
						System.out.println("The element is not Selected");
					}
				} else {
					System.out.println("Not selected ");
				}
				return flag;
			}
			
			public boolean isEnabled(WebDriver driver, WebElement ele) {
				boolean flag = false;
				flag = findElement(driver, ele);
				if (flag) {
					flag = ele.isEnabled();
					if (flag) {
						System.out.println("The element is Enabled");
					} else {
						System.out.println("The element is not Enabled");
					}
				} else {
					System.out.println("Not Enabled ");
				}
				return flag;
			}
			
			public boolean type(WebElement ele, String text) {
				boolean flag = false;
				try {
					flag = ele.isDisplayed();
					ele.clear();
					ele.sendKeys(text);
					// logger.info("Entered text :"+text);
					flag = true;
				} catch (Exception e) {
					System.out.println("Location Not found");
					flag = false;
				} finally {
					if (flag) {
						System.out.println("Successfully entered value");
					} else {
						System.out.println("Unable to enter value");
					}

				}
				return flag;
			}
			
			public boolean selectBySendkeys(String value,WebElement ele) {
				boolean flag = false;
				try {
					ele.sendKeys(value);
					flag = true;
					return true;
				} catch (Exception e) {

					return false;
				} finally {
					if (flag) {
						System.out.println("Select value from the DropDown");		
					} else {
						System.out.println("Not Selected value from the DropDown");
						// throw new ElementNotFoundException("", "", "")
					}
				}
			}

			public boolean selectByIndex(WebElement element, int index) {
				boolean flag = false;
				try {
					Select s = new Select(element);
					s.selectByIndex(index);
					flag = true;
					return true;
				} catch (Exception e) {
					return false;
				} finally {
					if (flag) {
						System.out.println("Option selected by Index");
					} else {
						System.out.println("Option not selected by Index");
					}
				}
			}
			
			public boolean selectByValue(WebElement element,String value) {
				boolean flag = false;
				try {
					Select s = new Select(element);
					s.selectByValue(value);
					flag = true;
					return true;
				} catch (Exception e) {

					return false;
				} finally {
					if (flag) {
						System.out.println("Option selected by Value");
					} else {
						System.out.println("Option not selected by Value");
					}
				}
			}

			public boolean selectByVisibleText(String visibletext, WebElement ele) {
				boolean flag = false;
				try {
					Select s = new Select(ele);
					s.selectByVisibleText(visibletext);
					flag = true;
					return true;
				} catch (Exception e) {
					return false;
				} finally {
					if (flag) {
						System.out.println("Option selected by VisibleText");
					} else {
						System.out.println("Option not selected by VisibleText");
					}
				}
			}
			
			public int getColumncount(WebElement row) {
				List<WebElement> columns = row.findElements(By.tagName("td"));
				int a = columns.size();
				System.out.println(columns.size());
				for (WebElement column : columns) {
					System.out.print(column.getText());
					System.out.print("|");
				}
				return a;
			}
			
			public int getRowCount(WebElement table) {
				List<WebElement> rows = table.findElements(By.tagName("tr"));
				int a = rows.size() - 1;
				return a;
			}
			
//			public boolean Alert(WebDriver driver) {
//				boolean presentFlag = false;
//				Alert alert = null;
//
//				try {
//					// Check the presence of alert
//					alert = driver.switchTo().alert();
//					// if present consume the alert
//					alert.accept();
//					presentFlag = true;
//				} catch (NoAlertPresentException ex) {
//					// Alert present; set the flag
//
//					// Alert not present
//					ex.printStackTrace();
//				} finally {
//					if (!presentFlag) {
//						System.out.println("The Alert is handled successfully");		
//					} else{
//						System.out.println("There was no alert to handle");
//					}
//				}
//
//				return presentFlag;
//			}
			
			public boolean launchUrl(WebDriver driver,String url) {
				boolean flag = false;
				try {
					driver.navigate().to(url);
					flag = true;
					return true;
				} catch (Exception e) {
					return false;
				} finally {
					if (flag) {
						System.out.println("Successfully launched \""+url+"\"");				
					} else {
						System.out.println("Failed to launch \""+url+"\"");
					}
				}
			}
			
			public String getTitle(WebDriver driver) {
				boolean flag = false;

				String text = driver.getTitle();
				if (flag) {
					System.out.println("Title of the page is: \""+text+"\"");
				}
				return text;
			}
			
			public String getCurrentURL(WebDriver driver)  {
				boolean flag = false;

				String text = driver.getCurrentUrl();
				if (flag) {
					System.out.println("Current URL is: \""+text+"\"");
				}
				return text;
			}
			
			public boolean click1(WebElement locator, String locatorName) {
				boolean flag = false;
				try {
					locator.click();
					flag = true;
					return true;
				} catch (Exception e) {
					return false;
				} finally {
					if (flag) {
						System.out.println("Able to click on \""+locatorName+"\"");
					} else {
						System.out.println("Click Unable to click on \""+locatorName+"\"");
					}
				}

			}
			
		
			public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
			    Wait<WebDriver> wait = null;
			    try {
			        wait = new FluentWait<WebDriver>((WebDriver) driver)
			        		.withTimeout(Duration.ofSeconds(20))
			        	    .pollingEvery(Duration.ofSeconds(2))
			        	    .ignoring(Exception.class);
			        wait.until(ExpectedConditions.visibilityOf(element));
			        element.click();
			    }catch(Exception e) {
			    }
			}
		
			public void implicitWait(WebDriver driver, int timeOut) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			
			public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
				WebDriverWait wait = new WebDriverWait(driver,timeOut);
				wait.until(ExpectedConditions.visibilityOf(element));
			}
		
			public void pageLoadTimeOut(WebDriver driver, int timeOut) {
				driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
			}
			
			
			public String getCurrentTime() {
				String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
				return currentDate;
			}
	
}
