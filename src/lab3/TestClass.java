package selenium;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

class TestClass {

	private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("http://zero.webappsecurity.com/");
        
        WebElement signin = driver.findElement(By.id("signin_button"));
        signin.click();
        
        WebElement username = driver.findElement(By.name("user_login"));
        WebElement password = driver.findElement(By.name("user_password"));
        
        username.sendKeys("username");
        password.sendKeys("password");
        
        signin = driver.findElement(By.name("submit"));
        signin.click();
        
        WebElement payBillsTab = driver.findElement(By.id("pay_bills_tab"));
        payBillsTab.click();
        
        WebElement foreignCurrencyTab = driver.findElement(By.xpath("//a[@href='#ui-tabs-3']"));
        foreignCurrencyTab.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pc_currency")));
        
        Select currency = new Select(driver.findElement(By.id("pc_currency")));
        currency.selectByValue("CAD");
        
        WebElement amount = driver.findElement(By.id("pc_amount"));
        amount.sendKeys("100");
        
        WebElement tickBox = driver.findElement(By.id("pc_inDollars_true"));
        tickBox.click();
        
        WebElement calculateCostsButton = driver.findElement(By.id("pc_calculate_costs"));
        calculateCostsButton.click();
        
        WebElement conversionAmount = driver.findElement(By.id("pc_conversion_amount"));
        assertEquals(conversionAmount.getText(), "94.19 dollar (CAD) = 100.00 U.S. dollar (USD)");    
    }

}
