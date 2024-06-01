package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.BasePage;

public class HomePage extends BasePage
{
	By searchinput=By.name("q");
	
	public void search(String prodtype)
	{
		driver.findElement(searchinput).sendKeys(prodtype,Keys.ENTER);
	}
}
