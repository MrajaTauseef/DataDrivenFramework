package ReadExcelData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Library.ReadExcelData;

public class FacebookLogin {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}
	
	@Test(dataProvider="facebookdata")
	public void Facebooklogin(String uname,String pass)
	{
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.findElement(By.id("loginbutton")).click();	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name="facebookdata")
	public Object[][] passData()
	{
		ReadExcelData config=new ReadExcelData("E:\\DDF\\Data\\TestData.xlsx");
		int rowcount=config.getrowCount(0);
		
		Object[][] data=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++)
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
		}
		return data;
		
		
	}

}
