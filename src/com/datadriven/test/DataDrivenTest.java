package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\vamsh\\eclipse-workspace\\SeleniumDemo\\Lib\\geckoDriver\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		
		driver.get("https://reg.ebay.com/reg/PartialReg?siteid=0&UsingSSL=1&co_partnerId=2&errmsg=&src=&ru=https%3A%2F%2Fcart.payments.ebay.com%2Fsc%2Fview&signInUrl=https%3A%2F%2Fsignin.ebay.com%3A443%2Fws%2FeBayISAPI.dll%3FSignIn%26UsingSSL%3D1%26siteid%3D0%26co_partnerId%3D2%26pageType%3D2046448%26ru%3Dhttps%253A%252F%252Fcart.payments.ebay.com%252Fsc%252Fview%26_trksid%3Dp2046448.m2450&rv4=1");
		Thread.sleep(3000);
		Xls_Reader reader = new Xls_Reader("C:\\Users\\vamsh\\eclipse-workspace\\DataDrivenFramework\\src\\com\\testdata\\testData.xlsx");
		
		String firstname = reader.getCellData("sheet1", "firstname", 2);
		System.out.println(firstname);
		
		String lastname = reader.getCellData("sheet1", "lastname", 2);
		System.out.println(lastname);
		
		String emailaddress = reader.getCellData("sheet1", "emailaddress", 2);
		System.out.println(emailaddress);
		
		driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys(lastname);
		driver.findElement(By.cssSelector("input#email")).sendKeys(emailaddress);
		
		
	}

}
