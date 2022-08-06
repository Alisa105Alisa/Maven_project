package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class DiaryTestCookies {
    // авторизация с помощью подставления cookies
    public static void main(String[] args) throws InterruptedException  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://diary.ru");
        Cookie cookie = new Cookie("_identity_", "83668234c30812b14c46bac1deda1a240770255504032650b424a75038c00b3aa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C2592000%5D%22%3B%7D");

        driver.manage().addCookie(cookie);
        //добавляем cookies
        driver.navigate().refresh();
        //перезагружаем страницу

        //driver.manage().getCookieNamed("_identity_");
        //удалить куку

        //создаем новую запись:
        driver.findElement(By.id("writeThisDiary")).click();
        //driver, найди элемент по id

        String postTile = "test" + new Random().nextInt(1000);
        //создадим случайные заголовки постов
        driver.findElement(By.id("postTitle")).sendKeys(postTile);
        //кликаем на поле заголовка и вставляем этот случайный заголовок

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        //переключаемся на iframe, т.к поле ввода находится внутри iframe
        driver.findElement(By.id("tinymce")).sendKeys("tttttttwtwetewrew");
        //driver, найди элемент по id и передай ему текст
        driver.switchTo().parentFrame();
        //возвращаемся из iframe

        driver.findElement(By.id("rewrite")).click();
        //driver, найди элемент по id и кликни на него

        //driver.findElement(By.xpath(String.format("//a[text()='%s']", postTile))).click();
        //driver, найди элемент с заданным текстом (%s)

        List<WebElement> postTitles = driver.findElements(By.xpath("//a[@class='title']"));
        //список элементов - всех заголовков
        postTitles.stream().filter(p -> p.getText().contains(postTile)).findFirst().get().click();
        //делаем фильтр: чтобы текст соответствовал postTile и кликаем на первый совпавший
        //про stream в JavaCore

        Thread.sleep(5000);

        driver.quit();


    }
}
