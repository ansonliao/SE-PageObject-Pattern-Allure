package com.github.ansonliao.selenium.anonymous;


import com.github.ansonliao.selenium.annotations.URL;
import com.github.ansonliao.selenium.annotations.browser.Chrome;
import com.github.ansonliao.selenium.annotations.browser.Firefox;
import com.github.ansonliao.selenium.google.pages.LoginPage;
import com.github.ansonliao.selenium.google.pages.SecurePage;
import com.github.ansonliao.selenium.google.utils.CredentialUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.github.ansonliao.selenium.factory.WDManager.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_Allure {

    @Test(groups = "debug")
    @Description("Allure Test Report Description")
    @URL("http://the-internet.herokuapp.com/login")
    @Firefox
    @Chrome
    public void loginWithCorrectLoginInfo() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.inputUserName(CredentialUtils.getUserName());
        loginPage.inputPassword(CredentialUtils.getPassword());
        SecurePage securePage = loginPage.clickLoginButton();
        assertThat(securePage.getDriver().getTitle().toLowerCase())
                .contains("internet");
    }
}
