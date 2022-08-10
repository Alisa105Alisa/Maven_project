package org.example.lesson4;

import org.junit.jupiter.api.*;

import static org.example.lesson4.Functions.isPalindrome;
import static org.junit.Assert.assertThat;

public class FunctionsTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Метод выполняется 1 раз перед всеми тестами класса");
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //например, первым тестом может быть запуск браузера
    }

    @BeforeEach
    void beforeEach() {
        //WebDriver driver = new ChromeDriver();
        // перед каждым тестом создаем драйвер. Это то, что есть в каждом тесте
        System.out.println("Метод выполнится перед каждым тестом класса");
    }

    @Test
    @DisplayName("Метод проверки палиндрома, переданного в метод isPalindrome")
    void givenPalindromeWhenCallIsPalindromeMethodThenTrue (){
        boolean result = isPalindrome("1234321");
        Assertions.assertTrue(result);// это то же, что assertEquals, но короче
        //Assertions.assertEquals(true, result);
    }
    @AfterEach
    void afterEach() {
        //driver.quit(); - после каждого теста закрываем браузер
        System.out.println("Метод выполнится 1 раз после каждого теста");
    }


    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполнится 1 раз после всех тестов класса");
    }

}
