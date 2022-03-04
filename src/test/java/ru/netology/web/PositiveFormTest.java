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

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.*;

public class PositiveFormTest {
    private WebDriver driver;

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
        WebElement form = driver.findElement(className("App_appContainer__3jRx1"));
        form.findElement(cssSelector("[data-test-id=name] input")).sendKeys("Куравоал ыаомфваы-авсваы");
        form.findElement(cssSelector("[data-test-id=phone] input")).sendKeys("+98473256734");
        form.findElement(cssSelector("[data-test-id=agreement]")).click();
        form.findElement(className("button__content")).click();
        String text = driver.findElement(cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

// TODO TEST 2: COMPOUND FIRSTNAME & SIMPLE SURNAME, PHONE NUMBER IS USUAL, FLAG IS TRUE
    @Test
    void shouldSubmitRequestV2() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(className("App_appContainer__3jRx1"));
        form.findElement(cssSelector("[data-test-id=name] input")).sendKeys("Стефания-Мария Маршл");
        form.findElement(cssSelector("[data-test-id=phone] input")).sendKeys("+98473256734");
        form.findElement(cssSelector("[data-test-id=agreement]")).click();
        form.findElement(className("button__content")).click();
        String text = driver.findElement(cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

// TODO TEST 3: SIMPLE FIRSTNAME &  COMPOUND SURNAME, PHONE NUMBER IS USUAL, FLAG IS TRUE
    @Test
    void shouldSubmitRequestV3() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(className("App_appContainer__3jRx1"));
        form.findElement(cssSelector("[data-test-id=name] input")).sendKeys("Евгений Онегин-Благородный");
        form.findElement(cssSelector("[data-test-id=phone] input")).sendKeys("+98473256734");
        form.findElement(cssSelector("[data-test-id=agreement]")).click();
        form.findElement(className("button__content")).click();
        String text = driver.findElement(cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
}

// TODO TEST 4: SIMPLE FIRSTNAME & SIMPLE SURNAME, PHONE NUMBER IS USUAL, FLAG IS TRUE
    @Test
    void shouldSubmitRequestV4() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(className("App_appContainer__3jRx1"));
        form.findElement(cssSelector("[data-test-id=name] input")).sendKeys("Александр Жуков");
        form.findElement(cssSelector("[data-test-id=phone] input")).sendKeys("+98473256734");
        form.findElement(cssSelector("[data-test-id=agreement]")).click();
        form.findElement(className("button__content")).click();
        String text = driver.findElement(cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
}

}
