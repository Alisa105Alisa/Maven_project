package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/user/login");

        WebElement loginForm = driver.findElement(By.id("loginform-username"));// By - чтобы указать локатор
        //просим найти элемент по id локатору. Важно указать уникальный локатор
        loginForm.sendKeys("spartalex");//вводим в заданное поле "spartalex"
        driver.findElement(By.id("loginform-password")).sendKeys("123456");
        //написали покороче - найди элемент по id пароля и введи "123456"

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        //driver, переключись на айфрейм и найди по XPath
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        //кликни по заданной кнопке
        driver.switchTo().parentFrame();
        //переключись в родительский фрейм (из фрейма капчи)
        driver.findElement(By.id("login_btn")).click();


        String a = "";// красная точка - точка дебага, значит останавливаемся на этой строчке
        driver.quit();
        Thread.sleep(5000);

    }
}
