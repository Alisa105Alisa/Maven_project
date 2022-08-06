package org.example.lesson3.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiveLibTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.livelib.ru/");

        driver.findElement(By.xpath("//button[@class='page-header__login']")).click();

        driver.findElement(By.id("checkin-email")).sendKeys("jewelry105@yandex.ru");
        //driver.findElement(By.xpath("//input[@placeholder='Введите пароль']")).sendKeys("jewelry105@yandex.ru");
        driver.findElement(By.xpath("id(\"regForm__checkin\")//button[@class='reg-popup__btnNext']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Введите пароль']")).sendKeys("6fre20Jklg");

        driver.quit();
        Thread.sleep(10000);
    }
}
