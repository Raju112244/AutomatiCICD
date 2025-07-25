package rahlshettyacademy.Tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahlshettyacademy.pageobject.CartPage;
import rahlshettyacademy.pageobject.CheckoutPage;
import rahlshettyacademy.pageobject.ConfirmationPage;
import rahlshettyacademy.pageobject.ProductCatalogue;
import rahulshettyacadmey.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest{


	
	
	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException,InterruptedException
	{
	
		
       landingPage.loginApplication("rajuautomatio@gmail.com","Raju@103");
       Assert.assertEquals("Incorrect email or password.",  landingPage.getErroMessage());
        // step->2 .searching the product adding to the cart
       
    
	}
    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException
    {
    	String productName ="ZARA COAT 3";
        ProductCatalogue productCatalogue =landingPage.loginApplication("rahulshetty@gmail.com","Raju@143");
         // step->2 .searching the product adding to the cart
        List<WebElement> products = productCatalogue.getProductList();
 		productCatalogue.addProductToCart(productName);
 		CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 3");  
        Assert.assertTrue(match);
       
     
    }
     
	}


