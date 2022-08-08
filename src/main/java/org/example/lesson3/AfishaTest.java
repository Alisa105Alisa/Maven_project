package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.afisha.ru/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //в течение 3 секунд ждем, что элемент появится на странице
        driver.findElement(By.xpath("//input[@placeholder='Событие, актер, место']")).sendKeys("Брат");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Брат']")));
        //говорим, что ждем появление xpath Брат
        driver.findElement(By.xpath("//div[.='Брат']")).click();

        Thread.sleep(10000);
        driver.quit();


    }
}
