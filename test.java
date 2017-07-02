package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Autotest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

  @Before
    public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://app.cms2cms.com/auth";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Test
public void testAuto() throws Exception {
    driver.get(baseUrl + "/auth");
    driver.findElement(By.id("signUpEmail")).clear();
    driver.findElement(By.id("signUpEmail")).sendKeys("test@test.com");
    driver.findElement(By.id("signUpPassword")).clear();
    driver.findElement(By.id("signUpPassword")).sendKeys("111111");
    driver.findElement(By.id("signUpName")).clear();
    driver.findElement(By.id("signUpName")).sendKeys("Roman");
    driver.findElement(By.id("signUpPhone")).clear();
    driver.findElement(By.id("signUpPhone")).sendKeys("2015551221");
    driver.findElement(By.id("signUpName")).clear();
    driver.findElement(By.id("signUpName")).sendKeys("Roman");
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
}

@After
public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
    }
}

private boolean isElementPresent(By by) {
    try {
        driver.findElement(by);
        return true;
    } catch (NoSuchElementException e) {
        return false;
    }
}

private boolean isAlertPresent() {
    try {
        driver.switchTo().alert();
        return true;
    } catch (NoAlertPresentException e) {
        return false;
    }
}

private String closeAlertAndGetItsText() {
    try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        return alertText;
    } finally {
        acceptNextAlert = true;
    }
}
}
