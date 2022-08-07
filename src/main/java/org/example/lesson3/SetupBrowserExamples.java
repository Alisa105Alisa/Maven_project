package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        //добавляем настройки:
        chromeOptions.addArguments("--disable-notifications");
        //эта настройка отключает уведомления
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        // прикинуться поисковым роботом
        chromeOptions.addArguments("--headless");
        //браузер запустится без интерфейса. Он запустится, но мы его не увидим

        WebDriver driver = new ChromeDriver();
        driver.get("https:google.com");
        Thread.sleep(5000);
        driver.quit();
        
    }
}
