package org.titanium.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class EjemploAcciones {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        try {
            WebElement txtUser =driver.findElement(By.name("email"));
            Actions builder = new Actions(driver);
            Action seriesOfActions = builder
                    .moveToElement(txtUser)
                    .click().keyDown(Keys.SHIFT)
                    .sendKeys("HOLA")
                    .keyUp(Keys.SHIFT)
                    .doubleClick()
                    .contextClick()
                    .build();

            seriesOfActions.perform();
            Thread.sleep(2000);
            System.out.println("Prueba Exitosa!");

        }catch (NoSuchElementException ne){
            System.err.println("No encuentra el WebElement" + ne.getMessage());
        }catch (Exception we){
            System.err.println("Prueba fallida" + we.getMessage());
        }finally {
            driver.quit();
        }
    }
}
