package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtility;

public class HalfEbayTest {
	
	WebDriver driver;

	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\vamsh\\eclipse-workspace\\SeleniumDemo\\Lib\\geckoDriver\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?siteid=0&UsingSSL=1&co_partnerId=2&errmsg=&src=&ru=https%3A%2F%2Fcart.payments.ebay.com%2Fsc%2Fview&signInUrl=https%3A%2F%2Fsignin.ebay.com%3A443%2Fws%2FeBayISAPI.dll%3FSignIn%26UsingSSL%3D1%26siteid%3D0%26co_partnerId%3D2%26pageType%3D2046448%26ru%3Dhttps%253A%252F%252Fcart.payments.ebay.com%252Fsc%252Fview%26_trksid%3Dp2046448.m2450&rv4=1");
			}
	
	@DataProvider
	public Iterator<Object[]> gettestdata()
	{
		
		ArrayList<Object[]> testdata =TestUtility.getDataFromExcel();
		return testdata.iterator();
	}
	
	
	
	
	@Test(dataProvider ="gettestdata")
	public void halfEbayRegPageTest(String firstname,String lastname,String emailaddress)
	{
		 driver.findElement(By.xpath(".//*[@id='firstname']")).clear();;
		 driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys(firstname);
		 driver.findElement(By.xpath(".//*[@id='lastname']")).clear();
		 driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys(lastname);
		 driver.findElement(By.cssSelector("input#email")).clear();
		 driver.findElement(By.cssSelector("input#email")).sendKeys(emailaddress);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
