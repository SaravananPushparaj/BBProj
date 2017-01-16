package Generic_Component;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {
	
	public static Process process;
	public static AndroidDriver driver;
	
	public static void Start_Server() throws IOException, InterruptedException
	{
		String Start_Server="D:\\Appium\\node.exe D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		 process = Runtime.getRuntime().exec(Start_Server);
		
		if(process != null)
		{
			System.out.println("Started the Appium Server");
		}
		else
		{
			System.out.println("NOT able to Start the Server");
		}
		
		Thread.sleep(12000);
	}
	
	public static void Init_App() throws InterruptedException, IOException
	{
		//Device details
				DesiredCapabilities capabilities= new DesiredCapabilities();
				
				capabilities.setCapability("deviceName", "GT-I9300I");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "4.4.4");
				
				
				//app details
				capabilities.setCapability("appPackage", "com.bigbasket.mobileapp");
				capabilities.setCapability("appActivity", "com.bigbasket.mobileapp.activity.SplashActivity");
				
				
				//Appium details
				
				 driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				Thread.sleep(4000);
	}
	
	
	public void Explicitwait(WebElement ele, long T1)
	{
		WebDriverWait wait = new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
	}
	
	
	public void snapshot1(String TC_ID,String Order) throws IOException
	{
		
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		File file= new File(df.format(date)+".png");
		
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\Dec16_Project\\Screenshot\\"+TC_ID+"-"+Order+"-"+file));
		
	}
	
	
	public static void Stop_Server() throws InterruptedException 
	{
				
				if(process!=null)
				{
					process.destroy();
					Thread.sleep(4000);
					System.out.println("Stopped the Appium Server");
				}
	}
	

}
