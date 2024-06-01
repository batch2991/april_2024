package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import base.BasePage;

public class SingleProductPage extends BasePage
{
    By cartbtn=By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']");
	By pname=By.className("gE4Hlh");
	By price=By.className("_1Y9Lgu");
	
	ArrayList<String> tabs;
	
	public void clickAddToCart()
	{
		try {Thread.sleep(3000);}catch(Exception e) {}
		tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,1000)");
		driver.findElement(cartbtn).click();	
	}
	public String[] readProductNameandPrice()
	{
	    String second[]=new String[2];
	    second[0]=driver.findElement(pname).getText();
	    second[1]=driver.findElement(price).getText();
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	    return second;
	}
}
