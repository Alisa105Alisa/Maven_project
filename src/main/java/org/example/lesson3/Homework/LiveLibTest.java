package org.example.lesson3.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LiveLibTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.livelib.ru/");

        driver.findElement(By.xpath("//button[@class='page-header__login']")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkin-email")));
        driver.findElement(By.id("checkin-email")).sendKeys("jewelry105@yandex.ru");
        Thread.sleep(2000);
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Продолжить']")));
        driver.findElement(By.xpath("//button[.='Продолжить']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('regForm__checkin')//button[@class='reg-popup__btnNext")));
        driver.findElement(By.xpath("id('regForm__checkin')//button[@class='reg-popup__btnNext']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Введите пароль']")).sendKeys("6fre20Jklg");

        driver.quit();
        Thread.sleep(10000);
    }
}
