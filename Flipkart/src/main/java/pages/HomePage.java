package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.BasePage;

public class HomePage extends BasePage
{
	By searchinput=By.name("q");
	
	//To search for a given product type in the homepage
	public void search(String prodtype)
	{
		driver.findElement(searchinput).sendKeys(prodtype,Keys.ENTER);
	}
	public void getLinks()
	{
		
	}
}
