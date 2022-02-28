package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveFormTest {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

// TODO TEST 1: COMPOUND FIRSTNAME & COMPOUND SURNAME, PHONE NUMBER IS USUAL, FLAG IS TRUE
    @Test
    void shouldSubmitRequest() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(By.className("App_appContainer__3jRx1"));
        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Василий-Стефан Григорович-Жуков");
        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79270000000");
        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        ((WebElement) form).findElement(By.className("button__content")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }
// TODO TEST 2: COMPOUND FIRSTNAME & SIMPLE SURNAME, PHONE NUMBER IS USUAL, FLAG IS TRUE


// TODO TEST 3: SIMPLE FIRSTNAME &  COMPOUND SURNAME, PHONE NUMBER IS USUAL, FLAG IS TRUE


// TODO TEST 4: SIMPLE FIRSTNAME & SIMPLE SURNAME, PHONE NUMBER IS USUAL, FLAG IS TRUE

}
