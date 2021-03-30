package com.saucelabs.pages;

import com.saucelabs.utils.HelperMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.saucelabs.base.BasePage.driver;//BasePage den driver i cagirdik.
public class LoginPage {//driver i cagirmak icin BasePage den extends de yapabiliriz.
    //Fields:Locators,webelements,
    @FindBy(id="user-name")
    public static WebElement username;
    @FindBy(id="password")
    public static WebElement password;
    @FindBy(id="login-button")
    public  static WebElement loginBtn;

public LoginPage(){
    PageFactory.initElements(driver,this);//BasePage.driver is also possible
}
public static  String verifyTitle(){
   return HelperMethods.doGetPageTitle();
}
public static void enterUserName(String user){
  HelperMethods.sendText(username,user);


}
public static void enterPassword(String pass){
    HelperMethods.sendText(password,pass);
}
public static void clickLoginBtn(){
    HelperMethods.doClick(loginBtn);
}
public  static String verifyURL(){
    return HelperMethods.getCurrentUrl();
}
}