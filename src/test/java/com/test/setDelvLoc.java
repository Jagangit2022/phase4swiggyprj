package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class setDelvLoc {
		
	private AndroidDriver driver;
	TouchAction touchAction;

	  @BeforeTest
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:platformVersion", "7.1.1");
	    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
	    //desiredCapabilities.setCapability("appium:app", "C:\\Users\\ADMIN\\Downloads\\ApiDemos-debug.apk");
	    desiredCapabilities.setCapability("appium:appPackage", "in.swiggy.android");
	    desiredCapabilities.setCapability("appium:appActivity", "in.swiggy.android.activities.HomeActivity");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    
	    touchAction = new TouchAction(driver);
	  }
	  
	  public MobileElement getTextViewByContentDesc(String contentDesc) {
          
          return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\""+ contentDesc +"\"]");
	  }

	  public MobileElement getTextViewByResourceId(String resourceId) {
          
          return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id=\""+ resourceId +"\"]");
	  }
	  
	  public MobileElement getTextViewByText(String textId) {
          
          return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\""+ textId +"\"]");
	  }
	  
	  
	  @Test
	  public void testNavToSearchPage() throws InterruptedException {

		  MobileElement eleLocDesc=(MobileElement) driver.findElementById("in.swiggy.android:id/location_description");
		  eleLocDesc.sendKeys("Bangalore");
		
		//  MobileElement eleLocDescfromList= getTextViewByIndex("1");

		  
		  MobileElement eleLocDescfromList=(MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[3]");
		  eleLocDescfromList.click();
		  
		  MobileElement eleConfLoc=(MobileElement) driver.findElementById("in.swiggy.android:id/google_place_search_title_text1");
		  eleConfLoc.click();
		  
		  MobileElement eleSelectLoc=(MobileElement) driver.findElementByXPath("//android.view.ViewGroup[2]");
		  eleSelectLoc.click();
		  
		  MobileElement eleSelectProceed=(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView");
		  eleSelectProceed.click();	  
/*		  
		  MobileElement eleSearchRestItem=(MobileElement) driver.findElementById("in.swiggy.android:id/tv_search_dls");
		  eleSearchRestItem.click();
		  
		  MobileElement eleEditText=(MobileElement) driver.findElementByXPath("//android.widget.EditText");
		  eleEditText.sendKeys("nan");

		  MobileElement eleFromSrchList=(MobileElement) driver.findElementByXPath("//android.view.ViewGroup[5]");
		  eleFromSrchList.click();
		  
		  MobileElement eleNandhiniRest=getTextViewByResourceId("in.swiggy.android:id/restaurant_item");
		  eleNandhiniRest.click();
*/		  
	  }
	  
	  @Test (dependsOnMethods= {"testNavToSearchPage"})
	  public void testRestaurantSrch() throws InterruptedException {
/*
		  MobileElement eleLocDesc=(MobileElement) driver.findElementById("in.swiggy.android:id/location_description");
		  eleLocDesc.sendKeys("Bangalore");
		
		//  MobileElement eleLocDescfromList= getTextViewByIndex("1");

		  
		  MobileElement eleLocDescfromList=(MobileElement) dri  ver.findElementByXPath("//android.widget.LinearLayout[3]");
		  eleLocDescfromList.click();
		  
		  MobileElement eleConfLoc=(MobileElement) driver.findElementById("in.swiggy.android:id/google_place_search_title_text1");
		  eleConfLoc.click();
		  
		  MobileElement eleSelectLoc=(MobileElement) driver.findElementByXPath("//android.view.ViewGroup[2]");
		  eleSelectLoc.click();
		  
		  MobileElement eleSelectProceed=(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView");
		  eleSelectProceed.click();	  
	*/	  
		  MobileElement eleSearchRestItem=(MobileElement) driver.findElementById("in.swiggy.android:id/tv_search_dls");
		  eleSearchRestItem.click();
		  
		  MobileElement eleEditText=(MobileElement) driver.findElementByXPath("//android.widget.EditText");
		  eleEditText.sendKeys("Nanda");

		  MobileElement eleSelectedRest=getTextViewByContentDesc("Nanda's");
		  String selectedRestVal = eleSelectedRest.getAttribute("text");
          System.out.println("Selected Restaurant value =" +selectedRestVal);
          eleSelectedRest.click();
          
		  //MobileElement eleFromSrchList=(MobileElement) driver.findElementByXPath("//android.view.ViewGroup[4]");
		  
          MobileElement eleNandasRest=getTextViewByResourceId("in.swiggy.android:id/list_item_title");
		  String nandasRestVal = eleNandasRest.getAttribute("text");
          System.out.println("Final slected Restaurant value =" + nandasRestVal);
          eleNandasRest.click();

		  
		  //MobileElement eleNandaRest=getTextViewByResourceId("in.swiggy.android:id/restaurant_item");
		  //eleNandaRest.click();
		  //Thread.sleep(5000);

	  }
	  
	  @Test (dependsOnMethods= {"testNavToSearchPage", "testRestaurantSrch"})
	  public void testDishSrch() throws InterruptedException {
		  //MobileElement eleSearchDishBtn=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Search for items\"]");
		  //eleSearchDishBtn.click();
		  
		  MobileElement eleSearchDishBtn=(MobileElement) driver.findElementById("in.swiggy.android:id/search_tv");
		  eleSearchDishBtn.click();
		  
		  //MobileElement eleSearchDishItem=(MobileElement) driver.findElementById("in.swiggy.android:id/search_query");
		  MobileElement eleSearchDishItem=(MobileElement) driver.findElementByXPath("//android.widget.EditText");
		  
		  eleSearchDishItem.sendKeys("Biryani");
		  
		  MobileElement eleSelectedDish=getTextViewByText("Chicken Biryani");
		  String selectedDishVal = eleSelectedDish.getAttribute("text");

          if(selectedDishVal.equalsIgnoreCase("Chicken Biryani")){
              System.out.println("Selected Dish value =" +selectedDishVal);
        	  eleSelectedDish.click();
          }
		  
		  //MobileElement eleSelectedDish=getTextViewByResourceId("in.swiggy.android:id/layout_with_image");
		  //eleSelectedDish.click();

	  }
	  
	  
	  @AfterTest
	  public void tearDown() throws InterruptedException {
		  Thread.sleep(5000);
		//driver.wait(2000);
	    driver.quit();
	  }




}
