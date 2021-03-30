package com.saucelabs.stepdefinitions;

import com.saucelabs.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginPageSD {
    @Given("^I am on the login page$")
    public void verifyLoginPage(){
        String expectedTitle="Swag Labs";
        Assert.assertEquals(expectedTitle, LoginPage.verifyTitle());
}

    @When("I enter valid username")
    public void iEnterValidUsername() {
        LoginPage.enterUserName("standard_user");
    }

    @And("I enter valid password")
    public void iEnterValidPassword() {
        LoginPage.enterPassword("secret_sauce");
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        LoginPage.clickLoginBtn();
    }

    @Then("I see the home page")
    public void iSeeTheHomePage() {
        String expectedURL="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedURL,LoginPage.verifyURL());

    }
}
