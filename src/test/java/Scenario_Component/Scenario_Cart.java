package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Cart;


public class Scenario_Cart extends Base_Class{
	

	public static Logger log= Logger.getLogger(Scenario_Cart.class);
	SoftAssert sAssert= new SoftAssert();
	
	@Test(dataProvider="dp_AddCart", dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void testAddCart(Map Cart) throws IOException, InterruptedException
	{
		String TC_ID = Cart.get("TC_ID").toString();
		String Order = Cart.get("Order").toString();
		String Search_item = Cart.get("Search_item").toString();
		String Exp_Result = Cart.get("Exp_Result").toString();
		
		Start_Server();
		log.info("Executing the Testcase " +TC_ID +" Order is  "+Order);
		
		Init_App();	
		
		PageObject_Cart BC_pob=new PageObject_Cart(driver);
		
		Explicitwait(BC_pob.Search_btn, 25);
		BC_pob.Click_Search();
		
		Explicitwait(BC_pob.Search_txtbox, 25);
		BC_pob.Enter_Searchtxt(Search_item);
		
		Explicitwait(BC_pob.Addbtn, 25);
		BC_pob.Click_Addbtn();
		
		Explicitwait(BC_pob.Cart_img, 25);
		BC_pob.Click_Cartimg();
		
		Explicitwait(BC_pob.item_msg, 25);
		String Actual_Result = BC_pob.getAddcartmsg();		
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is " +Actual_Result+ "  Expected Result is "+Exp_Result);
		}
		else
		{
			log.info("Failed as Actual Result is " +Actual_Result+ "  Expected Result is "+Exp_Result);
			sAssert.fail("Failed as Actual Result is " +Actual_Result+ "  Expected Result is "+Exp_Result);
		}
		
		Stop_Server();
		sAssert.assertAll();
		
	}


	@Test(dataProvider="dp_DeleteCart", dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void testDeleteCart(Map Cart) throws IOException, InterruptedException
	{
		String TC_ID = Cart.get("TC_ID").toString();
		String Order = Cart.get("Order").toString();
		String Search_item = Cart.get("Search_item").toString();
		String Exp_Result = Cart.get("Exp_Result").toString();
		
		Start_Server();
		log.info("Executing the Testcase " +TC_ID +" Order is  "+Order);
		
		Init_App();	
		
		PageObject_Cart BC_pob=new PageObject_Cart(driver);
		
		Explicitwait(BC_pob.Search_btn, 25);
		BC_pob.Click_Search();
		
		Explicitwait(BC_pob.Search_txtbox, 25);
		BC_pob.Enter_Searchtxt(Search_item);
		
		Explicitwait(BC_pob.Addbtn, 25);
		BC_pob.Click_Addbtn();
		
		Explicitwait(BC_pob.Cart_img, 25);
		BC_pob.Click_Cartimg();
		
		Explicitwait(BC_pob.Remove_btn, 25);
		BC_pob.Click_Removebtn();
		
		Explicitwait(BC_pob.Delete_msg, 25);
		String Actual_Result = BC_pob.getDeletcartmsg();
		
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is " +Actual_Result+ "  Expected Result is "+Exp_Result);
			snapshot1(TC_ID, Order);
		}
		else
		{
			log.info("Failed as Actual Result is " +Actual_Result+ "  Expected Result is "+Exp_Result);
			snapshot1(TC_ID, Order);
			sAssert.fail("Failed as Actual Result is " +Actual_Result+ "  Expected Result is "+Exp_Result);
		}
		
		Stop_Server();
		sAssert.assertAll();
		
	}


}
