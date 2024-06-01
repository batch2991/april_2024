package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ProductsListPage extends BasePage
{
	By heading=By.className("BUOuZu");
	By lowhigh=By.xpath("//div[.='Price -- Low to High']");
	By prices=By.cssSelector("div.Nx9bqj._4b5DiR");
	By prod=By.className("KzDlHZ");
	
	public String readTitle()
	{
		String title=driver.getTitle().toLowerCase();
		return title;
	}
	public String readHeading()
	{
		String strhead=driver.findElement(heading).getText();
		return strhead;
	}
	public void clickPriceLowToHigh()
	{
		try {Thread.sleep(5000);}catch(Exception e) {}
		driver.findElement(lowhigh).click();
		try {Thread.sleep(3000);}catch(Exception e) {}
	}
	public List<Integer> readAllPrices()
	{
	   List<WebElement>	lst=driver.findElements(prices);
	   List<Integer> p=new ArrayList<Integer>();
	   for(WebElement x : lst)
	   {
		  p.add(Integer.parseInt(x.getText().substring(1).replace(",","")));
	   }
	   return p;
	}
	public String[] clickOneProduct()
	{
		String first[]=new String[2];
		first[0]=driver.findElements(prod).get(0).getText();
		first[1]=driver.findElements(prices).get(0).getText();
		driver.findElements(prod).get(0).click();
		return first;
	}
}
