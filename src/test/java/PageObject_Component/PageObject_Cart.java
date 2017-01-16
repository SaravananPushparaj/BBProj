package PageObject_Component;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Cart {
	
public AppiumDriver driver;
	
	//2nd section
	@FindBy(id="com.bigbasket.mobileapp:id/action_search")
	public WebElement Search_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Search_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/btnAddToBasket")
	public WebElement Addbtn;
		
	@FindBy(id="com.bigbasket.mobileapp:id/basketimageview")
	public WebElement Cart_img;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement item_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement Remove_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Delete_msg;
	
	//1st section
	//initializing page factory
	public PageObject_Cart(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3rd section
	
	public void Click_Search()
	{
		Search_btn.click();
		
	}
	
	public void Enter_Searchtxt(String Value)
	{
		Search_txtbox.sendKeys(Value + "\n");
		
	}
	
	public void Click_Addbtn()
	{
		Addbtn.click();
		
	}
	
	public void Click_Cartimg()
	{
		Cart_img.click();
		
	}
	
	public String getAddcartmsg()
	{
		return item_msg.getText();
		
	}
	
	public void Click_Removebtn()
	{
		Remove_btn.click();
		
	}
	
	public String getDeletcartmsg()
	{
		return Delete_msg.getText();
		
	}

}
